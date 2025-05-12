package com.careerit.sd.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonNumberQuestionsTest {

    @Autowired
    private CommonNumberQuestions commonNumberQuestions;

    @BeforeAll
    public static void initAll(){
        System.out.println("Before all tests");
    }

    @AfterAll
    public static void destroyAll(){
        System.out.println("After all tests");
    }

    @BeforeEach
    public void init(){
        System.out.println("Test started");
    }

    @AfterEach
    public void destroy(){
        System.out.println("Test completed");
    }

    @Test
    @DisplayName("Test for biggest of 3 number")
    public void testBiggest(){
        int a = -10;
        int b = -20;
        int c = -30;
        int expected = -10;
        int actual = commonNumberQuestions.biggest(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for smallest of 3 number")
    public void testSmallest(){
        int a = -10;
        int b = -20;
        int c = -30;
        int expected = -30;
        int actual = commonNumberQuestions.smallest(a, b, c);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Test for factorial")
    public void testFactorial(){
        int n = 5;
        int expected = 120;
        int actual = commonNumberQuestions.factorial(n);
        Assertions.assertEquals(expected, actual);
    }



}