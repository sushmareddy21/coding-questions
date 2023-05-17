class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        partitionRecursion(s, 0, res, ls);
        return res;
    }

    public void partitionRecursion(String s, int index, List<List<String>> res, List<String> ls){

        if(index == s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(palindrome(s, index, i)){
                ls.add(s.substring(index, i + 1));
                partitionRecursion(s, i + 1, res, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public boolean palindrome(String str, int s, int e){
        while(s <= e){
            if(str.charAt(s++)!= str.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}
