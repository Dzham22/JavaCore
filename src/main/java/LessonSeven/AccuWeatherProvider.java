package LessonSeven;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.management.openmbean.SimpleType;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_PERIOD = "5day";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST = "forecasts";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private static final ObjectMapper responseMapper = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();


            String responseList = client.newCall(request).execute().body().string();

            List<WeatherResponse> weatherResponseList = responseMapper.readValue(responseList, new TypeReference<List<WeatherResponse>>() {
            });

            WeatherResponse weather = weatherResponseList.get(0);

            System.out.println("???? ???????????? ???????? " + weather.getLocalObservationDateTime() + " ?? ???????????? " + ApplicationGlobalState.getInstance().getSelectedCity() +
                    " ?????????????????????? " + weather.getTemperature().getMetric().getValue() + "????, ?? " + weather.getWeatherText() + ".");
        }


        if (Objects.equals(periods, Periods.FIVE_DAYS)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(FORECAST_PERIOD)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
            String responseList = client.newCall(request).execute().body().string();

            int firstIndexBody = responseList.indexOf("[{\"Date\"");
            int lastIndexBody = responseList.lastIndexOf("}");
            responseList = responseList.substring(firstIndexBody, lastIndexBody);

            List<WeatherResponse> weatherResponseList = responseMapper.readValue(responseList, new TypeReference<List<WeatherResponse>>() {
            });

            for (WeatherResponse weather : weatherResponseList) {
                System.out.println("?? ???????????? " + ApplicationGlobalState.getInstance().getSelectedCity() + " ???? ?????????????????? ???????? "  + weather.getLocalObservationDateTime() +
                        " ?????????????????? ?????????? ????????????: ?????????????????????? ?????????????????????? " + weather.getWeatherText() + weather.getTemperature().getMinimum().getValue());


            }
        }
    }


    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();


        if (!response.isSuccessful()) {
            throw new IOException("???????????????????? ???????????????? ???????????????????? ?? ????????????. " +
                    "?????? ???????????? ?????????????? = " + response.code() + " ???????? ???????????? = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("?????????????????? ?????????? ???????????? " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("???????????? ?????????? " + cityName + " ?? ???????????? " + countryName);


        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();

    }

}
