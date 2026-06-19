class Twitter {
    private static int timestamp = 0;

    class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    Map<Integer, List<Tweet>> postMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        postMap.putIfAbsent(userId, new ArrayList<>());
        postMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add user's own tweets
        postMap.getOrDefault(userId, List.of()).forEach(maxHeap::offer);

        // Add followees' tweets
        followMap.getOrDefault(userId, Set.of())
            .stream()
            .flatMap(f -> postMap.getOrDefault(f, List.of()).stream())
            .forEach(maxHeap::offer);

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll().id);
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return; // prevent self-follow
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return; // prevent self-unfollow
        followMap.getOrDefault(followerId, Set.of()).remove(followeeId);
    }
}
