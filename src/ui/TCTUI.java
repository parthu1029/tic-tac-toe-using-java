package ui;

import java.awt.*;
import javax.swing.*;

public class TCTUI {
    JFrame frame;

    public TCTUI() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(650, 500);
        frame.getContentPane().setBackground(Color.decode("#f5a3a3"));
        frame.setLocationRelativeTo(null);

        //JPanel homePanel=new JPanel();

        JPanel gPanel=new JPanel();
        gPanel.setLayout(null);
        gPanel.setSize(650,500);
        gPanel.setBackground(Color.decode("#f5a3a3"));
        gPanel.setLocation(0,0);

        JLabel title = new JLabel("TIC TAC TOE");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setBounds(200, 30, 300, 50);
        gPanel.add(title);
        
        GamePanel gamePanel=new GamePanel("X");
        gPanel.add(gamePanel);

        ScorePanel scorePanel=new ScorePanel(gamePanel);
        gPanel.add(scorePanel);

        gamePanel.setScorePanel(scorePanel);

        //gPanel.add(new IntroPanel());
        
        frame.add(gPanel);
        //frame.add(new IntroPanel());
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
}


