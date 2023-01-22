// package jp.ac.uryukyu.ie.e215402;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class GameMasterTest {
//     @Test
//     public void canFlipTest() {
//     // テスト用のDiscManagerを作成
//     DiscManager discs = new DiscManager();
//     discs.addDisc(new Disc(4, 3, "X"));
//     discs.addDisc(new Disc(4, 4, "O"));
//     discs.addDisc(new Disc(5, 4, "O"));
//     discs.addDisc(new Disc(5, 5, "O"));
//     discs.addDisc(new Disc(6, 5, "X"));

//     // もしXが(3, 4)に置いたとする
//     assertTrue(GameMaster.canFlip(discs, 3, 4, "X", 0));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "O", 0));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "X", 1));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "X", 2));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "X", 3));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "X", 4));
//     assertTrue(GameMaster.canFlip(discs, 3, 4, "X", 5));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "X", 6));
//     assertFalse(GameMaster.canFlip(discs, 3, 4, "X", 7));

//     }
// }    
