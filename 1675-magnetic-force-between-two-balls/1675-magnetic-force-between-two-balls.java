class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        
             int start=1;
             int end=(position[position.length-1]-position[0])/(m-1);
             while(start<=end){
                 int mid=(end+start)/2;
                   int req=dist(position,mid);
                   if(req>=m){
                    start=mid+1;
                   }
                   else{
                    end=mid-1;
                   }

             
             }
             return end;

    }
    public int dist(int[] nums,int mid){
        int count=1;
       int last=nums[0];
        for(int i=1;i<nums.length;i++){
             if(nums[i]-last>=mid){
                count++;
                last=nums[i];
             }
        }
        return count;
    }
}

// public class Solution {
//     public boolean possibleToPlace(int force, int[] position, int m) {
//         int prev = position[0];
//         int countBalls = 1;

//         for (int i = 1; i < position.length; i++) {
//             int curr = position[i];

//             if (curr - prev >= force) {
//                 countBalls++;
//                 prev = curr;
//             }

//             if (countBalls == m) {
//                 break;
//             }
//         }

//         return countBalls == m;
//     }

//     public int maxDistance(int[] position, int m) {
//         int n = position.length;
//         Arrays.sort(position);

//         int minForce = 1;
//         int maxForce = position[n - 1] - position[0]; // This value is the maximum possible distance

//         int result = 0;
//         while (minForce <= maxForce) {
//             int midForce = minForce + (maxForce - minForce) / 2;

//             if (possibleToPlace(midForce, position, m)) {
//                 result = midForce;
//                 minForce = midForce + 1;
//             } else {
//                 maxForce = midForce - 1;
//             }
//         }

//         return result;
//     }
// }