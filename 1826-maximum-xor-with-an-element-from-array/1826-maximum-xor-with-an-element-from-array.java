class Solution {
 class TrieNode {
        TrieNode nums[] = new TrieNode[2];
        int prefixValue;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int queriesLength = queries.length;
        int[] ans = new int[queriesLength];
        int[][] temp = new int[queriesLength][3];
        for (int i = 0; i < queriesLength; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }

        Arrays.sort(temp, (a, b) -> {
            return a[1] - b[1];
        });
        int index = 0;
        Arrays.sort(nums);
        TrieNode root = new TrieNode();

        for (int query[] : temp) {
            while (index < nums.length && nums[index] <= query[1]) {
                insert(root, nums[index]);
                index++;
            }
            int tempAns = -1;
            if (index != 0) {
                tempAns = search(root, query[0]);
            }
            ans[query[2]] = tempAns;
        }

        return ans;
    }

    public void insert(TrieNode root, int n) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (node.nums[bit] == null) {
                node.nums[bit] = new TrieNode();
            }
            node = node.nums[bit];
        }
        node.prefixValue = n;
    }

    public int search(TrieNode root, int n) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            int requiredBit = bit == 1 ? 0 : 1;
            if (node.nums[requiredBit] != null) {
                node = node.nums[requiredBit];
            } else {
                node = node.nums[bit];
            }
        }
        return node.prefixValue ^ n;
    }
}