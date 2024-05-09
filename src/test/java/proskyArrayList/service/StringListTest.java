package proskyArrayList.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proskyArrayList.exception.InvalidIndexException;
import proskyArrayList.exception.NullItemException;
import proskyArrayList.exception.StorageIsFullException;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {

    private final StringList list = new StringListImpl(11);

    @BeforeEach
    public void setUp() {
        list.add("один");
        list.add("два");
        list.add("три");
        list.add("четыре");
        list.add("пять");
        list.add("шесть");
        list.add("семь");
        list.add("восемь");
        list.add("девять");
        list.add("десять");

    }

    @Test
    public void addTest() {
        assertEquals(10, list.size());
    }

    @Test
    public void StorageIsFullExceptionTest() {
        list.add("Test");

        assertThrows(StorageIsFullException.class, () -> list.add("одинадцать"));

    }

    @Test
    public void addIndexTest() {
        list.add(3, "Проверка");

        Assertions.assertEquals("Проверка", list.get(3));
        Assertions.assertEquals("десять", list.get(10));

    }

    @Test
    public void setTest() {

        list.set(4, "Проверка");
        Assertions.assertEquals("Проверка", list.get(4));

    }

    @Test
    public void removeItemTest() {

        list.remove("один");

        Assertions.assertEquals(9, list.size());
        Assertions.assertEquals("два", list.get(0));
    }

    @Test
    public void removeIndexTest() {

        list.remove(0);

        Assertions.assertEquals(9, list.size());
        Assertions.assertEquals("два", list.get(0));
    }

    @Test
    public void containsTest() {

        Assertions.assertTrue(list.contains("один"));
        Assertions.assertTrue(list.contains("два"));
        Assertions.assertTrue(list.contains("семь"));

    }

    @Test
    public void indexOfTest() {

        Assertions.assertEquals(0, list.indexOf("один"));
        Assertions.assertEquals(-1, list.indexOf("тест"));
    }

    @Test
    public void lastIndexOfTest() {

        Assertions.assertEquals(0, list.indexOf("один"));
        Assertions.assertEquals(-1, list.indexOf("тест"));
    }

    @Test
    public void getTest() {

        Assertions.assertEquals("один", list.get(0));
        Assertions.assertEquals("два", list.get(1));
        Assertions.assertEquals("десять", list.get(9));
    }

    @Test
    public void equalsTest() {
        StringList testList = new StringListImpl(11);
        testList.add("один");
        testList.add("два");
        testList.add("три");
        testList.add("четыре");
        testList.add("пять");
        testList.add("шесть");
        testList.add("семь");
        testList.add("восемь");
        testList.add("девять");
        testList.add("десять");

        assertTrue(list.equals(testList));

    }

    @Test
    public void sizeTest() {

        assertEquals(10, list.size());
    }

    @Test
    public void isEmptyTest() {

        StringList testList = new StringListImpl(11);

        assertFalse(list.isEmpty());
        assertTrue(testList.isEmpty());
    }

    @Test
    public void clearTest() {

        list.clear();

        assertTrue(list.isEmpty());

    }

    @Test
    public void toArrayTest() {

        String[] testList = list.toArray();

        assertEquals("один",testList[0]);
        assertEquals(10, testList.length);

    }

    @Test
    public void InvalidIndexExceptionTest() {

        assertThrows(InvalidIndexException.class, () -> list.get(20));
    }

    @Test
    public void NullItemExceptionTest() {

        assertThrows(NullItemException.class, () -> list.add(null));

    }

}
