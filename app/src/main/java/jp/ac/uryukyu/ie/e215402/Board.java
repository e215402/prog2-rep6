package jp.ac.uryukyu.ie.e215402;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Board extends JFrame {

    private static final int BOARD_SIZE = 8; // 盤面のサイズ
    private String[][] board;
    private String lastPiecePlaced = "";


    public Board() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
            board[i][j] = "-";
            board[3][3] = "X";
            board[4][4] = "X";
            board[4][3] = "O";
            board[3][4] = "O";
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
                    g.drawString(board[i][j], i * 60 + 30, j * 60 + 33);
                }
            }
            // for (int i = 0; i < BOARD_SIZE; i++) {
            //     g.drawLine(i * 60, 0, i * 60, BOARD_SIZE * 60);
            //     g.drawLine(0, i * 60, BOARD_SIZE * 60, i * 60);
            // }
            
            addMouseListener(new MouseAdapter() {
                // マウスをクリックしてコマを置く
                public void mouseClicked(MouseEvent e) {
                    
                    int x = e.getX() / 60;
                    int y = e.getY() / 60;
                    
                    putPiece(x, y, "O"); 
                }
            });
        }
    }

    // public boolean isInitialState() {
    //     // 盤面が初期状態かどうかを判定する いらない？
    //     for (int i = 0; i < BOARD_SIZE; i++) {
    //         for (int j = 0; j < BOARD_SIZE; j++) {
    //             if (!"-".equals(board[i][j])) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    public void putPiece(int x, int y, String piece) {
        // 盤面の範囲外の場合は何もしない
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) 
            return;
        if (!"-".equals(board[x][y])) 
            return;
        // 交互に置く
        piece = (lastPiecePlaced.equals("X")) ? "O" : "X";
        // コマを置く
        board[x][y] = piece;
        lastPiecePlaced = piece;
        repaint();
    }
}
