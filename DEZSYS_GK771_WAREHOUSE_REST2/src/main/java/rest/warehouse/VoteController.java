package rest.warehouse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import rest.model.VoteData;
import rest.warehouse.VoteService;

@RestController
public class VoteController {

    @Autowired
    private VoteService service;

    /**
     * Hauptseite der Anwendung
     */
    @RequestMapping("/vote")
    public String voteMain() {
        String mainPage = "Welcome to the Voting Application! <br/><br/>" +
                "<a href='http://localhost:8080/vote/33123/json'>Link to vote/33123/json</a><br/>" +
                "<a href='http://localhost:8080/vote/33123/xml'>Link to vote/33123/xml</a>";
        return mainPage;
    }

    /**
     * Liefert die Wahldaten im JSON-Format
     */
    @RequestMapping(value = "/vote/{regionID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getVoteDataAsJSON(@PathVariable String regionID) {
        VoteData data = service.getVoteData(regionID);
        return data.toJSON();
    }

    /**
     * Liefert die Wahldaten im XML-Format
     */
    @RequestMapping(value = "/vote/{regionID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getVoteDataAsXML(@PathVariable String regionID) {
        VoteData data = service.getVoteData(regionID);
        return data.toXML();
    }
}
