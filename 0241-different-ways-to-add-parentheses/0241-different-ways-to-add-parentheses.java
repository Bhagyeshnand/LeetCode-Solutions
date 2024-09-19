class Solution {
    public List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '+' || curr == '-' || curr == '*') {
                List<Integer> left = solve(s.substring(0, i));
                List<Integer> right = solve(s.substring(i + 1));

                for (int x : left) {
                    for (int y : right) {
                        if (curr == '+') {
                            result.add(x + y);
                        } else if (curr == '-') {
                            result.add(x - y);
                        } else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }
}