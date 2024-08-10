class Solution {
    public String mostCommonWord(String s1, String[] ban) {
        s1 = s1.toLowerCase().replaceAll("\\W+"," ");
        String[] arr = s1.split("\\s+");

        int n = arr.length;
        HashMap<String,Integer> hp = new HashMap<>();
        for(int i=0; i<n; i++){
            hp.put(arr[i],hp.getOrDefault(arr[i],0)+1);
        }

        HashSet<String> h = new HashSet<>();
        for(int i=0; i<ban.length; i++){
            h.add(ban[i]);
        }
        

        int freq = 0;
        String ans = "";
        for(var a : hp.keySet()){
            if(hp.get(a)>freq && !h.contains(a)){
                freq = hp.get(a);
                ans = a;
            }
        }
        return ans;
    }
}