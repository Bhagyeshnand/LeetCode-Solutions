class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        
        // For very small arrays or when candidates is large
        if (2 * candidates >= n) {
            Arrays.sort(costs);
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += costs[i];
            }
            return sum;
        }
        
        // For single candidate case
        if (candidates == 1) {
            long sum = 0;
            int left = 0, right = n - 1;
            while (k-- > 0) {
                if (right < left || costs[left] <= costs[right]) {
                    sum += costs[left++];
                } else {
                    sum += costs[right--];
                }
            }
            return sum;
        }
        
        // Main case: Use primitive arrays as heaps
        int[] frontHeap = new int[candidates];
        int[] backHeap = new int[candidates];
        int frontSize = 0, backSize = 0;
        int left = 0, right = n - 1;
        
        // Initialize heaps
        for (int i = 0; i < candidates && i < n/2; i++) {
            frontHeap[frontSize++] = costs[left++];
            backHeap[backSize++] = costs[right--];
            siftUp(frontHeap, frontSize - 1);
            siftUp(backHeap, backSize - 1);
        }
        
        long totalCost = 0;
        while (k-- > 0) {
            if (backSize == 0 || (frontSize > 0 && frontHeap[0] <= backHeap[0])) {
                totalCost += frontHeap[0];
                if (left <= right) {
                    frontHeap[0] = costs[left++];
                    siftDown(frontHeap, 0, frontSize);
                } else {
                    frontHeap[0] = frontHeap[--frontSize];
                    if (frontSize > 0) siftDown(frontHeap, 0, frontSize);
                }
            } else {
                totalCost += backHeap[0];
                if (left <= right) {
                    backHeap[0] = costs[right--];
                    siftDown(backHeap, 0, backSize);
                } else {
                    backHeap[0] = backHeap[--backSize];
                    if (backSize > 0) siftDown(backHeap, 0, backSize);
                }
            }
        }
        
        return totalCost;
    }
    
    private void siftUp(int[] heap, int index) {
        int value = heap[index];
        while (index > 0) {
            int parent = (index - 1) >>> 1;
            if (heap[parent] <= value) break;
            heap[index] = heap[parent];
            index = parent;
        }
        heap[index] = value;
    }
    
    private void siftDown(int[] heap, int index, int size) {
        int value = heap[index];
        int half = size >>> 1;
        while (index < half) {
            int child = (index << 1) + 1;
            int right = child + 1;
            if (right < size && heap[right] < heap[child]) {
                child = right;
            }
            if (value <= heap[child]) break;
            heap[index] = heap[child];
            index = child;
        }
        heap[index] = value;
    }
}


// class Solution {
//     public long totalCost(int[] costs, int k, int candidates) {
//         int n = costs.length;
//         // Separate heaps for front and back candidates for better performance
//         PriorityQueue<Integer> frontHeap = new PriorityQueue<>();
//         PriorityQueue<Integer> backHeap = new PriorityQueue<>();
        
//         // Initialize pointers
//         int left = 0, right = n - 1;
//         long totalCost = 0;
        
//         // Add initial candidates
//         for (; left < candidates; left++) {
//             frontHeap.offer(costs[left]);
//         }
//         for (; right >= Math.max(left, n - candidates); right--) {
//             backHeap.offer(costs[right]);
//         }
        
//         // Hire k workers
//         while (k-- > 0) {
//             // If only front heap has candidates
//             if (backHeap.isEmpty() || 
//                 (!frontHeap.isEmpty() && frontHeap.peek() <= backHeap.peek())) {
//                 totalCost += frontHeap.poll();
//                 if (left <= right) {
//                     frontHeap.offer(costs[left++]);
//                 }
//             }
//             // If only back heap has candidates or back has smaller value
//             else {
//                 totalCost += backHeap.poll();
//                 if (left <= right) {
//                     backHeap.offer(costs[right--]);
//                 }
//             }
//         }
        
//         return totalCost;
//     }
// }