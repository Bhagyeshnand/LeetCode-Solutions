class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        gensum(1, 0, k, new ArrayList<>(), 0, n);
        return list;
    }

    private void gensum(int i, int idx, int len, List<Integer> temp, int sum, int target) {
        if (temp.size() == len && sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target || i > 9) return;
        temp.add(i);
        gensum(i + 1, idx + 1, len, temp, sum + i, target);
        temp.remove(temp.size() - 1);
        gensum(i + 1, idx, len, temp, sum, target);
    }
}