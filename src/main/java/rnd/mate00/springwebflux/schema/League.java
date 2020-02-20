package rnd.mate00.springwebflux.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {

    @JsonProperty("league_id")
    public Integer leagueId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;
    @JsonProperty("country")
    public String country;
    @JsonProperty("country_code")
    public String countryCode;
    @JsonProperty("season")
    public Integer season;
    @JsonProperty("season_start")
    public String seasonStart;
    @JsonProperty("season_end")
    public String seasonEnd;
    @JsonProperty("logo")
    public Object logo;
    @JsonProperty("flag")
    public String flag;
    @JsonProperty("standings")
    public Integer standings;
    @JsonProperty("is_current")
    public Integer isCurrent;
    @JsonProperty("coverage")
    public Coverage coverage;
}