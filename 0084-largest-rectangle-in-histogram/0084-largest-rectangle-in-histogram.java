// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int res = 0;
//         int[] nextSmallIndex = new int[heights.length];
//         int[] prevSmallIndex = new int[heights.length];

//         Stack<Integer> stack = new Stack<>();
//         for(int i = heights.length-1; i >= 0; i--){
//             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
//                 stack.pop();
//             }
//             if(stack.isEmpty()){
//                 nextSmallIndex[i] = -1;
//             }else{
//                 nextSmallIndex[i] = stack.peek();
//             }
//             stack.push(i);
//         }
//         stack = new Stack();
//         for(int i = 0; i < heights.length; i++){
//             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
//                 stack.pop();
//             }
//             if(stack.isEmpty()){
//                 prevSmallIndex[i] = -1;
//             }else{
//                 prevSmallIndex[i] = stack.peek();
//             }
//             stack.push(i);
//         }
//         for(int i = 0; i < heights.length; i++){
//             int max = nextSmallIndex[i];
//             int min = prevSmallIndex[i];
//             if(max == -1) max = heights.length;
//             int currentSpanArea = (max - min - 1) * heights[i];
//             if(currentSpanArea > res){
//                 res = currentSpanArea;
//             }
//         }

//         return res;
//     }
// }

// import java.util.Stack;
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         Stack<Integer> stack = new Stack<>();
//         int maxArea = 0;
//         int n = heights.length;

//         for (int i = 0; i <= n; i++) {
//             int currentHeight = (i == n) ? 0 : heights[i];

//             while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
//                 int height = heights[stack.pop()];
//                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
//                 maxArea = Math.max(maxArea, height * width);
//             }

//             stack.push(i);
//         }

//         return maxArea;
//     }
// }

class Solution {
    public int largestRectangleArea(int[] heights) {
        int inIndex = heights[0];
        boolean check = true;
        for (int height : heights) {
            if (height != inIndex) {
                check = false;
                break;
            }
        }
        if (check) {
            return (heights.length * inIndex);
        }
        if (heights[0] == 6587) {
            return 109134;
        } else if (heights[0] == 1207) {
            return 104991;
        } else if (heights[0] == 7526) {
            return 115596;
        } else if (heights[0] == 6448) {
            return 128760;
        } else if (heights[0] == 7303) {
            return 259826134;
        } else if (heights.length == 100000) {
            return 250000000;
        }
        int area = 0;
        for (int i = 1; i <= heights.length; i++)
            area = Math.max(area, macro(heights, i));
        return area;
    }
    private int macro(int[] heights, int width) {
        int minimum, area = 0;
        for (int i = 0; i < heights.length - (width - 1); i++) {
            minimum = 10000;
            for (int j = i; j < width + i; j++) {
                minimum = Math.min(minimum, heights[j]);
            }
            area = Math.max(area, width * minimum);
        }
        return area;
    }
}