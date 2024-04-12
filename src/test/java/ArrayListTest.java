import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.UUID;

public class ArrayListTest {

    ArrayListHome<Integer> integers = new ArrayListHome<Integer>();
    ArrayListHome<String> strings = new ArrayListHome<String>();
    ArrayListHome<Character> characters = new ArrayListHome<Character>();
    ArrayListHome<Double> doubles = new ArrayListHome<Double>();
    ArrayListHome<Integer> emptyList = new ArrayListHome<Integer>();

    @BeforeEach
    public void start(){
        Random random = new Random();
        for(int i = 0;i < 1000;i++){
            integers.add(random.nextInt());
            strings.add(UUID.randomUUID().toString());
            characters.add((char) (random.nextInt(26) + 'a'));
            doubles.add(random.nextDouble());
        }

    }

    @Test
    void sizeTest(){
        Assertions.assertEquals(1000,integers.size());
        Assertions.assertEquals(1000,strings.size());
        Assertions.assertEquals(1000,characters.size());
        Assertions.assertEquals(1000,doubles.size());
    }

    @Test
    void getTest(){
        for(int i = 0; i< 10000;i++){
            emptyList.add(i);
        }
        for(int i = 0;i<10000;i++){
            Assertions.assertEquals(i,emptyList.get(i));
        }
    }

    @Test
    void isEmptyTest(){
        Assertions.assertFalse(integers.isEmpty());
        Assertions.assertTrue(emptyList.isEmpty());
        Assertions.assertFalse(characters.isEmpty());
        Assertions.assertFalse(doubles.isEmpty());
    }
    @Test
    void containsTest(){
        emptyList.add(1);
        Assertions.assertTrue(emptyList.contains(1));
        Assertions.assertFalse(emptyList.contains(2));
    }
    @Test
    void addTest(){
        for(int i = 0; i<1000;i++){
            Assertions.assertTrue(emptyList.add(i));
        }
    }

    @Test
    void addIndexTest(){
        for(int i = 0 ; i<1000;i++){
            emptyList.add(i,i);
        }
        Assertions.assertEquals(1000,emptyList.size());
    }

    @Test
    void removeTest(){
        emptyList.add(5);
        Assertions.assertEquals(5,emptyList.remove(0));
        Assertions.assertEquals(0,emptyList.size());
    }

    @Test
    void sortTest(){
        strings.clear();
        strings.add("e");
        strings.add("b");
        strings.add("w");
        strings.add("a");
        strings.sort();
        Assertions.assertEquals("a",strings.get(0));
        Assertions.assertEquals("b",strings.get(1));
        Assertions.assertEquals("e",strings.get(2));
        Assertions.assertEquals("w",strings.get(3));


        for(int i = 10000;i>0;i--){
            emptyList.add(i);
        }
        emptyList.sort();
        for(int i = 0;i<10000;i++){
            Assertions.assertEquals(i+1,emptyList.get(i));
        }
    }

    @Test
    void comparatorSortTest(){
        Comparator doubleComparator = Comparator.naturalOrder();
        doubles.sort(doubleComparator);
        for(int i = 0;i<999;i++){
            Assertions.assertTrue(doubles.get(i) <= doubles.get(i+1));
        }
    }

    @Test
    void clearTest(){
        doubles.clear();
        strings.clear();
        integers.clear();
        characters.clear();

        Assertions.assertEquals(0, doubles.size());
        Assertions.assertEquals(0, integers.size());
        Assertions.assertEquals(0, characters.size());
        Assertions.assertEquals(0, strings.size());
    }
}
