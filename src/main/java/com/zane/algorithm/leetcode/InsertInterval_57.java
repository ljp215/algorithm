package main.com.zane.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Created by jinpiluo on 3/25/16.
 */
public class InsertInterval_57 {
    public static class Interval {
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

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // find the new start and end
        for (int i = 0; i < intervals.size(); i++) {
            Interval element = intervals.get(i);

            if (isContains(element, newInterval.start)) {
                newInterval.start = element.start;
            }

            if (isContains(element, newInterval.end)) {
                newInterval.end = element.end;
            }

            if (element.start > newInterval.end) {
                break;
            }
        }


        // remove duplicated element
        int insertIndex = 0;
        Iterator<Interval> it = intervals.iterator();
        while (it.hasNext()) {
            Interval element = it.next();

            if (isBeContained(element, newInterval)) {
                it.remove();
            } else if (newInterval.start > element.end) {
                insertIndex++;
            } else if (newInterval.end < element.start) {
                break;
            }
        }

        intervals.add(insertIndex, newInterval);

        return intervals;
    }

    private boolean isContains(Interval interval, int i) {
        return i >= interval.start && i <= interval.end;
    }

    private boolean isBeContained(Interval interval, Interval newInterval) {
        return newInterval.start <= interval.start && newInterval.end >= interval.end;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(6, 9);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);

        Interval newInterval = new Interval(2, 5);

        InsertInterval_57 insertInterval = new InsertInterval_57();
        insertInterval.insert(intervals, newInterval);

        intervals.forEach(System.out::print);
    }
}
