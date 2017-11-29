package gameplay.winning.wintypes;

import gameplay.player.Player;
import gameplay.signs.Sign;

public class WinFactory {

    public static WinningCondition getWin(RoundState roundState, Player player) {
        switch (roundState) {
            case XWINS:
                return new XWins(player);
            case OWINS:
                return new OWins(player);
            case DRAW:
                return new Draw();
            default:
                return null;
        }
    }

    public static WinningCondition getWin(Sign lastMoveSign, Player player) {
        if (lastMoveSign instanceof XWins) return getWin(RoundState.XWINS, player);
        return getWin(RoundState.OWINS, player);
    }
}
