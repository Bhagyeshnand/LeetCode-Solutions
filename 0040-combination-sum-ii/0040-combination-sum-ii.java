class Solution {

    public void findSum(int ind , int[] arr ,int T ,ArrayList<Integer> ds,List<List<Integer>> ans){
        if(T == 0){
         ans.add(new ArrayList<>(ds));
         return ;
        }

        for(int i =ind ; i< arr.length ; i++){
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > T) break;

            ds.add(arr[i]);   
            findSum(i+1, arr, T-arr[i], ds, ans);
            ds.remove(ds.size()-1);         
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

    findSum(0, candidates, target,new ArrayList<>(), ans);
    return ans;

    }
}