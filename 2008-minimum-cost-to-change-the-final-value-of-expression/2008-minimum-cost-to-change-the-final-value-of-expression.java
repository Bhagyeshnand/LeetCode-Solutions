class Solution {
    public int minOperationsToFlip(String expression) {
        /*
        there will be some final evaluation that after all other expression order evaluations, will be of the form 
        Bit Op Bit
        where bits are 0 or 1, Op is AND or OR
        can say the expression "simplifies" down to this case
        in other words, we get this case by simplifying exp1 and exp2 where expression is of the form
        exp1 OP exp2 for expressions exp1, exp2.

        can then break this up into it's possible cases:
            case 1: 0 and 0
                this will evaluate to 0, to change it to evaluate to 1, either
                    - both of the bits must change to 1
                    - one of the bits changes to one and the operator changes to OR
                Note, to change any of the bits to one, the problem breaks into a subproblem of min to change either exp1 or exp2.
                    can also note that is must take at least a single operation to change, as if it takes 0 ops then we've done nothing and trivially not changed the subproblem
                Thus, if we define f as function that gives min ops to change for an expression, for this case have 
                f(expression) = MIN(f(exp1) + f(exp2), MIN(f(exp1), f(exp2)) + 1).
                Can say that the second part of the MIN statement, i.e. MIN(f(exp1), f(exp2)) + 1 will always be <= to f(exp1) + f(exp2), as
                1 <= f(x) for any expression x by note before. 
                Thus, it is always optimal to change expression by only changing one of the bits and changing the middle operator to OR

                So f(expression) = MIN(f(exp1), f(exp2)) + 1. In this case.
            
            case 2: 1 and 0 / 0 and 1. 
                Trivially, if change AND to OR, immediately changes from evaluating = 0 to evaluating = 1, so can change in a single operation
                Thus f(expression) = 1 for this case
            case 3: 1 and 1
                This evaluates to 1, to make it 0 we can either change the operator to OR then force both bits to Zero, or just force one of the bits to 0
                It is trivially always more efficient to just simply force a single bit to zero rather than both and an extra cost operator change, meaning
                f(expression) = MIN(f(exp1), f(exp2))

            case 4: 0 or 0:
                In order to make a 1 with any operator, need at least a single 1 bit, and if have a single 1 bit then this changes automatically from 0 to 1 in eval. Thus, 
                f(expression) = MIN(f(exp1), f(exp2))

            case 5: 1 or 0 / 0 or 1
                changing to AND auto does in 1 cost for 0 extra exp1, exp2 suboperations, thus 
                f(expression) = 1
            
            case 6: 1 or 1
                similar to case 1 for AND, optimal should be to change a single operation and then a single bit expr, so
                f(expression) = MIN(f(exp1), f(exp2)) + 1.
            */
        int[] res = evaluateAndChange(expression, 0);
        return res[1];
       

    }
    

    private int[] evaluateAndChange(String s, int l) { //returns expression evaluation and min cost to change
        char op = 'e';
        int[] exp1 = null, exp2 = null;

        int n = s.length(), i;
        for(i = l; i < n; i++) {
            char c = s.charAt(i);
            if(c == ')') break;
            switch(c) {
                case '0':
                case '1':
                    if(exp1 == null) {
                        exp1 = new int[]{c-'0', 1};
                    } else {
                        exp2 = new int[]{c-'0', 1};
                    }
                    break;
                case '(':
                    int[] subproblem = evaluateAndChange(s, i+1);
                    if(exp1 == null) {
                        exp1 = new int[]{subproblem[0], subproblem[1]};
                    } else {
                        exp2 = new int[]{subproblem[0], subproblem[1]};
                    }
                    i = subproblem[2];
                    break;
                case '&':
                case '|':
                    op = c;
                    break;
            }
            if(exp2 != null) {
                int b1 = exp1[0], b2 = exp2[0], minCost = Math.min(exp1[1], exp2[1]);
                exp2 = null;
                if(op == '&') {
                    if((b1 & b2) == 1) {
                        exp1 = new int[]{1, minCost};
                    } else if ((b1 ^ b2) == 1) {
                        exp1 = new int[]{0, 1};
                    } else {
                        exp1 = new int[]{0, minCost + 1};
                    }
                } else {
                    if((b1 | b2) == 0) {
                        exp1 = new int[]{0, minCost};
                    } else if ((b1 ^ b2) == 1) {
                        exp1 = new int[]{1, 1};
                    } else {
                        exp1 = new int[]{1, minCost + 1};
                    }
                }
            }
        }
        return new int[]{exp1[0], exp1[1], i};
    }
}