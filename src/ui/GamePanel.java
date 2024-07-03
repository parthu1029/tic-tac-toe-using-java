package ui;

import utils.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    private int x, y;
    private String[][] board;
    private String playerChoice, aiChoice;
    private TicTacToeAI ai;
    private ScorePanel scorePanel;

    public GamePanel(String choice) {
        board = new String[3][3];
        this.playerChoice = choice;
        aiChoice = (choice.equals("X")) ? "O" : "X";
        ai = new TicTacToeAI(board, playerChoice);
        this.setSize(300, 300);
        this.setLocation(50, 100);
        this.setBackground(Color.decode("#ebebda"));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX() / 100;
                y = e.getY() / 100;

                if (board[x][y] == null) {
                    board[x][y] = playerChoice;
                    repaint();
                    if (ai.checkWin()) {
                        System.out.println("Player wins!");
                        scorePanel.increaseP1Score();
                        resetGame();
                    } else if (ai.checkDraw()) {
                        System.out.println("Draw!");
                        resetGame();
                    } else {
                        int[] aiMove = ai.makeMove(x, y);
                        board[aiMove[0]][aiMove[1]] = aiChoice;
                        if (ai.checkWin()) {
                            System.out.println("AI wins!");
                            scorePanel.increaseP2Score();
                            resetGame();
                        } else if (ai.checkDraw()) {
                            System.out.println("Draw!");
                            resetGame();
                        }
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics gp) {
        super.paintComponent(gp);
        Graphics2D g = (Graphics2D) gp;
        g.setStroke(new BasicStroke(5));
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);
        g.setFont(new Font("Arial", Font.PLAIN, 110));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != null) {
                    g.drawString(board[i][j], i * 100 + 10, j * 100 + 90);
                }
            }
        }
    }

    public void setScorePanel(ScorePanel scorePanel){
        this.scorePanel=scorePanel;
    }

    public void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
        }
        repaint();
    }
}
