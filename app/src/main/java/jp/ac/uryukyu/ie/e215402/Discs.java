package jp.ac.uryukyu.ie.e215402;

import java.util.ArrayList;
import java.util.List;

/**
 * 盤上全てのマスを管理する
 */
public class Discs {
    private List<Disc> discs;
    
    
    public Discs() {
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
                return "黒の勝ち!";
            } else if (whiteCount > blackCount) {
                return "白の勝ち!";
            } else {
                return "同点!";
            }
        }
        return "";
    }
}
