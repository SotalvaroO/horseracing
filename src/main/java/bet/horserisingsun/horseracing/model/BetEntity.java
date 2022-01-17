/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.model;


public class BetEntity {
    
    private PlayerEntity player;
    private HorseEntity horse;
    private RaceEntity race;
    private int betAmount;

    public BetEntity(PlayerEntity player, HorseEntity horse, RaceEntity race, int betAmount) {
        this.player = player;
        this.horse = horse;
        this.race = race;
        this.betAmount = betAmount;
    }
    
    public BetEntity(PlayerEntity player, HorseEntity horse, int betAmount) {
        this.player = player;
        this.horse = horse;
        this.betAmount = betAmount;
    }

    public BetEntity() {
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public HorseEntity getHorse() {
        return horse;
    }

    public void setHorse(HorseEntity horse) {
        this.horse = horse;
    }

    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
    
    
    
}
