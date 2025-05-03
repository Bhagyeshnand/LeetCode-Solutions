class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list= new ArrayList<>();

        for(int i=0;i<Math.pow(2,n);i++)
        {
            list.add(i^(i>>1));
             // xor operation between i current element and right shifted element  to ensure that only one binary digit is changed at one time
        }
        return list;
        
    }
}