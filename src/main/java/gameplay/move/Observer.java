package gameplay.move;

public interface Observer<T> {

    //method to update the observer, used by subject
    void update(T cos);


}
