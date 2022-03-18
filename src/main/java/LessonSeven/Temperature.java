package LessonSeven;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Temperature {
    @JsonProperty("Minimum")
    private TemperatureUnit minimum;
    @JsonProperty("Maximum")
    private TemperatureUnit maximum;

    @JsonGetter("Minimum")
    public TemperatureUnit getMinimum() {
        return minimum;
    }

    @JsonSetter("Minimum")
    public void setMinimum(TemperatureUnit minimum) {
        this.minimum = minimum;
    }

    @JsonGetter("Maximum")
    public TemperatureUnit getMaximum() {
        return maximum;
    }

    @JsonSetter("Maximum")
    public void setMaximum(TemperatureUnit maximum) {
        this.maximum = maximum;
    }

    @JsonProperty(value = "Metric")
    private TemperatureUnit metric;
    @JsonProperty(value = "Imperial")
    private TemperatureUnit imperial;

    @JsonGetter("Metric")
    public TemperatureUnit getMetric() {
        return metric;
    }

    @JsonSetter("Metric")
    public void setMetric(TemperatureUnit metric) {
        this.metric = metric;
    }

    @JsonGetter("Imperial")
    public TemperatureUnit getImperial() {
        return imperial;
    }

    @JsonSetter("Imperial")
    public void setImperial(TemperatureUnit imperial) {
        this.imperial = imperial;
    }
}



