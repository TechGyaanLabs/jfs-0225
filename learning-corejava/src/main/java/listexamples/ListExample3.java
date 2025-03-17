package listexamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListExample3 {

    public static void main(String[] args) {

        // Question bank has {250} question, pick randomly 50 unique question from the question bank.

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 250; i++) {
            list.add(i);
        }
        List<Integer> randomQuestionsList = new ArrayList<>();
        while (randomQuestionsList.size() != 50) {
            //int randomIndex = ThreadLocalRandom.current().nextInt(1, list.size() + 1);
            int randomIndex = (int) (Math.random() * list.size());
            int question = list.get(randomIndex);
            if (!randomQuestionsList.contains(question)) {
                randomQuestionsList.add(question);
            }
        }
        System.out.println(randomQuestionsList);
    }
}
