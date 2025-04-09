class Solution {
 public int maxPoints(int[][] points) {
        int len = points.length;
        if (len < 3)
            return len;

        int maxPoints = 2;
        for (int i=0; i<len; i++)
            maxPoints = Math.max(maxPoints, getMaxLine(points[i][0], points[i][1], i+1, points));

        return maxPoints;
    }

    private int getMaxLine(int x1, int y1, int j, int[][] points)  {
        int len = points.length;
        Map<Double, Integer> map = new HashMap<>();
        int max = 1;
        for (; j<len; j++)  {
            int x2 = points[j][0], y2 = points[j][1];
            //NEGATIVE_INFINITY or POSITIVE_INFINITY both work, just has to be same everytime
            Double slope = (x2 == x1) ? Double.NEGATIVE_INFINITY : (double)(y2-y1)/(x2-x1);//((y2 == y1) ? 0.0 :
            if(slope == -0.0){
                slope = 0.0;
            }
            int count = map.getOrDefault(slope, 1)+1;
            map.put(slope, count);
            max = Math.max(max, count);
        }
        return max;
    }
}