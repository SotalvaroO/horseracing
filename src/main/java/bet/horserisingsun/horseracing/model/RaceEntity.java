/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.model;

import java.util.ArrayList;

public class RaceEntity {

    private Integer id;
    private int totalBetAmount;
    private ArrayList<HorseEntity> horses;
    private ArrayList<BetEntity> bets;

    public RaceEntity() {
    }

    public RaceEntity(Integer id, int totalBetAmount, ArrayList<HorseEntity> horses, ArrayList<BetEntity> bets) {
        this.id = id;
        this.horses = horses;
        this.bets = bets;
        this.totalBetAmount = totalBetAmount;
        //this.totalBetAmount = getTotalBetAmountValue();
    }

    public RaceEntity(Integer id, ArrayList<HorseEntity> horses, ArrayList<BetEntity> bets) {
        this.id = id;
        this.horses = horses;
        this.bets = bets;
        //this.totalBetAmount = getTotalBetAmountValue();
    }

    /*public int getTotalBetAmountValue() {
        int totalBetAmount = 0;

        for (BetEntity bet : bets) {
            totalBetAmount = totalBetAmount + bet.getBetAmount();
        }
        return totalBetAmount;
    }*/
    public RaceEntity(Integer id, int totalBetAmount, ArrayList<HorseEntity> horses) {
        this.id = id;
        this.horses = horses;
        this.totalBetAmount = totalBetAmount;
    }

    public RaceEntity(Integer id, ArrayList<HorseEntity> horses) {
        this.id = id;
        this.horses = horses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<HorseEntity> getHorses() {
        return horses;
    }

    public void setHorses(ArrayList<HorseEntity> horses) {
        this.horses = horses;
    }

    public ArrayList<BetEntity> getBets() {
        return bets;
    }

    public void setBets(ArrayList<BetEntity> bets) {
        this.bets = bets;
    }

    public int getTotalBetAmount() {
        return totalBetAmount;
    }

    public void setTotalBetAmount(int totalBetAmount) {
        this.totalBetAmount = totalBetAmount;
    }

}
