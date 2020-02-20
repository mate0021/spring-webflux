package rnd.mate00.springwebflux.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fixtures {

    @JsonProperty("events")
    public Boolean events;
    @JsonProperty("lineups")
    public Boolean lineups;
    @JsonProperty("statistics")
    public Boolean statistics;
    @JsonProperty("players_statistics")
    public Boolean playersStatistics;

}