import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    void testQuickSort(){
        ArrayListHome<String> strings = new ArrayListHome<String>();
        ArrayListHome<Integer> integers = new ArrayListHome<Integer>();
        ArrayListHome<Character> chars = new ArrayListHome<Character>();

        for(int i = 1000;i >= 0;i--){
            integers.add(i);
            strings.add(String.valueOf(i));
            chars.add((char) (i + 'a'));
        }

        Assertions.assertTrue(QuickSort.quickSort(integers,0,integers.size()-1));
        Assertions.assertTrue(QuickSort.quickSort(strings,0,strings.size()-1));
        Assertions.assertTrue(QuickSort.quickSort(chars,0,chars.size()-1));
    }
}
