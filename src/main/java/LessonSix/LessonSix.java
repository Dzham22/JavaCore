package LessonSix;


import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;


public class LessonSix {

        private static final String MainHost= "dataservice.accuweather.com";
        private static final String Predict = "forecasts";
        private static final String ApiVersion = "v1";
        private static final String PredictType = "daily";
        private static final String PredictPeriod = "5day";
        private static final String SaintPetersburgKey = "474212";
        private static final String ApiKey = "XvsZGZHrSj6WZn3vcc2LkWA2iPwpQPiT";


        public static void main(String[] args) throws IOException {

            OkHttpClient okHttpClient = new OkHttpClient();

            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme("http")
                    .host(MainHost)
                    .addPathSegment(Predict)
                    .addPathSegment(ApiVersion)
                    .addPathSegment(PredictType)
                    .addPathSegment(PredictPeriod)
                    .addPathSegment(SaintPetersburgKey)
                    .addQueryParameter("apikey", ApiKey)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("details","true")
                    .addQueryParameter("metric", "true")
                    .build();

            System.out.println(httpUrl.toString());

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            String jsonReply = okHttpClient.newCall(request).execute().body().string();
            System.out.println(jsonReply);
        }
    }



