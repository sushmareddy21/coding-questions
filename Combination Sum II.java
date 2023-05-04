class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        comb(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    void comb(int start,int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){

        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        else if(target < 0){
            return;
        }

        if(start < candidates.length){

            if((candidates[start] > target)) return;
            ds.add(candidates[start]);
            comb(start + 1, candidates, target - candidates[start], res, ds);
            ds.remove(ds.size()-1);

            //skipping the duplicates in the second recursive call
            while((start < candidates.length - 1) && 
            candidates[start] == candidates[start + 1]){
                start++;
            }
            
            comb(start + 1, candidates, target, res, ds);
        }
    }
}
