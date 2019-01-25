package AlgorithmTest;

import java.util.*;

/*

“今年暑假不AC？”“是的。”“那你干什么呢？”“看世界杯呀，笨蛋！”“@#$%^&*%...”确实如此，世界杯来了，球迷的节日也来了，估计很多ACMer也会抛开电脑，奔向电视作为球迷，一定想看尽量多的完整的比赛，当然，作为新时代的好青年，你一定还会看一些其它的节目，比如新闻联播（永远不要忘记关心国家大事）、非常6+7、超级女生，以及王小丫的《开心辞典》等等，
假设你已经知道了所有你喜欢看的电视节目的转播时间表，你会合理安排吗？（目标是能看尽量多的完整节目）
*   贪心法：涉及一种排序，就是优先
*
* */
class Time{
    int start;
    int end;
    Time(int end,int start){
        this.end=end;
        this.start=start;
    }
}
public class MaxSumVnum {
    public static void main(String[] args) {
        new MaxSumVnum().MaxSum(
                new int[][]{
                        {1,3},
                        {3,4},
                        {0,7},
                        {3,8},
                        {15,19},
                        {15,20},
                        {10,15},
                        {8,18},
                        {6,12},
                        {5,10},
                        {4,14},
                        {2,9}
                }
        );
    }
    public void MaxSum(int[][] times){
        List<Time> list=new ArrayList<>();
        for (int i = 0; i <times.length ; i++) {
            list.add(new Time(times[i][1],times[i][0]));
        }
        int result=0;
        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.start-o2.start==0){
                    return (o1.end-o1.start)-(o2.end-o2.start);
                }else{
                    return o1.start-o2.start;
                }

            }
        });

    }
}
