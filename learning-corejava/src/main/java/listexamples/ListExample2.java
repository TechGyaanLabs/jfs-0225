package listexamples;

import java.util.ArrayList;
import java.util.List;

public class ListExample2 {

    public static void main(String[] args) {

        List<String> names1 = new ArrayList<>();
        names1.add("Krish");
        names1.add("Raj");
        names1.add("Anil");
        names1.add("Raj");

        List<String> names2 = new ArrayList<>();
        names2.add("Nimmmi");
        names2.add("Haadhya");
        names2.add("Dhatri");

        List<String> names3 = new ArrayList<>();
        names3.add("Krish");
        names3.add("Haadhya");

        List<String> allNames = new ArrayList<>();
        allNames.addAll(names1);
        allNames.addAll(names2);
        System.out.println(allNames);

        // Check names3 all elements present in allNames, if all elements present
        // show message as yes otherwise no

        boolean allNamesExists = allNames.containsAll(names3);
        System.out.println(allNamesExists? "Yes" : "No");


    }
}
