package gameplay.winning;

import gameplay.board.BoardDimension;

public class WinSeeker {


    private final int winningLength;
    private final String pattern;


    public WinSeeker(BoardDimension bd) {
        this.winningLength = bd.winningLength();
        this.pattern = String.format(".*(X{%d}|O{%d}).*", winningLength, winningLength);

    }

    boolean matcher(String sequence) {
        return sequence.matches(pattern);
    }

    public boolean isWinningMove(Sequence seq) {
        while(seq.hasNext())
            if (matcher(seq.next())) return true;
        return false;
    }

}
