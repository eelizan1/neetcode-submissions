class Twitter {
    private int count; 
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count = 0; 
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = tweetMap.get(userId); 
        if (tweets == null) {
            tweets = new ArrayList<>(); 
            tweetMap.put(userId, tweets); 
        }

        // increment count since we added a tweet 
        tweets.add(new int[] {count++, tweetId}); 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> allTweets = new ArrayList<>();

        List<int[]> ownTweets = tweetMap.get(userId);
        if (ownTweets != null) {
            allTweets.addAll(ownTweets);
        }

        Set<Integer> followees = followMap.get(userId);
        if (followees != null) {
            for (int followeeId : followees) {
                if (followeeId == userId) continue; // already added above
                List<int[]> followeeTweets = tweetMap.get(followeeId);
                if (followeeTweets != null) {
                    allTweets.addAll(followeeTweets);
                }
            }
        }

        allTweets.sort((a, b) -> b[0] - a[0]);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i)[1]);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.get(followerId); 
        if (followees == null) {
            followees = new HashSet<>(); 
            followMap.put(followerId, followees); 
        }

        followees.add(followeeId); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.get(followerId); 
        if (followees != null) {
            followees.remove(followeeId); 
        }
    }
}
