package jp.ac.uryukyu.ie.e215402;

public class Disc {
    private int x;
    private int y;
    private String color;

    public Disc(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
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
}



