package gameplay.winning.roundStates;

import gameplay.player.Player;

public class WinFactory {

    public static WinningCondition getWin(RoundState roundState) {
        switch (roundState) {
            case XWINS:
                return new XWins();
            case OWINS:
                return new OWins();
            case DRAW:
                return new Draw();
            default:
                return null;
        }
    }

    public static WinningCondition getWin(Player player) {
        if (player.getSign() instanceof XWins) return getWin(RoundState.XWINS);
        return getWin(RoundState.OWINS);
    }
}
