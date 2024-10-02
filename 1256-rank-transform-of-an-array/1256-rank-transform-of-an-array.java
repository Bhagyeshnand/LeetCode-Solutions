class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0){
            return arr;
        }
        int[] nums=arr.clone();
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=1;
        map.put(nums[0],j++);
        for(int i=1;i<arr.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            else{
                map.put(nums[i],j++);
            }
        }
        for(int i=0;i<arr.length;i++){
            nums[i]=map.get(arr[i]);
        }
        return nums;
    }
}

// import java.util.*;

// class Solution {
//     public int[] arrayRankTransform(int[] arr) {
//         Map<Integer, Integer> valueToRank = new HashMap<>();  // Map to store value-to-rank mapping
//         int[] sortedUniqueNumbers = Arrays.stream(arr).distinct().sorted().toArray();  // Remove duplicates and sort
        
//         // Assign ranks to sorted unique elements
//         for (int i = 0; i < sortedUniqueNumbers.length; i++) {
//             valueToRank.put(sortedUniqueNumbers[i], i + 1);
//         }

//         // Replace each element in the original array with its rank
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = valueToRank.get(arr[i]);
//         }

//         return arr;  // Return the updated array
//     }
// }
