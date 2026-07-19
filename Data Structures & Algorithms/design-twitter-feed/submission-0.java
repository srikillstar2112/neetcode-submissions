class Twitter {
    private int timestamp=0;
    private class User{
        int user_id;
        Set<Integer> followed;
        Tweet tweethead;
        public User(int id){
            this.user_id=id;
            followed=new HashSet<>();
            follow(id);
            tweethead=null;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            if(this.user_id!=id){
                followed.remove(id);
            }
        }
        public void post(int id){
            Tweet newt=new Tweet(id);
            newt.next=tweethead;
            tweethead=newt;
        }
    }
    private class Tweet{
        int tweet_id;
        int time;
        Tweet next;
        public Tweet(int id){
            this.tweet_id=id;
            time=timestamp++;
            next=null;
        }
    }
    Map<Integer,User> usermap;

    public Twitter() {
        usermap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!usermap.containsKey(userId)){
            User newuser=new User(userId);
            usermap.put(userId,newuser);
        }
        usermap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news=new LinkedList<>();
        if(!usermap.containsKey(userId)){
            return news;
        }
        Set<Integer> followers=usermap.get(userId).followed;
        PriorityQueue<Tweet> pq=new PriorityQueue<>(followers.size(),(a,b)->b.time-a.time);
        for(int i:followers){
            Tweet tweet=usermap.get(i).tweethead;
            if(tweet!=null) pq.offer(tweet);
        }
        int c=0;
        while(!pq.isEmpty() && c<10){
            Tweet tweet=pq.poll();
            news.add(tweet.tweet_id);
            c++;
            if(tweet.next!=null){
                pq.offer(tweet.next);
            }
        }
        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId)){
            User newuser=new User(followerId);
            usermap.put(followerId,newuser);
        }
        if(!usermap.containsKey(followeeId)){
            User newuser=new User(followeeId);
            usermap.put(followeeId,newuser);
        }
        usermap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(usermap.containsKey(followerId) && followerId!=followeeId ){
            usermap.get(followerId).unfollow(followeeId);
        }
    }
}
