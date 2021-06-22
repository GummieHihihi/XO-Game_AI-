/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Dot;

/**
 *
 * @author admin
 */
public class Board {

    int[][] board = new int[20][20];
    public Board() {
        this.board = board;
    }

    /**
     * @return the Board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @param Board the Board to set
     */
    public void setTable() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = 0;
            }
        }

    }

    public void setX(int row, int col) {
        board[row][col] = 1;
    }

    public void setO(int row, int col) {
        board[row][col] = 2;
    }

    public boolean checkWin() {
        boolean hasWon = false;
        //check hang ngang

        // 4 cai lien tiep va cai thu 5 ko bi chan, co' tinh cot 1 va cot cuoi
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 17; col++) {
                // tu 1 den 15
                if (col > 0 && col < 16) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3] && posNull(row, col + 4)
                            && posNull(row, col - 1) && board[row][col] == 1) {
                        hasWon = true;
                    }
                }
                //cot` 1
                if (col == 0) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3] && posNull(row, col + 4) && board[row][col] == 1) {
                        hasWon = true;
                    }
                    // cot 16
                }
                if (col == 16) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3] && posNull(row, col - 1) && board[row][col] == 1) {
                        hasWon = true;
                    }
                }
            }
        }

        //check hang ngang 5 so = nhau va bi chan 1 dau 
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 16; col++) {
                //hang` 1
                if (col == 0) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3]
                            && board[row][col + 3] == board[row][col + 4] && board[row][col] == 1 && board[row][col + 5] == 2) {
                        hasWon = true;
                    }
                }
                if (row == 15) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3]
                            && board[row][col + 3] == board[row][col + 4] && board[row][col] == 1 && board[row][col - 1] == 2) {
                        hasWon = true;
                    }
                }
                if (row > 0 && row < 15) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3]
                            && board[row][col + 3] == board[row][col + 4] && board[row][col] == 1) {
                        if (board[row][col + 5] == 2 || board[row][col - 1] == 2) {
                            hasWon = true;
                        }
                    }
                }
            }
        }

        //check hang cheo sang ben phai 4 dot lien tuc ko bi cach
        for (int row = 0; row < 17; row++) {
            for (int col = 0; col < 17; col++) {
                if (col == 16 && row == 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1) {
                        hasWon = true;
                    }
                }
                if (col == 16 && row > 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1 && posNull(row - 1, col - 1)) {
                        hasWon = true;
                    }
                }
                if (col == 0 && row == 17) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1) {
                        hasWon = true;
                    }
                }
                if (col == 0 && row < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1 && posNull(row + 4, col + 4)) {
                        hasWon = true;
                    }
                }
                if (col > 0 && row == 0 && col < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1 && posNull(row + 4, col + 4)) {
                        hasWon = true;
                    }
                }
                if (col > 0 && row == 16 && col < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1 && posNull(row - 1, col - 1)) {
                        hasWon = true;
                    }
                }
                if (col > 0 && row < 16 && row > 0 && col < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 1 && posNull(row - 1, col - 1) && posNull(row + 4, col + 4)) {
                        hasWon = true;
                    }
                }
            }
        }

        //check hang cheo 1 dot bi chan va win 5 dots
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 16; col++) {
                //dot cuoi cung ngoai bien phai
                if (col == 15 && row > 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 1 && board[row - 1][col - 1] == 2) {
                        hasWon = true;
                    }
                }
                //dot cuoi cung ngoai bien trai
                if (col == 0 && row >= 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 1 && board[row + 5][col + 5] == 2) {
                        hasWon = true;
                    }
                }
                //dot dau tien tren cung`
                if (col > 0 && row == 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 1 && board[row + 5][col + 5] == 2) {
                        hasWon = true;
                    }
                }
                // dot cuoi cung cham day board
                if (col > 0 && row == 15) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 1 && board[row - 1][col - 1] == 2) {
                        hasWon = true;
                    }
                }
                //th base 
                if (col > 0 && col < 15 && row > 0 && row < 15) {
                    if (board[row][col] == board[row + 1][col + 1]
                            && board[row + 2][col + 2] == board[row + 1][col + 1] && board[row + 2][col + 2] == board[row + 3][col + 3]
                            && board[row + 3][col + 3] == board[row + 4][col + 4] && board[row][col] == 1) {
                        if (board[row + 5][col + 5] == 2 || board[row - 1][col - 1] == 2) {
                            hasWon = true;
                        }
                    }
                }
            }
        }
        //check hang doc
        //check doc  4 so 
        for (int row = 0; row < 17; row++) {
            for (int col = 0; col < 20; col++) {
                // ben ngoai cung ben phai 
                if (row == 16) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row][col] == 1 && board[row - 1][col] == 0) {
                        hasWon = true;
                    }
                }
                //ben ngoaif cung ben trai
                if (row == 0) {
                    if (board[row + 1][col] == board[row][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row][col] == 1 && board[row + 4][col] == 0) {
                        hasWon = true;
                    }
                }
                //truong hop o giua
                if (row > 0 && row < 16) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row][col] == 1 && board[row - 1][col] == 0 && board[row + 4][col] == 0) {
                        hasWon = true;
                    }
                }
            }
        }

        //check hang doc 5 so bi chan 1 trong 2
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row + 3][col] == board[row + 4][col] && board[row][col] == 1 && board[row + 5][col] == 2) {
                        hasWon = true;
                    }
                }
                if (row == 15) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row + 3][col] == board[row + 4][col] && board[row][col] == 1 && board[row - 1][col] == 2) {
                        hasWon = true;
                    }
                }
                if (row > 0 && row < 15) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row + 3][col] == board[row + 4][col] && board[row][col] == 1) {
                        if (board[row - 1][col] == 2 || board[row + 5][col] == 2) {
                            hasWon = true;
                        }
                    }
                }
            }
        }

        //check hang cheo sang trai
        //check hang cheo 4 so ko bi chan 
        for (int row = 0; row < 17; row++) {
            for (int col = 3; col < 20; col++) {
                if (col == 3 && row == 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1) {
                        hasWon = true;
                    }
                }
                if (col == 19 && row == 16) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1) {
                        hasWon = true;
                    }
                }
                if (col == 3 && row > 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1 && posNull(row - 1, col + 1)) {
                        hasWon = true;
                    }
                }
                if (col == 19 && row < 16 && row != 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1 && posNull(row + 4, col - 4)) {
                        hasWon = true;
                    }
                }
                if (col > 3 && row == 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1 && posNull(row + 4, col - 4)) {
                        hasWon = true;
                    }
                }
                if (col > 3 && row == 16 && col < 19) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1 && posNull(row - 1, col + 1)) {
                        hasWon = true;
                    }
                }
                if (row > 0 && row < 16 && col > 3 && col < 19) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 1 && posNull(row - 1, col + 1) && posNull(row + 4, col - 4)) {
                        hasWon = true;
                    }
                }
            }
        }

        //check cheo ben trai 5 so lien tiep bi chan 1
        for (int row = 0; row < 16; row++) {
            for (int col = 4; col < 20; col++) {
                if (col == 4 && row < 16 && row > 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 1 && board[row - 1][col + 1] == 2) {
                        hasWon = true;
                    }
                }
                if (col == 19 && row < 15) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 1 && board[row + 5][col - 5] == 2) {
                        hasWon = true;
                    }
                }
                if (col > 4 && col < 19 && row == 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 1 && board[row + 5][col - 5] == 2) {
                        hasWon = true;
                    }
                }
                if (col > 4 && col < 19 && row == 15) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 1 && board[row - 1][col + 1] == 2) {
                        hasWon = true;
                    }
                }
                if (col > 4 && col < 19 && row > 0 && row < 15) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 1) {
                        if (board[row - 1][col + 1] == 2 || board[row + 5][col - 5] == 2) {
                            hasWon = true;
                        }
                    }
                }
            }
        }
        return hasWon;
    }

    public void printBoard() {
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (col % 20 == 0) {
                    System.out.println("");
                }
                System.out.print(board[row][col] + "");

            }
        }
    }

    public int getValueAt(int row, int col, int i) {
        return board[row][col];
    }

    public boolean checkLose() {
        boolean hasLose = false;
        //check hang ngang

        // 4 cai lien tiep va cai thu 5 ko bi chan, co' tinh cot 1 va cot cuoi
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 17; col++) {
                // tu 1 den 15
                if (col > 0 && col < 16) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3] && posNull(row, col + 4)
                            && posNull(row, col - 1) && board[row][col] == 2) {
                        hasLose = true;
                    }
                }
                //cot` 1
                if (col == 0) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3] && posNull(row, col + 4) && board[row][col] == 2) {
                        hasLose = true;
                    }
                    // cot 16
                }
                if (col == 26) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3] && posNull(row, col - 1) && board[row][col] == 2) {
                        hasLose = true;
                    }
                }
            }
        }

        //check hang ngang 5 so = nhau va bi chan 1 dau 
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 16; col++) {
                //hang` 1
                if (col == 0) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3]
                            && board[row][col + 3] == board[row][col + 4] && board[row][col] == 2 && board[row][col + 5] == 1) {
                        hasLose = true;
                    }
                }
                if (row == 25) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3]
                            && board[row][col + 3] == board[row][col + 4] && board[row][col] == 2 && board[row][col - 1] == 1) {
                        hasLose = true;
                    }
                }
                if (row > 0 && row < 15) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col + 2] == board[row][col + 1] && board[row][col + 2] == board[row][col + 3]
                            && board[row][col + 3] == board[row][col + 4] && board[row][col] == 2) {
                        if (board[row][col + 5] == 1 || board[row][col - 1] == 1) {
                            hasLose = true;
                        }
                    }
                }
            }
        }

        //check hang cheo sang ben phai 4 dot lien tuc ko bi cach
        for (int row = 0; row < 17; row++) {
            for (int col = 0; col < 17; col++) {
                if (col == 26 && row == 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2) {
                        hasLose = true;
                    }
                }
                if (col == 26 && row > 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2 && posNull(row - 1, col - 1)) {
                        hasLose = true;
                    }
                }
                if (col == 0 && row == 27) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2) {
                        hasLose = true;
                    }
                }
                if (col == 0 && row < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2 && posNull(row + 4, col + 4)) {
                        hasLose = true;
                    }
                }
                if (col > 0 && row == 0 && col < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2 && posNull(row + 4, col + 4)) {
                        hasLose = true;
                    }
                }
                if (col > 0 && row == 26 && col < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2 && posNull(row - 1, col - 1)) {
                        hasLose = true;
                    }
                }
                if (col > 0 && row < 16 && row > 0 && col < 16) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row][col] == 2 && posNull(row - 1, col - 1) && posNull(row + 4, col + 4)) {
                        hasLose = true;
                    }
                }
            }
        }

        //check hang cheo 1 dot bi chan va win 5 dots
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 16; col++) {
                //dot cuoi cung ngoai bien phai
                if (col == 25 && row > 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 2 && board[row - 1][col - 1] == 1) {
                        hasLose = true;
                    }
                }
                //dot cuoi cung ngoai bien trai
                if (col == 0 && row >= 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 2 && board[row + 5][col + 5] == 1) {
                        hasLose = true;
                    }
                }
                //dot dau tien tren cung`
                if (col > 0 && row == 0) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 2 && board[row + 5][col + 5] == 1) {
                        hasLose = true;
                    }
                }
                // dot cuoi cung cham day board
                if (col > 0 && row == 25) {
                    if (board[row][col] == board[row + 1][col + 1] && board[row + 1][col + 1] == board[row + 2][col + 2]
                            && board[row + 2][col + 2] == board[row + 3][col + 3] && board[row + 3][col + 3] == board[row + 4][col + 4]
                            && board[row][col] == 2 && board[row - 1][col - 1] == 1) {
                        hasLose = true;
                    }
                }
                //th base 
                if (col > 0 && col < 15 && row > 0 && row < 15) {
                    if (board[row][col] == board[row + 1][col + 1]
                            && board[row + 2][col + 2] == board[row + 1][col + 1] && board[row + 2][col + 2] == board[row + 3][col + 3]
                            && board[row + 3][col + 3] == board[row + 4][col + 4] && board[row][col] == 2) {
                        if (board[row + 5][col + 5] == 1 || board[row - 1][col - 1] == 1) {
                            hasLose = true;
                        }
                    }
                }
            }
        }
        //check hang doc

        //check doc  4 so 
        for (int row = 0; row < 17; row++) {
            for (int col = 0; col < 20; col++) {
                // ben ngoai cung ben phai 
                if (row == 26) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row][col] == 2 && board[row - 1][col] == 0) {
                        hasLose = true;
                    }
                }
                //ben ngoaif cung ben trai
                if (row == 0) {
                    if (board[row + 1][col] == board[row][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row][col] == 2 && board[row + 4][col] == 0) {
                        hasLose = true;
                    }
                }
                //truong hop o giua
                if (row > 0 && row < 16) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row][col] == 2 && board[row - 1][col] == 0 && board[row + 4][col] == 0) {
                        hasLose = true;
                    }
                }
            }
        }

        //check hang doc 5 so bi chan 1 trong 2
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row + 3][col] == board[row + 4][col] && board[row][col] == 2 && board[row + 5][col] == 1) {
                        hasLose = true;
                    }
                }
                if (row == 25) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row + 3][col] == board[row + 4][col] && board[row][col] == 2 && board[row - 1][col] == 1) {
                        hasLose = true;
                    }
                }
                if (row > 0 && row < 15) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row + 2][col] == board[row + 1][col] && board[row + 2][col] == board[row + 3][col]
                            && board[row + 3][col] == board[row + 4][col] && board[row][col] == 2) {
                        if (board[row - 1][col] == 1 || board[row + 5][col] == 1) {
                            hasLose = true;
                        }
                    }
                }
            }
        }

        //check hang cheo sang trai
        //check hang cheo 4 so ko bi chan 
        for (int row = 0; row < 17; row++) {
            for (int col = 3; col < 20; col++) {
                if (col == 3 && row == 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2) {
                        hasLose = true;
                    }
                }
                if (col == 29 && row == 26) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2) {
                        hasLose = true;
                    }
                }
                if (col == 3 && row > 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2 && posNull(row - 1, col + 1)) {
                        hasLose = true;
                    }
                }
                if (col == 29 && row < 16 && row != 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2 && posNull(row + 4, col - 4)) {
                        hasLose = true;
                    }
                }
                if (col > 3 && row == 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2 && posNull(row + 4, col - 4)) {
                        hasLose = true;
                    }
                }
                if (col > 3 && row == 26 && col < 19) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2 && posNull(row - 1, col + 1)) {
                        hasLose = true;
                    }
                }
                if (row > 0 && row < 16 && col > 3 && col < 19) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row][col] == 2 && posNull(row - 1, col + 1) && posNull(row + 4, col - 4)) {
                        hasLose = true;
                    }
                }
            }
        }

        //check cheo ben trai 5 so lien tiep bi chan 1
        for (int row = 0; row < 16; row++) {
            for (int col = 4; col < 20; col++) {
                if (col == 4 && row < 16 && row > 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 2 && board[row - 1][col + 1] == 1) {
                        hasLose = true;
                    }
                }
                if (col == 29 && row < 15) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 2 && board[row + 5][col - 5] == 1) {
                        hasLose = true;
                    }
                }
                if (col > 4 && col < 19 && row == 0) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 2 && board[row + 5][col - 5] == 1) {
                        hasLose = true;
                    }
                }
                if (col > 4 && col < 19 && row == 25) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 2 && board[row - 1][col + 1] == 1) {
                        hasLose = true;
                    }
                }
                if (col > 4 && col < 19 && row > 0 && row < 15) {
                    if (board[row][col] == board[row + 1][col - 1] && board[row + 1][col - 1] == board[row + 2][col - 2]
                            && board[row + 2][col - 2] == board[row + 3][col - 3] && board[row + 3][col - 3] == board[row + 4][col - 4] && board[row][col] == 2) {
                        if (board[row - 1][col + 1] == 1 || board[row + 5][col - 5] == 1) {
                            hasLose = true;
                        }
                    }
                }
            }
        }
        return hasLose;
    }

    public void choiceToBoard(int row, int col) {
        board[row][col] = 1;
    }

    public void opponentChoiceToBoard(int row, int col) {
        board[row][col] = 2;
    }

   

    public boolean posNull(int row, int col) {
        if (board[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }

}
