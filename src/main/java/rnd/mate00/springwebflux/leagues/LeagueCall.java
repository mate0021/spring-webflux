package rnd.mate00.springwebflux.leagues;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rnd.mate00.springwebflux.schema.LeagueCallResult;

@Service
public class LeagueCall {

    @Autowired
    private RestTemplate restTemplate;

    public void getLeagues() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "api-football-v1.p.rapidapi.com");
        headers.add("x-rapidapi-key", "577f914677mshe067ff566272b48p1e82c9jsn8e39d25f3dd0");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response =
                restTemplate.exchange("https://api-football-v1.p.rapidapi.com/v2/leagues/country/england/2018", HttpMethod.GET, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            LeagueCallResult api = mapper.readValue(response.getBody(), LeagueCallResult.class);
            System.out.println(api);
//            JsonNode jsonNode = mapper.readTree(response.getBody());
//            System.out.println(jsonNode.toPrettyString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
