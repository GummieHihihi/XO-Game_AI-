/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Board;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author admin
 */
public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private ImageIcon XImage;
    private ImageIcon OImage;
    Random rand = new Random();
    
    private Board board;
    public boolean newGame = false;
    public int row;
    public int col;

    public boolean gameMode1;
    public boolean gameMode2;

    public GamePlay(Board board) {
        this.board = board;
        gameMode1 = false;
        gameMode2 = false;
        newGame = false; 

    }

    public void paint(Graphics g) {
        //draw background for the game play 
        g.setColor(Color.WHITE);
        g.fillRect(25, 75, 600, 600);

        // draw scores 
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        

        for (int i = 25; i < 600; i = i + 30) {
            for (int j = 75; j < 650; j = j + 30) {
                g.setColor(Color.BLACK);
                g.drawRect(i, j, 30, 30);
            }
        }
        System.out.println("value of newGame : " + newGame);
        update(getBoard(), g);

    }

    private void update(Board board, Graphics g) {
        OImage = new ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\XOGame\\src\\Imange\\OImage.png");
        XImage = new ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\XOGame\\src\\Imange\\XImage.png");

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (board.getBoard()[row][col] == 2) {
                    OImage.paintIcon(this, g, col * 30 + 28, row * 30 + 77);
                }
                if (board.getBoard()[row][col] == 1) {
                    XImage.paintIcon(this, g, col * 30 + 28, row * 30 + 83);
                }
                if (gameOver_playerXWin()) {
                   
                    g.setColor(Color.RED);
                    g.setFont(new Font("arial", Font.BOLD, 50));
                    g.drawString("Game Over", 200, 300);
                    g.setFont(new Font("arial", Font.BOLD, 30));
                    g.drawString("player X win, press play again button to restart ", 60, 350);
                }
                if (gameOver_playerOwin()) {
                  
                    g.setColor(Color.RED);
                    g.setFont(new Font("arial", Font.BOLD, 50));
                    g.drawString("Game Over", 200, 300);
                    g.setFont(new Font("arial", Font.BOLD, 30));
                    g.drawString("player O win, press play again button to restart ", 60, 350);
                }
            }
        }
    }
    

    boolean gameOver_playerXWin() {
        boolean gameover = false;
        if (board.checkWin()) {
            gameover = true;
        }
        return gameover;
    }

    boolean gameOver_playerOwin() {
        boolean gameover = false;
        if (board.checkLose()) {
            gameover = true;
        }
        return gameover;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (newGame == true) {
            repaint();
        }

    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_2) {
            newGame = true;
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_2) {
            newGame = true;
            repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_2) {
            newGame = true;
            repaint();
        }
    }

}
