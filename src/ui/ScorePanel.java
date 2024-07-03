package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScorePanel extends JPanel{
    private JButton reset,restart,exit;
    private JLabel player1Score,player2Score;
    private int p1Score,p2Score;
    @SuppressWarnings("unused")
    private GamePanel gamePanel;

    public ScorePanel(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        p1Score=0;
        p2Score=0;
        setSize(200,300);
        setLocation(400,100);
        setBackground(Color.decode("#ebebda"));
        setLayout(null);

        reset = new JButton("Reset");
        reset.setSize(80, 30);
        reset.setLocation(15, 210);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.resetGame();
                System.out.println("Game Reset");
            }
        });

        restart = new JButton("Restart");
        restart.setSize(80, 30);
        restart.setLocation(105, 210);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.resetGame();
                p1Score=0;
                p2Score=0;
                player1Score.setText("0");
                player2Score.setText("0");
                System.out.println("Game Restarted");
            }
        });

        exit = new JButton("Exit");
        exit.setSize(80, 30);
        exit.setLocation(60, 250);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        player1Score=new JLabel(Integer.toString(p1Score),SwingConstants.CENTER);
        player1Score.setBackground(Color.decode("#adff2f"));
        player1Score.setForeground(Color.red);
        player1Score.setFont(new Font("Arial", Font.PLAIN, 30));
        player1Score.setOpaque(true);
        player1Score.setLocation(0,50);
        player1Score.setSize(200,50);

        player2Score=new JLabel(Integer.toString(p2Score),SwingConstants.CENTER);
        player2Score.setBackground(Color.decode("#adff2f"));
        player2Score.setForeground(Color.red);
        player2Score.setFont(new Font("Arial", Font.PLAIN, 30));
        player2Score.setOpaque(true);
        player2Score.setLocation(0,150);
        player2Score.setSize(200,50);

        JLabel p1=new JLabel("Player 1",SwingConstants.CENTER);
        p1.setBackground(Color.decode("#ebebda"));
        p1.setForeground(Color.red);
        p1.setFont(new Font("Arial", Font.PLAIN, 30));
        p1.setOpaque(true);
        p1.setLocation(0,0);
        p1.setSize(200,50);

        JLabel p2=new JLabel("Player 2",SwingConstants.CENTER);
        p2.setBackground(Color.decode("#ebebda"));
        p2.setForeground(Color.red);
        p2.setFont(new Font("Arial", Font.PLAIN, 30));
        p2.setOpaque(true);
        p2.setLocation(0,100);
        p2.setSize(200,50);

        add(p1);
        add(player1Score);
        add(p2);
        add(player2Score);
        add(reset);
        add(restart);
        add(exit);

        repaint();
    }

    public void increaseP1Score(){
        p1Score++;
        player1Score.setText(Integer.toString(p1Score));
    }

    public void increaseP2Score(){
        p2Score++;
        player2Score.setText(Integer.toString(p2Score));
    }
}
