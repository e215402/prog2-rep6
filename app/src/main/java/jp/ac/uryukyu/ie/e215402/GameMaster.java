package jp.ac.uryukyu.ie.e215402;

/**
 * Discをひっくり返す処理を行うクラス
 */
public class GameMaster {
    // private static final int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    // private static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    // /**
    //  * 指定された座標と色が指定された方向にあるコマをひっくり返すべきか判定する
    //  * @param discs 盤上のコマの配置
    //  * @param x 置かれるコマのx座標
    //  * @param y 置かれるコマのy座標
    //  * @param color 置かれるコマの色
    //  * @param direction 方向
    //  * @return ひっくり返すべきならtrue、そうでないならfalse
    //  */
    // public static boolean canFlip(Discs discs, int x, int y, String color, int direction) {
    //     // 盤外に出ていたらfalseを返す
    //     if (x < 0 || x >= 8 || y < 0 || y >= 8) {
    //         return false;
    //     }

    //     // 盤上のコマを取得
    //     Disc disc = discs.getDiscAtLocation(x, y);

    //     // コマが存在しないか、自分と同じ色だったらfalseを返す
    //     if (disc == null || disc.getColor().equals(color)) {
    //         return false;
    //     }
    //     // コマをひっくり返す
    //     disc.setColor(color);

    //     // ひっくり返すべきコマがあるか再帰的に判定
    //     return canFlip(discs, x + dx[direction], y + dy[direction], color, direction);
            // ひっくり返すべきコマがあった場合は、自分自身もひっくり返す
    //         disc.setColor(color);
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    
    // }
}
