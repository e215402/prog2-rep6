package jp.ac.uryukyu.ie.e215402;

import java.awt.Color;
// import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame {
    // 定数
    private static final int BOARD_SIZE = 8;  // ボードのサイズ
    private static final int CELL_SIZE = 60;  // セルのサイズ
    private static final int WINDOW_SIZE = 500;  // ウィンドウのサイズ

    // フィールド
    private Discs discs;  // ディスクのリスト
    private String lastPiecePlaced = "";  // 最後に置かれたピースの色

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

                    // 新しいディスクを作成し、リストに追加する
                    String color = lastPiecePlaced.equals("X") ? "O" : "X";
                    disc = new Disc(x, y, color);
                    discs.addDisc(disc);
                    lastPiecePlaced = color;

                    // 再描画
                    repaint();
                }
            });
        }
        private Disc getDiscAtLocation(int x, int y) {
            for (Disc disc : discs.getDiscs()) {
                if (disc.getX() == x && disc.getY() == y) {
                    return disc;
                }
            }
            return null;
        }
    
    }
}
