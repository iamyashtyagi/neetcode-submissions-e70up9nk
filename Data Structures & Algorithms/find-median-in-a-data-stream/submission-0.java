class MedianFinder {

    private final PriorityQueue<Integer> left;   // max-heap (lower half)
    private final PriorityQueue<Integer> right;  // min-heap (upper half)

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size() + 1) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        int ls = left.size();
        int rs = right.size();
        if (ls == 0 && rs == 0) {
            throw new NoSuchElementException("No elements present");
        }
        if (ls == rs) {
            // cast to double to avoid integer division
            return (left.peek().doubleValue() + right.peek().doubleValue()) / 2.0;
        } else if (ls > rs) {
            return left.peek();
        } else {
            return right.peek();
        }
    }
}
