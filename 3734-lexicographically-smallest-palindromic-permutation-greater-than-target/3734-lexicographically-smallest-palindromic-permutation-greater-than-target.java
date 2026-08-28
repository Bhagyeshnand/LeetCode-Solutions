class Solution {
    public String lexPalindromicPermutation(
        String s,
        String target
    ) {
        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                if (!middle.isEmpty()) {
                    return "";
                }

                middle = String.valueOf(
                    (char)('a' + i)
                );
            }

            freq[i] /= 2;
        }

        int halfLen = n / 2;

        StringBuilder half =
            new StringBuilder();

        int matched = 0;

        while (matched < halfLen) {
            int c =
                target.charAt(matched) - 'a';

            if (freq[c] == 0) {
                break;
            }

            freq[c]--;
            half.append((char)('a' + c));
            matched++;
        }

        int i = matched;

        while (i >= 0) {
            if (i < halfLen) {
                int start =
                    target.charAt(i) - 'a' + 1;

                for (int c = start; c < 26; c++) {
                    if (freq[c] == 0) {
                        continue;
                    }

                    freq[c]--;

                    StringBuilder suffix = new StringBuilder();

                    for (int j = 0; j < 26; j++) {
                        for (int x = 0; x < freq[j]; x++) {
                            suffix.append((char)('a' + j));
                        }
                    }

                    String left = half.substring(0, i) + (char)('a' + c) + suffix;

                    String candidate = left + middle + new StringBuilder(left).reverse().toString();

                    if (candidate.compareTo(target) > 0) {
                        return candidate;
                    }

                    freq[c]++;
                }
            }

            if (i == halfLen) {
                String left = half.toString();

                String candidate = left + middle + new StringBuilder(left).reverse().toString();

                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }
            }

            i--;

            if (i >= 0) {
                int c = half.charAt(i) - 'a';
                freq[c]++;
                half.deleteCharAt(half.length() - 1);
            }
        }

        return "";
    }
}