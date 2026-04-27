class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1,  res = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while(l <= r) {
            int k = (l + r) / 2;
            long timeTaken = 0;
            for(int pile: piles) {
                timeTaken += Math.ceil((double) pile / k);
            }
            if(timeTaken <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
        
    }
}
