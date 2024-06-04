class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList <Integer> num = new ArrayList<>();  // for iteration sequence

        for(int i = 1 ; i < n; i++){
            fact *= i;    // calculate 1 num less than n! for 4! = 24 we need 3! = 6
            num.add(i);
        }   num.add(n);    // add the last one element

        String ans = ""; // Our ans string
        k = k-1;                // we required 1 less eg: for k =4 , we consider 4 - 1= 3

        while(true){
            ans = ans + num.get(k / fact);  // geting & adding to ans our index range from k/fact = 16/6 = 2 
            num.remove(k/fact);     //removing after adding
            
            if(num.size() == 0) break;

            k = k % fact;
            fact = fact/num.size();  
        }

        return ans;
    }
}