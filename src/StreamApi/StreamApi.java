package StreamApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// filter() - фильтрация по предикату
// distinct() - возвращает stream без повторений
// collect(Collectors.ToList()) - стрим в лист

public class StreamApi {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(3);
            add(2);
        }};

        Stream<Integer> sumOdd = list.stream();

        Set<Integer> newL = sumOdd.collect(Collectors.toSet());
        System.out.println(newL);

    }
    boolean func(int i) {
        return i%2 == 0;
    }
}
