/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.controller;

import bet.horserisingsun.horseracing.model.PlayerEntity;

/**
 *
 * @author Santiago
 */
public class PlayerController {

    public void updateAmount(int amount, PlayerEntity player) {
        int currentAmount = player.getAmount();
        int actualAmount = currentAmount + amount;
        player.setAmount(actualAmount);
        if (player.getAmount() <= 0) {
            deletePlayer(player);
        }
    }

    public PlayerEntity createPlayer(Integer id, String name, int amount) {
        PlayerEntity player = new PlayerEntity();
        player.setId(id);
        player.setName(name);
        player.setAmount(amount);
        return player;
    }
    
    public void deletePlayer(PlayerEntity player){
        player.setId(null);
        player.setName(null);
        player.setAmount(0);
    }

}
