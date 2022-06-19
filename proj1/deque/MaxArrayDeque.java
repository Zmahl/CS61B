package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comparator;

    //Public getter that creates an instance of comparator
    public MaxArrayDeque(Comparator<T> c){
        this.comparator = c;
    }

    public T max() {
        if (comparator == null){
            return null;
        }

        return max(this.comparator);
    }

    public T max(Comparator<T> c){
        T max = get(0);
        for (int i = 1; i < size(); ++i){
            if (c.compare(max, get(i)) < 0){
                max = get(i);
            }
        }
        return max;
    }

}
