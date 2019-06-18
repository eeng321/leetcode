class Solution(object):
    def findAndReplacePattern(self, words, pattern):
        """
        :type words: List[str]
        :type pattern: str
        :rtype: List[str]
        """
        output = []
        for word in words:
            match = True
            pdic = {}
            wdic = {}
            for i in range(len(pattern)):
                if not pdic.has_key(pattern[i]) and not wdic.has_key(word[i]):
                    pdic[pattern[i]] = word[i]
                    wdic[word[i]] = pattern[i]
                else:
                    if not word[i] == pdic.get(pattern[i]):
                        match = False
                        break
                        
            if match:
                output.append(word)
            else:
                match = True
        return output