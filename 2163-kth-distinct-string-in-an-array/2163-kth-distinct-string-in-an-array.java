class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> uniqueValInArray = new LinkedList<>();
        int totalDistinctVal = 0;
        Set<String> nonDistinctSet = new HashSet<>();
        Set<String> distinctSet = new HashSet<>();
        for(String s:arr) {
            if(!nonDistinctSet.contains(s)) {
                if(!distinctSet.contains(s)) {
                    distinctSet.add(s);
                    totalDistinctVal++;
                } else {
                    nonDistinctSet.add(s);
                    distinctSet.remove(s);
                    totalDistinctVal--;
                }
            }
        }
        if(totalDistinctVal<k) {
            return "";
        }
        for(String s:arr) {
            if(distinctSet.contains(s)){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}