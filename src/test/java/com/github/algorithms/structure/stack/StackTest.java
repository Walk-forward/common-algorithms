package com.github.algorithms.structure.stack;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackTest {

    Logger logger = LoggerFactory.getLogger(StackTest.class);

    @Test
    public void stackPushPopTest() {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        try {
            logger.debug("出栈 {}", stack.pop());
            logger.debug("出栈 {}", stack.pop());
            logger.debug("出栈 {}", stack.pop());
            logger.debug("出栈 {}", stack.pop());
        }catch (RuntimeException e) {
            logger.debug("{}", e.getMessage());
        }
    }
}
