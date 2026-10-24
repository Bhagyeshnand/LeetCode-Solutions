class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arr={0,31,59,90,120,151,181,212,243,273,304,334};
        int aa=arr[Integer.valueOf(arriveAlice.substring(0,2))-1]+Integer.valueOf(arriveAlice.substring(3,5));
        int la=arr[Integer.valueOf(leaveAlice.substring(0,2))-1]+Integer.valueOf(leaveAlice.substring(3,5));
        int ab=arr[Integer.valueOf(arriveBob.substring(0,2))-1]+Integer.valueOf(arriveBob.substring(3,5));
        int lb=arr[Integer.valueOf(leaveBob.substring(0,2))-1]+Integer.valueOf(leaveBob.substring(3,5));
        int st=Math.max(aa,ab);
        int end=Math.min(la,lb);
        return Math.max(0,end-st+1);
    }
}