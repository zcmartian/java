package com.mars.stack;

import java.util.Random;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class StackTest {

    ArrayStack<Integer> arrayStack;
    LinkedListStack<Integer> linkedListStack;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Before
    public void init() {
        arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
    }

    @Test
    public void testPush() {
        Assert.assertEquals("Stack: [0, 1, 2, 3, 4] top", arrayStack.toString());
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (c == '}'  && top != '{')
                        return false;
                    if (c == ']'  && top != '[')
                        return false;
                    if (c == ')'  && top != '(')
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void testIsValid() {
        Assert.assertTrue(isValid("{{[[(())]]}}"));
        Assert.assertTrue(isValid("{}"));
        Assert.assertTrue(isValid("[]"));
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void testLinkedListStack() {
        linkedListStack = new LinkedListStack<>();
        for (int i=0;i<5;i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        linkedListStack.pop();
        System.out.println(linkedListStack);

        Assert.assertEquals("Stack: top 0->NULL\n" +
                "Stack: top 1->0->NULL\n" +
                "Stack: top 2->1->0->NULL\n" +
                "Stack: top 3->2->1->0->NULL\n" +
                "Stack: top 4->3->2->1->0->NULL\n" +
                "Stack: top 3->2->1->0->NULL\n", log.getLog());
    }

    private double testStack(com.mars.stack.Stack<Integer> stack, int optCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < optCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < optCount; i++)
            stack.pop();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }

    @Test
    public void testPerformance() {
        int optCount = 100_000;

        com.mars.stack.Stack<Integer> arrayStack = new com.mars.stack.ArrayStack<>();
        double time1 = testStack(arrayStack, optCount);
        System.out.println("ArrayStack, time: " + time1 + " s.");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, optCount);
        System.out.println("LinkedListStack, time: " + time2 + " s.");
        System.out.println(time1/time2);
    }
}
