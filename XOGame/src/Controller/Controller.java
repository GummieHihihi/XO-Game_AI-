/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AI.AI2;
import AI.AIPlayer;
import View.MainFrame;
import Model.Board;
import java.awt.Graphics;
import View.GamePlay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class Controller {

    private Board board;
    private MainFrame mainframe;
    Timer timer;
    private AI2 com;
    private int turn;
    private boolean stop;
    private boolean changed;

    public Controller(Board board, MainFrame mainframe, AI2 com) {
        this.board = board;
        this.mainframe = mainframe;
        this.com = com;
        this.turn = 0;
        this.stop = false;
        com = new AI2(board);
    }

    public void boardToView(Board board, MainFrame mainframe) {
        mainframe.setBoard(board);
    }

    public void setBoardX(int row, int col, Board board) {
        board.getBoard()[row][col] = 1;
    }

    public void setBoardO(int row, int col, Board board) {
        board.getBoard()[row][col] = 2;
    }

    public void updateTable(Boolean a, Board b, Board c) {
        if (a) {
            copyBoard(b, c);
        }
    }

    public void copyBoard(Board a, Board b) {

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                a.getBoard()[row][col] = b.getBoard()[row][col];
            }
        }
    }

    //2 nguoi choi, X di truoc, trigger = click chuot
    public void PvPMove_XGoFirst(MainFrame main, Board board) {
        main.getGameplay().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (getTurn() % 2 == 0) {
                    int row = ((e.getY() - 75) / 30);
                    int col = ((e.getX() - 25) / 30);
                    board.choiceToBoard(row, col);
                    main.getGameplay().repaint();
                    System.out.print(" " + row + ", " + col + "..");
                    System.out.println("turn : " + getTurn());
                    setTurn(getTurn() + 1);
                    board.printBoard();

                } else {
                    int row = ((e.getY() - 75) / 30);
                    int col = ((e.getX() - 25) / 30);
                    board.opponentChoiceToBoard(row, col);
                    main.getGameplay().repaint();
                    System.out.print(" " + row + ", " + col);
                    System.out.println("turn" + getTurn());
                    setTurn(getTurn() + 1);
                    board.printBoard();

                }
            }
        });
    }

    public void PvPMove_XGoSecond(MainFrame main, Board board) {

        main.getGameplay().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (getTurn() % 2 == 0) {
                    int row = ((e.getY() - 75) / 30);
                    int col = ((e.getX() - 25) / 30);
                    board.opponentChoiceToBoard(row, col);
                    main.getGameplay().repaint();
                    System.out.print(" " + row + ", " + col);
                    setTurn(getTurn() + 1);
                    System.out.print("turn" + getTurn());

                } else {
                    int row = ((e.getY() - 75) / 30);
                    int col = ((e.getX() - 25) / 30);
                    board.choiceToBoard(row, col);
                    main.getGameplay().repaint();
                    System.out.print(" " + row + ", " + col);
                    setTurn(getTurn() + 1);
                    System.out.print("turn" + getTurn());

                }
            }
        });
    }

    public void CvPMove_XGoFirst(MainFrame main, Board board) {
        comFirstMove_GoFirst(main, board);
        main.getGameplay().repaint();
        main.getGameplay().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int row = ((e.getY() - 75) / 30);
                int col = ((e.getX() - 25) / 30);
                board.choiceToBoard(row, col);
                com.makeBestMove();
                main.getGameplay().repaint();
            }
        });
    }

    public void CvPMove_XGoSecond(MainFrame main, Board board) {
        main.getGameplay().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (getTurn() == 0) {
                    int row = ((e.getY() - 75) / 30);
                    int col = ((e.getX() - 25) / 30);
                    board.choiceToBoard(row, col);
                    com.comMakeFirstMove_goSecond();
                    main.getGameplay().repaint();
                    setTurn(getTurn() + 1);
                }
                else  {
                    int row = ((e.getY() - 75) / 30);
                    int col = ((e.getX() - 25) / 30);
                    board.choiceToBoard(row, col);
                    com.makeBestMove();
                    main.getGameplay().repaint();
                }
            }
        });
    }

    public void comFirstMove_GoFirst(MainFrame main, Board board) {
        com.makeFirstMove_goFirst();
    }

    /**
     * @return the turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    private void stop() {

    }
}
