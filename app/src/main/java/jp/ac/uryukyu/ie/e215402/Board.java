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
    private DiscManager discs; // ディスクのリスト

    /**
     * コンストラクタ。
     */
    public Board() {
        // ディスクのリストを初期化
        discs = new DiscManager();
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
     * ゲーム終了画面
     * 
     * @param message
     */
    public void showMessageWindow(String message) {
        JFrame frame = new JFrame();
        frame.setTitle("Game Over");
        frame.setBounds(240, 250, 250, 100);
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
                    Disc disc = discs.getDiscAtLocation(i, j);

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
                    Disc disc = discs.getDiscAtLocation(x, y);

                    // この位置にすでにディスクがある場合は何もしない
                    if (disc != null) {
                        return;
                    }
                    // この位置にディスクを設置できるかを確認
                    // if (!canPutDisc(x, y)) {
                    //     return;
                    // }
                      // この位置にディスクを設置できるかを確認
                    // if (!GameMaster.canFlip(discs, x, y, lastPiecePlaced, 0)) {
                    //     return;
                    // }
                    // 最後に置かれたピースの色を反転させ、新しいピースの色を設定
                    String newColor = discs.getLastDicsPlaced().equals("X") ? "O" : "X";
                    discs.setLastDiscPlaced(newColor);

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
    }
}
