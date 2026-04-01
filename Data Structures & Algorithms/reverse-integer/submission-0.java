class Solution {
    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int digit = x % 10;

            // overflow check
            if (answer > Integer.MAX_VALUE/10 || 
               (answer == Integer.MAX_VALUE/10 && digit > 7))
                return 0;

            if (answer < Integer.MIN_VALUE/10 || 
               (answer == Integer.MIN_VALUE/10 && digit < -8))
                return 0;

            answer = answer * 10 + digit;
            x /= 10;
        }

        return answer;
    }
}