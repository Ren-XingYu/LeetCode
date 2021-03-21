package x.y.z;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_0046 {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return result;
    }

    public void backtrack(LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(track, nums);
            track.removeLast();
        }
    }
}
