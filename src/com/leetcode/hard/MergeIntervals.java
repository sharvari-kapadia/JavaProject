package com.leetcode.hard;

import java.util.*;

/**
 * Created by SKapadia on 9/22/2016.
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0; end = 0;
        }
        Interval(int s, int e) {
            start = s; end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        if(intervals.size() == 0) {
            return new ArrayList<>();
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval i1;
        Interval i2;
        List<Interval> resultList = new ArrayList<>();
        i1 = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            i2 = intervals.get(i);
            if(this.overlaps(i1, i2)) {
                i1 = mergedInterval(i1, i2);
            } else {
                resultList.add(i1);
                i1 = intervals.get(i);
            }
        }
        resultList.add(i1);
        return resultList;
    }

    private boolean overlaps(Interval i1, Interval i2) {
        if(i1 == null || i2 == null) {
            return false;
        }
        return (i2.start >= i1.start) && (i2.start <= i1.end);
    }

    private Interval mergedInterval(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }

    public void printInterval(Interval i) {
        System.out.println("[" + i.start + ", " + i.end + "]");
    }

    public void printIntervalList(List<Interval> intervals) {
        for(int i = 0; i < intervals.size(); i++) {
            printInterval(intervals.get(i));
        }
    }

    public static void main(String[] args) {

        MergeIntervals object = new MergeIntervals();

        //[[2,3],[5,5],[2,2],[3,4],[3,4]] => [[2,4],[5,5]]
        List<Interval> intervals1 = new ArrayList<>(Arrays.asList(object.new Interval(2, 3),
                                                                        object.new Interval(5, 5),
                                                                        object.new Interval(2, 2),
                                                                        object.new Interval(3, 4),
                                                                        object.new Interval(3, 4)));
        object.printIntervalList(object.merge(intervals1));

        System.out.println("------------");

        //[1,3],[2,6],[8,10],[15,18] => [1,6],[8,10],[15,18]
        List<Interval> intervals2 = new ArrayList<>(Arrays.asList(object.new Interval(1, 3),
                                                                        object.new Interval(2, 6),
                                                                        object.new Interval(8, 10),
                                                                        object.new Interval(15, 18)));
        object.printIntervalList(object.merge(intervals2));
    }
}
