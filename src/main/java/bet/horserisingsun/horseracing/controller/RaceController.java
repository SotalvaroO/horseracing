/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.controller;

import bet.horserisingsun.horseracing.model.BetEntity;
import bet.horserisingsun.horseracing.model.HorseEntity;
import bet.horserisingsun.horseracing.model.RaceEntity;
import java.util.ArrayList;
import java.util.Random;


public class RaceController {

    public HorseEntity getWinnerHorse(RaceEntity race) {
        Random classRandom = new Random();
        int random = 1 + classRandom.nextInt(5-1);
        switch (random){
            case 1:
                return race.getHorses().get(0);
            case 2:
                return race.getHorses().get(1);
            case 3:
                return race.getHorses().get(2);
            case 4:
                return race.getHorses().get(3);
            default:
                return null;
        } 
    }
    
    public RaceEntity createRace(Integer id, ArrayList<HorseEntity> horses, ArrayList<BetEntity> bets){
        
        RaceEntity race = new RaceEntity(id,horses, bets);
        return race;
    }
    
    public void calculateTotalAmount(RaceEntity race){
        int totalBetAmount = 0;
        for(BetEntity bet: race.getBets()){
            totalBetAmount = totalBetAmount + bet.getBetAmount();
        }
        race.setTotalBetAmount(totalBetAmount);
    }

}
