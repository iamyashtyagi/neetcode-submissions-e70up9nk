class DynamicArray {
    Map<Integer,Integer> map;
    Integer capacity;
    Integer index;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.index = 0;
    }

    public int get(int i) {
        return map.get(i);
    }

    public void set(int i, int n) {
        map.put(i,n);
    }

    public void pushback(int n) {
        map.put(index,n);
        index++;
        if(index>capacity){
            capacity*=2;
        }
    }

    public int popback() {
        index--;
        return map.get(index);
    }

    private void resize() {
        capacity *=2;
    }

    public int getSize() {
        return index;
    }

    public int getCapacity() {
        return capacity;
    }
}
