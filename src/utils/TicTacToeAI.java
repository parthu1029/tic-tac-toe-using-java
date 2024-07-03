package utils;

public class TicTacToeAI {
    private String aiPlayer, humanPlayer;
    private String[][] board;

    public TicTacToeAI(String[][] gameBoard, String humanChoice) {
        this.board = gameBoard;
        humanPlayer = humanChoice;
        aiPlayer = (humanChoice.equals("X")) ? "O" : "X";
    }

    public int[] makeMove(int playerRowMove, int playerColMove) {
        int[] move = minimax(4, aiPlayer);
        return new int[]{move[1], move[2]};
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                return true;
            }
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                return true;
            }
        }
        if (board[0][0] != null && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        }
        if (board[0][2] != null && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            return true;
        }
        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] minimax(int depth, String player) {
        if (checkWin()) {
            if (player.equals(aiPlayer)) {
                return new int[]{-1, -1, -1};
            } else {
                return new int[]{1, -1, -1};
            }
        } else if (checkDraw()) {
            return new int[]{0, -1, -1};
        }

        int[] best = (player.equals(aiPlayer)) ? new int[]{Integer.MIN_VALUE, -1, -1} : new int[]{Integer.MAX_VALUE, -1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    board[i][j] = player;
                    int[] score = minimax(depth - 1, (player.equals(aiPlayer)) ? humanPlayer : aiPlayer);
                    board[i][j] = null;
                    score[1] = i;
                    score[2] = j;

                    if (player.equals(aiPlayer)) {
                        if (score[0] > best[0]) {
                            best = score;
                        }
                    } else {
                        if (score[0] < best[0]) {
                            best = score;
                        }
                    }
                }
            }
        }
        return best;
    }
}
