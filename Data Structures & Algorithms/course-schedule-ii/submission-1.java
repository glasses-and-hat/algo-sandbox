class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] state; // 0 = unvisited, 1 = visiting, 2 = visited
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            graph.get(req[1]).add(req[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(i)) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = res.get(numCourses - 1 - i);
        }
        return order;
    }

    private boolean dfs(int course) {
        if (state[course] == 1)
            return false; // cycle
        if (state[course] == 2)
            return true; // already checked

        state[course] = 1;

        for (int next : graph.get(course)) {
            if (!dfs(next)) {
                return false;
            }
        }
        res.add(course);
        state[course] = 2;
        return true;
    }
}
