package rnd.mate00.springwebflux.schema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results",
        "leagues"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Api {

    @JsonProperty("results")
    public Integer results;

    @JsonProperty("leagues")
    public List<League> leagues = null;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    @Override
    public String toString() {
        return "Api{" +
                "results=" + results +
                ", leagues=" + leagues +
                '}';
    }
}