class Solution {
    public int minAddToMakeValid(String s) {
        Stack<String> st=new Stack<>();
        int openCount=0;
        int closeCount=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                openCount++;
            }
           else
            {
                if(openCount>0)
                {
                    openCount--;
                }
                else
                closeCount++;
            }
        }
        return openCount+closeCount;
    }
}