package gameplay.winning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence implements Iterator<String>{


    private final List<String> sequences;
    private int index = 0;

    public Sequence() {
        sequences = new ArrayList<>();
    }

    public void add(String seq) {
        sequences.add(seq);
    }

    @Override
    public boolean hasNext() {
        if(index < sequences.size()) return true;
        return false;
    }

    @Override
    public String next() {
        return sequences.get(index++);
    }
}
