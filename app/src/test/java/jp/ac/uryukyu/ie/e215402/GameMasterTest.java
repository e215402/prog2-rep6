package jp.ac.uryukyu.ie.e215402;

import org.junit.jupiter.api.Test;

public class GameMasterTest {
    @Test
    public static void main(String[] args) {
        DiscManager discs = new DiscManager();
        discs.addDisc(new Disc(3, 3, "X"));
        discs.addDisc(new Disc(4, 4, "X"));
        discs.addDisc(new Disc(4, 3, "O"));
        discs.addDisc(new Disc(3, 4, "O"));
    
        // (5, 5) の位置に "X" のコマを置いた場合、ひっくり返すことができる
        boolean result = GameMaster.canFlip(discs, 5, 5, "X");
        System.out.println("期待される結果: true / 実際の結果 : " + result);
    
        // (3, 4) の位置に "X" のコマを置いた場合、ひっくり返すことができない
        result = GameMaster.canFlip(discs, 3, 4, "X");
        System.out.println("期待される結果 : false / 実際の結果 : " + result);
    }
}    
