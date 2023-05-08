import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
//aufgabe 2
public class Bag <T> {
    private T[] xs;

    public Bag(T...xs){
        this.xs = xs;

    }
    //2e
    public static <S extends Comparable<S>> Bag<S>sortedBag(S[] xs){
        return new Bag();
    }
    //2f
    public void addToList(List<? super T > l){
        for (T x : xs){
            l.add(x);
        }
    }
    //2g
    public T pickMax(Predicate<T> p, Comparator<T> c){
        T maxItem = null;
        for(int i = 0; i < xs.length; i++){
            if(maxItem == null)maxItem = xs[i];
            if(p.test(xs[i]) && c.compare(maxItem , xs[i]) <0)maxItem = xs[i];
        }
        return maxItem;
    }
}
