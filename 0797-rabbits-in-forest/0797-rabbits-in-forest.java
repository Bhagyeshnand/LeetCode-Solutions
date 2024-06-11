class Solution {
    public int numRabbits(int[] answers) {
         HashMap<Integer, Integer> map = new HashMap<>();
        int totalRabbits = 0;

        // Count the frequency of each answer
        for (int n : answers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Calculate the minimum number of rabbits
        for (int answer : map.keySet()) {
            int count = map.get(answer);
            int groupSize = answer + 1;
            int numberOfGroups = (int) Math.ceil((double) count / groupSize);
            totalRabbits += numberOfGroups * groupSize;
        }

        return totalRabbits;
    }
}