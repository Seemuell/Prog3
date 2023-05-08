import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MAin {

    public static void main(String...args){
        Bag<String> rick = new Bag<>("Never", "gonna", "give", "you", "up");
         List<Object> rollList = new ArrayList<>();
         rick.addToList(rollList);
         //3d
         Pred2D f = Pred2D.inCircle(1).and((x,y)-> {return x > 0;});
         System.out.println(f.test(0.2,0.2));
    }
    //4a
    public static long sumsumLentgh(List<String> l){
        return l.stream()
                .filter( x -> x != null)
                .mapToLong(x -> x.length())
                .sum();
    }
    //4b
    public static double avarege(List<RealFunction> fs, double x){
        return fs.stream()
                .mapToDouble(f -> f.apply(x))
                .average()
                .orElseThrow(() ->new IllegalArgumentException());

    }
    //4c
    public static DiscountItem maxDiscountItem(List<Item> items){
        return items.stream()
                .filter(x -> x instanceof DiscountItem)
                .map(x-> (DiscountItem)x)
                .max((x,y) -> Integer.compare(x.getDiscount(),y.getDiscount()))
                .orElse( null);

    }
    //5
    public void fill(int [] result, int start, int amount){
        //Dummy Methode

    }
    public void fillParallel(int [] result, int n){
        int l = result.length;
        int k = l/n;
        Thread [] threads = new Thread[n];
        for(int i = 0; i< n; i++){
            int j = i*k;
            threads[i] =  new Thread(() -> fill(result,j,k));
            threads[i].start();

        }
        for(Thread t :threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ;

    }

}
