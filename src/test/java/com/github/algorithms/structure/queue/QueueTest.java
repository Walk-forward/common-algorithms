package com.github.algorithms.structure.queue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueTest {

    Logger logger = LoggerFactory.getLogger(QueueTest.class);

    @Test
    public void queuePushTest() {
        Queue<String> queue = new Queue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        printQueue(queue);
    }

    @Test
    public void queuePopTest() {
        Queue<String> queue = new Queue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        logger.debug("{}", queue.pop());
        logger.debug("{}", queue.pop());
        logger.debug("{}", queue.pop());
    }
    private void printQueue(Queue<?> queue) {
        queue.forEach(v -> logger.debug("队列 {}", v));
    }
}
