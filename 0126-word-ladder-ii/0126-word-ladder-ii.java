import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return new AbstractList<List<String>>() {
            private List<List<String>> resList;
            private void onload() {
                resList = new ArrayList<>();
                Set<String> wordSet = new HashSet<>(wordList);
                if (!wordSet.contains(endWord)) {
                    return;
                }
                Map<String, Set<String>> map = new HashMap<>();
                boolean flag = false;
                Set<String> currLevel = new HashSet<>();
                currLevel.add(beginWord);
                while (!currLevel.isEmpty() && !flag) {
                    wordSet.removeAll(currLevel); // Remove the used words
                    Set<String> nextLevel = new HashSet<>();
                    for (String currWord : currLevel) {
                        for (String nextWord : generate(currWord, wordSet)) {
                            if (nextWord.equals(endWord)) {
                                flag = true;
                            }
                            map.putIfAbsent(nextWord, new HashSet<>());
                            map.get(nextWord).add(currWord);
                            nextLevel.add(nextWord);
                        }
                    }
                    currLevel = nextLevel;
                }
                if (flag) { // There is path from beginWord to endWord
                    helper(endWord, map, new ArrayList<>());
                }
                return;
            }

            private List<String> generate(String currWord, Set<String> wordSet) {
                List<String> arr = new ArrayList<>();
                char[] chArr = currWord.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char old = chArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        chArr[i] = ch;
                        String nextWord = new String(chArr);
                        if (wordSet.contains(nextWord)) {
                            arr.add(nextWord);
                            ;
                        }
                    }
                    chArr[i] = old;
                }
                return arr;
            }

            private void helper(String currWord, Map<String, Set<String>> map, List<String> path) {
                path.add(currWord);
                if (currWord.equals(beginWord)) {
                    resList.add(new ArrayList<>(path).reversed());
                    path.remove(path.size() - 1);
                    return;
                }
                for (String prevWord : map.get(currWord)) {
                    helper(prevWord, map, path);
                }

                path.remove(path.size() - 1);
            }

            private void init() {
                if (null == resList) {
                    onload();
                    System.gc();
                }
            }

            @Override
            public List<String> get(int index) {
                init();
                return resList.get(index);
            }

            @Override
            public int size() {
                init();
                return resList.size();
            }

        };
    }
}