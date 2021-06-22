/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Board;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class MainFrame {

    Random rand = new Random();
    private int comScore = 0;
    private int yourScore = 0;
    ImageIcon XImage;
    ImageIcon YImage;
    private GamePlay gameplay;
    private Board board;
    JFrame obj;

    public MainFrame(Board board) {
        // TODO code application logic here
        this.board = board;
        this.obj = obj;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.gameplay = new GamePlay(board);
        obj = new JFrame();
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
