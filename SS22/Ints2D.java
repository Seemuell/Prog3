@FunctionalInterface
public interface Ints2D {
    public double eval(int [] i);
    public static Ints2D avg(){
        return x -> {
            int sum = 0;
            for(int i = 0; i < x.length; i++){
               sum = sum + x[i];
            }
            return (double)sum/ x.length;
        };
    }
    default Ints2D sqr(int a){
        return x -> {
            for(int i = 0; i < x.length; i ++){
                x[i] = x[i]*x[i];
            }
            return this.eval(x);
        };
    }
}
