/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing;

import bet.horserisingsun.horseracing.controller.BetController;
import bet.horserisingsun.horseracing.controller.HorseController;
import bet.horserisingsun.horseracing.controller.PlayerController;
import bet.horserisingsun.horseracing.controller.RaceController;
import bet.horserisingsun.horseracing.model.BetEntity;
import bet.horserisingsun.horseracing.model.HorseEntity;
import bet.horserisingsun.horseracing.model.PlayerEntity;
import bet.horserisingsun.horseracing.model.RaceEntity;
import bet.horserisingsun.horseracing.util.JsonReaderUtil;
import bet.horserisingsun.horseracing.util.JsonWriterUtil;
import bet.horserisingsun.horseracing.view.HorseView;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;*/
public class Main {

    public static ArrayList<HorseEntity>gHorses = new ArrayList<>();
    
    
    public static void main(String[] args) throws Exception  {
        
        HorseEntity horse1 = new HorseEntity(1, "Mostufa");
        HorseEntity horse2 = new HorseEntity(1, "Omicron");
        HorseEntity horse3 = new HorseEntity(1, "Paracron");
        HorseEntity horse4 = new HorseEntity(1, "Trueno");
        
        
        gHorses.add(horse1);
        gHorses.add(horse2);
        gHorses.add(horse3);
        gHorses.add(horse4);
        
        //static ArrayList<PlayerEntity> players = new ArrayList<>();
        MainFrame m = new MainFrame();
        m.setVisible(true);

        /*PlayerController playerController = new PlayerController();
        RaceController raceController = new RaceController();
        BetController betController = new BetController();
        HorseController horseController = new HorseController();
        JsonReaderUtil jsonReaderUtil = new JsonReaderUtil();
        JsonWriterUtil jsonWriterUtil = new JsonWriterUtil();

        PlayerEntity player2Create = new PlayerEntity(1, "Santiago", 30000);
        JSONObject jsonObject = playerController.createPlayer(player2Create);
        System.out.println("-+-+-+-++-+-+-+-");
        System.out.println(jsonObject.toJSONString());
        
        PlayerEntity player2Create2 = new PlayerEntity(2, "Santiago", 50000);
        JSONObject jsonObject2 = playerController.createPlayer(player2Create2);
        System.out.println("-+-+-+-++-+-+-+-");
        System.out.println(jsonObject2.toJSONString());
        
        HorseEntity horse1 = new HorseEntity(1, "Mostufa");
        Object obj = jsonReaderUtil.fileToObject("src/horses.json");
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        JSONArray jsonArray = jsonReaderUtil.toJsonObjectArray(jsonObj, "horses");
        
       // System.out.println("-----------------------------------");
        System.out.println(jsonArray.get(1));
        
        HorseEntity horse2 = new HorseEntity(2, "Omicron");
        HorseEntity horse3 = new HorseEntity(3, "Paracron");
        HorseEntity horse4 = new HorseEntity(4, "trueno");

        ArrayList<HorseEntity> horses = horseController.getHorses();
        System.out.println(horses.get(0));


        /*horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        horses.add(horse4);*/

        //RaceEntity race = new RaceEntity(1, horses);

        /*BetEntity bet1 = betController.createBet(player1, horse1, race, 1000);
        BetEntity bet2 = betController.createBet(player2, horse2, race, 2000);
        BetEntity bet3 = betController.createBet(player3, horse3, race, 3000);
        BetEntity bet4 = betController.createBet(player4, horse4, race, 4000);

        ArrayList<BetEntity> bets = new ArrayList<>();
        bets.add(bet1);
        bets.add(bet2);
        bets.add(bet3);
        bets.add(bet4);

        race.setBets(bets);

        raceController.calculateTotalAmount(race);
        System.out.println(race.getTotalBetAmount());
        System.out.println("///////////////////////////");

        //RaceEntity race = new RaceEntity(1,horses, bets);
        HorseEntity winnerHorse = raceController.getWinnerHorse(race);

        ArrayList<BetEntity> winnerBets = betController.getWinniers(race, winnerHorse);
        for (BetEntity bet : race.getBets()) {
            playerController.changePlayerMoney(bet);
        }
        System.out.println(winnerHorse.getName());
        System.out.println("-------------");
*/
        //jsonWriterUtil.flushFile("src/players.json");*/
    }

}
