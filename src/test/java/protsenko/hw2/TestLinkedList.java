package protsenko.hw2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestLinkedList {

    private static MyList<Object> mist = new LinkedListTwo<>();

    @BeforeEach
    void setup() {
        mist.add("first");
        mist.add("second");
        mist.add("three");

    }

    @Test
    @DisplayName("Should to show elements from LinkedList by index")
    void getElementsAfterAdded() {
        //given
        String expectedString = "first";
        String expectedStringSecond = "second";
        String expectedStringThree = "three";
        //then
        assertEquals(expectedString, mist.get(0));
        assertEquals(expectedStringSecond, mist.get(1));
        assertEquals(expectedStringThree, mist.get(2));
    }

    @Test
    @DisplayName("Should to search and found element by name")
    void testCheckForContainsMethod() {

        //then
        assertTrue(mist.contains("first"));
        assertTrue(mist.contains("second"));
        assertTrue(mist.contains("three"));

    }

    @Test
    @DisplayName("Should to remove element by index and after checking result")
    void testCheckRemoveElement(){
        //given
        mist.remove(1);
        int expectedSize = 2;
        //then
        assertEquals(expectedSize, mist.size());
    }


}