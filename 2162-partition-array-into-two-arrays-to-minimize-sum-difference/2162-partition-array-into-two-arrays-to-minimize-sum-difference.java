class Solution {

	public int minimumDifference(int[] nums) {
		int n = nums.length / 2;
		int total = Arrays.stream(nums).sum();
		HashMap<Integer,List<Integer>> leftMap = new HashMap();
		HashMap<Integer,List<Integer>> rightMap = new HashMap();

		createSumMappings(0, leftMap, nums, n);
		createSumMappings(n, rightMap, nums, n);
        leftMap.put(0,Arrays.asList(0));
        rightMap.put(0,Arrays.asList(0));

		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= n; i++){
            List<Integer> left = leftMap.get(i);
            List<Integer> right = rightMap.get(n - i);
            Collections.sort(left);
            Collections.sort(right);
            
            int p1 = 0, p2 = right.size() - 1;
            while(p1 < left.size() && p2 >= 0){
                int sum = left.get(p1) + right.get(p2);
                int remaining = total - sum;
                int diff =  Math.abs(remaining - sum);
                min = Math.min(min,diff);
                if(sum > total / 2) p2--;
                else p1++;
                
            }
        }
		return min;
	}
	public void createSumMappings(int offSet, HashMap < Integer, List < Integer >> map, int[] nums, int n) {
		for (int i = 1; i <= Math.pow(2, n) - 1; i++) {
			String binary = Integer.toBinaryString(i);
			int sum = 0,
			setBits = 0;
			for (int j = binary.length() - 1, index = nums.length - 1; j >= 0; j--, index--) {
				if (binary.charAt(j) == '1') {
					setBits++;
					sum += nums[index - offSet];
				}
			}
			if (!map.containsKey(setBits)) map.put(setBits, new ArrayList());
			map.get(setBits).add(sum);
		}
	}
}