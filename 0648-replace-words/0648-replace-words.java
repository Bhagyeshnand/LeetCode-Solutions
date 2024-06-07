class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
         return Arrays.stream(sentence.split(" "))
                .map(word -> dictionary.stream()
                                       .filter(word::startsWith)
                                       .min(Comparator.comparingInt(String::length))
                                       .orElse(word))
                .collect(Collectors.joining(" "));
    }
}