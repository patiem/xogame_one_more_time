package gameplay.winning.roundStates;

import gameplay.player.Player;
import gameplay.signs.Sign;

public class WinFactory {

    public static WinningCondition getWin(RoundState roundState, String playerName) {
        switch (roundState) {
            case XWINS:
                return new XWins(playerName);
            case OWINS:
                return new OWins(playerName);
            case DRAW:
                return new Draw();
            default:
                return null;
        }
    }

    public static WinningCondition getWin(Sign lastMoveSign, String playerName) {
        if (lastMoveSign instanceof XWins) return getWin(RoundState.XWINS, playerName);
        return getWin(RoundState.OWINS, playerName);
    }
}
