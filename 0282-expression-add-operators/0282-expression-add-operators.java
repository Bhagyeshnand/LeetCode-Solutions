class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, "", 0, 0, 0);
        return result;
    }
    
    private void backtrack(List<String> result, String num, int target, String expression, int index, long currentValue, long prevOperand) {
        // Base case: if we've reached the end of the string
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);  // Add the valid expression to the result list
            }
            return;
        }
        
        // Iterate through all possible lengths of the next number
        for (int i = index; i < num.length(); i++) {
            // Avoid numbers with leading zeros
            if (i != index && num.charAt(index) == '0') break;
            
            // Extract the current substring as the next number to process
            String currentStr = num.substring(index, i + 1);
            long currentNum = Long.parseLong(currentStr);
            
            // If this is the first number (we don't place an operator before the first number)
            if (index == 0) {
                backtrack(result, num, target, currentStr, i + 1, currentNum, currentNum);
            } else {
                // Try adding '+'
                backtrack(result, num, target, expression + "+" + currentStr, i + 1, currentValue + currentNum, currentNum);
                
                // Try adding '-'
                backtrack(result, num, target, expression + "-" + currentStr, i + 1, currentValue - currentNum, -currentNum);
                
                // Try adding '*'
                backtrack(result, num, target, expression + "*" + currentStr, i + 1, currentValue - prevOperand + prevOperand * currentNum, prevOperand * currentNum);
            }
        }
    }
}
