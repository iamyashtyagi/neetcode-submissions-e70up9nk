class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        createPalindrome(s, 0, 0, "", new ArrayList<>(), result);
        return result;
    }

    private void createPalindrome(String s,
                                  int index,
                                  int considered,
                                  String current,
                                  List<String> temp,
                                  List<List<String>> result) {

        if (index == s.length()) {
            if (considered == s.length()) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        char ch = s.charAt(index);

        // extend current substring
        String next = current + ch;

        // if palindrome, take it
        if (isPalindrome(next)) {
            temp.add(next);
            createPalindrome(
                    s,
                    index + 1,
                    considered + next.length(),
                    "",
                    temp,
                    result
            );
            temp.remove(temp.size() - 1);
        }

        // continue building current
        createPalindrome(
                s,
                index + 1,
                considered,
                next,
                temp,
                result
        );
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}