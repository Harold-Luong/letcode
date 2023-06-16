
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediumLeetCode {
    /**
     * 
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int l = candidates.length;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> listResult = new ArrayList<>();
        if (l == 0 || (l == 1 && candidates[0] == target)) {
            list.add(target);
            listResult.add(list);

            return (l != 0) ? listResult : new ArrayList<>(new ArrayList<>());
        } else {
            for (int i = 0; i < l; i++) {
                if (candidates[i] <= target) {

                    list.add(candidates[i]);
                }
            }
            listResult.add(list);

        }
        return listResult;

    }

    public static void backTrack(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {

        }

    }

    public static void main(String[] args) {
        int[] candidates = { 1, 3, 5, 7 };
        int target = 4;
        // [3,1] ,[1,1,1,1]
        System.out.println(combinationSum(candidates, target));
    }
}
