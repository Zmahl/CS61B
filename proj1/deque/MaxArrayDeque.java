package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }

    /**
     * returns the max element in the deque of the comparator.
     * Returns empty if null
     */
    public T max() {
        if (comparator == null){
            return null;
        }
        return max(this.comparator);
    }

    public T max(Comparator<T> c) {
        T max = get(0);
        for (int i = 0; i < size(); ++i){
            if (c.compare(max, get(i)) < 0){
                max = get(i);
            }
        }
        return max;
    }

}
