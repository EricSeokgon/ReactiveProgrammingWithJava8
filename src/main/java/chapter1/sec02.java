package chapter1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class sec02 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            // Prints elements (4)
            System.out.println(iterator.next());
        }
    }
}
