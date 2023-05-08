//aufgabe 3
@FunctionalInterface
public interface Pred2D {
    boolean test(double x, double y);
    //3b
    public static Pred2D inCircle(double r){
        return (x,y) -> {
            if(Math.sqrt(x*x + y*y) < r)return true;
            return false;
        };
    }
    //3c
    default Pred2D and(Pred2D...ps){
        return(x,y)-> {
            boolean result = this.test(x,y);
            for (Pred2D pr : ps){
                result = result && pr.test(x,y);
            }
            return result;
        };
    }


}
