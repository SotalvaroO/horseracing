/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing;

import bet.horserisingsun.horseracing.controller.PlayerController;
import bet.horserisingsun.horseracing.model.PlayerEntity;

/**
 *
 * @author Santiago
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        PlayerController playerController = new PlayerController();
        
        PlayerEntity player = playerController.createPlayer(1020492578, "Santiago", 30000);
        PlayerEntity player2 = playerController.createPlayer(7513416, "Jesus", 30000);


    }

  
    
}
