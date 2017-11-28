package gameplay;

import gameplay.player.Player;
import gameplay.signs.Sign;
import gameplay.winning.winTypes.WinningCondition;
import utility.Polish;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<WinningCondition> winList = new ArrayList<>();
    private Player playerX;
    private Player playerO;

    public ScoreBoard(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void addWin(WinningCondition wc) {
        winList.add(wc);
        recountPointsForPlayer(wc);
    }

    private void recountPointsForPlayer(WinningCondition wc) {
         playerX.increasePoints(wc.getPointsForX());
         playerO.increasePoints(wc.getPointsForO());
    }

    @Override
    public String toString() {
        return String.format(Polish.MSG_SCORE.toString(),
                playerX.getName(), playerX.getPoints(), playerO.getName(), playerO.getPoints());
    }

    public Polish getWinner() {
        if (playerX.getPoints() == playerO.getPoints()) return Polish.DRAW;
        return (playerX.getPoints() > playerO.getPoints()) ? Polish.WIN_X : Polish.WIN_O;
    }
}
