class Twitter {

    private static int time = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = Twitter.time++;
        }
    }

    Map<Integer, Set<Integer>> following;
    Map<Integer, Tweet> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        following.putIfAbsent(userId, new HashSet<>());
        following.get(userId).add(userId);

        for (int followee : following.get(userId)) {
            if (tweets.containsKey(followee)) {
                pq.offer(tweets.get(followee));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet curr = pq.poll();
            res.add(curr.id);
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId) && followerId != followeeId) {
            following.get(followerId).remove(followeeId);
        }
    }
}