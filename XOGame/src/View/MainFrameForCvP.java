/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class MainFrameForCvP {

    Random rand = new Random();
    private int comScore = 0;
    private int yourScore = 0;
    ImageIcon XImage;
    ImageIcon YImage;
    private GamePlay gameplay;
    private Board board;

    public MainFrameForCvP(Board board) {
        this.board = board;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.gameplay = new GamePlay(board);
        JFrame obj = new JFrame();
        obj.setBounds((int) screenSize.getWidth() / 4, (int) screenSize.getHeight() / 4, 650, 725);
        obj.setBackground(Color.DARK_GRAY);
        obj.setVisible(true);
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setTitle("XO game");
        obj.add(gameplay);
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the gameplay
     */
    public GamePlay getGameplay() {
        return gameplay;
    }

    /**
     * @param gameplay the gameplay to set
     */
    public void setGameplay(GamePlay gameplay) {
        this.gameplay = gameplay;
    }
}
