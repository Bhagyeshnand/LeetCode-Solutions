class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int n : nums) pq.offer(n);

        long score = 0;

        while( k > 0){
            int big = pq.poll();
            score += big;
            int update = (int)Math.ceil(big/3.0);

            pq.add(update);
            k--;
        }
        return score;
    }
}