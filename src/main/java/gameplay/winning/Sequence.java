package gameplay.winning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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
        return index < sequences.size();
    }

    @Override
    public String next() {
        if (index >= sequences.size()) throw new NoSuchElementException();
        return sequences.get(index++);
    }
}
