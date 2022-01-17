/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bet.horserisingsun.horseracing.view;

import bet.horserisingsun.horseracing.controller.BetController;
import bet.horserisingsun.horseracing.controller.PlayerController;
import bet.horserisingsun.horseracing.controller.RaceController;
import bet.horserisingsun.horseracing.model.BetEntity;
import bet.horserisingsun.horseracing.model.HorseEntity;
import bet.horserisingsun.horseracing.model.PlayerEntity;
import bet.horserisingsun.horseracing.model.RaceEntity;
import java.util.ArrayList;

public class WinnerView extends javax.swing.JFrame {

    public static BetController betController = new BetController();
    public static PlayerController playerController = new PlayerController();
    public static ArrayList<PlayerEntity> players = HorseView.players;
    public static ArrayList<RaceEntity> races = HorseView.races;
    public static ArrayList<BetEntity> raceBets = races.get(HorseView.raceCounter).getBets();
    public static ArrayList<BetEntity> winnerRaceBets = new ArrayList<>();
    public RaceController raceController = new RaceController();

    public WinnerView() {
        initComponents();
        RaceEntity race = races.get(HorseView.raceCounter);
        System.out.println("////////////");
        HorseEntity winnerHorse = raceController.getWinnerHorse(race);

        winnerRaceBets = betController.getWinniers(race, winnerHorse);
        int winnersCount = winnerRaceBets.size();
        if (winnersCount == 0) {
            winnersCount = winnersCount + 1;
        }

        jLabelWinnerHorse.setText(winnerHorse.getName());

        if (!players.get(0).toString().equals("")) {
            jLabelP1.setText(players.get(0).getName());
        }
        if (!players.get(1).toString().equals("")) {
            jLabelP2.setText(players.get(1).getName());
        }
        if (!players.get(2).toString().equals("")) {
            jLabelP3.setText(players.get(2).getName());
        }
        if (!players.get(3).toString().equals("")) {
            jLabelP4.setText(players.get(3).getName());
        }
        
        
        

        if (raceBets.get(0).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet1 = raceBets.get(0);
            jLabel1Win.setText(String.valueOf(race.getTotalBetAmount() / winnersCount - bet1.getBetAmount()));

            players.get(0).setAmount(players.get(0).getAmount() + (race.getTotalBetAmount() / winnersCount - bet1.getBetAmount()));
            jLabel1Total.setText(String.valueOf(players.get(0).getAmount()));
        } else {
            jLabel1Win.setText(" ");
        }
        if (raceBets.get(1).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet2 = raceBets.get(1);
            jLabel2Win.setText(String.valueOf(race.getTotalBetAmount() / winnersCount - bet2.getBetAmount()));
            
            players.get(1).setAmount(players.get(1).getAmount() + (race.getTotalBetAmount() / winnersCount - bet2.getBetAmount()));
            jLabel2Total.setText(String.valueOf(players.get(1).getAmount()));
        } else {
            jLabel2Win.setText(" ");
        }
        if (raceBets.get(2).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet3 = raceBets.get(2);
            jLabel3Win.setText(String.valueOf(race.getTotalBetAmount() / winnersCount - bet3.getBetAmount()));
            
            players.get(2).setAmount(players.get(2).getAmount() + (race.getTotalBetAmount() / winnersCount - bet3.getBetAmount()));
            jLabel3Total.setText(String.valueOf(players.get(2).getAmount()));
        } else {
            jLabel3Win.setText(" ");
        }
        if (raceBets.get(3).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet4 = raceBets.get(3);
            jLabel4Win.setText(String.valueOf(race.getTotalBetAmount() / winnersCount - bet4.getBetAmount()));
            
            players.get(3).setAmount(players.get(3).getAmount() + (race.getTotalBetAmount() / winnersCount - bet4.getBetAmount()));
            jLabel4Total.setText(String.valueOf(players.get(3).getAmount()));
        } else {
            jLabel4Win.setText(" ");
        }
        
        
        

        if (!raceBets.get(0).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet1 = raceBets.get(0);
            jLabel5Lose.setText(String.valueOf(bet1.getBetAmount() * (-1)));

            players.get(0).setAmount(players.get(0).getAmount() - bet1.getBetAmount());
            jLabel1Total.setText(String.valueOf(players.get(0).getAmount()));
        } else {
            jLabel5Lose.setText(" ");
        }
        if (!raceBets.get(1).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet2 = raceBets.get(1);
            jLabel6Lose.setText(String.valueOf(bet2.getBetAmount() * (-1)));

            players.get(1).setAmount(players.get(1).getAmount() - bet2.getBetAmount());
            jLabel2Total.setText(String.valueOf(players.get(1).getAmount()));
        } else {
            jLabel6Lose.setText(" ");
        }
        if (!raceBets.get(2).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet3 = raceBets.get(2);
            jLabel7Lose.setText(String.valueOf(bet3.getBetAmount() * (-1)));

            players.get(2).setAmount(players.get(2).getAmount() - bet3.getBetAmount());
            jLabel3Total.setText(String.valueOf(players.get(2).getAmount()));
        } else {
            jLabel7Lose.setText(" ");
        }
        if (!raceBets.get(3).getHorse().getName().equals(winnerHorse.getName())) {
            BetEntity bet4 = raceBets.get(3);
            jLabel8Lose.setText(String.valueOf(bet4.getBetAmount() * (-1)));

            players.get(3).setAmount(players.get(3).getAmount() - bet4.getBetAmount());
            jLabel4Total.setText(String.valueOf(players.get(3).getAmount()));
        } else {
            jLabel8Lose.setText(" ");
        }

        ArrayList<PlayerEntity>playersLeft= new ArrayList<>();
        
        for(PlayerEntity p: players){
            if (p.getAmount() > 0) {
                playersLeft.add(p);
            }
        }   
        HorseView.players=playersLeft;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelWinnerHorse = new javax.swing.JLabel();
        jLabelP1 = new javax.swing.JLabel();
        jLabelP2 = new javax.swing.JLabel();
        jLabelP3 = new javax.swing.JLabel();
        jLabelP4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1Win = new javax.swing.JLabel();
        jLabel2Win = new javax.swing.JLabel();
        jLabel3Win = new javax.swing.JLabel();
        jLabel4Win = new javax.swing.JLabel();
        jLabel1Total = new javax.swing.JLabel();
        jLabel2Total = new javax.swing.JLabel();
        jLabel3Total = new javax.swing.JLabel();
        jLabel4Total = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5Lose = new javax.swing.JLabel();
        jLabel6Lose = new javax.swing.JLabel();
        jLabel7Lose = new javax.swing.JLabel();
        jLabel8Lose = new javax.swing.JLabel();
        jButtonPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("El caballo ganador es :");

        jLabelWinnerHorse.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabelP1.setText("jugador 1");

        jLabelP2.setText("jugador 2");

        jLabelP3.setText("jugador 3");

        jLabelP4.setText("jugador 4");

        jLabel6.setText("ganado");

        jLabel7.setText("total");

        jLabel1Win.setText("jLabel2");

        jLabel2Win.setText("jLabel3");

        jLabel3Win.setText("jLabel4");

        jLabel4Win.setText("jLabel5");

        jLabel1Total.setText("jLabel8");

        jLabel2Total.setText("jLabel9");

        jLabel3Total.setText("jLabel10");

        jLabel4Total.setText("jLabel11");

        jLabel12.setText("perdido");

        jLabel5Lose.setText("jLabel13");

        jLabel6Lose.setText("jLabel14");

        jLabel7Lose.setText("jLabel15");

        jLabel8Lose.setText("jLabel16");

        jButtonPlay.setText("Volver a jugar");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPlay)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelWinnerHorse, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelP4)
                            .addComponent(jLabelP3)
                            .addComponent(jLabelP2)
                            .addComponent(jLabelP1))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8Lose))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7Lose))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6Lose))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5Lose))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12)))
                                .addGap(58, 58, 58))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2Win)
                                    .addComponent(jLabel3Win)
                                    .addComponent(jLabel4Win)
                                    .addComponent(jLabel1Win))
                                .addGap(153, 153, 153)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4Total)
                            .addComponent(jLabel3Total)
                            .addComponent(jLabel2Total)
                            .addComponent(jLabel1Total)
                            .addComponent(jLabel7))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelWinnerHorse, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelP1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelP2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelP3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelP4))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1Win)
                                .addComponent(jLabel5Lose))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2Win)
                                .addComponent(jLabel6Lose))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3Win)
                                .addComponent(jLabel7Lose))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4Win)
                                .addComponent(jLabel8Lose))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4Total)))
                .addGap(49, 49, 49)
                .addComponent(jButtonPlay)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        HorseView hv = new HorseView();
        hv.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonPlayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WinnerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinnerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinnerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinnerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinnerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel1Total;
    private javax.swing.JLabel jLabel1Win;
    private javax.swing.JLabel jLabel2Total;
    private javax.swing.JLabel jLabel2Win;
    private javax.swing.JLabel jLabel3Total;
    private javax.swing.JLabel jLabel3Win;
    private javax.swing.JLabel jLabel4Total;
    private javax.swing.JLabel jLabel4Win;
    private javax.swing.JLabel jLabel5Lose;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel6Lose;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel7Lose;
    private javax.swing.JLabel jLabel8Lose;
    private javax.swing.JLabel jLabelP1;
    private javax.swing.JLabel jLabelP2;
    private javax.swing.JLabel jLabelP3;
    private javax.swing.JLabel jLabelP4;
    private javax.swing.JLabel jLabelWinnerHorse;
    // End of variables declaration//GEN-END:variables
}
