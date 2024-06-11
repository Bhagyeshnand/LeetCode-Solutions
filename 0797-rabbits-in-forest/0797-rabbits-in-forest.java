class Solution {
  public int numRabbits(int[] answers) {
    int ans = 0;
    int[] count = new int[1000];

    for (final int answer : answers) {
      if (count[answer] % (answer + 1) == 0) // add to ans when new group arise
        ans += answer + 1;      // let for [1 1 1 2] first time when it comes its freq is 0 which satisfy the condition 
      ++count[answer];          // and its value(Group size(num + 1)) is added and for index 2 for the 3rd 1 , condition again satisfy for
    }                           // formation of new group

    return ans;
  }
}

/*class Solution {
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
*/