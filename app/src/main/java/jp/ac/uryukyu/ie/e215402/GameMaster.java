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
     * @return ひっくり返すべきならtrue、そうでないならfalse
     */
public static boolean canFlip(DiscManager discs, int x, int y, String color) {
    boolean canFlip = false;
    for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        // 盤外に出ていたらスキップ
        if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
            continue;
        }
        // 盤上のコマを取得
        Disc disc = discs.getDiscAtLocation(nx, ny);
        // コマが存在しないか、自分と同じ色だったらスキップ
        if (disc == null || disc.getColor().equals(color)) {
            continue;
        }
        // 直前の色が違う色だったら
        if(disc.getColor() != color) {
            int nextX = nx + dx[i];
            int nextY = ny + dy[i];
            // 一度も自分の色が見つからなかったらfalse
            while(nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8) {
                Disc nextDisc = discs.getDiscAtLocation(nextX, nextY);
                if(nextDisc == null) {
                    break;
                }
                if(nextDisc.getColor().equals(color)) {
                    while(nextX != x || nextY != y) {
                        nextX -= dx[i];
                        nextY -= dy[i];
                        if(nextX==x && nextY==y) continue;
                        Disc flipDisc = discs.getDiscAtLocation(nextX, nextY);
                        flipDisc.setColor(color);
                    }
                    canFlip = true;
                    break;
                }
                nextX += dx[i];
                nextY += dy[i];
                }
            }
        }
    return canFlip;
}
}



