/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import AI.AI2;
import AI.AIPlayer;
import Controller.Controller;
import Model.Board;
import View.GamePlay;
import View.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class Main extends JPanel {

    boolean change = false;

    public static void main(String[] args) {
        Board board = new Board();

        MainFrame main = new MainFrame(board);
        AI2 com = new AI2(board);
        Controller con = new Controller(board, main, com);
        con.CvPMove_XGoSecond(main, board);
    }
}
