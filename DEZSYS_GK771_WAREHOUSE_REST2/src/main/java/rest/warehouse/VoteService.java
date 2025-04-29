package rest.warehouse;

import org.springframework.stereotype.Service;
import rest.model.VoteData;
import rest.model.VoteData.PartyData;
import rest.model.VoteData.PreferentialVote;

import java.util.Arrays;

@Service
public class VoteService {

    /**
     * Liefert simulierte Wahldaten für eine Region
     */
    public VoteData getVoteData(String regionID) {
        VoteData data = new VoteData();
        data.setRegionID(regionID);
        data.setRegionName("Linz Bahnhof");
        data.setRegionAddress("Bahnhofsstrasse 27/9");
        data.setRegionPostalCode("4020");
        data.setFederalState("Austria");
        data.setTimestamp("2024-09-12 11:48:21");

        // Simulierte Parteien und Stimmen
        PartyData party1 = new PartyData();
        party1.setPartyID("OEVP");
        party1.setAmountVotes(322);

        PartyData party2 = new PartyData();
        party2.setPartyID("SPOE");
        party2.setAmountVotes(301);

        PartyData party3 = new PartyData();
        party3.setPartyID("FPOE");
        party3.setAmountVotes(231);

        PartyData party4 = new PartyData();
        party4.setPartyID("GRUENE");
        party4.setAmountVotes(211);

        PartyData party5 = new PartyData();
        party5.setPartyID("NEOS");
        party5.setAmountVotes(182);

        // Parteien hinzufügen
        data.setCountingData(Arrays.asList(party1, party2, party3, party4, party5));

        // Simulierte Vorzugsstimmen hinzufügen
        PreferentialVote candidate1 = new PreferentialVote();
        candidate1.setListNumber(1);
        candidate1.setPersonName("Max Mustermann ÖVP");
        candidate1.setVotes(75);

        PreferentialVote candidate2 = new PreferentialVote();
        candidate2.setListNumber(2);
        candidate2.setPersonName("Maria Musterfrau ÖVP");
        candidate2.setVotes(63);

        PreferentialVote candidate3 = new PreferentialVote();
        candidate3.setListNumber(3);
        candidate3.setPersonName("Franz Huber SPÖ");
        candidate3.setVotes(58);

        PreferentialVote candidate4 = new PreferentialVote();
        candidate4.setListNumber(4);
        candidate4.setPersonName("Anna Schuster FPÖ");
        candidate4.setVotes(49);

        // Vorzugsstimmen hinzufügen
        data.setPreferentialVotes(Arrays.asList(candidate1, candidate2, candidate3, candidate4));

        return data;
    }
}
