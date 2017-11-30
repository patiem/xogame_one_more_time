package gameplay.winning.wintypes;

import gameplay.player.Player;
import gameplay.round.RoundState;

public class WinFactory {

    private WinFactory(){}

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
}
