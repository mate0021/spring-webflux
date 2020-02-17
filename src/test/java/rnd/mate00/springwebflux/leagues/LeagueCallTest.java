package rnd.mate00.springwebflux.leagues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LeagueCallTest {

    @Autowired
    private LeagueCall subject;

    @Test
    public void t() {
        subject.getLeagues();
    }
}