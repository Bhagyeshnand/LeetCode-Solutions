class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list from the array
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Step 3: Sort the list based on frequency and value
        Collections.sort(list, (a, b) -> {
            int frequencyA = frequencyMap.get(a);
            int frequencyB = frequencyMap.get(b);
            if (frequencyA == frequencyB) {
                return b - a; // For same frequency, sort by value in descending order
            } else {
                return frequencyA - frequencyB; // Sort by frequency in ascending order
            }
        });

        // Step 4: Convert the sorted list back to array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;

    }
}