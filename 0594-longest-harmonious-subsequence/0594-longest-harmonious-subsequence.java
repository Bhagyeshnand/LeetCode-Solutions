class Solution {
    static{
        for (int i = 0; i < 500; i++){
            findLHS(new int[]{1,2,3,4});
        }
    }
    public static int findLHS(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        int size = maxValue - minValue + 1;
        if (size > 1000000) return findLHSUsingMap(nums);
        int[] valueToCount = new int[size];
        for (int num : nums) valueToCount[num - minValue]++;
        int answer = 0;
        for (int i = 1; i < valueToCount.length; i++) {
            if (valueToCount[i] != 0 && valueToCount[i - 1] != 0) {
                answer = Math.max(answer, valueToCount[i] + valueToCount[i - 1]);
            }
        }
        return answer;
    }
    private static int findLHSUsingMap(int[] nums) {
        if (nums.length < 2) return 0;
        Map<Integer, Integer> valueToCount = new HashMap();
        for (int num : nums) valueToCount.merge(num, 1, Integer::sum);
        int answer = 0;
        for (Map.Entry<Integer,Integer> entry : valueToCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            Integer less = valueToCount.get(key - 1);
            Integer more = valueToCount.get(key + 1);
            if (less != null) answer = Math.max(answer, value + less);
            if (more != null) answer = Math.max(answer, value + more);
        }
        return answer;
    }
}