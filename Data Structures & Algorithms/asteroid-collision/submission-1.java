
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();
        for (int asteroid : asteroids) {
            if (st.isEmpty() || (st.peek() < 0 && asteroid > 0) || (st.peek() * asteroid > 0)) {
                st.push(asteroid);
            } else {
                // only collide while top > 0 and current < 0
                while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                    if (st.peek() < -asteroid) {
                        st.pop();                 // top explodes; keep checking
                    } else if (st.peek() == -asteroid) {
                        st.pop();                 // both explode
                        asteroid = 0;
                        break;                    // <- important
                    } else {
                        asteroid = 0;             // current explodes
                        break;
                    }
                }
                if (asteroid != 0) {              // survived after popping / no more collisions
                    st.push(asteroid);
                }
            }
        }
        return st.stream().mapToInt(i -> i).toArray();
    }
}
