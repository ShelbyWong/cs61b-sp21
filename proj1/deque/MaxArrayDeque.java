package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private final Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }

    public T max(Comparator<T> c){
        if (isEmpty())return null;
        int index=0;
        for (int i = 1; i < size(); i++) {
            if (c.compare(get(i),get(index))>0)index=i;
        }
        return get(index);
    }

    public T max(){
        return max(comparator);
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o==null)return false;
//        if (!(o instanceof MaxArrayDeque))return false;
//        if (((MaxArrayDeque<T>)o).max()!=max()) {
//            return false;
//        }
//        return super.equals(o);
//    }


}
