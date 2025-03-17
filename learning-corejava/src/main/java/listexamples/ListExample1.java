package listexamples;


import java.util.ArrayList;
import java.util.List;

public class ListExample1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Using for each");
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println("Print list elements in reverse order");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
        list.remove(1);
        list.remove(Integer.valueOf(30));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains(10));
    }
}
