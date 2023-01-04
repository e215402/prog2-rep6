package jp.ac.uryukyu.ie.e215402;

import java.util.ArrayList;
import java.util.List;

/**
 * 盤上全てのコマを管理する
 */
public class DiscManager {
    private List<Disc> discs;
    private String LastDiscPlaced = ""; 
    
    
    public DiscManager() {
        discs = new ArrayList<>();
    }

    public void addDisc(Disc disc) {
        discs.add(disc);
    }

    public void removeDisc(Disc disc) {
        discs.remove(disc);
    }

    public List<Disc> getDiscs() {
        return discs;
    }
    public String getLastDicsPlaced() {
        return LastDiscPlaced;
    }
    public void setLastDiscPlaced(String LastDiscPlaced) {
        this.LastDiscPlaced = LastDiscPlaced;
    }
    /**
     * 指定された位置にあるディスクを取得する。
     * 
     * @param x x座標
     * @param y y座標
     * @return 指定された位置にあるディスク。ない場合はnull。
     */
    public Disc getDiscAtLocation(int x, int y) {
        for (Disc disc : getDiscs()) {
            if (disc.getX() == x && disc.getY() == y) {
                return disc;
            }
        }
        return null;
    }
    /**
     * 勝敗を判定する
     */
    public String JudgeGame(){
        int blackCount = 0;
        int whiteCount = 0;
        for (Disc disc : discs) {
            if (disc.getColor().equals("X")) {
                blackCount++;
            } else if (disc.getColor().equals("O")) {
                whiteCount++;
            }
        }
        if(blackCount+whiteCount==64){
            if (blackCount > whiteCount) {
                return "黒の勝ち！";
            } else if (whiteCount > blackCount) {
                return "白の勝ち！";
            } else {
                return "同点！";
            }
        }
        return "";
    }
}
