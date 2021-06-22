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
public class AI2 {

    Board board;
    boolean playFirst = false;
    Random rand = new Random();
    int nextMoveRow;
    int nextMoveCol;

    public AI2(Board board) {
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
                if (board.getBoard()[row][col] == 2) {
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

    private boolean comHas2OutOf3Def(int a, int b, int c) {
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

    // do block early
    private boolean canDefEarly_2ToTheRight(int row, int col) {
        boolean canGo = false;
        if (col > 17) {
            canGo = false;
        } else if (col == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                    canGo = true;
                }
            }
        }
        if (col < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 3] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2ToTheLeft(int row, int col) {
        boolean canGo = false;
        if (col < 2) {
            canGo = false;
        } else if (col == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2])) {
                    canGo = true;
                }
            }
        }
        if (col > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 3] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2toTheUp(int row, int col) {
        boolean canGo = false;
        if (row < 2) {
            canGo = false;
        } else if (row == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col])) {
                    canGo = true;
                }
            }
        }
        if (row > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 3][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2ToTheDown(int row, int col) {
        boolean canGo = false;
        if (row > 17) {
            canGo = false;
        } else if (row == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                    canGo = true;
                }
            }
        }
        if (row < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 3][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2ToTheUpRight(int row, int col) {
        boolean canGo = false;
        if (row < 2 && col > 17) {
            canGo = false;
        } else if (row == 2 && col == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2])) {
                    canGo = true;
                }
            }
        }
        if (row > 2 && col < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 3][col + 3] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2ToTheUpLeft(int row, int col) {
        boolean canGo = false;
        if (row < 2 && col < 2) {
            canGo = false;
        } else if (row == 2 && col == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2])) {
                    canGo = true;
                }
            }
        }
        if (row > 2 && col > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 3][col - 3] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2ToTheDownLeft(int row, int col) {
        boolean canGo = false;
        if (row > 17 && col < 2) {
            canGo = false;
        } else if (row == 2 && col == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                    canGo = true;
                }
            }
        }
        if (row < 17 && col > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 3][col - 3] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canDefEarly_2ToTheDownRight(int row, int col) {
        boolean canGo = false;
        if (row > 17 && col > 17) {
            canGo = false;
        } else if (row == 17 && col == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                    canGo = true;
                }
            }
        }
        if (row < 17 && col < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 3][col + 3] == 0) {
                if (opHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                    System.out.print("hereeeeee");
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    // bi chan 1 dau 
    private boolean canDefEarly_opHas3Right_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 4] == 1) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3Left_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col < 3) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 4] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3Up_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 3) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3Down_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3UpRight_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 3 && col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 3 && col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 3 && col < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col + 4] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3UpLeft_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 3 && col < 3) {
            opHas3OnTheRight_NeedToDef = false;
        }
        if (row == 3 && col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 3 && col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col - 4] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3DownRight_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 16 && col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 16 && col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 16 && row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col + 4] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canDefEarly_opHas3DownLeft_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 16 && col < 3) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 16 && col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 16 && col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col - 4] == 2) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    // boolean chan nuoc doi 
    private boolean opTwinsChancesFound() {
        boolean opTwins = false;
        boolean breakk = false;
        int count = 0;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (canDefEarly_2ToTheDown(row, col)) {
                    count++;
                }
                if (canDefEarly_2ToTheDownLeft(row, col)) {
                    count++;
                }
                if (canDefEarly_2ToTheDownRight(row, col)) {
                    count++;
                }
                if (canDefEarly_2ToTheLeft(row, col)) {
                    count++;
                }
                if (canDefEarly_2ToTheRight(row, col)) {
                    count++;
                }
                if (canDefEarly_2ToTheUpLeft(row, col)) {
                    count++;
                }
                if (canDefEarly_2ToTheUpRight(row, col)) {
                    count++;
                }
                if (canDefEarly_2toTheUp(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3DownLeft_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3DownRight_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3Down_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3Left_OneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3Right_OneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3UpLeft_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3UpRight_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canDefEarly_opHas3Up_OneHeadBlock(row, col)) {
                    count++;
                }
                if (count == 2) {
                    opTwins = true;
                    breakk = true;

                    break;
                }
                count = 0;
            }
            if (breakk == true) {
                break;
            }
        }

        return opTwins;
    }

    // boolean phat hien nuoc doi de danh
    private boolean comHasTwinsChancesFound() {
        boolean opTwins = false;
        boolean breakk = false;
        int count = 0;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (canMakeChances_2ToTheDown(row, col)) {
                    count++;
                }
                if (canMakeChances_2ToTheDownLeft(row, col)) {
                    count++;
                }
                if (canMakeChances_2ToTheDownRight(row, col)) {
                    count++;
                }
                if (canMakeChances_2ToTheLeft(row, col)) {
                    count++;
                }
                if (canMakeChances_2ToTheRight(row, col)) {
                    count++;
                }
                if (canMakeChances_2ToTheUpLeft(row, col)) {
                    count++;
                }
                if (canMakeChances_2ToTheUpRight(row, col)) {
                    count++;
                }
                if (canMakeChances_2toTheUp(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3DownLeft_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3DownRight_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3Down_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3Left_OneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3Right_OneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3UpLeft_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3UpRight_oneHeadBlock(row, col)) {
                    count++;
                }
                if (canMakeChances_comHas3Up_OneHeadBlock(row, col)) {
                    count++;
                }
                if (count == 2) {
                    opTwins = true;
                    breakk = true;

                    break;
                }
                count = 0;
            }
            if (breakk == true) {
                break;
            }
        }
        return opTwins;
    }

    // create chances 
    private boolean canMakeChances_2ToTheRight(int row, int col) {
        boolean canGo = false;
        if (col > 17) {
            canGo = false;
        } else if (col == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                    canGo = true;
                }
            }
        }
        if (col < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 3] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2ToTheLeft(int row, int col) {
        boolean canGo = false;
        if (col < 2) {
            canGo = false;
        } else if (col == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2])) {
                    canGo = true;
                }
            }
        }
        if (col > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 3] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2toTheUp(int row, int col) {
        boolean canGo = false;
        if (row < 2) {
            canGo = false;
        } else if (row == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col])) {
                    canGo = true;
                }
            }
        }
        if (row > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 3][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2ToTheDown(int row, int col) {
        boolean canGo = false;
        if (row > 17) {
            canGo = false;
        } else if (row == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                    canGo = true;
                }
            }
        }
        if (row < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 3][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2ToTheUpRight(int row, int col) {
        boolean canGo = false;
        if (row < 2 && col > 17) {
            canGo = false;
        } else if (row == 2 && col == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2])) {
                    canGo = true;
                }
            }
        }
        if (row > 2 && col < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 3][col + 3] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2ToTheUpLeft(int row, int col) {
        boolean canGo = false;
        if (row < 2 && col < 2) {
            canGo = false;
        } else if (row == 2 && col == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2])) {
                    canGo = true;
                }
            }
        }
        if (row > 2 && col > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 3][col - 3] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2ToTheDownLeft(int row, int col) {
        boolean canGo = false;
        if (row > 17 && col < 2) {
            canGo = false;
        } else if (row == 2 && col == 2) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                    canGo = true;
                }
            }
        }
        if (row < 17 && col > 2) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 3][col - 3] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    private boolean canMakeChances_2ToTheDownRight(int row, int col) {
        boolean canGo = false;
        if (row > 17 && col > 17) {
            canGo = false;
        } else if (row == 17 && col == 17) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                    canGo = true;
                }
            }
        }
        if (row < 17 && col < 17) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 3][col + 3] == 0) {
                if (comHas2OutOf3Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2])) {
                    canGo = true;
                }
            }
        }

        return canGo;
    }

    // bi chan 1 dau 
    private boolean canMakeChances_comHas3Right_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 4] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3Left_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col < 3) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 4] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3Up_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 3) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3Down_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3UpRight_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 3 && col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 3 && col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 3 && col < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col + 4] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3UpLeft_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 3 && col < 3) {
            opHas3OnTheRight_NeedToDef = false;
        }
        if (row == 3 && col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 3 && col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col - 4] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3DownRight_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 16 && col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 16 && col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 16 && row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col + 4] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        return opHas3OnTheRight_NeedToDef;
    }

    private boolean canMakeChances_comHas3DownLeft_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 16 && col < 3) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 16 && col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 16 && col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col - 4] == 1) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    //boolean check dieu kien
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

    private boolean comHas3OutOf4Def(int a, int b, int c, int d) {
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

    private boolean comHas4OutOf5Def(int a, int b, int c, int d, int e) {
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

    //boolean 3 node ko bi chan 2 dau de def
    private boolean mustDef_opHas3Right(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col > 16) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 4] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas3Left(int row, int col) {
        boolean opHas3OnTheLeft_NeedToDef = false;
        if (col < 3) {
            opHas3OnTheLeft_NeedToDef = false;
        } else if (col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    opHas3OnTheLeft_NeedToDef = true;
                }
            }
        }
        if (col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 4] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    opHas3OnTheLeft_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheLeft_NeedToDef;
    }

    private boolean mustDef_opHas3Up(int row, int col) {
        boolean opHas3OnTop_NeedToDef = false;
        if (row < 3) {
            opHas3OnTop_NeedToDef = false;
        } else if (row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }

        return opHas3OnTop_NeedToDef;
    }

    private boolean mustDef_opHas3Down(int row, int col) {
        boolean opHas3OnTop_NeedToDef = false;
        if (row > 16) {
            opHas3OnTop_NeedToDef = false;
        }
        if (row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        return opHas3OnTop_NeedToDef;
    }

    private boolean mustDef_opHas3DownRight(int row, int col) {
        boolean opHas3OnTop_NeedToDef = false;
        if (col > 16 && row > 16) {
            opHas3OnTop_NeedToDef = false;
        } else if (col == 16 && row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (col < 16 && row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col + 4] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }

        return opHas3OnTop_NeedToDef;
    }

    private boolean mustDef_opHas3DownLeft(int row, int col) {
        boolean opHas3OnTop_NeedToDef = false;
        if (col < 3 && row > 16) {
            opHas3OnTop_NeedToDef = false;
        } else if (col == 3 && row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (col > 4 && row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col - 4] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        return opHas3OnTop_NeedToDef;
    }

    private boolean mustDef_opHas3UpRight(int row, int col) {
        boolean opHas3OnTop_NeedToDef = false;
        if (col > 16 && row < 3) {
            opHas3OnTop_NeedToDef = false;
        } else if (col == 16 && row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (col < 16 && row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col + 4] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }

        }
        return opHas3OnTop_NeedToDef;

    }

    private boolean mustDef_opHas3UpLeft(int row, int col) {
        boolean opHas3OnTop_NeedToDef = false;
        if (col < 3 && row < 3) {
            opHas3OnTop_NeedToDef = false;
        } else if (col == 3 && row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }

        } else if (col > 3 && row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col - 4] == 0) {
                if (opHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    opHas3OnTop_NeedToDef = true;
                }
            }
        }

        return opHas3OnTop_NeedToDef;
    }

    //boolean 4 node bi chan 1 dau 
    private boolean mustDef_opHas4Right_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col > 15) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3],
                        board.getBoard()[row][col + 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 15) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 5] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3],
                        board.getBoard()[row][col + 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4Left_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (col < 4) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (col == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3],
                        board.getBoard()[row][col - 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col > 4) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 5] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3],
                        board.getBoard()[row][col - 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4Up_OneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 4) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col],
                        board.getBoard()[row - 4][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 4) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 5][col] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col],
                        board.getBoard()[row - 4][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4Down_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 15) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col],
                        board.getBoard()[row + 4][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 15) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 5][col] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col],
                        board.getBoard()[row + 4][col])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4UpRight_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 4 && col > 15) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 4 && col == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3],
                        board.getBoard()[row - 4][col + 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 4 && col < 15) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 5][col + 5] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3],
                        board.getBoard()[row - 4][col + 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4UpLeft_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row < 4 && col < 4) {
            opHas3OnTheRight_NeedToDef = false;
        }
        if (row == 4 && col == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3],
                        board.getBoard()[row - 4][col - 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 4 && col > 4) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 5][col - 5] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3],
                        board.getBoard()[row - 4][col - 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4DownRight_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 15 && col > 15) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 15 && col == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                        board.getBoard()[row + 4][col + 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 15 && row < 15) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 5][col + 5] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                        board.getBoard()[row + 4][col + 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        return opHas3OnTheRight_NeedToDef;
    }

    private boolean mustDef_opHas4DownLeft_oneHeadBlock(int row, int col) {
        boolean opHas3OnTheRight_NeedToDef = false;
        if (row > 15 && col < 4) {
            opHas3OnTheRight_NeedToDef = false;
        } else if (row == 15 && col == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                        board.getBoard()[row + 4][col - 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 15 && col > 4) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 5][col - 5] == 2) {
                if (opHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                        board.getBoard()[row + 4][col - 4])) {
                    opHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return opHas3OnTheRight_NeedToDef;
    }

    // boolean check xem co win ko
    private boolean canAtk_comHas3Right(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (col > 16) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (col == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        } else if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 4] == 0) {
            if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3])) {
                comHas3OnTheRight_NeedToDef = true;
            }
        }
        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas3Left(int row, int col) {
        boolean comHas3OnTheLeft_NeedToDef = false;
        if (col < 3) {
            comHas3OnTheLeft_NeedToDef = false;
        } else if (col == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    comHas3OnTheLeft_NeedToDef = true;
                }
            }
        }
        if (col > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 4] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3])) {
                    comHas3OnTheLeft_NeedToDef = true;
                }
            }
        }
        return comHas3OnTheLeft_NeedToDef;
    }

    private boolean canAtk_comHas3Up(int row, int col) {
        boolean comHas3OnTop_NeedToDef = false;
        if (row < 3) {
            comHas3OnTop_NeedToDef = false;
        } else if (row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        } else if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col] == 0) {
            if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col])) {
                comHas3OnTop_NeedToDef = true;
            }
        }
        return comHas3OnTop_NeedToDef;
    }

    private boolean canAtk_comHas3Down(int row, int col) {
        boolean comHas3OnTop_NeedToDef = false;
        if (row > 16) {
            comHas3OnTop_NeedToDef = false;
        }
        if (row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }
        return comHas3OnTop_NeedToDef;
    }

    private boolean canAtk_comHas3DownRight(int row, int col) {
        boolean comHas3OnTop_NeedToDef = false;
        if (col > 16 && row > 16) {
            comHas3OnTop_NeedToDef = false;
        }
        if (col == 16 && row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (col < 16 && row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col + 4] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }

        return comHas3OnTop_NeedToDef;
    }

    private boolean canAtk_comHas3DownLeft(int row, int col) {
        boolean comHas3OnTop_NeedToDef = false;
        if (col < 3 && row > 16) {
            comHas3OnTop_NeedToDef = false;
        } else if (col == 3 && row == 16) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (col > 4 && row < 16) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 4][col - 4] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }
        return comHas3OnTop_NeedToDef;
    }

    private boolean canAtk_comHas3UpRight(int row, int col) {
        boolean comHas3OnTop_NeedToDef = false;
        if (col > 16 && row < 3) {
            comHas3OnTop_NeedToDef = false;
        } else if (col == 16 && row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }
        if (col < 16 && row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col + 4] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }

        }
        return comHas3OnTop_NeedToDef;

    }

    private boolean canAtk_comHas3UpLeft(int row, int col) {
        boolean comHas3OnTop_NeedToDef = false;
        if (col < 3 && row < 3) {
            comHas3OnTop_NeedToDef = false;
        } else if (col == 3 && row == 3) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }

        } else if (col > 3 && row > 3) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 4][col - 4] == 0) {
                if (comHas3OutOf4Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3])) {
                    comHas3OnTop_NeedToDef = true;
                }
            }
        }

        return comHas3OnTop_NeedToDef;
    }

    //boolean 4 node bi chan 1 dau 
    private boolean canAtk_comHas4Right_OneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (col > 15) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (col == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3],
                        board.getBoard()[row][col + 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        } else if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col + 5] == 1) {
            if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col + 1], board.getBoard()[row][col + 2], board.getBoard()[row][col + 3],
                    board.getBoard()[row][col + 4])) {
                comHas3OnTheRight_NeedToDef = true;
            }
        }
        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4Left_OneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (col < 4) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (col == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3],
                        board.getBoard()[row][col - 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        } else if (board.getBoard()[row][col] == 0 && board.getBoard()[row][col - 5] == 1) {
            if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row][col - 1], board.getBoard()[row][col - 2], board.getBoard()[row][col - 3],
                    board.getBoard()[row][col - 4])) {
                comHas3OnTheRight_NeedToDef = true;
            }
        }
        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4Up_OneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (row < 4) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (row == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col],
                        board.getBoard()[row - 4][col])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        } else if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 5][col] == 1) {
            if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col], board.getBoard()[row - 2][col], board.getBoard()[row - 3][col],
                    board.getBoard()[row - 4][col])) {
                comHas3OnTheRight_NeedToDef = true;
            }
        }
        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4Down_oneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (row > 15) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (row == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col],
                        board.getBoard()[row + 4][col])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        } else if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 5][col] == 1) {
            if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col], board.getBoard()[row + 2][col], board.getBoard()[row + 3][col],
                    board.getBoard()[row + 4][col])) {
                comHas3OnTheRight_NeedToDef = true;
            }
        }
        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4UpRight_oneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (row < 4 && col > 15) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (row == 4 && col == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3],
                        board.getBoard()[row - 4][col + 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 4 && col < 15) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 5][col + 5] == 1) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col + 1], board.getBoard()[row - 2][col + 2], board.getBoard()[row - 3][col + 3],
                        board.getBoard()[row - 4][col + 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4UpLeft_oneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (row < 4 && col < 4) {
            comHas3OnTheRight_NeedToDef = false;
        }
        if (row == 4 && col == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3],
                        board.getBoard()[row - 4][col - 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row > 4 && col > 4) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row - 5][col - 5] == 1) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row - 1][col - 1], board.getBoard()[row - 2][col - 2], board.getBoard()[row - 3][col - 3],
                        board.getBoard()[row - 4][col - 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4DownRight_oneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (row > 15 && col > 15) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (row == 15 && col == 15) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                        board.getBoard()[row + 4][col + 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (col < 15 && row < 15) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 5][col + 5] == 1) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col + 1], board.getBoard()[row + 2][col + 2], board.getBoard()[row + 3][col + 3],
                        board.getBoard()[row + 4][col + 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        return comHas3OnTheRight_NeedToDef;
    }

    private boolean canAtk_comHas4DownLeft_oneHeadBlock(int row, int col) {
        boolean comHas3OnTheRight_NeedToDef = false;
        if (row > 15 && col < 4) {
            comHas3OnTheRight_NeedToDef = false;
        } else if (row == 15 && col == 4) {
            if (board.getBoard()[row][col] == 0) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                        board.getBoard()[row + 4][col - 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }
        if (row < 15 && col > 4) {
            if (board.getBoard()[row][col] == 0 && board.getBoard()[row + 5][col - 5] == 1) {
                if (comHas4OutOf5Def(board.getBoard()[row][col], board.getBoard()[row + 1][col - 1], board.getBoard()[row + 2][col - 2], board.getBoard()[row + 3][col - 3],
                        board.getBoard()[row + 4][col - 4])) {
                    comHas3OnTheRight_NeedToDef = true;
                }
            }
        }

        return comHas3OnTheRight_NeedToDef;
    }

    public boolean mustDefense(int row, int col) {
        boolean mustDef = false;

        if (mustDef_opHas3Down(row, col) || mustDef_opHas3DownLeft(row, col) || mustDef_opHas3DownRight(row, col) || mustDef_opHas3Left(row, col)
                || mustDef_opHas3Right(row, col) || mustDef_opHas3Up(row, col) || mustDef_opHas3UpLeft(row, col) || mustDef_opHas3UpRight(row, col)
                || mustDef_opHas4DownLeft_oneHeadBlock(row, col) || mustDef_opHas4DownRight_oneHeadBlock(row, col) || mustDef_opHas4Down_oneHeadBlock(row, col)
                || mustDef_opHas4Left_OneHeadBlock(row, col) || mustDef_opHas4Right_OneHeadBlock(row, col) || mustDef_opHas4UpLeft_oneHeadBlock(row, col)
                || mustDef_opHas4UpRight_oneHeadBlock(row, col) || mustDef_opHas4Up_OneHeadBlock(row, col)) {
            mustDef = true;
        }
        return mustDef;
    }

    public boolean canFinishTheGame(int row, int col) {
        boolean canFinish = false;
        if (canAtk_comHas3Down(row, col) || canAtk_comHas3DownLeft(row, col) || canAtk_comHas3DownRight(row, col) || canAtk_comHas3Left(row, col) || canAtk_comHas3Right(row, col)
                || canAtk_comHas3Up(row, col) || canAtk_comHas3UpLeft(row, col) || canAtk_comHas3UpRight(row, col) || canAtk_comHas4DownLeft_oneHeadBlock(row, col)
                || canAtk_comHas4DownRight_oneHeadBlock(row, col) || canAtk_comHas4Down_oneHeadBlock(row, col) || canAtk_comHas4Left_OneHeadBlock(row, col)
                || canAtk_comHas4UpRight_oneHeadBlock(row, col) || canAtk_comHas4Up_OneHeadBlock(row, col) || canAtk_comHas4Right_OneHeadBlock(row, col)
                || canAtk_comHas4UpLeft_oneHeadBlock(row, col)) {
            canFinish = true;
        }
        return canFinish;
    }

    public boolean canCreateChance(int row, int col) {
        boolean canDoChances = false;
        if (canMakeChances_2ToTheDown(row, col) || canMakeChances_2ToTheDownLeft(row, col) || canMakeChances_2ToTheDownRight(row, col) || canMakeChances_2ToTheLeft(row, col)
                || canMakeChances_2ToTheRight(row, col) || canMakeChances_2ToTheUpLeft(row, col) || canMakeChances_2ToTheUpRight(row, col) || canMakeChances_2toTheUp(row, col)
                || canMakeChances_comHas3DownLeft_oneHeadBlock(row, col) || canMakeChances_comHas3DownRight_oneHeadBlock(row, col) || canMakeChances_comHas3Down_oneHeadBlock(row, col)
                || canMakeChances_comHas3Left_OneHeadBlock(row, col) || canMakeChances_comHas3Right_OneHeadBlock(row, col) || canMakeChances_comHas3UpLeft_oneHeadBlock(row, col)
                || canMakeChances_comHas3UpRight_oneHeadBlock(row, col) || canAtk_comHas4UpRight_oneHeadBlock(row, col) || canMakeChances_comHas3Up_OneHeadBlock(row, col)) {
            canDoChances = true;
        }
        return canDoChances;
    }

    public boolean canBlockEarly(int row, int col) {
        boolean canBlockEarly = false;
        if (canDefEarly_2ToTheDown(row, col) || canDefEarly_2ToTheDownLeft(row, col) || canDefEarly_2ToTheDownRight(row, col) || canDefEarly_2ToTheLeft(row, col)
                || canDefEarly_2ToTheRight(row, col) || canDefEarly_2ToTheUpLeft(row, col) || canDefEarly_2ToTheUpRight(row, col) || canDefEarly_2toTheUp(row, col)
                || canDefEarly_opHas3DownLeft_oneHeadBlock(row, col) || canDefEarly_opHas3DownRight_oneHeadBlock(row, col) || canDefEarly_opHas3Down_oneHeadBlock(row, col)
                || canDefEarly_opHas3Left_OneHeadBlock(row, col) || canDefEarly_opHas3Right_OneHeadBlock(row, col) || canDefEarly_opHas3UpLeft_oneHeadBlock(row, col)
                || canDefEarly_opHas3UpRight_oneHeadBlock(row, col) || canDefEarly_opHas3Up_OneHeadBlock(row, col)) {
            canBlockEarly = true;
        }
        return canBlockEarly;
    }

    private boolean needToDefOrLose_wholedesk() {
        boolean needDef = false;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (mustDefense(row, col)) {
                    needDef = true;
                    break;
                }
            }
        }
        return needDef;
    }

    private boolean canAtkToWin_wholedesk() {
        boolean needDef = false;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (canFinishTheGame(row, col)) {
                    needDef = true;
                    break;
                }
            }
        }
        return needDef;
    }

    private boolean canMakeChance_wholeDesk() {
        boolean needDef = false;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (canCreateChance(row, col)) {
                    needDef = true;
                    break;
                }
            }
        }
        return needDef;
    }

    private boolean canMakeTheBlockEarly_WholeDesk() {
        boolean needDef = false;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                if (canBlockEarly(row, col)) {
                    needDef = true;
                    break;
                }
            }
        }
        return needDef;
    }

    public void comMakeFirstMove_goSecond() {

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

    public void makeBestMove() {

        boolean hasMakeMoved = false;
        boolean breakk = false;

        if (canAtkToWin_wholedesk()) {
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (canFinishTheGame(row, col)) {
                        board.opponentChoiceToBoard(row, col);
                        System.out.println("can finish the game " + canAtkToWin_wholedesk());
                        hasMakeMoved = true;
                        breakk = true;
                        break;
                    }
                }
                if (breakk) {
                    break;
                }
            }
        } else if (needToDefOrLose_wholedesk() && !hasMakeMoved) {
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (mustDefense(row, col)) {
                        board.opponentChoiceToBoard(row, col);
                        System.out.println("must def the game " + needToDefOrLose_wholedesk());
                        hasMakeMoved = true;
                        breakk = true;
                        break;
                    }
                }
                if (breakk) {
                    break;
                }
            }
        } else if (opTwinsChancesFound() && !hasMakeMoved) {
            System.out.println("Chan nuoc doi");
            int count = 0;
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (canDefEarly_2ToTheDown(row, col)) {
                        count++;
                        System.out.println("case 16 ");
                    }
                    if (canDefEarly_2ToTheDownLeft(row, col)) {
                        count++;
                        System.out.println("case 1 ");
                    }
                    if (canDefEarly_2ToTheDownRight(row, col)) {
                        count++;
                        System.out.println("case 2 ");
                    }
                    if (canDefEarly_2ToTheLeft(row, col)) {
                        count++;
                        System.out.println("case 3 ");
                    }
                    if (canDefEarly_2ToTheRight(row, col)) {
                        count++;
                        System.out.println("case 4 ");
                    }
                    if (canDefEarly_2ToTheUpLeft(row, col)) {
                        count++;
                        System.out.println("case 5 ");
                    }
                    if (canDefEarly_2ToTheUpRight(row, col)) {
                        count++;
                        System.out.println("case 6 ");
                    }
                    if (canDefEarly_2toTheUp(row, col)) {
                        count++;
                        System.out.println("case 7 ");
                    }
                    if (canDefEarly_opHas3DownLeft_oneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 8 ");
                    }
                    if (canDefEarly_opHas3DownRight_oneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 9 ");
                    }
                    if (canDefEarly_opHas3Down_oneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 10 ");
                    }
                    if (canDefEarly_opHas3Left_OneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 11 ");
                    }
                    if (canDefEarly_opHas3Right_OneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 12 ");
                    }
                    if (canDefEarly_opHas3UpLeft_oneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 13 ");
                    }
                    if (canDefEarly_opHas3UpRight_oneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 14 ");
                    }
                    if (canDefEarly_opHas3Up_OneHeadBlock(row, col)) {
                        count++;
                        System.out.println("case 15 ");
                    }
                    if (count == 2) {
                        board.opponentChoiceToBoard(row, col);
                        hasMakeMoved = true;
                        System.out.println("row : " + row);
                        System.out.println("col : " + col);
                        breakk = true;

                        break;
                    }
                    count = 0;
                }
                if (breakk == true) {

                    break;
                }
            }
        } else if (comHasTwinsChancesFound() && !hasMakeMoved) {
            int count = 0;
            System.out.println("danh nuoc doi");
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (canMakeChances_2ToTheDown(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2ToTheDownLeft(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2ToTheDownRight(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2ToTheLeft(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2ToTheRight(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2ToTheUpLeft(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2ToTheUpRight(row, col)) {
                        count++;
                    }
                    if (canMakeChances_2toTheUp(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3DownLeft_oneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3DownRight_oneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3Down_oneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3Left_OneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3Right_OneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3UpLeft_oneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3UpRight_oneHeadBlock(row, col)) {
                        count++;
                    }
                    if (canMakeChances_comHas3Up_OneHeadBlock(row, col)) {
                        count++;
                    }
                    if (count == 2) {
                        board.opponentChoiceToBoard(row, col);
                        hasMakeMoved = true;
                        System.out.println("row : " + row);
                        System.out.println("col : " + col);
                        breakk = true;

                        break;
                    }
                    count = 0;
                }
                if (breakk == true) {
                    break;
                }
            }

        } else if (canMakeChance_wholeDesk() && !hasMakeMoved) {
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (canCreateChance(row, col)) {
                        board.opponentChoiceToBoard(row, col);
                        System.out.println("can create the chance " + canMakeChance_wholeDesk());
                        hasMakeMoved = true;
                        breakk = true;
                        break;
                    }
                }
                if (breakk) {
                    break;
                }
            }
        } else if (canMakeTheBlockEarly_WholeDesk() && !hasMakeMoved) {
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (canBlockEarly(row, col)) {
                        board.opponentChoiceToBoard(row, col);
                        System.out.println("can block early the game " + canMakeTheBlockEarly_WholeDesk());
                        hasMakeMoved = true;
                        breakk = true;
                        break;
                    }
                }
                if (breakk) {
                    break;
                }
            }
        } else {
            secondMove_goFirst();
        }

    }

}
