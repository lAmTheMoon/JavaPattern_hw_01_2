package hw_01_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class FilterTest {

    @Test
    void filterOut() {
        int treshold = 15;
        List<Integer> list = List.of(1, 2, 3, 4, 6, 8, 10, 15, 16, 30, 50);
        Filter filter = new Filter(treshold);
        List<Integer> actual = filter.filterOut(list);
        List<Integer> expected = list.stream().filter(n -> n >= treshold)
                .collect(Collectors.toList());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void filterOutRandomList() {
        int listLength = 50;
        int minValue = 0;
        int maxValue = 100;
        int treshold = 30;
        List<Integer> list = new Random().ints(listLength, minValue, maxValue)
                .boxed().collect(Collectors.toList());
        Filter filter = new Filter(treshold);
        List<Integer> actual = filter.filterOut(list);
        List<Integer> expected = list.stream().filter(n -> n >= treshold)
                .collect(Collectors.toList());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void filterOutEmptyList() {
        int listLength = 50;
        int minValue = 0;
        int maxValue = 90;
        int treshold = 100;
        List<Integer> list = new Random().ints(listLength, minValue, maxValue)
                .boxed().collect(Collectors.toList());
        Filter filter = new Filter(treshold);
        List<Integer> actual = filter.filterOut(list);
        Assertions.assertTrue(actual.isEmpty());
    }
}