package jp.ac.uryukyu.ie.e215402;

/**
 *盤上の1マスを管理する
 */
public class Disc {
    private int x;
    private int y;
    private String color;

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

    /**
     * ディスクの色を設定する
     * @param color 設定する色
     */
    public void setColor(String color) {
        this.color = color;
    }
    
}



