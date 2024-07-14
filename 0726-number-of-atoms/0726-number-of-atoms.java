class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();

        Stack<Map<String, Integer>> stack = new Stack<>();
        
        stack.push(new HashMap<>());

        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for (String key : top.keySet()) {
                    int value = top.get(key);
                    top.put(key, value * multiplier);
                }
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key));
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i++));
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i++));
                }
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i++));
                }
                int count = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0) + count);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder result = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            result.append(key);
            int count = sortedMap.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}