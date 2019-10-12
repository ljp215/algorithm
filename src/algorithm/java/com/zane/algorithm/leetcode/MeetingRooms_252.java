package com.zane.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],
 * ...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * <p>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 18:38
 */
public class MeetingRooms_252 {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        List<Interval> intervalList = Arrays.asList(intervals);

        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        int preEnd = 0;
        for (Interval interval : intervalList) {
            if (interval.start < preEnd) {
                return false;
            } else {
                preEnd = interval.end;
            }
        }

        return true;
    }
}
