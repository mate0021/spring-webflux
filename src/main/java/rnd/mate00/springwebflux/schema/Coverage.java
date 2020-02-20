package rnd.mate00.springwebflux.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coverage {

    @JsonProperty("standings")
    public Boolean standings;
    @JsonProperty("fixtures")
    public Fixtures fixtures;
    @JsonProperty("players")
    public Boolean players;
    @JsonProperty("topScorers")
    public Boolean topScorers;
    @JsonProperty("predictions")
    public Boolean predictions;
    @JsonProperty("odds")
    public Boolean odds;

}