package jp.ac.uryukyu.ie.e215402;

/**
 *盤上の1マスを管理する
 */
public class Disc {
    private int x;
    private int y;
    private String color;
    // private boolean placed;

    /**
     * 指定された座標と色で新しいDiscを構築します。
     * @param x ディスクのx座標
     * @param y ディスクのy座標
     * @param color ディスクの色
     */
    public Disc(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        // this.placed = true; // コマを設置する
    }

    /**
     * ディスクのx座標を返す
     * @return ディスクのx座標
     */
    public int getX() {
        return x;
    }

    /**
     * ディスクのy座標を返す
     * @return ディスクのy座標
     */
    public int getY() {
        return y;
    }

    /**
     * ディスクの色を返す
     * @return ディスクの色
     */
    public String getColor() {
        return color;
    }

    // public void setColor(String color) {
    //     this.color = color;
    // }

    // public boolean isPlaced() {
    //     return placed;
    // }

    // public void setPlaced(boolean placed) {
    //     this.placed = placed;
    // }
    
}



