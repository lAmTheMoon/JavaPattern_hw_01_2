package hw_01_2;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        return source.stream().filter(n -> n >= this.treshold)
                .collect(Collectors.toList());
    }
}
