class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;

        Map <String, Integer> mp = new HashMap<>();

        String[] words = s.split(" ");

        for (String word : words){
            mp.put(word , mp.getOrDefault(word, 0) +1 );
        }

        List <String> result = new ArrayList<>();

        for(Map.Entry <String, Integer> entry : mp.entrySet()){
            if(entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }
        return result.stream().toArray(String[]::new) ;
    }
}