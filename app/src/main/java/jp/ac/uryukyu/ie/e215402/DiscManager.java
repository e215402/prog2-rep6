package jp.ac.uryukyu.ie.e215402;

import java.util.ArrayList;
import java.util.List;

/**
 * 盤上全てのディスクを管理する
 */
public class DiscManager {
    private List<Disc> discs;
    private String LastDiscPlaced = ""; 
    
    
    /**
     * コンストラクタ
     * */
    public DiscManager() {
        discs = new ArrayList<>();
    }

    /**
     * ディスクを追加する
     * 
     * @param disc 追加するディスク
     * */
    public void addDisc(Disc disc) {
        discs.add(disc);
    }

    /**
    * 盤上のすべてのディスクを取得する
    *
    * @return 盤上のすべてのディスク
    */
    public List<Disc> getDiscs() {
        return discs;
    }

    /**
     * 最後に置かれたディスクの色を取得する。
     * @return 最後に置かれたディスクの色
     * */
    public String getLastDicsPlaced() {
        return LastDiscPlaced;
    }

    /**
     * 最後に置かれたディスクの色を設定する。
     * 
    **/
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
     * 指定された位置にあるディスクを取得する。
     * 
     * @return ディスクの数
     */
    public int getDiscCount() {
        return discs.size();
    }
    
    /**
     * 勝敗を判定する
     * 
     * @return ゲームの勝者を宣言する
     */
    public String JudgeGame(){
        int blackCount = 0;
        int whiteCount = 0;
        for (Disc disc : discs) {
            if (disc.getColor().equals("X")) {
                blackCount++;
                // System.out.println(blackCount);
            } else if (disc.getColor().equals("O")) {
                whiteCount++;
                // System.out.println(whiteCount);
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
