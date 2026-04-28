class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        // Pair<Integer, String> pair = new Pair(timestamp, value);
        // list.add(pair);
        map.get(key).add(new Pair(timestamp, value));
        // map.set(key, list);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Pair<Integer, String>> list = map.get(key);

        int l = 0, r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Pair<Integer, String> pair = list.get(mid);

            if (pair.getKey() <= timestamp) {
                result = pair.getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
