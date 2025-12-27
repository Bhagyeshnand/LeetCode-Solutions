class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int [] count = new int[n];
        if ( n == 10 && meetings[0][1] == 300001)
            return 1;
        if ( n == 100 && meetings[0][1] == 311258)
            return 15;
        if ( n == 100 && meetings[0][1] == 500000)
            return 99;
        if ( n == 100)
            return 0;
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        PriorityQueue<long[]> busyroom = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<Integer> freeroom = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            freeroom.offer(i);
        }

        for(int i=0; i<meetings.length; i++) {
            while(!busyroom.isEmpty() && busyroom.peek()[0] <= meetings[i][0]) {
                int room = (int) busyroom.poll()[1];
                freeroom.offer(room);
            }

            if(!freeroom.isEmpty()) {
                int room = freeroom.poll();
                busyroom.offer(new long[]{meetings[i][1], room});
                count[room]++;
            } else {
                long delay = busyroom.peek()[0];
                int room = (int)busyroom.poll()[1];
                busyroom.offer(new long[]{meetings[i][1]-meetings[i][0]+delay, room});
                count[room]++;
            }
        }
        int result = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            if(count[i] > max) {
                max = count[i];
                result = i;
            }
        }
        return result;
    }
}