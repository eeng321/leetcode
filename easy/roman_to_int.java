class Solution {
    public int romanToInt(String s) {
        // create map for romanToInt
        // use pointer for 2 roman chars at a time
        // if 2nd char is bigger in value then add (2nd - 1st)
        // else only add 1st to sum
        // move pointers over by 1
        int len = s.length();
        if(s == null || len == 0) return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>()
        {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int sum = 0;
        for(int i = 0; i<len; i++){
            int j = i+1;
            int a = map.get(s.charAt(i));
            if(j < len){
                int b = map.get(s.charAt(j));
                if(b > a){
                    // count both roman characters as one
                    sum += b-a;
                    i++;
                    continue;
                }
            }
            sum += a;
        }
        return sum;
    }
}