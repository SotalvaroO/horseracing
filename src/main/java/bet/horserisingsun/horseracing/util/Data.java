/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.util;

import bet.horserisingsun.horseracing.model.BetEntity;
import bet.horserisingsun.horseracing.model.HorseEntity;
import bet.horserisingsun.horseracing.model.PlayerEntity;
import bet.horserisingsun.horseracing.model.RaceEntity;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Data {

    public static ArrayList<HorseEntity> horses = new ArrayList<>();
    public static ArrayList<PlayerEntity> players = new ArrayList<>();
    public static ArrayList<RaceEntity> race = new ArrayList<>();
    public static ArrayList<BetEntity> bets = new ArrayList<>();

    public static ArrayList<HorseEntity> getHorses() {
        return horses;
    }

    public static void setHorses(ArrayList<HorseEntity> horses) {
        Data.horses = horses;
    }

    public static ArrayList<PlayerEntity> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<PlayerEntity> players) {
        Data.players = players;
    }

    public static ArrayList<RaceEntity> getRace() {
        return race;
    }

    public static void setRace(ArrayList<RaceEntity> race) {
        Data.race = race;
    }

    public static ArrayList<BetEntity> getBets() {
        return bets;
    }

    public static void setBets(ArrayList<BetEntity> bets) {
        Data.bets = bets;
    }

}
