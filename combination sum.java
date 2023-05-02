class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combi(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

  private void combi(int start,int[] candidates, int target, List<Integer> currList, List<List<Integer>> res){
       if(target == 0){
           res.add(new ArrayList<>(currList));
           return;
       }
       else if(target < 0){
           return;
       }

        if(start < candidates.length){
        currList.add(candidates[start]); 
        System.out.println(start);   
        combi(start, candidates, target - candidates[start], currList, res);
        currList.remove(currList.size()-1);
        combi(start + 1, candidates, target, currList, res);
        }
    }
}
