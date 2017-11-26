package gameplay.move;

import gameplay.signs.XSign;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MoveManagerTest {

    MoveManager ml;

    class SomeObserver implements Observer<Integer> {
        @Override
        public void update(Integer i) {
        }
    }

    @BeforeMethod
    public void setup() {
        ml = new MoveManager();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void whenNullObserverTryToRegister_trowsNullPointerException() {

        //given
        //when
        ml.register(null);
        //then
    }

    @Test
    public void addObserverToObservers() {

        //given
        Observer one = new SomeObserver();
        //when - //then
        assertEquals(ml.observers.size(), 0);
        ml.register(one);
        assertEquals(ml.observers.size(), 1);
    }

    @Test
    public void removeObserverFromObserversIfObserverIsOnTheList() {

        //given
        Observer one = new SomeObserver();
        Observer two = new SomeObserver();
        Observer three = new SomeObserver();
        ml.register(one);
        ml.register(two);
        ml.register(three);
        int size = ml.observers.size();
        //when
        ml.unregister(one);
        //then
        assertEquals(ml.observers.size(), size - 1);
    }

    @Test
    public void addingNewMoveToList_returnTrue() {

        //given
        Move move = new Move(1, new XSign());
        //when
        //then
        assertTrue(ml.makeMove(move));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void addingMoveToAlreadyOccupiedPosition_throwsException() {

        //given
        Move move = new Move(1, new XSign());
        ml.makeMove(move);
        Move move1 = new Move(1, new XSign());
        //when
        ml.makeMove(move1);
        //then
    }

}