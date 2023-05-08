import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fraction {
    private int nom;
    private int denom;

    public Fraction(int nom, int denom) {
        this.nom = nom;
        this.denom = denom;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }
    public double asDouble(){
        return (double)nom/denom;
    }
    public Fraction normalized(){
        return new Fraction(1,3);
    }

    public static  int countDifferentDenoms(List<Fraction> xs){
        return xs.stream()
                .map( x -> x.normalized())
                .mapToInt(x -> x.getDenom())
                .distinct()
                .sum();
    }
    public static int[] everyOther(int [] xs){
        return IntStream
                .range(0,xs.length/2)
                .map(x-> xs[x*2])
                .toArray();

    }
    public static Map<Integer,List<Task>> groupByPriority(TodoList<? extends Task> tl, int minPrio){
        return tl.getList().stream()
                .filter( x -> x.getPriority() >= minPrio)
                .collect(Collectors.groupingBy(x -> x.getPriority()));
    }
    public static Stream<Fraction> factorialFractions(double min){
        return Stream
                .iterate(new Fraction(1,1), x -> new Fraction(x.getNom()+1, x.getDenom()* (x.getDenom()+1)))
                .takeWhile( x -> x.asDouble() > min);
    }



}
