class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        List<int[]> counter = new ArrayList<>();
        Arrays.sort(basket1);
        Arrays.sort(basket2);
        int p1 = 0, p2 = 0;
        
        int totalToSwap = 0;
        while(p1<basket1.length||p2<basket2.length){
            if(p1<basket1.length&&p2<basket2.length&&basket1[p1]==basket2[p2]){
                p1++;
                p2++;
                continue;
            }
            int curVal = 0;
            int curCount = 0;
            if((p1<basket1.length&&p2<basket2.length&&basket1[p1]<basket2[p2])||p2>=basket2.length){
                curVal = basket1[p1];
                while(p1<basket1.length&&basket1[p1]==curVal){
                    curCount++;
                    p1++;
                }
            }
            else{
                curVal = basket2[p2];
                while(p2<basket2.length&&basket2[p2]==curVal){
                    curCount++;
                    p2++;
                }
            }
            if(curCount%2!=0) return -1;
            totalToSwap += curCount/2;
            counter.add(new int[]{curVal,curCount/2});
        }
        long ans = 0;
        int swaped = 0;
        int minEle = Math.min(basket1[0],basket2[0]);
        int i = 0;
        int acc = 0;
        while(i<counter.size()){
            int[] pair = counter.get(i);
            ans+=Math.min(minEle*2,pair[0]);
            swaped+=2;
            if(swaped==totalToSwap) break;
            acc++;
            if(acc==pair[1]){
                acc = 0;
                i++;
            }
        }
        return ans;
    }
}