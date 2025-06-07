class Solution {
    public String clearStars(String s) {
        int n = s.length();
        Map<Character, Stack<Integer>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            Stack<Integer> stack = new Stack<Integer>();
            map.put(c, stack);
        }
        boolean[] arr = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                arr[i] = true;
                for (char c = 'a'; c <= 'z'; c++) {
                    if (!map.get(c).isEmpty()) {
                        Stack stack = map.get(c);
                        // System.out.println(stack);
                        int idx = (int)stack.pop();
                        arr[idx] = true;
                        break;
                    }
                }
            } else {
                map.get(s.charAt(i)).add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!arr[i]) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}