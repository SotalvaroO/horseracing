/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.controller;

import bet.horserisingsun.horseracing.model.BetEntity;
import bet.horserisingsun.horseracing.model.HorseEntity;
import bet.horserisingsun.horseracing.model.PlayerEntity;
import bet.horserisingsun.horseracing.model.RaceEntity;
import bet.horserisingsun.horseracing.util.JsonReaderUtil;
import bet.horserisingsun.horseracing.util.JsonWriterUtil;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BetController {

    private JsonReaderUtil jsonReaderUtil = new JsonReaderUtil();
    private JsonWriterUtil jsonWriterUtil = new JsonWriterUtil();
    private String filePath = "src/bets.json";

    public BetEntity createBet(PlayerEntity player, HorseEntity horse, RaceEntity race, int betAmount) {
        BetEntity bet = new BetEntity(player, horse, race, betAmount);
        return bet;
    }

    public ArrayList<BetEntity> getWinniers(RaceEntity race, HorseEntity winnerHorse) {

        ArrayList<BetEntity> winnerBets = new ArrayList<>();

        for (BetEntity bet : race.getBets()) {

            if (bet.getHorse().equals(winnerHorse)) {
                winnerBets.add(bet);
            }

        }
        return winnerBets;

    }

    public ArrayList<BetEntity> getLosers(RaceEntity race, HorseEntity winnerHorse) {

        ArrayList<BetEntity> loserBets = new ArrayList<>();

        for (BetEntity bet : race.getBets()) {

            if (!bet.getHorse().equals(winnerHorse)) {
                loserBets.add(bet);
            }

        }
        return loserBets;

    }

    public int splitGains(RaceEntity race, HorseEntity winnerHorse) {
        int winnersCount = getWinniers(race, winnerHorse).size();
        int gainPerPerson = (int) (race.getTotalBetAmount() / winnersCount);
        return gainPerPerson;
    }

    public BetEntity getBet(Object obj) throws Exception {
        BetEntity bet = new BetEntity();
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        JSONObject playerJson = (JSONObject) jsonObj.get("player");
        JSONObject horseJson = (JSONObject) jsonObj.get("horse");
        JSONObject raceJson = (JSONObject) jsonObj.get("race");
        
        PlayerEntity player = new PlayerEntity();
        player.setId(Integer.valueOf(playerJson.get("id").toString()));
        player.setName(playerJson.get("name").toString());
        player.setAmount(Integer.valueOf(playerJson.get("amount").toString()));
        
        HorseEntity horse = new HorseEntity();
        horse.setId(Integer.valueOf(horseJson.get("id").toString()));
        horse.setName(horseJson.get("name").toString());
        
        RaceEntity race = new RaceEntity();
        race.setId(Integer.valueOf(raceJson.get("id").toString()));

        bet.setPlayer(player);
        bet.setHorse(horse);
        bet.setRace(race);
        bet.setBetAmount(Integer.valueOf(jsonObj.get("betAmount").toString()));
        return bet;
    }

    public ArrayList<BetEntity> getBets() throws Exception {
        Object obj = jsonReaderUtil.fileToObject(filePath);
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        JSONArray jsonArr = jsonReaderUtil.toJsonObjectArray(jsonObj, "bets");
        ArrayList<BetEntity> bets = new ArrayList<>();
        BetEntity bet = new BetEntity();
        for (Object arrObj : jsonArr) {
            bet = getBet(arrObj);
            bets.add(bet);
        }
        return bets;
    }

}
