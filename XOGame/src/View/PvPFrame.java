/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import AI.AI2;
import Controller.Controller;
import Model.Board;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author admin
 */
public class PvPFrame extends javax.swing.JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Creates new form PvPFrame
     */
    public PvPFrame() {
        initComponents();
        this.setTitle("XO game");
        this.setBackground(Color.GRAY);
        this.setBounds((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3, 330, 200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPvP_XGoFirst = new javax.swing.JButton();
        btnPvP_XGoSecond = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPvP_XGoFirst.setText("X Go First");
        btnPvP_XGoFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPvP_XGoFirstActionPerformed(evt);
            }
        });

        btnPvP_XGoSecond.setText("O Go First");
        btnPvP_XGoSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPvP_XGoSecondActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("PvP Mode : you are X, Choose mode :");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnPvP_XGoFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPvP_XGoSecond)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPvP_XGoFirst)
                    .addComponent(btnPvP_XGoSecond))
                .addGap(17, 17, 17)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.hide();
        WelcomeFrame welcome = new WelcomeFrame();
        welcome.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPvP_XGoFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPvP_XGoFirstActionPerformed
        // TODO add your handling code here:
        Board board = new Board();
        MainFrame main = new MainFrame(board);
        Button refresh = new Button("play again");
        main.getGameplay().add(refresh);
        Button backToMenu = new Button("Back To Menu");
        main.getGameplay().add(backToMenu);
        backToMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                main.obj.setVisible(false);
                WelcomeFrame welcom = new WelcomeFrame();
                welcom.setVisible(true);
            }
        });
        refresh.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                board.setTable();
                main.getGameplay().repaint();
            }
        });
        AI2 com = new AI2(board);
        Controller con = new Controller(board, main, com);
        this.hide();
        con.PvPMove_XGoFirst(main, board);
    }//GEN-LAST:event_btnPvP_XGoFirstActionPerformed

    private void btnPvP_XGoSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPvP_XGoSecondActionPerformed
        Board board = new Board();
        MainFrame main = new MainFrame(board);
        Button refresh = new Button("play again");
        main.getGameplay().add(refresh);
        
        Button backToMenu = new Button("Back To Menu");
        main.getGameplay().add(backToMenu);
        backToMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                main.obj.setVisible(false);
                WelcomeFrame welcom = new WelcomeFrame();
                welcom.setVisible(true);
            }
        });
        refresh.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                board.setTable();
                main.getGameplay().repaint();
            }
        });
        AI2 com = new AI2(board);
        this.hide();
        Controller con = new Controller(board, main, com);
        con.PvPMove_XGoSecond(main, board);
    }//GEN-LAST:event_btnPvP_XGoSecondActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPvP_XGoFirst;
    private javax.swing.JButton btnPvP_XGoSecond;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}