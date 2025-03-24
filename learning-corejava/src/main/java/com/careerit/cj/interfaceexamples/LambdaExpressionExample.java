package com.careerit.cj.interfaceexamples;

import java.util.function.BinaryOperator;

interface Operation {
    int perform(int a, int b);
}

interface MyPredicate{
    boolean test(int num);
}


class PerformAction {

    public int caculate(Operation operation, int num1, int numm) {
        return operation.perform(num1, numm);
    }

}

public class LambdaExpressionExample {

    public static void main(String[] args) {

        PerformAction performAction = new PerformAction();
        Operation ope = (num1, num2)-> num1 * num2;
        int result = performAction.caculate(ope, 20, 30);
        System.out.println(result);

        MyPredicate predicate = num -> num % 2 == 0;

        BinaryOperator<Integer> obj = (num1, num2) -> num1 + num2;
        System.out.println(obj.apply(10,20));

    }
}
