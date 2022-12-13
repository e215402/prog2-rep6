package jp.ac.uryukyu.ie.e215402;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Board extends JFrame {

    private static final int BOARD_SIZE = 8; // 盤面のサイズ
    private String[][] board;

    public Board() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
            board[i][j] = "-";
            }
        }

        setTitle("Board");
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new myBoard());
        setVisible(true);
    }

    public class myBoard extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 盤面を表示
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    g.drawString(board[i][j], i * 60 + 30, j * 60 + 30);
                }
            }
        }
    }
}
