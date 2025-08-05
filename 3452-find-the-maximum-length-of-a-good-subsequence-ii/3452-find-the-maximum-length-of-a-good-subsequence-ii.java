class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> num2id = new HashMap<>();
        int id = 0;
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = num2id.get(nums[i]);

        int[][] dp = new int[id][k+1];
        int[] cMax = new int[k+1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // for (int j = 0; j < k+1; j++) {
            for (int j = k; j >= 0; j--) {
                if (i == 0) {
                    dp[num][j] = 1;
                } else {
                    if (j == 0) {
                        dp[num][j] = dp[num][j] + 1;
                    } else {
                        // i != 0 && j != 0
                        int prevNumDp = dp[num][j];

                        dp[num][j] = Math.max(dp[num][j], prevNumDp+1);
                        
                        // for (int p = 0; p < i; p++) {
                        //     int prev = nums[p];
                        //     // if (prev != num) dp[num][j] = Math.max(dp[num][j], dp[prev][j-1]+1);
                        //     // if (prev == num) dp[num][j] = Math.max(dp[num][j], prevNumDp+1);
                        //     dp[num][j] = Math.max(dp[num][j], dp[prev][j-1]+1);
                        // }
                        dp[num][j] = Math.max(dp[num][j], cMax[j-1]+1);
                    }
                }
                cMax[j] = Math.max(cMax[j], dp[num][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}

class Solution9 {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> num2id = new HashMap<>();
        int id = 0;
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = num2id.get(nums[i]);
        // System.out.println(Arrays.toString(nums));

        int[][] dp = new int[id][k+1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // for (int j = 0; j < k+1; j++) {
            for (int j = k; j >= 0; j--) {
                if (i == 0) {
                    dp[num][j] = 1;
                } else {
                    if (j == 0) {
                        dp[num][j] = dp[num][j] + 1;
                    } else {
                        // i != 0 && j != 0
                        int prevNumDp = dp[num][j];

                        dp[num][j] = Math.max(dp[num][j], prevNumDp+1);
                        
                        for (int p = 0; p < i; p++) {
                            int prev = nums[p];
                            // if (prev != num) dp[num][j] = Math.max(dp[num][j], dp[prev][j-1]+1);
                            // if (prev == num) dp[num][j] = Math.max(dp[num][j], prevNumDp+1);
                            dp[num][j] = Math.max(dp[num][j], dp[prev][j-1]+1);
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}




class Solution8 {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> num2id = new HashMap<>();
        int id = 0;
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = num2id.get(nums[i]);
        // System.out.println(Arrays.toString(nums));

        int[][] dp = new int[id][k+1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < k+1; j++) {
                if (i == 0) {
                    dp[num][j] = 1;
                } else {
                    if (j == 0) {
                        dp[num][j] = dp[num][j] + 1;
                    } else {
                        int prevNumDp = dp[num][j];
                        for (int p = 0; p < i; p++) {
                            if (nums[p] != nums[i]) {
                                dp[num][j] = Math.max(dp[num][j], dp[nums[p]][j-1] + 1);
                            } else {
                                dp[num][j] = Math.max(dp[num][j], prevNumDp+1);
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}








class Solution7 {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> num2id = new HashMap<>();
        int id = 0;
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = num2id.get(nums[i]);
        // System.out.println(Arrays.toString(nums));


        int[][] dp = new int[id][k+1];
        for (int num : nums) {
            for (int j = 0; j < k+1; j++) {
                int prevNumDp = dp[num][j];

                // add a new part
                for (int prev : nums) {
                    if (j > 0) {
                        if (num != prev) dp[num][j] = Math.max(dp[num][j], dp[prev][j-1] + 1);
                        else dp[num][j] = Math.max(dp[num][j], prevNumDp + 1);
                    }
                }

                // don't add a new part
                dp[num][j] = Math.max(dp[num][j], prevNumDp+1);

                System.out.println(num + ", " + j + ": " + dp[num][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}

class Solution6 {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Integer> num2id = new HashMap<>();
        int id = 0;
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = num2id.get(nums[i]);
        System.out.println(Arrays.toString(nums));


        int[][] dp = new int[id][k+1];
        for (int num : nums) {
            for (int j = 0; j < k+1; j++) {
                // don't add a new part
                dp[num][j] = Math.max(dp[num][j], dp[num][j]+1);
                // add a new part
                for (int prev : nums) {
                    if (j > 0 && prev != num) dp[num][j] = Math.max(dp[num][j], dp[prev][j-1] + 1);
                }
                // System.out.println(num + ", " + j + ": " + dp[num][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}



class Solution5 { // 关于p的for loop有跟值域相关的requirement
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // nums的unique vals不多，可以discretization
        int id = 0;
        Map<Integer,Integer> num2id= new HashMap<>();
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }
        for (int i = 0; i < n; i++) nums[i] = num2id.get(nums[i]);

        // System.out.println(Arrays.toString(nums));

        int[][] dp = new int[id][k+1];
        int[] colMax = new int[k+1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int[] curDp = new int[k+1];
            for (int j = 0; j < k+1; j++) {
                if (i == 0) {
                    curDp[j] = 1;
                } else {
                    // dp[num][j] = Math.max(1, dp[num][j]+1, dp[x][j-1]+1 for all x != num);
                    if (j == 0) {
                        curDp[j] = dp[num][j] + 1;
                    } else {
                        int prevMax = colMax[j-1];
                        curDp[j] = Math.max(dp[num][j]+1, prevMax+1);
                    }
                }
            }
            for (int j = 0; j < k+1; j++) {
                dp[num][j] = curDp[j];
                colMax[j] = Math.max(colMax[j], dp[num][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) res = Math.max(res, dp[i][k]);
        return res;

        // int n = nums.length;
        // int[][] dp = new int[n][k+1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < k+1; j++) {
        //         if (i == 0) {
        //             dp[i][j] = 1;
        //         } else {
        //             dp[i][j] = 1;
        //             for (int p = 0; p < i; p++) {
        //                 if (nums[i] == nums[p]) {
        //                     dp[i][j] = Math.max(dp[i][j], dp[p][j]+1);
        //                 } else {
        //                     if (j >= 1) dp[i][j] = Math.max(dp[i][j], dp[p][j-1]+1);
        //                 }
        //             }
        //         }
        //     }
        // }
        // int res = 0;
        // for (int i = 0; i < n; i++) res = Math.max(res, dp[i][k]);
        // return res;
    }
}



// dp[i][j]: 以index i为end的subarray，最大k个inequality budget的max length
class Solution4 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k+1; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1;
                    for (int p = 0; p < i; p++) {
                        if (nums[i] == nums[p]) {
                            dp[i][j] = Math.max(dp[i][j], dp[p][j]+1);
                        } else if (j >= 1) {
                            dp[i][j] = Math.max(dp[i][j], dp[p][j-1]+1);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}


// dp[x][j]: 以value x为end的subsequence，最多有j个pairs的，max length
// x---离散化
// 转移方程：
// dp[x][j]
// 不选，dp[x][j]不变
// 选，不attach在任何后面：1
// 选，跟在不一样的后面: dp[x][j] + 1 --- [38,40,38,40] issue
// 选，跟在一样的后面：dp[y][j-1] + 1
// 需要在开头定义一个prev

// TBD：DP优化
class Solution3 {
    public int maximumLength(int[] nums, int k) {
        // 离散化
        int n = nums.length;
        int id = 0;
        Map<Integer, Integer> num2id = new HashMap<>();
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = num2id.get(nums[i]);
        }

        // 定义以值域为state的dp: 以id为end的，最多pair数为k的longest length
        int[][] dp = new int[id][k+1];
        int[] rangeMax = new int[k+1];

        // 跟LIS一样遍历
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 跟at most 01背包一样遍历
            int[] curDp = new int[k+1];
            for (int j = 0; j < k+1; j++) {
                if (i == 0) {
                    curDp[j] = 1;
                    rangeMax[j] = 1;
                } else {
                    // int prevMax = 0;
                    // for (int p = 0; p < i; p++) {
                    //     // if (nums[p] != num) {
                    //         if (j >= 1) prevMax = Math.max(prevMax, dp[nums[p]][j-1]);
                    //     // }
                    // }
                    int prevMax = (j >= 1) ? rangeMax[j-1] : 0;
                    curDp[j] = Math.max(dp[num][j]+1, prevMax+1);
                }

            }
            for (int j = 0; j < k+1; j++) dp[num][j] = curDp[j];
            if (i == 0) {
                for (int j = 0; j < k+1; j++) rangeMax[j] = 1;
            } else {
                for (int j = 0; j < k+1; j++) rangeMax[j] = Math.max(rangeMax[j], curDp[j]);
            }
        }
        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}


class Solution2 {
    public int maximumLength(int[] nums, int k) {
        // 离散化
        int n = nums.length;
        int id = 0;
        Map<Integer, Integer> num2id = new HashMap<>();
        for (int num : nums) {
            if (!num2id.containsKey(num)) num2id.put(num, id++);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = num2id.get(nums[i]);
        }

        // 定义以值域为state的dp: 以id为end的，最多pair数为k的longest length
        int[][] dp = new int[id][k+1];
        Set<Integer> visited = new HashSet<>();

        // 跟LIS一样遍历
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 跟at most 01背包一样遍历
            for (int j = 0; j < k+1; j++) {
                if (i == 0) {
                    dp[num][j] = 1;
                } else {
                    int prev = dp[num][j];
                    // 以该num结尾至少是1:注意这里num，j可能出现过，所以要跟1取max
                    dp[num][j] = Math.max(1, prev);
                    // 如果按下面的iteration遍历，会有[38,40,38,40] issue：
                    // 如果dp[p][j-1]+1已经让dp[num][j]变大了，
                    // 之后又因为前面出现过num，dp[num][j]会自增1，所以会出现dp[num][j]同时用了前面两个states的增大。
                    // [38,40,38,40] issue：
                    // for (int p : visited) {
                    //     if (p == num) dp[num][j] = Math.max(dp[num][j], dp[p][j]+1);
                    //     else if (j >= 1) dp[num][j] = Math.max(dp[num][j], dp[p][j-1]+1);
                    // }
                    // [38,40,38,40] solution： --- 在开头就定义一个prev
                    for (int p : visited) { // try to attach num to previously visited num的后面
                        if (p == num) {
                            dp[num][j] = Math.max(dp[num][j], prev+1);
                        } else {
                            if (j >= 1) dp[num][j] = Math.max(dp[num][j], dp[p][j-1]+1);
                        }
                    }
                }
            }
            visited.add(num);
        }
        int res = 0;
        for (int i = 0; i < id; i++) res = Math.max(res, dp[i][k]);
        return res;
    }
}

class Solution1 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // int[][] dp = new int[n][k+1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < k+1; j++) {
        //         if (i == 0) {
        //             dp[i][j] = 1;
        //         } else {
        //             dp[i][j] = 1; // LIS类型：不attach到任何subseq后面
        //             for (int p = 0; p < i; p++) { // 尽量attach到subseq后面
        //                 if (nums[i] == nums[p]) dp[i][j] = Math.max(dp[i][j], dp[p][j] + 1);
        //                 if (j >= 1) dp[i][j] = Math.max(dp[i][j], dp[p][j-1]+1);
        //             }
        //         }
        //     }
        // }
        // int res = 0;
        // for (int i = 0; i < n; i++) res = Math.max(res, dp[i][k]);
        // return res;

        int[][] dp = new int[k+1][n];
        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1; // LIS类型：不attach到任何subseq后面

                    for (int p = 0; p < j; p++) { // 尽量attach到subseq后面
                        if (nums[j] == nums[p]) dp[i][j] = Math.max(dp[i][j], dp[i][p]+1);
                        if (i >= 1) dp[i][j] = Math.max(dp[i][j], dp[i-1][p]+1);
                    }
                }
            }
        }
        int res = 0;
        for (int r : dp[k]) res = Math.max(res, r);
        return res;
    }
}


class Solution000 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k+1][n];

        SegmentTree prevSt = new SegmentTree(n);

        for (int i = 0; i < k+1; i++) {
            SegmentTree curSt = new SegmentTree(n);
            Map<Integer,Integer> num2dpmax = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int num = nums[j];
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1;
                    // for (int p = 0; p < j; p++) {
                    //     if (nums[j] == nums[p]) { // hashmap optimization
                    //         dp[i][j] = Math.max(dp[i][j], dp[i][p]+1);
                    //     }

                    //     if (i >= 1) dp[i][j] = Math.max(dp[i][j], dp[i-1][p]+1); // segment tree optimization
                    // }

                    dp[i][j] = Math.max(dp[i][j], num2dpmax.getOrDefault(num,0)+1);
                    if (i >= 1) dp[i][j] = Math.max(dp[i][j], prevSt.queryMax(0, j-1) + 1);
                }
                curSt.update(j, dp[i][j]);
                num2dpmax.put(num, Math.max(dp[i][j], num2dpmax.getOrDefault(num,0)));
            }
            prevSt = curSt;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            res = Math.max(res, dp[k][j]);
        }
        return res;
    }

    class SegmentTree {
        Node root;
        public SegmentTree(int n) {
            root = new Node(0, n);
        }

        public int queryMax(int s, int e) {
            return queryHelper(root, s, e);
        }

        private int queryHelper(Node node, int s, int e) {
            if (node == null) return 0;
            if (s <= node.start && node.end <= e) return node.val;
            if (s > node.end || e < node.start) return 0;
            return Math.max(queryHelper(node.left, s, e), queryHelper(node.right, s, e));
        }

        public void update(int ind, int val) {
            updateHelper(root, ind, val);
        }

        private void updateHelper(Node node, int ind, int val) {
            if (node.start == ind && node.end == ind) {
                node.val = val;
                return;
            }

            int mid = (node.start + node.end) / 2;
            if (ind <= mid) {
                if (node.left == null) node.left = new Node(node.start, mid);
                updateHelper(node.left, ind, val);
                node.val = (node.right==null) ? node.left.val : Math.max(node.left.val, node.right.val);
            } else {
                if (node.right == null) node.right = new Node(mid+1, node.end);
                updateHelper(node.right, ind, val);
                node.val = (node.left==null) ? node.right.val : Math.max(node.left.val, node.right.val);
            }
        }
    }

    class Node {
        int start, end, val;
        Node left, right;
        public Node(int s, int e) {
            start = s;
            end = e;
        }
    }
}