import java.util.AbstractList;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ret;
            List<Integer> list;
            @Override
            public List<Integer> get(int index) {
                if (ret == null) {
                    init();
                }
                return ret.get(index);
            }

            void init() {
                ret = new ArrayList<>();
                list = new ArrayList<>();
                Arrays.sort(candidates);
                rec(0, candidates, target);
            }
            void rec(int start, int[] candidates, int target) {
                if (target == 0) {
                    ret.add(new ArrayList<>(list));
                    return;
                }

                for (int i = start; i < candidates.length; i++) {
                    if (candidates[i] > target) {
                        break;
                    }
                    list.add(candidates[i]);
                    rec(i, candidates, target - candidates[i]);
                    list.remove(list.size() - 1);
                }
            }
            @Override
            public int size() {
                if (ret == null) {
                    init();
                }
                return ret.size();
            }
        };
    }
}