class Solution {
    private List<Integer>[] children;
    private int[] parent, present, future;
    private int budget;
    
    private void createHierarchy(int n, int[][] hierarchy) {
        children = new ArrayList[n + 1];
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }
        
        for (int[] relation : hierarchy) {
            int boss = relation[0];
            int subordinate = relation[1];
            children[boss].add(subordinate);
            parent[subordinate] = boss;
        }
        
        parent[1] = 0;
    }
    
    private int[] combine(int[] dp1, int[] dp2) {
        int[] newDp = new int[budget + 1];
        for (int b1 = 0; b1 <= budget; b1++) {
            for (int b2 = 0; b1 + b2 <= budget; b2++) {
                newDp[b1 + b2] = Math.max(newDp[b1 + b2], dp1[b1] + dp2[b2]);
            }
        }
        return newDp;
    }
    
    private int[][] dfs(int employee) {
        int costWithoutDiscount = present[employee - 1];
        int profitWithoutDiscount = future[employee - 1] - costWithoutDiscount;
        int costWithDiscount = present[employee - 1] / 2;
        int profitWithDiscount = future[employee - 1] - costWithDiscount;
        
        int[] dpChildrenNo = new int[budget + 1]; 
        int[] dpChildrenYes = new int[budget + 1]; 
        
        dpChildrenNo[0] = 0;
        dpChildrenYes[0] = 0;
        
        List<int[][]> childResults = new ArrayList<>();
        for (int child : children[employee]) {
            childResults.add(dfs(child));
        }
        
        for (int[][] childRes : childResults) {
            int[] childNoDiscount = childRes[0];
            int[] childWithDiscount = childRes[1];
            
            dpChildrenNo = combine(dpChildrenNo, childNoDiscount);
            dpChildrenYes = combine(dpChildrenYes, childWithDiscount);
        }
        
        int[] dpNoDiscount = new int[budget + 1];
        for (int b = 0; b <= budget; b++) {
            dpNoDiscount[b] = dpChildrenNo[b];
        }

        for (int b = costWithoutDiscount; b <= budget; b++) {
            int newProfit = dpChildrenYes[b - costWithoutDiscount] + profitWithoutDiscount;
            if (newProfit > dpNoDiscount[b]) {
                dpNoDiscount[b] = newProfit;
            }
        }
        
        int[] dpWithDiscount = new int[budget + 1];
        for (int b = 0; b <= budget; b++) {
            dpWithDiscount[b] = dpChildrenNo[b];
        }

        for (int b = costWithDiscount; b <= budget; b++) {
            int newProfit = dpChildrenYes[b - costWithDiscount] + profitWithDiscount;
            if (newProfit > dpWithDiscount[b]) {
                dpWithDiscount[b] = newProfit;
            }
        }
        
        return new int[][]{dpNoDiscount, dpWithDiscount};
    }
    
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.budget = budget;
        
        createHierarchy(n, hierarchy);
        
        int[][] result = dfs(1);
        
        int maxProfit = 0;
        for (int b = 0; b <= budget; b++) {
            maxProfit = Math.max(maxProfit, result[0][b]);
        }
        
        return maxProfit;
    }
}