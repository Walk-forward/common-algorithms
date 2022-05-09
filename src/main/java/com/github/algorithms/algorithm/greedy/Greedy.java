package com.github.algorithms.algorithm.greedy;

import com.github.algorithms.structure.array.ArrayList;
import com.github.algorithms.structure.array.ListArrays;
import com.github.algorithms.structure.queue.Queue;

import java.time.LocalTime;

/**
 * 贪心算法
 */
public class Greedy {

    /**
     * 教室调度问题
     */
    public static Queue<Classroom> classroomSchedule(ArrayList<Classroom> list) {
        Queue<Classroom> queue = new Queue<>();
        list = ListArrays.quickSort(list);

        Classroom previous = null;
        for (Classroom classroom : list) {
            if (previous == null) {
                previous = classroom;
                queue.push(classroom);
            }else if (previous.endTime.compareTo(classroom.startTime) <= 0) {
                previous = classroom;
                queue.push(classroom);
            }
        }

        return queue;
    }

    /**
     * 课程时间
     */
    static class Classroom implements Comparable<Classroom> {
        private String name;
        private LocalTime startTime;
        private LocalTime endTime;

        public Classroom(String name, LocalTime startTime, LocalTime endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Classroom o) {
            return this.startTime.compareTo(o.startTime);
        }

        @Override
        public String toString() {
            return "Classroom{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
