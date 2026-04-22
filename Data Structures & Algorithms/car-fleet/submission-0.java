class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleet = 0;
        double prevTime = 0;
        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];
            if (time > prevTime) {
                fleet++;
                prevTime = time;
            }
        }
        return fleet;
    }
}
