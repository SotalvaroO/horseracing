/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.controller;

import bet.horserisingsun.horseracing.model.BetEntity;
import bet.horserisingsun.horseracing.model.PlayerEntity;
import bet.horserisingsun.horseracing.util.JsonReaderUtil;
import bet.horserisingsun.horseracing.util.JsonWriterUtil;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PlayerController {

    private JsonReaderUtil jsonReaderUtil = new JsonReaderUtil();
    private JsonWriterUtil jsonWriterUtil = new JsonWriterUtil();
    private String filePath = "src/players.json";

    public void updateAmount(int amount, PlayerEntity player) {
        int currentAmount = player.getAmount();
        int actualAmount = currentAmount + amount;
        player.setAmount(actualAmount);
        if (player.getAmount() <= 0) {
            deletePlayer(player);
        }
    }

    public void deletePlayer(PlayerEntity player) {
        player.setId(null);
        player.setName(null);
        player.setAmount(0);
    }

    public void changePlayerMoney(BetEntity bet) {
        updateAmount(bet.getBetAmount(), bet.getPlayer());
    }

    public PlayerEntity getPlayer(Object obj) throws Exception {
        PlayerEntity player = new PlayerEntity();
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        player.setId(Integer.valueOf(jsonObj.get("id").toString()));
        player.setName(jsonObj.get("name").toString());
        player.setAmount(Integer.valueOf(jsonObj.get("amount").toString()));
        return player;
    }

    public ArrayList<PlayerEntity> getPlayers() throws Exception {
        Object obj = jsonReaderUtil.fileToObject(filePath);
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        JSONArray jsonArr = jsonReaderUtil.toJsonObjectArray(jsonObj, "players");
        ArrayList<PlayerEntity> players = new ArrayList<>();
        PlayerEntity player = new PlayerEntity();
        for (Object arrObj : jsonArr) {
            player = getPlayer(arrObj);
            players.add(player);
        }
        return players;
    }

    public JSONObject createPlayer(PlayerEntity player) {
        JSONObject objInsert = new JSONObject();
        objInsert.put("id", player.getId());
        objInsert.put("name", player.getName());
        objInsert.put("amount", player.getAmount());
        JSONObject obj = jsonWriterUtil.readFile(filePath, "players", objInsert);

        /*obj.put("id", player.getId());
        obj.put("name", player.getName());
        obj.put("amount", player.getAmount());*/
        return obj;
    }

}
