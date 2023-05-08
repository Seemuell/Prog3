import java.util.Comparator;

public class Triple <T> {
    private T first;
    private T second;
    private T third;

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public void setFirst(T first){
        this.first = first;
    }
    public T getFirst(){
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }
    public static  <T extends Comparable<T>> Triple <T> createSorted(T first, T second, T third){
       return new Triple<T>(first, second, third);
    }
    public static <T> void copy(Triple<? extends T> from, Triple<? super T>to){

    }
    public boolean isSorted(Comparator<T> c){
        if(c.compare(first,second)> 0)return false;
        if(c.compare(second,third)> 0) return false;
        return true;
    }
}
