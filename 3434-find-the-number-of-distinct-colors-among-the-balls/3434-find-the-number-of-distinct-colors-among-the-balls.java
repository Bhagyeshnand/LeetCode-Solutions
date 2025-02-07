class Solution {

public int[] queryResults (int limit, int[][] queries) {

int n = queries.length;

int[] result = new int[n];

Map<Integer, Integer> ballColorMap = new HashMap<>();
    Map<Integer, Integer> colorCountMap  = new HashMap<>(); 
    Set<Integer> distinctColors = new HashSet<>();

for (int i=0; i < n; i++) {

int ball = queries [i][0];

int newColor = queries [i][1];

if (ballColorMap.containsKey(ball)) {

int oldColor = ballColorMap.get(ball);

ballColorMap.put(ball, newColor);

colorCountMap.put(oldColor, colorCountMap.get(oldColor) - 1);

if (colorCountMap.get(oldColor) == 0) { 
    colorCountMap.remove(oldColor);

distinctColors.remove(oldColor);

}

} else {

ballColorMap.put(ball, newColor);

}

colorCountMap.put(newColor, colorCountMap.getOrDefault(newColor, 0) + 1); distinctColors.add(newColor);

result[i] = distinctColors.size();

}

return result;

}

}