import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 127. Word Ladder
/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord)==-1) return 0;
        HashSet<String> set = new HashSet<>();
        for(String str:wordList) set.add(str);

        // start BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0;k<size;k++) {
                String curStr = queue.poll();
                if(curStr.equals(endWord)) {
                    return level;
                }
                char[] chars = curStr.toCharArray();
                for(int i=0;i<chars.length;i++) {
                    char originalChar = chars[i];
                    for(char c='a';c<='z';c++) {
                        if(c==originalChar) continue;
                        chars[i] = c;
                        String newStr = new String(chars);
                        if(set.contains(newStr)) {
                            queue.offer(newStr);
                            set.remove(newStr); // key point!
                        }
                    }
                    chars[i] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
