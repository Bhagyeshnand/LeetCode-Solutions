class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait = 0;
        int t = -1;
        for(int[] a : customers) {
            t = (t<a[0])?a[0]:t;
            t += a[1];
            wait += t-a[0];
        }
        return wait/customers.length;
    }
}

// class Solution {
//     public double averageWaitingTime(int[][] customers) {
//         double total_waiting_time = 0;
//         int current_time = 0;

//         for (int[] customer : customers) {
//             int arrival = customer[0];
//             int service = customer[1];
//             if (current_time < arrival) {
//                 current_time = arrival;
//             }
//             int waiting_time = current_time - arrival + service;
//             total_waiting_time += waiting_time;
//             current_time += service;
//         }

//         return total_waiting_time / customers.length;
//     }
// }