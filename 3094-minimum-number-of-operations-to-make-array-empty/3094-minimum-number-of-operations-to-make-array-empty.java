class Solution {
    public int minOperations(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            if (x > maxVal) {
                maxVal = x;
            }
        }

        int[] freq = new int[maxVal + 1];
        for (int x : nums) {
            freq[x]++;
        }

        int minOperations = 0;
        for (int count : freq) {
            if (count == 0) continue;
            if (count == 1) return -1;
            // Add the minimum number of operations needed for this count
            minOperations += (count + 2) / 3;
        }

        return minOperations;
    }
}

/* 
class Solution {
    public int minOperations(int[] nums) {
        int steps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();

            if (count == 1) {
                return -1;
            }

            steps += count / 3;
            int remainder = count % 3;

            if (remainder == 1) {
                if (count >= 4) { 
                    steps += 1; 
                } else {
                    return -1; 
                }
            } else if (remainder == 2) {
                steps += 1; 
            }
        }

        return steps;
    }
}
*/