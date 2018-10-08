package AlgorithmTest;

import java.util.ArrayList;
import java.util.List;
/*
* 给出一个区间的集合，请合并所有重叠的区间。
* 输入: [[1,3],[2,6],[8,10],[15,18]]
* 输出: [[1,6],[8,10],[15,18]]
* 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
* */

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return  start+","+end;
    }
}
public class ScaleTest {
    public static void main(String[] args) {
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,1));
        intervals.add(new Interval(1,1));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
        merg(intervals);
    }
    public static  List<Interval> merg(List<Interval> intervals){
        List<Interval> result=new ArrayList<>();
        if( intervals.get(0).end<intervals.get(1).end&&intervals.get(0).end>intervals.get(1).start){
            result.add(new Interval( intervals.get(0).start,intervals.get(1).end));
        }else  if(intervals.get(0).end==intervals.get(1).end&&intervals.get(0).end==intervals.get(1).start){
            result.add(intervals.get(0));
        }else{
            result.add(intervals.get(0));
            result.add(intervals.get(1));
        }
        for(int i=2;i<intervals.size();i++) {
            if (result.size() == 0) {
                if (intervals.get(0).end < intervals.get(1).end && intervals.get(0).end > intervals.get(1).start) {
                    result.add(new Interval(intervals.get(0).start, intervals.get(1).end));
                } else {
                    result.add(intervals.get(0));
                    result.add(intervals.get(1));
                }
            } else {
                if (intervals.get(i).end < result.get(result.size() - 1).end && intervals.get(i).end > result.get(result.size() - 1).start) {
                    result.add(new Interval(result.get(result.size() - 1).start, intervals.get(i).end));
                    result.remove(result.size() - 2);//移除之前末尾
                }else{
                    result.add(intervals.get(i));
                }

            }
        }
        System.out.println(result);
        return result;


    }
}
