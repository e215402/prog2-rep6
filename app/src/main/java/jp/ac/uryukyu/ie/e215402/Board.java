package jp.ac.uryukyu.ie.e215402;

import java.awt.Color;
// import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class Board extends JFrame {
    // 定数
    private static final int BOARD_SIZE = 8; // ボードのサイズ
    private static final int CELL_SIZE = 60; // セルのサイズ
    private static final int WINDOW_SIZE = 500; // ウィンドウのサイズ

    // フィールド
    private Discs discs; // ディスクのリスト
    private String lastPiecePlaced = ""; // 最後に置かれたピースの色
    

    /**
     * コンストラクタ。
     */
    public Board() {
        // ディスクのリストを初期化
        discs = new Discs();
        discs.addDisc(new Disc(3, 3, "X"));
        discs.addDisc(new Disc(4, 4, "X"));
        discs.addDisc(new Disc(4, 3, "O"));
        discs.addDisc(new Disc(3, 4, "O"));

        // ウィンドウを設定
        setTitle("Othello");
        setBounds(100, 100, WINDOW_SIZE, WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GameBoard());
        setVisible(true);
    }
    //ゲーム終了画面
    public void showMessageWindow(String message) {
        JFrame frame = new JFrame();
        frame.setTitle("Game Over");
        frame.setBounds(100, 100, 250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JPanel panel = new JPanel();
        panel.add(new JLabel(message));
        frame.add(panel);
    
        frame.setVisible(true);
    }
    
    /**
     * ボードを描画するパネルを表す内部クラス。
     */
    private class GameBoard extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // ボードを描画
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    // この位置にあるディスクを取得
                    Disc disc = getDiscAtLocation(i, j);

                    // ディスクを描画するか、空白を描画する
                    if (disc == null) {
                        g.setColor(Color.GREEN);
                        g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    } else {
                        g.setColor(disc.getColor().equals("X") ? Color.BLACK : Color.WHITE);
                        g.fillOval(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
            }

            // グリッド線を描画
            g.setColor(Color.BLACK);
            for (int i = 0; i <= BOARD_SIZE; i++) {
                g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
                g.drawLine(0, i * CELL_SIZE, BOARD_SIZE * CELL_SIZE, i * CELL_SIZE);
            }

            // ボードでクリックされたときにリスナーを追加
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // クリックされたセルの座標を取得
                    int x = e.getX() / CELL_SIZE;
                    int y = e.getY() / CELL_SIZE;

                    // この位置にあるディスクを取得
                    Disc disc = getDiscAtLocation(x, y);

                    // この位置にすでにディスクがある場合は何もしない
                    if (disc != null) {
                        return;
                    }
                    // この位置にディスクを設置できるかを確認
                    // if (!canPutDisc(x, y)) {
                    //     return;
                    // }
                    // 最後に置かれたピースの色を反転させ、新しいピースの色を設定
                    String newColor = lastPiecePlaced.equals("X") ? "O" : "X";
                    lastPiecePlaced = newColor;

                    // 新しいピースを設置
                    Disc newDisc = new Disc(x, y, newColor);
                    discs.addDisc(newDisc);
                    String gameResult = discs.JudgeGame();
                    // ゲームの状態を更新し、ボードを再描画
                    repaint();
                    if (!gameResult.isEmpty()) {
                        showMessageWindow(gameResult);
                    }
                }
            });
        }
        
        /**
         * 指定された位置にあるディスクを取得する。
         * 
         * @param x x座標
         * @param y y座標
         * @return 指定された位置にあるディスク。ない場合はnull。
         */
        public Disc getDiscAtLocation(int x, int y) {
            for (Disc disc : discs.getDiscs()) {
                if (disc.getX() == x && disc.getY() == y) {
                    return disc;
                }
            }
            return null;
        }
        
        // public boolean canPlaceDiscAtLocation(int x, int y) {
        //     for (Disc disc : discs.canPutDisc()) {
        //         if (disc.getX() == x && disc.getY() == y) {
        //             return false;
        //         }
        //     }
        //     return true;
        // }
        
        // ボード上の指定された場所に、新しいコマを置けるかどうかを判定する処理を追加
        // public boolean canPutDisc(int x, int y) {
        //     // 指定された場所にすでにコマがある場合、新しいコマを置けない
        //     if (getDiscAtLocation(x, y) != null) {
        //         return false;
        //     }
        //     // 上下左右に移動しながら、相手のコマを挟んでいるかを調べる
        //     int[] dx = { -1, 0, 1, 0 };
        //     int[] dy = { 0, -1, 0, 1 };
        //     for (int i = 0; i < 4; i++) {
        //         int nx = x + dx[i];
        //         int ny = y + dy[i];
        //         // 移動先がボード外の場合は、スキップする
        //         if (nx < 0 || nx >= BOARD_SIZE || ny < 0 || ny >= BOARD_SIZE) {
        //             continue;
        //         }

        //         Disc disc = getDiscAtLocation(nx, ny);
        //         // 移動先に相手のコマがない場合は、スキップする
        //         if (disc == null || disc.getColor().equals(lastPiecePlaced)) {
        //             continue;
        //         }

        //         // 移動先からさらに移動して自分のコマがあるかを調べる
        //         while (true) {
        //             nx += dx[i];
        //             ny += dy[i];
        //             // 移動先がボード外の場合は、スキップする
        //             if (nx < 0 || nx >= BOARD_SIZE || ny < 0 || ny >= BOARD_SIZE) {
        //                 break;
        //             }
        //             Disc nextDisc = getDiscAtLocation(nx, ny);
        //             // 移動先にコマがない場合は、スキップする
        //             if (nextDisc == null) {
        //                 break;
        //             }
        //             // 移動先に自分のコマがある場合は、新しいコマを置ける
        //             if (nextDisc.getColor().equals(lastPiecePlaced)) {
        //                 return true;
        //             }
        //         }
        //     }
        //     // 新しいコマを置ける場所が見つからなかった場合は、新しいコマを置けない
        //     return false;
        // }
    }
}
