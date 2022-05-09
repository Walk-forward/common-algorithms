package com.github.algorithms.algorithm.greedy;

import com.github.algorithms.structure.array.ArrayList;
import com.github.algorithms.structure.array.ListArrays;
import com.github.algorithms.structure.queue.Queue;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

class GreedyTest {

    Logger logger = LoggerFactory.getLogger(GreedyTest.class);

    @Test
    void classroomSchedule() {
        Greedy.Classroom art = new Greedy.Classroom("美术",
                LocalTime.of(9, 0), LocalTime.of(10, 0));
        Greedy.Classroom english = new Greedy.Classroom("英语",
                LocalTime.of(9, 30), LocalTime.of(10, 30));
        Greedy.Classroom math = new Greedy.Classroom("数学",
                LocalTime.of(10, 0), LocalTime.of(11, 0));
        Greedy.Classroom computer = new Greedy.Classroom("计算机",
                LocalTime.of(10, 30), LocalTime.of(11, 30));
        Greedy.Classroom music = new Greedy.Classroom("音乐",
                LocalTime.of(11, 0), LocalTime.of(12, 0));

        ArrayList<Greedy.Classroom> classroomArrayList = new ArrayList<>();
        classroomArrayList.add(art);
        classroomArrayList.add(computer);
        classroomArrayList.add(music);
        classroomArrayList.add(english);
        classroomArrayList.add(math);

        Queue<Greedy.Classroom> queue = Greedy.classroomSchedule(classroomArrayList);

        logger.debug("调度完成 {}", queue);
    }

    @Test
    void classroomCompareTo() {
        Greedy.Classroom art = new Greedy.Classroom("美术",
                LocalTime.of(9, 0), LocalTime.of(10, 0));
        Greedy.Classroom english = new Greedy.Classroom("英语",
                LocalTime.of(9, 30), LocalTime.of(10, 30));
        Greedy.Classroom math = new Greedy.Classroom("数学",
                LocalTime.of(10, 0), LocalTime.of(11, 0));
        Greedy.Classroom computer = new Greedy.Classroom("计算机",
                LocalTime.of(10, 30), LocalTime.of(11, 30));
        Greedy.Classroom music = new Greedy.Classroom("音乐",
                LocalTime.of(11, 0), LocalTime.of(12, 0));

        int n = art.compareTo(english);
        logger.debug("{}", n);

        ArrayList<Greedy.Classroom> classroomArrayList = new ArrayList<>();
        classroomArrayList.add(art);
        classroomArrayList.add(computer);
        classroomArrayList.add(music);
        classroomArrayList.add(english);
        classroomArrayList.add(math);

        ArrayList<Greedy.Classroom> quickSort = ListArrays.quickSort(classroomArrayList);
        logger.debug("排序后 {}", quickSort);
    }

}