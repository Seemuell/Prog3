import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Vec {
  private double x;
  private double y;

    public Vec(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getMag(){
        return Math.sqrt((x*x) + (y*y));
    }
    public Vec norm(){
        return new Vec(x/getMag(),y/getMag());
    }
    public Vec add(Vec o){
         return new Vec(this.x + o.getX(),this.y + o.getY());
    }
    public Vec invert(){
        return new Vec(y,x);
    }

    //Streams
    public static double sumOfLargerThan(List<Vec> vs, double min){
        return vs.stream()
                .filter(x->x.getMag()>= min)
                .mapToDouble(x->x.getMag())
                .sum();
    }
    public static Map<Integer, List<Triple<Integer>>> groupByFirst(List<Triple<Integer>> triples){
        return  triples.stream()
                .collect(Collectors.groupingBy(x-> x.getFirst()));

    }
    public static Vec[] longerVecs(Vec v, int n, double dx, double dy){
        return (Vec[]) Stream
                .iterate(v, x -> new Vec(x.getX()+dx,x.getY()+dy))
                .limit(n)
                .toArray();
    }




}
