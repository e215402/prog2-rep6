package jp.ac.uryukyu.ie.e215402;

/**
 * Discをひっくり返す処理を行うクラス
 * 
 */
public class GameMaster {
    private static final int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    private static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    /**
     * 指定された座標と色が指定された方向にあるコマをひっくり返すべきか判定する
     * @param discs 盤上のコマの配置
     * @param x 置かれるコマのx座標
     * @param y 置かれるコマのy座標
     * @param color 置かれるコマの色
     * @param direction 方向
     * @return ひっくり返すべきならtrue、そうでないならfalse
     */
    public static boolean canFlip(DiscManager discs, int x, int y, String color, int direction) {
        // 盤外に出ていたらfalseを返す
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
            return false;
        }
        
        // 盤上のコマを取得
        Disc disc = discs.getDiscAtLocation(nx, ny);

        // コマが存在しないか、自分と同じ色だったらfalseを返す
        if (disc == null || disc.getColor().equals(color)) {
            return false;
        }
        // ひっくり返すべきコマがあるか再帰的に判定
        boolean canFlip=canFlip(discs,nx,ny,color, direction);
        if (canFlip) {
            return true;
        } else {
            // ひっくり返すべきコマがない場合は、falseを返す
            return true;
        }
    }
}



