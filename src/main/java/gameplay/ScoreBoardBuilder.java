package gameplay;

import gameplay.player.Player;
import gameplay.player.PlayerSwitcher;
import gameplay.signs.OSign;
import gameplay.signs.XSign;
import init.Config;

public class ScoreBoardBuilder {

    private Player playerX;
    private Player playerO;

    public ScoreBoardBuilder withPlayersFromConfig(Config<String> users) {
        PlayerSwitcher pl = PlayerSwitcher.build(users);
        Player playerOne = pl.getActualPlayer();
        Player playerTwo = pl.getActualPlayer();
        playerX = (playerOne.getSign() instanceof XSign) ? playerOne : playerTwo;
        playerO = (playerOne.getSign() instanceof OSign) ? playerOne : playerTwo;
        return this;
    }

    public ScoreBoard build() {
        return new ScoreBoard(playerX, playerO);
    }
}
