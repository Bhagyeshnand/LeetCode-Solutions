class Solution {
    public int minLength(String s) {
        char[] stack = new char[s.length()+1];
        int last = -1;
        for (char c : s.toCharArray()) {
            if (last > -1 && (c == 'B' && stack[last] == 'A' || 
                                     c == 'D' && stack[last] == 'C')) 
            {
                last--;
            } else {
                last++;
                stack[last] = c;
            }
        }
        return last+1;
    }
}

// class Solution {
//     public int minLength(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             char cur_char = s.charAt(i);

//             if (stack.isEmpty()) {
//                 stack.push(cur_char);
//                 continue;
//             }
      
//             if (cur_char == 'B' && stack.peek() == 'A') {
//                 stack.pop();
//             }
//             else if (cur_char == 'D' && stack.peek() == 'C') {
//                 stack.pop();
//             }
//             else {
//                 stack.push(cur_char);
//             }
//         }

//         return stack.size();
//     }
// }