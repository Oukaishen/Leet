package algorithm;

import java.util.*;
/**
 * This problem is very fuck. Do it Later.行·
 * */
public class Leet355 {
    public static void main(String[] args){

    }

}

class Twitter {

    private  HashMap<Integer, List<Integer>> twitterTweetMap;
    private  HashMap<Integer, Set<Integer>> reverseTwitterFollowMap;


    /** Initialize your data structure here. */
    public Twitter() {
        twitterTweetMap = new HashMap<>();
        reverseTwitterFollowMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> userTweetList = twitterTweetMap.getOrDefault(userId, new LinkedList<>());
        userTweetList.add(0,tweetId);
        twitterTweetMap.put(userId, userTweetList);
        for(int followerId : reverseTwitterFollowMap.getOrDefault(userId, new HashSet<>())){
            List<Integer> followeeTweetList = twitterTweetMap.getOrDefault(followerId, new LinkedList<>());
            followeeTweetList.add(0,tweetId);
            twitterTweetMap.put(followerId, followeeTweetList);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tmp =  twitterTweetMap.getOrDefault(userId, new LinkedList<>());
        return tmp.size() <= 10 ? tmp : tmp.subList(0,10);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeSet = reverseTwitterFollowMap.getOrDefault(followeeId, new HashSet<>());
        followeeSet.add(followeeId);
        reverseTwitterFollowMap.put(followeeId, followeeSet);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followerSet = reverseTwitterFollowMap.get(followeeId);
        List<Integer> tweetList = twitterTweetMap.get(followeeId);
        List<Integer> followerTweetList = twitterTweetMap.get(followerId);
        if (followerSet == null || followerSet.isEmpty()){
            return;
        }
        else {
            followerSet.remove(followerId);
        }
        if(tweetList == null || tweetList.isEmpty()){
            return;
        }
        for(int tweetId : tweetList){
            followerTweetList.remove(new Integer(tweetId));
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */