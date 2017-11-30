package gameplay.winning;

import gameplay.board.BoardDimension;

class WinSeeker {


    private final String pattern;


    public WinSeeker(BoardDimension bd) {
        this.pattern = String.format(".*(X{%d}|O{%d}).*", bd.winningLength(), bd.winningLength());

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
