class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : nums){
            pq.add(i);
        }
        long ans = 0;
        while(k-- > 0){
            int n = pq.poll();
            ans += n;
            pq.offer((n + 2)/ 3);
        }
        return ans;
    }
}