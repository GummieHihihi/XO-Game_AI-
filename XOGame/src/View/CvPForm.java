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
public class CvPForm extends javax.swing.JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Creates new form CvPForm
     */
    public CvPForm() {
        initComponents();
        this.setTitle("XO game");
        this.setBackground(Color.GRAY);
        this.setBounds((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3, 330, 200);
        this.setResizable(false);
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
        btnXgoFirst = new javax.swing.JButton();
        btnXGoSecond = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("You are X, choose the mode you want to play");

        btnXgoFirst.setText("You Go First");
        btnXgoFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXgoFirstActionPerformed(evt);
            }
        });

        btnXGoSecond.setText("You Go Second");
        btnXGoSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXGoSecondActionPerformed(evt);
            }
        });

        btnBack.setText("Back To Main Menu");
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
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXgoFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnXGoSecond))
                    .addComponent(jLabel1))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXGoSecond)
                    .addComponent(btnXgoFirst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXgoFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXgoFirstActionPerformed
        Board board = new Board();
        MainFrame main = new MainFrame(board);
        AI2 com = new AI2(board);
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
        Controller con = new Controller(board, main, com);
        refresh.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                main.obj.hide();
                CvPForm cvNew = new CvPForm();
                cvNew.setVisible(true);
            }
        });
        this.setVisible(false);
        con.CvPMove_XGoSecond(main, board);
    }//GEN-LAST:event_btnXgoFirstActionPerformed

    private void btnXGoSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXGoSecondActionPerformed
        Board board = new Board();
        MainFrame main = new MainFrame(board);
        AI2 com = new AI2(board);
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
        Controller con = new Controller(board, main, com);
        refresh.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                main.obj.hide();
                CvPForm cvNew = new CvPForm();
                cvNew.setVisible(true);
            }
        });
        this.setVisible(false);
        con.CvPMove_XGoFirst(main, board);
    }//GEN-LAST:event_btnXGoSecondActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.hide();
        WelcomeFrame welcome = new WelcomeFrame();
        welcome.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnXGoSecond;
    private javax.swing.JButton btnXgoFirst;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}