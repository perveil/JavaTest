package leetcode;

import java.util.*;

class Twitter {
    static class tweet implements Comparable<tweet>{
        int userid; //谁发的tweet
        int tweetid; //发了什么tweet
        int time;
        tweet(int userid,int tweetid,int time){
            this.userid=userid;
            this.tweetid=tweetid;
            this.time=time;
        }
        @Override
        public int compareTo(tweet o) { //依据从大到小的排列
             return this.time-o.time;
        }

        @Override
        public int hashCode() {
            return time;
        }
    }
    public Map<Integer,ArrayList<Integer>> followmap;   //被关注者和关注者的映射
    public Map<Integer,ArrayList<tweet>> twittermap;  //用户与推特的映射
    int totaltime=0; //全局时间：表示每一个tweet的发送时间
    public Twitter() {
        followmap=new HashMap();
        twittermap=new HashMap();
    }

    public void postTweet(int userId, int tweetId) {
        if (!twittermap.containsKey(userId)){     //员工不存在
            twittermap.put(userId,new ArrayList<tweet>());
        }
        tweet newtw=new tweet(userId,tweetId,++totaltime); //新建tw
        twittermap.get(userId).add(newtw); //首先在自己的推特列表中插入
        if (!followmap.containsKey(userId)){ //此时没有人关注他
            followmap.put(userId,new ArrayList<>());
        }else { //有人关注他,则遍历其的关注者，向关注者们添加推特
            for (Integer i:
                 followmap.get(userId)) {
                if (twittermap.containsKey(i)){ //此时如果关注着都已存在
                    twittermap.get(i).add(newtw);
                }
            }
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user
     * followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        if (!twittermap.containsKey(userId)){
            return res;
        }
        int cursize=twittermap.get(userId).size();
        Collections.sort(twittermap.get(userId));  //依据time从大到小排序
        for (int i = cursize-1; i >=cursize-10 &&i>-1 ; i--) {
            res.add(twittermap.get(userId).get(i).tweetid);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId==followerId) return;
        if (!followmap.containsKey(followeeId)) followmap.put(followeeId,new ArrayList<>());
        if (!followmap.containsKey(followerId)) followmap.put(followerId,new ArrayList<>());
        if (!twittermap.containsKey(followeeId)) twittermap.put(followeeId,new ArrayList<tweet>());
        if (!twittermap.containsKey(followerId)) twittermap.put(followerId,new ArrayList<tweet>());
        if (!followmap.get(followeeId).contains(followerId)) followmap.get(followeeId).add(followerId);
        else  return; //有的话就不需要添加
        //跟随之后需要将followee的tweet 添加到follower的链表
        List<tweet> followee_tweetlist=twittermap.get(followeeId);
        for (int i=0;i<followee_tweetlist.size();i++) {
            tweet t_followee=followee_tweetlist.get(i);
            twittermap.get(followerId).add(t_followee);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {   //不flollow 则就意味着要删除follower中所有followee 发的推特
        if (followeeId==followerId) return;
        if (!followmap.containsKey(followeeId)){ //意外情况
            return;
        }
        if (followmap.get(followeeId).contains(followerId)){
            int index=followmap.get(followeeId).indexOf(followerId);
            followmap.get(followeeId).remove(index);
        }
        List<tweet> follower_tweetlist=twittermap.get(followerId); //删除followerId中为followeeId的tw
        for (int i=0;i<follower_tweetlist.size();i++) {
            tweet t=follower_tweetlist.get(i);
            if (t.userid==followeeId){ //被关注者的tweet
                twittermap.get(followerId).remove(t); // 删除
            }
        }
    }
}
public class leetcode355_设计推特 {
    public static void main(String[] args) {
        Twitter t=new Twitter();
        t.postTweet(1,1);
        t.follow(2,1);
        t.unfollow(2,1);
        List<Integer> list=t.getNewsFeed(2);
        System.out.println("w");
    }

}
