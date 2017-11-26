package gameplay.winning;

import gameplay.board.BoardDimension;

public class WinSeeker {


    private final int winningLength;
    private final String pattern;


    public WinSeeker(BoardDimension bd) {
        this.winningLength = bd.getWinningLength();
        this.pattern = String.format(".*(X{%d}|O{%d}).*", winningLength, winningLength);

    }

    public boolean matcher(String sequence) {
        return sequence.matches(pattern);
    }

    public boolean isWinningMove(String[] seqs) {
        for (String seq : seqs)
            if (seq.matches(pattern)) return true;
        return false;
    }

}
