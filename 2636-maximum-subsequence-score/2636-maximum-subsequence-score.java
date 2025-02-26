class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int max = 0;
        for (int num : nums2) {
            max = Math.max(num, max);
        }
        List<Integer>[] countsNums2 = new ArrayList[max + 1];
        max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (countsNums2[nums2[i]] == null)
                countsNums2[nums2[i]] = new ArrayList<>();
            countsNums2[nums2[i]].add(nums1[i]);
            max = Math.max(nums1[i], max);
        }
        long sum = 0;
        int[] countsNums1 = new int[max + 1];
        int min = max;
        int idx = countsNums2.length - 1;
        long res = 0;
        while (idx >= 0) {
            if (countsNums2[idx] != null) {
                for (int num : countsNums2[idx]) {
                    if (k == 1) {
                        sum += num;
                        countsNums1[num]++;
                        min = Math.min(num, min);
                        k--;
                        res = Math.max(sum * idx, res);
                    } else if (k <= 0) {
                        if (min < num) {
                            sum += num - min;
                            countsNums1[num]++;
                            countsNums1[min]--;
                            while (countsNums1[min] == 0) {
                                min++;
                            }
                            res = Math.max(sum * idx, res);
                        }
                    } else {
                        sum += num;
                        countsNums1[num]++;
                        min = Math.min(num, min);
                        k--;
                    }
                }
            }
            idx--;
        }
        return res;
    }
}


/* 
   [
    0: [],
    1: [3],
    2: [1],
    3: [3],
    4: [2],
   ] 



   [
    0: 0,
    1: 1.
    2: 1,
    3: 2,
    4: 0
   ]


   sum = 2 -> 5 -> 6
*/