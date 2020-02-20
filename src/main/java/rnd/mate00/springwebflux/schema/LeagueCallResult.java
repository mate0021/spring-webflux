package rnd.mate00.springwebflux.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "api"
})
public class LeagueCallResult {

    @JsonProperty("api")
    public Api api;

    @Override
    public String toString() {
        return "Example{" +
                "api=" + api +
                '}';
    }
}