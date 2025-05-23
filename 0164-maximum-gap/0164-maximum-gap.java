class Solution {
    public int maximumGap(int[] nums) {
        /*int gap = Integer.MIN_VALUE;
        if(nums.length<2) return 0;
        int max = nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++){
            max = Math.max(max,nums[i]);
        }

        int[] bucket = new int[max+1];
        for(int i = 0;i<n;i++){
            bucket[nums[i]]++;
        }
        int index = 0;
        for(int i = 0;i<=max;i++){
            for(int k = 0;k<bucket[i];k++){
                nums[index++] = i;
            }
        }

        for(int i = 1;i<n;i++){
            gap = Math.max(gap,nums[i]-nums[i-1]);
        }
        System.out.println(gap);
        return gap;
        if(nums.length<2) return 0;
        int maxGap = 0;
        int low = Integer.MAX_VALUE,high = 0,n=nums.length;
        List<List<Integer>> bucket = new ArrayList<>();
        for(int num : nums){
            low = Math.min(low,num);
            high = Math.max(high,num);
        }
        int bSize = Math.max((high-low)/(n-1),1);
        for(int key = (high-low)/bSize;key>=0;key--){
            bucket.add(new ArrayList<>());
        }
        for(int num : nums){
            bucket.get((num-low)/bSize).add(num);
        }

        int currHigh = 0;
        for(List<Integer> li : bucket){
            if(li.isEmpty()) continue;
            int prevHigh = currHigh>0?currHigh:li.get(0);
            int currlow = li.get(0);
            for(int num : li){
                currHigh = Math.max(currHigh,num);
                currlow = Math.min(currlow,num);
            }

            maxGap = Math.max(maxGap,currlow-prevHigh);
        }
        return maxGap;*/
        int arrLen = nums.length;
        if(arrLen<2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n : nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        if(min == max) return 0; // No diff
        int bSize = (int) Math.ceil((double) (max-min)/(arrLen-1));
        int bCount = ((max-min)/bSize)+1;
        int[]minBucket = new int[bCount]; //storing min to max
        int[]maxBucket = new int[bCount]; // storing max to min;

        for(int i = 0;i<bCount;i++){
            minBucket[i] = Integer.MAX_VALUE;
            maxBucket[i] = Integer.MIN_VALUE;
        }

        for(int n : nums){
            int index = (n-min)/bSize;
            minBucket[index] = Math.min(n,minBucket[index]);
            maxBucket[index] = Math.max(n,maxBucket[index]);
        }

        int maxGap = 0;
        int prevHigh = max;

        for(int i = 0;i<bCount;i++){
            if(minBucket[i]!=Integer.MAX_VALUE){
                maxGap = Math.max(maxGap,minBucket[i]-prevHigh);
                prevHigh = maxBucket[i];
            }
        }

        return maxGap;

    }
}