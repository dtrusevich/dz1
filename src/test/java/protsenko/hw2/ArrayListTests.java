package protsenko.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import protsenko.hw1.MyListDemo;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTests {

    private static final MyListDemo<Object> listDemo = new MyListDemo<>();

    @BeforeEach
    void setup(){
        listDemo.add(new Object());
        listDemo.add(new Object());
        listDemo.add(new Object());
        listDemo.add(new Object());
    }

    @Test
    @DisplayName("Should to remove element by index")
    void testRemoveMethod(){
        //given
        int sizeOfElementsExpected = 3;
        listDemo.remove(1);
        //then
        assertEquals(sizeOfElementsExpected, listDemo.size());
    }

    @Test
    @DisplayName("Should to add element and after checking size")
    void testAddMethod(){
        //given
        int sizeOfElementsExpected = 5;
        listDemo.add(new Object());
        //then
        assertEquals(sizeOfElementsExpected, listDemo.size());
    }

}
