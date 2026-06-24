class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            map.get(req[0]).add(req[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) {
            return true;
        }
        visited.add(course);
        for (int preReq : map.get(course)) {
            if (!dfs(preReq)) {
                return false;
            }
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
