class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> lastIndexByChar = new HashMap<>();
        List<Integer> p = new ArrayList<>();

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(lastIndexByChar.containsKey(c)) {
                lastIndexByChar.replace(c, i);
            } else {
                lastIndexByChar.put(c, i);
            }
        }
        
        int i = 0;
        while (i < S.length()) {
            int end = lastIndexByChar.get(S.charAt(i));
            int max = end;
            for(int j = i + 1; j < end; j++){
                int last = lastIndexByChar.get(S.charAt(j));
                max = Math.max(last, max);
                end = Math.max(last, end);
            }
            p.add(max - i + 1);
            i = max + 1;
        }
        return p;
    }
}