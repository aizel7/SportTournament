package com.SportsTournament;

import com.SportsTournament.model.VolleyballMatch;
import com.SportsTournament.service.VolleyballMatchesService; //elle yazdim
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class SportsTournamentController {

    @Autowired
    private VolleyballMatch volleyballMatchesService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "The application is up...";
    }

    @GetMapping("/")
    public String getupdates(Model model) {
        model.addAttribute("volleyballMatches", volleyballMatchesService.readMatches());
        return "index";
    }

    @RequestMapping(value = "createVolleyballMatch", method = RequestMethod.POST)
    public String createStudent(@RequestBody VolleyballMatch volleyballMatch) {
        return volleyballMatchesService.createVolleyballMatches(VolleyballMatch);
    }

    @RequestMapping(value = "readVolleyballMatches", method = RequestMethod.GET)
    public List<VolleyballMatch> readStudents() {
        return volleyballMatchesService.readMatches();
    }

    @RequestMapping(value = "updateVolleyballMatch", method = RequestMethod.PUT)
    public String updateMatch(@RequestBody VolleyballMatch volleyballMatch) {
        return volleyballMatchesService.updateVolleyballMatch(volleyballMatch);
    }

    @RequestMapping(value = "deleteVolleyballMatch", method = RequestMethod.DELETE)
    public String deleteMatch(@RequestBody VolleyballMatch volleyballMatch) {
        return volleyballMatchesService.deleteVolleyballMatch(VolleyballMatch);
    }
}

        /*model.addAttribute("matches", Arrays.asList(
                new VolleyballMatch("Turkey", "Italy", LocalDate.of(2022, 5,31), LocalTime.of(18,30)),
                new VolleyballMatch("Thailand","Bulgaria", LocalDate.of(2022, 5,31), LocalTime.of(18, 30)),
                new VolleyballMatch("Germany","Brazil", LocalDate.of(2022,6,1), LocalTime.of(17,00)),
                new VolleyballMatch("Poland","Canada", LocalDate.of(2022,06, 2), LocalTime.of(17, 00)),
                new VolleyballMatch("Belgium","Italy", LocalDate.of(2022, 06,02),LocalTime.of(19, 00))
                ));
                return "index";*/
    }
}
