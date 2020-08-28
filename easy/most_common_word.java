class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for(String word: banned) {
            if (!words.containsKey(word)) {
                words.put(word, -1);
            }
        }

        Integer highestCount = 0;
        String mostCommon = new String();
        String[] paragraphArray = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" "); 
        for(String word: paragraphArray) {
            // check for spaces (could have chains of spaces if multiple digits or commas were replaced consecutively)
            if(!word.isBlank()) {
                if(!words.containsKey(word)) {
                    words.put(word, 1);
                } else {
                    if(words.get(word) != -1) {
                        words.put(word, words.get(word) + 1);
                    }
                }
                
                if(words.get(word) > highestCount) {
                    highestCount = words.get(word);
                    mostCommon = word;
                }
            }
        }
        return mostCommon;
    }
}