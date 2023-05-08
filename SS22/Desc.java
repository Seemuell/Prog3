import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class Desc<T extends Comparable<T>> implements Comparable<Desc<T>> {
   private T val;
   private String desc;


    public Desc(T val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    @Override
    public int compareTo(Desc<T> o) {
        int result = this.val.compareTo(o.getVal());
        if(result == 0){
            result = this.desc.compareTo(o.getDesc());
        }
        return result;

    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public static <T extends Comparable<T>> void swapItems(Desc<T> d1, Desc <T> d2){
        T temp = d1.getVal();
        d1.setVal(d2.getVal());
        d2.setVal(temp);
    }
    public static List<Desc<Integer>> withoutEmpty(List<Desc<Integer>> l){
        return l.stream()
                .filter( s -> !(s.getDesc() == null|| s.getDesc().isEmpty()))
                .sorted()
                .collect(Collectors.toList());
    }

    public static double avgLengthofStrings(Object[] xs){
        return Arrays.stream(xs)
                .filter(x -> x instanceof String)
                .mapToDouble(x -> ((String) x).length())
                .average()
                .orElse(-1);
    }

    public static Map<Integer, List<Integer>> remainderClasses(List<Integer> xs, int d){
        return xs.stream()
                .filter(x -> x >=  0)
                .collect(Collectors.groupingBy(x -> x%d));
    }

    public static DoubleStream randomWalk(double bound){
        return DoubleStream
                .iterate(0.0, x-> x+ (Math.random()*2-1))
                .takeWhile(x -> x>bound);

    }

    



}
