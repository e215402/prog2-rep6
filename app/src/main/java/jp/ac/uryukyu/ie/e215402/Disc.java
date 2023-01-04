package jp.ac.uryukyu.ie.e215402;

/**
 *盤上の1マスを管理する
 */
public class Disc {
    private int x;
    private int y;
    private String color;
    private boolean placed;

    public Disc(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.placed = true; // コマを設置する
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
    
}



