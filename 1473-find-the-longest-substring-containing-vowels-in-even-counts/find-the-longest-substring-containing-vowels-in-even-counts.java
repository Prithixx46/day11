class Solution {
    public int findTheLongestSubstring(String s) {
        int[] first = new int[32];
        java.util.Arrays.fill(first, -2);
        first[0] = -1;

        int mask = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') mask ^= 1;
            else if (c == 'e') mask ^= 2;
            else if (c == 'i') mask ^= 4;
            else if (c == 'o') mask ^= 8;
            else if (c == 'u') mask ^= 16;

            if (first[mask] != -2) {
                maxLen = Math.max(maxLen, i - first[mask]);
            } else {
                first[mask] = i;
            }
        }

        return maxLen;
    }
}