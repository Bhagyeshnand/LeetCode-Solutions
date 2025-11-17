class Solution {
    public List<String> findRepeatedDnaSequences(String str) {
        int len = str.length();
        if (len < 10 || len >10000) return new ArrayList<>();
        Set<String> S = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i=0; i<=len-10; i++){
            String substring = str.substring(i,i+10);
            if(!S.add(substring))
                result.add(substring);
        }
        return new ArrayList<>(result);
    }
}