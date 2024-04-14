import java.util.AbstractList;
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ret;
            ArrayList<Integer> curr;

            void init() {
                if (ret != null) {
                    return;
                }
                ret = new LinkedList<>();
                curr = new ArrayList<>();
                Arrays.sort(candidates);
                rec(candidates, 0, target);
            }

            void rec(int[] candidates, int idx, int target) {
                if (target == 0) {
                    ret.add(new ArrayList<>(curr));
                    return;
                }
                for (int i = idx; i < candidates.length; i++) {
                    if (i > idx && candidates[i] == candidates[i - 1]) {
                        continue;
                    }
                    int num = candidates[i];
                    if (num > target) {
                        return;
                    }
                    curr.add(num);
                    rec(candidates, i + 1, target - num);
                    curr.remove(curr.size() - 1);
                }
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return ret.get(index);
            }

            @Override
            public int size() {
                init();
                return ret.size();
            }
        };
    }
}