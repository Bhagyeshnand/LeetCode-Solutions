class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccur=new int[26];
        List<Integer> result=new ArrayList<Integer>();
        char[] chars=s.toCharArray();
        int size=chars.length;

        for(int i=0;i<size;i++){
            lastOccur[chars[i]-'a']=i;
        }

        int startIndex=0;
        int endIndex=includeAllChars(startIndex,chars,lastOccur);
        while(endIndex<=size-1){
            result.add(endIndex-startIndex+1);
            startIndex=endIndex+1;
            if(startIndex>=size){
                break;
            }
            endIndex=includeAllChars(startIndex,chars,lastOccur);
        }
        return result;
    }

    private int includeAllChars(int startIndex,char[] chars,int[] lastOccur){
        int i=startIndex;
        int endIndex=lastOccur[chars[startIndex]-'a'];
        int size=chars.length;
        while(endIndex<size-1 && i<endIndex){
            i++;
            endIndex=Math.max(endIndex,lastOccur[chars[i]-'a']);
         //   System.out.println("i="+i+"endIndex:"+endIndex);
        }
        return endIndex;
    }

}

//start with a index
//find last character of the first index
//in this range iterate incrementally and for each unique char
//find its last occurance and adjust the range
//when iterator is at at last index, mark this as one block and move ahead