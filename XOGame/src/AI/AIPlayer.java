/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import Model.Board;
import java.util.Random;

/**
 *
 * @author admin
 */
public class AIPlayer {

    Board board;
    boolean playFirst = false;
    Random rand = new Random();
    int nextMoveRow;
    int nextMoveCol;

    public AIPlayer(Board board) {
        this.board = board;
    }

    public void updateBoard(Board board) {
        this.board = board;
    }

    private boolean isTurnOne() {
        boolean isTurnOne = false;
        int count = 0;
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard().length; col++) {
                if (board.getBoard()[row][col] != 0) {
                    count++;
                }
            }
        }
        if (count == 0) {
            isTurnOne = true;
        }
        return isTurnOne;
    }

    private boolean isTurnTwo() {
        boolean isTurnTwo = false;
        int count = 0;
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard().length; col++) {
                if (board.getBoard()[row][col] != 0) {
                    count++;
                }
            }
        }
        if (count == 1) {
            isTurnTwo = true;
        }
        return isTurnTwo;
    }

    public void makeFirstMove_goFirst() {
        if (isTurnOne()) {
            nextMoveRow = rand.nextInt(19);
            nextMoveCol = rand.nextInt(19);
            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
        }
    }

    public void secondMove_goFirst() {
        int row = 0;
        int col = 0;
        boolean stop = false;
        boolean sastisfy = false;
        for (row = 0; row < 19; row++) {
            for (col = 0; col < 19; col++) {
                if (board.getBoard()[row][col] == 1) {
                    stop = true;
                    break;
                }
            }
            if (stop == true) {
                break;
            }
        }
        while (sastisfy == false) {
            // trung hop nuoc dau tien vi tri 00
            if (col == 0 && row == 0) {
                int randomNumber = rand.nextInt(3) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = 1;
                    nextMoveRow = 0;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 1) {
                    nextMoveCol = 1;
                    nextMoveRow = 1;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 3) {
                    nextMoveCol = 0;
                    nextMoveRow = 1;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
            }
            // vi tri 19,0
            if (col == 19 && row == 0) {
                int randomNumber = rand.nextInt(3) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = 18;
                    nextMoveRow = 0;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 1) {
                    nextMoveCol = 19;
                    nextMoveRow = 1;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 3) {
                    nextMoveCol = 18;
                    nextMoveRow = 1;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
            }
            //vi tri 0,19
            if (col == 0 && row == 19) {
                int randomNumber = rand.nextInt(3) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = 0;
                    nextMoveRow = 18;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 1) {
                    nextMoveCol = 1;
                    nextMoveRow = 19;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 3) {
                    nextMoveCol = 1;
                    nextMoveRow = 18;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
            }//vi tri 19,19
            if (col == 19 && row == 19) {
                int randomNumber = rand.nextInt(3) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = 18;
                    nextMoveRow = 18;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 1) {
                    nextMoveCol = 18;
                    nextMoveRow = 19;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
                if (randomNumber == 3) {
                    nextMoveCol = 19;
                    nextMoveRow = 18;
                    if (board.posNull(nextMoveRow, nextMoveCol)) {
                        board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        sastisfy = true;
                    }
                }
            }
            //cot ngoai cung ben trái
            if (col == 0 && row != 0 && row != 19) {
                int randomNumber = rand.nextInt(5) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = col;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 1) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 3) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row;
                }
                if (randomNumber == 4) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 5) {
                    nextMoveCol = col;
                    nextMoveRow = row + 1;
                }
                if (board.posNull(nextMoveRow, nextMoveCol)) {
                    board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                    sastisfy = true;
                }
            }
            //cot ngoai cung ben phai
            if (col == 19 && row != 0 && row != 19) {
                int randomNumber = rand.nextInt(5) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = col;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 3) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row;
                }
                if (randomNumber == 4) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 5) {
                    nextMoveCol = col;
                    nextMoveRow = row + 1;
                }
                if (board.posNull(nextMoveRow, nextMoveCol)) {
                    board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                    sastisfy = true;
                }
            }

            //hang cuoi cung ben duoi
            if (row == 0 && col != 0 && col != 19) {
                int randomNumber = rand.nextInt(5) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row;
                }
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 3) {
                    nextMoveCol = col;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 4) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 5) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row;
                }
                if (board.posNull(nextMoveRow, nextMoveCol)) {
                    board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                    sastisfy = true;
                }
            }
            // hang cuoi cung ben duoi 
            if (row == 19 && col != 0 && col != 19) {
                int randomNumber = rand.nextInt(5) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row;
                }
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 3) {
                    nextMoveCol = col;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 4) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 5) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row;
                }
                if (board.posNull(nextMoveRow, nextMoveCol)) {
                    board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                    sastisfy = true;
                }
            } // truong hop o giua
            else {
                int randomNumber = rand.nextInt(8) + 1;
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row;
                }
                if (randomNumber == 1) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 3) {
                    nextMoveCol = col;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 4) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row - 1;
                }
                if (randomNumber == 5) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row;
                }
                if (randomNumber == 6) {
                    nextMoveCol = col + 1;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 7) {
                    nextMoveCol = col;
                    nextMoveRow = row + 1;
                }
                if (randomNumber == 8) {
                    nextMoveCol = col - 1;
                    nextMoveRow = row + 1;
                }

                if (board.posNull(nextMoveRow, nextMoveCol)) {
                    board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                    sastisfy = true;
                }
            }
        }

    }

    public void makeFirstMove_goSecond() {
        int count = 0;
        int row;
        int col;
        boolean stop = false;
        for (row = 0; row < board.getBoard().length; row++) {
            for (col = 0; col < board.getBoard().length; col++) {
                if (board.getBoard()[row][col] != 0) {
                    count++;
                    stop = true;
                    break;
                }
            }
            if (stop = true) {
                break;
            }
        }

    }

    public void makeSecondMove_goSecond() {
        if (isTurnTwo()) {
            int row;
            int col;
            for (row = 0; row < board.getBoard().length; row++) {
                for (col = 0; col < board.getBoard().length; col++) {
                    if (board.getBoard()[row][col] != 0) {
                        break;
                    }
                }
            }

        }
    }

    public void makeBestMove() {
        boolean done = false;
        //truong hop phai def truoc
        if (mustDef()) {
            doDef(board);
            done = true;
        } else if (mustAttackToWin()) // truong hop co the tan cong
        {
            if (done == false) {
                doAttackToWin(board);
                done = true;
            }

        } else if (chancesToMakeOpportunity()) {
            if (done == false) {
                doOpportunity();
                done = true;
            }
        } else if (needToBlockEarly()) {
            if (done == false) {
                doBlockEarly();
                done = true;
            }
        }  //truong hop ko def ko attack, chan move

    }

    private void playRandom() {
        int col = 0;
        int row = 0;
        boolean hasMakeMove = false;

        for (row = 0; row < 20; row++) {
            for (col = 0; col < 20; col++) {
                if (hasMakeMove = false) {
                    if (board.getBoard()[row][col] == 0) {
                        nextMoveCol = col;
                        nextMoveRow = row;
                    }
                    board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                }
            }
        }
    }

    private boolean opHas2OutOf3Def(int a, int b, int c) {
        boolean has3OutOf4 = false;
        int count = 0;
        if (a == 1) {
            count++;
        }
        if (b == 1) {
            count++;
        }
        if (c == 1) {
            count++;
        }

        if (count == 2) {
            has3OutOf4 = true;
        }
        return has3OutOf4;
    }

    private boolean comHas2OutOf3(int a, int b, int c) {
        boolean has3OutOf4 = false;
        int count = 0;
        if (a == 2) {
            count++;
        }
        if (b == 2) {
            count++;
        }
        if (c == 2) {
            count++;
        }

        if (count == 2) {
            has3OutOf4 = true;
        }
        return has3OutOf4;
    }

    private boolean opHas3OutOf4Def(int a, int b, int c, int d) {
        boolean has3OutOf4 = false;
        int count = 0;
        if (a == 1) {
            count++;
        }
        if (b == 1) {
            count++;
        }
        if (c == 1) {
            count++;
        }
        if (d == 1) {
            count++;
        }
        if (count == 3) {
            has3OutOf4 = true;
        }
        return has3OutOf4;
    }

    private boolean comHas3OutOf4(int a, int b, int c, int d) {
        boolean has3OutOf4 = false;
        int count = 0;
        if (a == 2) {
            count++;
        }
        if (b == 2) {
            count++;
        }
        if (c == 2) {
            count++;
        }
        if (d == 2) {
            count++;
        }
        if (count == 3) {
            has3OutOf4 = true;
        }
        return has3OutOf4;
    }

    private boolean opHas4OutOf5Def(int a, int b, int c, int d, int e) {
        boolean has3OutOf4 = false;
        int count = 0;
        if (a == 1) {
            count++;
        }
        if (b == 1) {
            count++;
        }
        if (c == 1) {
            count++;
        }
        if (d == 1) {
            count++;
        }
        if (e == 1) {
            count++;
        }
        if (count == 4) {
            has3OutOf4 = true;
        }
        return has3OutOf4;
    }

    private boolean comHas4OutOf5(int a, int b, int c, int d, int e) {
        boolean has3OutOf4 = false;
        int count = 0;
        if (a == 2) {
            count++;
        }
        if (b == 2) {
            count++;
        }
        if (c == 2) {
            count++;
        }
        if (d == 2) {
            count++;
        }
        if (e == 2) {
            count++;
        }
        if (count == 4) {
            has3OutOf4 = true;
        }
        return has3OutOf4;
    }

    // condition of the game to make decision 
    public boolean mustDef() {
        int row = 0;
        int col = 0;
        boolean mustDef = false;
        // hang` doc 4 so, xet 4 so truoc mat theo hang doc neu co 3 cai va khong bi chan thi danh 
        for (row = 0; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board.getBoard()[row + 4][col] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row == 16) {
                    if (board.getBoard()[row - 1][col] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row > 0 && row < 16) {
                    if (board.getBoard()[row - 1][col] == 0 && board.getBoard()[row + 4][col] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

        //hang doc 5 so bi chan 1 dau
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board.getBoard()[row + 5][col] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row == 15) {
                    if (board.getBoard()[row - 1][col] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                            mustDef = true;
                        }
                    }
                }

                if (row > 0 && row < 15) {
                    if (board.getBoard()[row + 5][col] == 2 || board.getBoard()[row - 1][col] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        //hang ngang 4 so ko bi chan
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (col == 0) {
                    if (board.getBoard()[row][col + 4] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 16 && col > 0) {
                    if (board.getBoard()[row][col - 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 16) {
                    if (board.getBoard()[row][col + 4] == 0 && board.getBoard()[row][col - 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

// hang ngang 5 so lien tiep bi chan 1 dau
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (col == 0) {
                    if (board.getBoard()[row][col + 5] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                            mustDef = true;
                        }
                    }
                }

                if (col == 15) {
                    if (board.getBoard()[row][col - 1] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 15) {
                    if (board.getBoard()[row][col - 1] == 2 || board.getBoard()[row][col + 5] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        //hang cheo sang phai
        //hang cheo sang phai 4 so lien tiep la win, khong bi chan

        for (row = 0; row < 17; row++) {
            for (col = 0; col < 17; col++) {
                //vi tri 16/0
                if (col == 0 && row == 16) {
                    if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                        mustDef = true;
                    }
                }

                if (row == 0 && col == 16) {
                    if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                        mustDef = true;
                    }
                }

                if (row == 0 && col < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 0 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

//truong hop cot ben phai ngoai cung
                if (col == 16 && row > 0) {
                    if (board.getBoard()[row - 1][col - 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

                //truong hop ben duoi cung
                if (row == 16 && col > 0 && col < 16) {
                    if (board.getBoard()[row - 1][col - 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 16 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0 && board.getBoard()[row - 1][col - 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        // hang cheo ben phai 5 so bi chan 1 dau 
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 16; col++) {
                //vi tri 15/0
                if (col == 0 && row == 15) {
                    if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                            board.getBoard()[row + 4][col + 4])) {
                        mustDef = true;
                    }
                }
                //vi tri 0,15
                if (col == 0 && row == 15) {
                    if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                            board.getBoard()[row + 4][col + 4])) {
                        mustDef = true;
                    }
                }
                //ben tren cung`
                if (row == 0 && col < 15) {
                    if (board.getBoard()[row + 5][col + 5] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
                //truong hop ben ngoai ben cung(ben trai)
                if (col == 0 && row > 0 && row < 15) {
                    if (board.getBoard()[row + 5][col + 5] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }

                    }
                }
                //truong hop cot ben phai ngoai cung
                if (col == 15 && row > 0) {
                    if (board.getBoard()[row - 1][col - 1] == 1) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
//truong hop ben duoi cung
                if (row == 15 && col > 0 && col < 15) {
                    if (board.getBoard()[row - 1][col - 1] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
//truong hop co ban
                if (col > 0 && col < 15 && row > 0 && row < 15) {
                    if (board.getBoard()[row + 5][col + 5] == 2 || board.getBoard()[row - 1][col - 1] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        // truong hop cheo  ben trai va 2 dau ko bi chan
        for (row = 0; row < 18; row++) {
            for (col = 3; col < 19; col++) {
                //vi tri 16/0
                if (col == 19 && row == 16) {
                    if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                        mustDef = true;
                    }
                }
                //vi tri 0,16
                if (row == 0 && col == 3) {
                    if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                        mustDef = true;

                    }
                } //ben tren cung`
                if (row == 0 && col > 3) {
                    if (board.getBoard()[row + 4][col - 4] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }

                    }
                }
//truong hop ben trai ngoai` cung
                if (col == 3 && row > 0 && row < 16) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 18 && row > 0 && row < 17) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
                //truong hop ben duoi cung
                if (row == 16 && col > 3) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
// th co ban
                if (col > 3 && col < 19 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col - 4] == 0 && board.getBoard()[row - 1][col + 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }

                //hang ngang 4 so ko bi chan
            }
        }

        //truong hop cheo ben trai co 1 dau bi chan 
        for (row = 4; row < 20; row++) {
            for (col = 4; col < 20; col++) {
                //vi tri 15/19
                if (col == 19 && row == 15) {
                    if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                            board.getBoard()[row + 4][col - 4])) {
                        mustDef = true;
                    }
                }
                //vi tri 0,4
                if (row == 0 && col == 4) {
                    if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                            board.getBoard()[row + 4][col - 4])) {
                        mustDef = true;
                    }
                }
                //ben tren cung`
                if (row == 0 && col > 4) {
                    if (board.getBoard()[row + 5][col - 5] == 2) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                board.getBoard()[row + 4][col - 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                mustDef = true;
                            }
                        }
                    }
                    //truong hop ben ngoai ben cung(ben trai)
                    if (col == 4 && row > 0 && row < 16) {
                        if (board.getBoard()[row - 1][col + 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                mustDef = true;
                            }
                        }
                    }
                    //truong hop cot ben phai ngoai cung
                    if (col == 19 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col - 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                mustDef = true;
                            }
                        }
                    }
                    //truong hop ben duoi cung
                    if (row == 15 && col > 4 && col < 20) {
                        if (board.getBoard()[row - 1][col + 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                mustDef = true;
                            }
                        }
                    }
                    //th co ban
                    if (col > 4 && col < 20) {
                        if (board.getBoard()[row + 5][col - 5] == 2 || board.getBoard()[row - 1][col + 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                mustDef = true;
                            }
                        }
                    }
                }
            }
        }

        return mustDef;
    }

    private void doDef(Board board) {
        // hang` doc 
        //hang` doc 4 so khong bi chan : doi phuong co 3 so lien tiep doc va khong bi chan
        int row = 0;
        int col = 0;
        int numberIncrease;
        boolean hasMakeMove = false;

        // hang` doc 4 so, xet 4 so truoc mat theo hang doc neu co 3 cai va khong bi chan thi danh 
        System.out.println("welcome to deDef");
        for (row = 0; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (hasMakeMove == false) {
                    System.out.println("to the first case");
                    if (row == 0) {
                        if (board.getBoard()[row + 4][col] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                                System.out.print(" dung roi");
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 4; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;

                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (row == 16) {
                        if (board.getBoard()[row - 1][col] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                                System.out.print(" dung roi");
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 4; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (row > 0 && row < 16) {
                        System.out.println("to the 3 case");
                        if (board.getBoard()[row - 1][col] == 0 && board.getBoard()[row + 4][col] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                                System.out.print(" dung roi");
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 4; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }

        }

        //hang` doc 5 so bi chan 1 dau hoac se danh duoc neu bi chan 
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 19; col++) {
                if (!hasMakeMove) {
                    if (row == 0) {
                        if (board.getBoard()[row + 5][col] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 5; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (row == 15) {
                        if (board.getBoard()[row - 1][col] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 5; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col] == 2 || board.getBoard()[row - 1][col] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 5; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

            }
        }

        //hang` ngang 4 so lien tiep va khong bi chan
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (hasMakeMove == false) {
                    if (col == 0) {
                        if (board.getBoard()[row][col + 4] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 4; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col == 16) {
                        if (board.getBoard()[row][col - 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 4; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (col > 0 && col < 16) {
                        if (board.getBoard()[row][col + 4] == 0 && board.getBoard()[row][col - 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 4; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

            }
        }

        //hang` ngang 5 so lien tiep bi chan 1 dau 
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (hasMakeMove == false) {
                    if (col == 0) {
                        if (board.getBoard()[row][col + 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 5; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col == 15) {
                        if (board.getBoard()[row][col - 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 5; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col > 0 && col < 15) {
                        if (board.getBoard()[row][col - 1] == 2 || board.getBoard()[row][col + 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 5; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

            }
        }

        //hang cheo sang phai
        //hang cheo sang phai 4 so lien tiep la win, khong bi chan
        for (row = 0; row < 17; row++) {
            for (col = 0; col < 17; col++) {
                //vi tri 16/0
                if (hasMakeMove == false) {
                    if (col == 0 && row == 16) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;

                        }
                    }
                }

                //vi tri 0,16
                if (hasMakeMove == false) {
                    if (row == 0 && col == 16) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;
                        }
                    }
                }

                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col < 16) {
                        if (board.getBoard()[row + 4][col + 4] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben ngoai ben cung
                if (hasMakeMove == false) {
                    if (col == 0 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 4][col + 4] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 16 && row > 0) {
                        if (board.getBoard()[row - 1][col - 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;

                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 16 && col > 0 && col < 16) {
                        if (board.getBoard()[row - 1][col - 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (col > 0 && col < 16 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0 && board.getBoard()[row - 1][col - 1] == 0) {
                        if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            if (hasMakeMove == false) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                    hasMakeMove = true;
                                }
                            }

                            if (hasMakeMove == false) {
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                    hasMakeMove = true;
                                }
                            }
                            if (hasMakeMove == false) {
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                    hasMakeMove = true;
                                }
                            }
                            if (hasMakeMove == false) {
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                    hasMakeMove = true;
                                }
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        }
                    }
                }
            }
        }

        // hang cheo ben phai 5 so bi chan 1 dau 
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 16; col++) {
                //vi tri 15/0
                if (hasMakeMove == false) {
                    if (col == 0 && row == 15) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col + 4] == 0) {
                                nextMoveCol = col + 4;
                                nextMoveRow = row + 4;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;

                        }
                    }
                }

                //vi tri 0,15
                if (hasMakeMove == false) {
                    if (col == 0 && row == 15) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col + 4] == 0) {
                                nextMoveCol = col + 4;
                                nextMoveRow = row + 4;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;

                        }
                    }
                }

                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col < 15) {
                        if (board.getBoard()[row + 5][col + 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben ngoai ben cung(ben trai)
                if (hasMakeMove == false) {
                    if (col == 0 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col + 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 15 && row > 0) {
                        if (board.getBoard()[row - 1][col - 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 15 && col > 0 && col < 15) {
                        if (board.getBoard()[row - 1][col - 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col > 0 && col < 15 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col + 5] == 2 || board.getBoard()[row - 1][col - 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

// truong hop cheo  ben trai va 2 dau ko bi chan            
        for (row = 0; row < 17; row++) {
            for (col = 3; col < 19; col++) {
                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col > 3) {
                        if (board.getBoard()[row + 4][col - 4] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben trai ngoai` cung
                if (hasMakeMove == false) {
                    if (col == 3 && row > 0 && row < 17) {
                        if (board.getBoard()[row - 1][col + 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 19 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 4][col - 4] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 16 && col > 3) {
                        if (board.getBoard()[row - 1][col + 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                // th co ban
                if (hasMakeMove == false) {
                    if (col > 3 && col < 19 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 4][col - 4] == 0 && board.getBoard()[row - 1][col + 1] == 0) {
                            if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

        //truong hop cheo ben trai co 1 dau bi chan 
        for (row = 4; row < 19; row++) {
            for (col = 4; col < 20; col++) {
                //vi tri 15/19
                if (hasMakeMove == false) {
                    if (col == 19 && row == 15) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                board.getBoard()[row + 4][col - 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col - 1] == 0) {
                                nextMoveCol = col - 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col - 2] == 0) {
                                nextMoveCol = col - 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col - 3] == 0) {
                                nextMoveCol = col - 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col - 4] == 0) {
                                nextMoveCol = col - 3;
                                nextMoveRow = row + 3;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;
                        }
                    }
                }

                //vi tri 0,4
                if (hasMakeMove == false) {
                    if (row == 0 && col == 4) {
                        if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col - 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col - 1] == 0) {
                                nextMoveCol = col - 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col - 2] == 0) {
                                nextMoveCol = col - 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col - 3] == 0) {
                                nextMoveCol = col - 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col - 4] == 0) {
                                nextMoveCol = col - 4;
                                nextMoveRow = row + 4;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;
                        }
                    }
                }

                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col > 4) {
                        if (board.getBoard()[row + 5][col - 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                //truong hop ben ngoai ben cung(ben trai)
                if (hasMakeMove == false) {
                    if (col == 4 && row > 0 && row < 16) {
                        if (board.getBoard()[row - 1][col + 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 19 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col - 5] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 15 && col > 4 && col < 19) {
                        if (board.getBoard()[row - 1][col + 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //th co ban
                if (hasMakeMove == false) {
                    if (col > 4 && col < 19 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col - 5] == 2 || board.getBoard()[row - 1][col + 1] == 2) {
                            if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean mustAttackToWin() {
        int row = 0;
        int col = 0;
        boolean mustDef = false;
        // hang` doc 4 so, xet 4 so truoc mat theo hang doc neu co 3 cai va khong bi chan thi danh 
        for (row = 0; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board.getBoard()[row + 4][col] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row == 16) {
                    if (board.getBoard()[row - 1][col] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row > 0 && row < 16) {
                    if (board.getBoard()[row - 1][col] == 0 && board.getBoard()[row + 4][col] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

        //hang doc 5 so bi chan 1 dau
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board.getBoard()[row + 5][col] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row == 15) {
                    if (board.getBoard()[row - 1][col] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                            mustDef = true;
                        }
                    }
                }

                if (row > 0 && row < 15) {
                    if (board.getBoard()[row + 5][col] == 1 || board.getBoard()[row - 1][col] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        //hang ngang 4 so ko bi chan
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (col == 0) {
                    if (board.getBoard()[row][col + 4] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 16 && col > 0) {
                    if (board.getBoard()[row][col - 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 16) {
                    if (board.getBoard()[row][col + 4] == 0 && board.getBoard()[row][col - 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

// hang ngang 5 so lien tiep bi chan 1 dau
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (col == 0) {
                    if (board.getBoard()[row][col + 5] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                            mustDef = true;
                        }
                    }
                }

                if (col == 15) {
                    if (board.getBoard()[row][col - 1] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 15) {
                    if (board.getBoard()[row][col - 1] == 1 || board.getBoard()[row][col + 5] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        //hang cheo sang phai
        //hang cheo sang phai 4 so lien tiep la win, khong bi chan

        for (row = 0; row < 17; row++) {
            for (col = 0; col < 17; col++) {
                //vi tri 16/0
                if (col == 0 && row == 16) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                        mustDef = true;
                    }
                }

                if (row == 0 && col == 16) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                        mustDef = true;
                    }
                }

                if (row == 0 && col < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 0 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

//truong hop cot ben phai ngoai cung
                if (col == 16 && row > 0) {
                    if (board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

                //truong hop ben duoi cung
                if (row == 16 && col > 0 && col < 16) {
                    if (board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 16 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0 && board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        // hang cheo ben phai 5 so bi chan 1 dau 
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 16; col++) {
                //vi tri 15/0
                if (col == 0 && row == 15) {
                    if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                            board.getBoard()[row + 4][col + 4])) {
                        mustDef = true;
                    }
                }
                //vi tri 0,15
                if (col == 0 && row == 15) {
                    if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                            board.getBoard()[row + 4][col + 4])) {
                        mustDef = true;
                    }
                }
                //ben tren cung`
                if (row == 0 && col < 15) {
                    if (board.getBoard()[row + 5][col + 5] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
                //truong hop ben ngoai ben cung(ben trai)
                if (col == 0 && row > 0 && row < 15) {
                    if (board.getBoard()[row + 5][col + 5] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }

                    }
                }
                //truong hop cot ben phai ngoai cung
                if (col == 15 && row > 0) {
                    if (board.getBoard()[row - 1][col - 1] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
//truong hop ben duoi cung
                if (row == 15 && col > 0 && col < 15) {
                    if (board.getBoard()[row - 1][col - 1] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
//truong hop co ban
                if (col > 0 && col < 15 && row > 0 && row < 15) {
                    if (board.getBoard()[row + 5][col + 5] == 1 || board.getBoard()[row - 1][col - 1] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        // truong hop cheo  ben trai va 2 dau ko bi chan
        for (row = 0; row < 18; row++) {
            for (col = 3; col < 19; col++) {
                //vi tri 16/0
                if (col == 19 && row == 16) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                        mustDef = true;
                    }
                }
                //vi tri 0,16
                if (row == 0 && col == 3) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                        mustDef = true;

                    }
                } //ben tren cung`
                if (row == 0 && col > 3) {
                    if (board.getBoard()[row + 4][col - 4] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }

                    }
                }
//truong hop ben trai ngoai` cung
                if (col == 3 && row > 0 && row < 16) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 18 && row > 0 && row < 17) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
                //truong hop ben duoi cung
                if (row == 16 && col > 3) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
// th co ban
                if (col > 3 && col < 19 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col - 4] == 0 && board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }

                //hang ngang 4 so ko bi chan
            }
        }

        //truong hop cheo ben trai co 1 dau bi chan 
        for (row = 4; row < 20; row++) {
            for (col = 4; col < 20; col++) {
                //vi tri 15/19
                if (col == 19 && row == 15) {
                    if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                            board.getBoard()[row + 4][col - 4])) {
                        mustDef = true;
                    }
                }
                //vi tri 0,4
                if (row == 0 && col == 4) {
                    if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                            board.getBoard()[row + 4][col - 4])) {
                        mustDef = true;
                    }
                }
                //ben tren cung`
                if (row == 0 && col > 4) {
                    if (board.getBoard()[row + 5][col - 5] == 1) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                board.getBoard()[row + 4][col - 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                mustDef = true;
                            }
                        }
                    }
                    //truong hop ben ngoai ben cung(ben trai)
                    if (col == 4 && row > 0 && row < 16) {
                        if (board.getBoard()[row - 1][col + 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                mustDef = true;
                            }
                        }
                    }
                    //truong hop cot ben phai ngoai cung
                    if (col == 19 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col - 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                mustDef = true;
                            }
                        }
                    }
                    //truong hop ben duoi cung
                    if (row == 15 && col > 4 && col < 20) {
                        if (board.getBoard()[row - 1][col + 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                mustDef = true;
                            }
                        }
                    }
                    //th co ban
                    if (col > 4 && col < 20) {
                        if (board.getBoard()[row + 5][col - 5] == 1 || board.getBoard()[row - 1][col + 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                mustDef = true;
                            }
                        }
                    }
                }
            }
        }

        return mustDef;
    }

    private void doAttackToWin(Board board) {
        // hang` doc 
        //hang` doc 4 so khong bi chan : doi phuong co 3 so lien tiep doc va khong bi chan
        int row = 0;
        int col = 0;
        int numberIncrease;
        boolean hasMakeMove = false;

        // hang` doc 4 so, xet 4 so truoc mat theo hang doc neu co 3 cai va khong bi chan thi danh 
        System.out.println("welcome to deDef");
        for (row = 0; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (hasMakeMove == false) {
                    System.out.println("to the first case");
                    if (row == 0) {
                        if (board.getBoard()[row + 4][col] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                                System.out.print(" dung roi");
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 4; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;

                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (row == 16) {
                        if (board.getBoard()[row - 1][col] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                                System.out.print(" dung roi");
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 4; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (row > 0 && row < 16) {
                        System.out.println("to the 3 case");
                        if (board.getBoard()[row - 1][col] == 0 && board.getBoard()[row + 4][col] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                                System.out.print(" dung roi");
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 4; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }

        }

        //hang` doc 5 so bi chan 1 dau hoac se danh duoc neu bi chan 
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 19; col++) {
                if (!hasMakeMove) {
                    if (row == 0) {
                        if (board.getBoard()[row + 5][col] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 5; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (row == 15) {
                        if (board.getBoard()[row - 1][col] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 5; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col] == 1 || board.getBoard()[row - 1][col] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col], board.getBoard()[row + 4][col])) {
                                nextMoveCol = col;
                                for (numberIncrease = row; numberIncrease < row + 5; numberIncrease++) {
                                    if (board.getBoard()[numberIncrease][col] == 0) {
                                        nextMoveRow = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

            }
        }

        //hang` ngang 4 so lien tiep va khong bi chan
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (hasMakeMove == false) {
                    if (col == 0) {
                        if (board.getBoard()[row][col + 4] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 4; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col == 16) {
                        if (board.getBoard()[row][col - 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 4; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (hasMakeMove == false) {
                    if (col > 0 && col < 16) {
                        if (board.getBoard()[row][col + 4] == 0 && board.getBoard()[row][col - 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 4; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

            }
        }

        //hang` ngang 5 so lien tiep bi chan 1 dau 
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 17; col++) {
                if (hasMakeMove == false) {
                    if (col == 0) {
                        if (board.getBoard()[row][col + 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 5; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col == 15) {
                        if (board.getBoard()[row][col - 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 5; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col > 0 && col < 15) {
                        if (board.getBoard()[row][col - 1] == 1 || board.getBoard()[row][col + 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3], board.getBoard()[row][col + 4])) {
                                nextMoveRow = row;
                                for (numberIncrease = col; numberIncrease < col + 5; numberIncrease++) {
                                    if (board.getBoard()[row][numberIncrease] == 0) {
                                        nextMoveCol = numberIncrease;
                                    }
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

            }
        }

        //hang cheo sang phai
        //hang cheo sang phai 4 so lien tiep la win, khong bi chan
        for (row = 0; row < 17; row++) {
            for (col = 0; col < 17; col++) {
                //vi tri 16/0
                if (hasMakeMove == false) {
                    if (col == 0 && row == 16) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;

                        }
                    }
                }

                //vi tri 0,16
                if (hasMakeMove == false) {
                    if (row == 0 && col == 16) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;
                        }
                    }
                }

                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col < 16) {
                        if (board.getBoard()[row + 4][col + 4] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben ngoai ben cung
                if (hasMakeMove == false) {
                    if (col == 0 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 4][col + 4] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 16 && row > 0) {
                        if (board.getBoard()[row - 1][col - 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;

                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 16 && col > 0 && col < 16) {
                        if (board.getBoard()[row - 1][col - 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                if (col > 0 && col < 16 && row > 0 && row < 16) {
                    if (board.getBoard()[row + 4][col + 4] == 0 && board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                            if (hasMakeMove == false) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                    hasMakeMove = true;
                                }
                            }

                            if (hasMakeMove == false) {
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                    hasMakeMove = true;
                                }
                            }
                            if (hasMakeMove == false) {
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                    hasMakeMove = true;
                                }
                            }
                            if (hasMakeMove == false) {
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                    hasMakeMove = true;
                                }
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                        }
                    }
                }
            }
        }

        // hang cheo ben phai 5 so bi chan 1 dau 
        for (row = 0; row < 16; row++) {
            for (col = 0; col < 16; col++) {
                //vi tri 15/0
                if (hasMakeMove == false) {
                    if (col == 0 && row == 15) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col + 4] == 0) {
                                nextMoveCol = col + 4;
                                nextMoveRow = row + 4;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;

                        }
                    }
                }

                //vi tri 0,15
                if (hasMakeMove == false) {
                    if (col == 0 && row == 15) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col + 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col + 3] == 0) {
                                nextMoveCol = col + 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col + 4] == 0) {
                                nextMoveCol = col + 4;
                                nextMoveRow = row + 4;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;

                        }
                    }
                }

                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col < 15) {
                        if (board.getBoard()[row + 5][col + 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben ngoai ben cung(ben trai)
                if (hasMakeMove == false) {
                    if (col == 0 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col + 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 15 && row > 0) {
                        if (board.getBoard()[row - 1][col - 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 15 && col > 0 && col < 15) {
                        if (board.getBoard()[row - 1][col - 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                if (hasMakeMove == false) {
                    if (col > 0 && col < 15 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col + 5] == 1 || board.getBoard()[row - 1][col - 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

// truong hop cheo  ben trai va 2 dau ko bi chan            
        for (row = 0; row < 17; row++) {
            for (col = 3; col < 19; col++) {
                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col > 3) {
                        if (board.getBoard()[row + 4][col - 4] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben trai ngoai` cung
                if (hasMakeMove == false) {
                    if (col == 3 && row > 0 && row < 17) {
                        if (board.getBoard()[row - 1][col + 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 19 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 4][col - 4] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 16 && col > 3) {
                        if (board.getBoard()[row - 1][col + 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                // th co ban
                if (hasMakeMove == false) {
                    if (col > 3 && col < 19 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 4][col - 4] == 0 && board.getBoard()[row - 1][col + 1] == 0) {
                            if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

        //truong hop cheo ben trai co 1 dau bi chan 
        for (row = 4; row < 19; row++) {
            for (col = 4; col < 20; col++) {
                //vi tri 15/19
                if (hasMakeMove == false) {
                    if (col == 19 && row == 15) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                board.getBoard()[row + 4][col - 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col - 1] == 0) {
                                nextMoveCol = col - 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col - 2] == 0) {
                                nextMoveCol = col - 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col - 3] == 0) {
                                nextMoveCol = col - 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col - 4] == 0) {
                                nextMoveCol = col - 3;
                                nextMoveRow = row + 3;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;
                        }
                    }
                }

                //vi tri 0,4
                if (hasMakeMove == false) {
                    if (row == 0 && col == 4) {
                        if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                board.getBoard()[row + 4][col - 4])) {
                            if (board.getBoard()[row][col] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;
                            }
                            if (board.getBoard()[row + 1][col - 1] == 0) {
                                nextMoveCol = col - 1;
                                nextMoveRow = row + 1;
                            }
                            if (board.getBoard()[row + 2][col - 2] == 0) {
                                nextMoveCol = col - 2;
                                nextMoveRow = row + 2;
                            }
                            if (board.getBoard()[row + 3][col - 3] == 0) {
                                nextMoveCol = col - 3;
                                nextMoveRow = row + 3;
                            }
                            if (board.getBoard()[row + 4][col - 4] == 0) {
                                nextMoveCol = col - 4;
                                nextMoveRow = row + 4;
                            }
                            board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                            hasMakeMove = true;
                        }
                    }
                }

                //ben tren cung`
                if (hasMakeMove == false) {
                    if (row == 0 && col > 4) {
                        if (board.getBoard()[row + 5][col - 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
                //truong hop ben ngoai ben cung(ben trai)
                if (hasMakeMove == false) {
                    if (col == 4 && row > 0 && row < 16) {
                        if (board.getBoard()[row - 1][col + 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop cot ben phai ngoai cung
                if (hasMakeMove == false) {
                    if (col == 19 && row > 0 && row < 15) {
                        if (board.getBoard()[row + 5][col - 5] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                                    board.getBoard()[row + 4][col + 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col + 1] == 0) {
                                    nextMoveCol = col + 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col + 2] == 0) {
                                    nextMoveCol = col + 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col + 3] == 0) {
                                    nextMoveCol = col + 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col + 4] == 0) {
                                    nextMoveCol = col + 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //truong hop ben duoi cung
                if (hasMakeMove == false) {
                    if (row == 15 && col > 4 && col < 20) {
                        if (board.getBoard()[row - 1][col + 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }

                //th co ban
                if (hasMakeMove == false) {
                    if (col > 4 && col < 19 && row > 0 && row < 16) {
                        if (board.getBoard()[row + 5][col - 5] == 1 || board.getBoard()[row - 1][col + 1] == 1) {
                            if (comHas4OutOf5(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                                    board.getBoard()[row + 4][col - 4])) {
                                if (board.getBoard()[row][col] == 0) {
                                    nextMoveCol = col;
                                    nextMoveRow = row;
                                }
                                if (board.getBoard()[row + 1][col - 1] == 0) {
                                    nextMoveCol = col - 1;
                                    nextMoveRow = row + 1;
                                }
                                if (board.getBoard()[row + 2][col - 2] == 0) {
                                    nextMoveCol = col - 2;
                                    nextMoveRow = row + 2;
                                }
                                if (board.getBoard()[row + 3][col - 3] == 0) {
                                    nextMoveCol = col - 3;
                                    nextMoveRow = row + 3;
                                }
                                if (board.getBoard()[row + 4][col - 4] == 0) {
                                    nextMoveCol = col - 4;
                                    nextMoveRow = row + 4;
                                }
                                board.opponentChoiceToBoard(nextMoveRow, nextMoveCol);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean needToBlockEarly() {
        boolean needToBlockEarly = false;
        int row;
        int col;

        // chi can ko o ria` va` ko bi chan la block early
        // hang doc 
        for (row = 1; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (board.getBoard()[col][row + 3] == 0 && board.getBoard()[col][row - 1] == 0) {
                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col][row + 1], board.getBoard()[col][row + 2])) {
                        needToBlockEarly = true;
                    }
                }
            }
        }

        //hang ngang
        for (row = 0; row < 20; row++) {
            for (col = 1; col < 16; col++) {
                if (board.getBoard()[col + 3][row] == 0 && board.getBoard()[col - 1][row] == 0) {
                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col + 1][row], board.getBoard()[col + 2][row])) {
                        needToBlockEarly = true;
                    }
                }
            }
        }

        //hang cheo sang ben phai 
        for (row = 1; row < 17; row++) {
            for (col = 1; col < 17; col++) {
                if (board.getBoard()[col + 3][row + 3] == 0 && board.getBoard()[col - 1][row - 1] == 0) {
                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col + 1][row + 1], board.getBoard()[col + 2][row + 2])) {
                        needToBlockEarly = true;
                    }
                }
            }
        }

        //hang cheo sang ben trai
        for (row = 1; row < 17; row++) {
            for (col = 3; col < 19; col++) {
                if (board.getBoard()[col - 3][row + 3] == 0 && board.getBoard()[col + 1][row - 1] == 0) {
                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col - 1][row + 1], board.getBoard()[col - 2][row + 2])) {
                        needToBlockEarly = true;
                    }
                }
            }
        }

        //hang doc : doi phuong co 2 so va khong bi chan o dau
        return needToBlockEarly;
    }

    private void doBlockEarly() {
        int col;
        int row;
        boolean hasMakeMove = false;
        int nextMoveCol = 0;
        int nextMoveRow = 0;
        System.out.println("just enter the method need to block early");
        // hang doc 

        for (row = 1; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (board.getBoard()[col][row + 3] == 0 && board.getBoard()[col][row - 1] == 0) {

                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col][row + 1], board.getBoard()[col][row + 2])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 1] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 2] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }

                }
            }
        }

        //hang ngang
        for (row = 0; row < 20; row++) {
            for (col = 1; col < 17; col++) {
                if (board.getBoard()[col + 3][row] == 0 && board.getBoard()[col - 1][row] == 0) {
                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col + 1][row], board.getBoard()[col + 2][row])) {

                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 1][row] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 2][row] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

        //hang cheo ben phai 
        for (row = 1; row < 17; row++) {
            for (col = 1; col < 17; col++) {
                if (board.getBoard()[col + 3][row + 3] == 0 && board.getBoard()[col - 1][row - 1] == 0) {

                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col + 1][row + 1], board.getBoard()[col + 2][row + 2])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 1][row + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 2][row + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }

                }
            }
        }

        //hang cheo sang ben trai
        for (row = 1; row < 17; row++) {
            for (col = 3; col < 19; col++) {
                if (board.getBoard()[col - 3][row + 3] == 0 && board.getBoard()[col + 1][row - 1] == 0) {
                    if (opHas2OutOf3Def(board.getBoard()[col][row], board.getBoard()[col - 1][row + 1], board.getBoard()[col - 2][row + 2])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col - 1][row + 1] == 0) {
                                nextMoveCol = col - 1;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col - 2][row + 2] == 0) {
                                nextMoveCol = col - 2;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean chancesToMakeOpportunity() {
        int row = 0;
        int col = 0;
        boolean mustDef = false;
        // hang` doc 2 so, xet 3 so truoc mat theo hang doc neu co 2 cai va khong bi chan thi danh 
        for (row = 0; row < 18; row++) {
            for (col = 0; col < 20; col++) {
                if (row == 0) {
                    if (board.getBoard()[row + 3][col] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row == 17) {
                    if (board.getBoard()[row - 1][col] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                            mustDef = true;
                        }
                    }
                }
                if (row > 0 && row < 17) {
                    if (board.getBoard()[row - 1][col] == 0 && board.getBoard()[row + 3][col] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

        //hang doc  bi chan 1 dau va dang co 3 so lien tiep nhau
        for (row = 1; row < 15; row++) {
            for (col = 0; col < 20; col++) {
                if (board.getBoard()[row - 1][col] == 1 || board.getBoard()[row + 4][col] == 1) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                        mustDef = true;
                    }
                }
            }
        }
        //hang ngang co 2 so va khong bi chan
        for (row = 0; row < 20; row++) {
            for (col = 0; col < 18; col++) {
                if (col == 0) {
                    if (board.getBoard()[row][col + 3] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 17) {
                    if (board.getBoard()[row][col - 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 17) {
                    if (board.getBoard()[row][col + 3] == 0 && board.getBoard()[row][col - 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

// hang ngang co 3 so va bi chan 1 trong 2 dau
        for (row = 0; row < 20; row++) {
            for (col = 1; col < 16; col++) {
                if (board.getBoard()[row][col - 1] == 1 || board.getBoard()[row][col + 4] == 1) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                        mustDef = true;
                    }
                }

            }
        }
        //hang cheo sang phai
        //hang cheo sang phai co 2 so lien tiep va khong bi chan

        for (row = 0; row < 17; row++) {
            for (col = 0; col < 17; col++) {

                if (row == 0) {
                    if (board.getBoard()[row + 3][col + 3] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                            mustDef = true;
                        }
                    }
                }
                if (col == 0 && row > 0) {
                    if (board.getBoard()[row + 3][col + 3] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                            mustDef = true;
                        }
                    }
                }

//truong hop cot ben phai ngoai cung
                if (col == 17 && row > 0) {
                    if (board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                            mustDef = true;
                        }
                    }
                }

                //truong hop ben duoi cung
                if (row == 17 && col > 0) {
                    if (board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                            mustDef = true;
                        }
                    }
                }

                if (col > 0 && col < 17 && row > 0 && row < 17) {
                    if (board.getBoard()[row + 3][col + 3] == 0 && board.getBoard()[row - 1][col - 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

        // hang cheo ben phai dang co 3 so va bi chan 1 dau 
        for (row = 1; row < 16; row++) {
            for (col = 2; col < 16; col++) {
//truong hop co ban

                if (board.getBoard()[row + 4][col + 4] == 1 || board.getBoard()[row - 1][col - 1] == 1) {
                    if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                        mustDef = true;
                    }
                }

            }
        }
        // truong hop cheo  ben trai va 2 dau ko bi chan
        for (row = 0; row < 19; row++) {
            for (col = 2; col < 19; col++) {
                //ben tren cung`
                if (row == 0 && col > 2) {
                    if (board.getBoard()[row + 3][col - 3] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                            mustDef = true;
                        }

                    }
                }
//truong hop ben trai ngoai` cung
                if (col == 2 && row > 1 && row < 16) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                            mustDef = true;
                        }
                    }
                }
// truong hop bot ben phai ngoai cung
                if (col == 19 && row > 0) {
                    if (board.getBoard()[row + 3][col - 3] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                            mustDef = true;
                        }
                    }
                }
                //truong hop ben duoi cung
                if (row == 17 && col > 2) {
                    if (board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                            mustDef = true;
                        }
                    }
                }
// th co ban
                if (col > 2 && col < 20 && row > 0 && row < 17) {
                    if (board.getBoard()[row + 3][col - 3] == 0 && board.getBoard()[row - 1][col + 1] == 0) {
                        if (comHas2OutOf3(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }

        //truong hop cheo ben trai co 1 dau bi chan 
        for (row = 0; row < 16; row++) {
            for (col = 4; col < 19; col++) {
                // th co ban
                if (col > 3 && col < 20 && row > 0 && row < 17) {
                    if (board.getBoard()[row + 4][col - 4] == 1 || board.getBoard()[row - 1][col + 1] == 1) {
                        if (comHas3OutOf4(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                            mustDef = true;
                        }
                    }
                }
            }
        }
        return mustDef;
    }

    private void doOpportunity() {
        int col;
        int row;
        boolean hasMakeMove = false;
        int nextMoveCol = 0;
        int nextMoveRow = 0;
        System.out.println("just enter the method need to block early");
        // hang doc 

        for (row = 1; row < 17; row++) {
            for (col = 0; col < 20; col++) {
                if (board.getBoard()[col][row + 3] == 0 && board.getBoard()[col][row - 1] == 0) {

                    if (comHas2OutOf3(board.getBoard()[col][row], board.getBoard()[col][row + 1], board.getBoard()[col][row + 2])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 1] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 2] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }

                }

            }
        }

        //hang ngang
        for (row = 0; row < 20; row++) {
            for (col = 1; col < 17; col++) {
                if (board.getBoard()[col + 3][row] == 0 && board.getBoard()[col - 1][row] == 0) {
                    if (comHas2OutOf3(board.getBoard()[col][row], board.getBoard()[col + 1][row], board.getBoard()[col + 2][row])) {

                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 1][row] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 2][row] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

        //hang cheo ben phai 
        for (row = 1; row < 17; row++) {
            for (col = 1; col < 17; col++) {
                if (board.getBoard()[col + 3][row + 3] == 0 && board.getBoard()[col - 1][row - 1] == 0) {

                    if (comHas2OutOf3(board.getBoard()[col][row], board.getBoard()[col + 1][row + 1], board.getBoard()[col + 2][row + 2])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 1][row + 1] == 0) {
                                nextMoveCol = col + 1;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col + 2][row + 2] == 0) {
                                nextMoveCol = col + 2;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

        //hang cheo sang ben trai
        for (row = 1; row < 17; row++) {
            for (col = 3; col < 19; col++) {
                if (board.getBoard()[col - 3][row + 3] == 0 && board.getBoard()[col + 1][row - 1] == 0) {
                    if (comHas2OutOf3(board.getBoard()[col][row], board.getBoard()[col - 1][row + 1], board.getBoard()[col - 2][row + 2])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col - 1][row + 1] == 0) {
                                nextMoveCol = col - 1;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }

                        if (hasMakeMove == false) {
                            if (board.getBoard()[col - 2][row + 2] == 0) {
                                nextMoveCol = col - 2;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }

        // hang doc bi chan 1 dau 
        for (row = 1; row < 16; row++) {
            for (col = 0; col < 20; col++) {
                if (board.getBoard()[col][row + 4] == 0 && board.getBoard()[col][row - 1] == 0) {

                    if (comHas3OutOf4(board.getBoard()[col][row], board.getBoard()[col][row + 1], board.getBoard()[col][row + 2], board.getBoard()[col][row + 3])) {
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row;

                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;

                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 1] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 1;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 2] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 2;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                        if (hasMakeMove == false) {
                            if (board.getBoard()[col][row + 3] == 0) {
                                nextMoveCol = col;
                                nextMoveRow = row + 3;
                                board.opponentChoiceToBoard(nextMoveCol, nextMoveRow);
                                hasMakeMove = true;
                            }
                        }
                    }
                }
            }
        }
    }
    //hang ngang bi chan 1 dau
}

/**
 * @return the hasMakeAMove
 */
/**
 * @param hasMakeAMove the hasMakeAMove to set
 */
