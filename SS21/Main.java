public class Main {


    public static  void main(String... args){
        Triple<Integer> t1 = new Triple<>(5,2,8);
        t1.setFirst(1);
        Triple<String> t2 = new Triple<>("A", "B", "C");
        Triple<Object> t3 = new Triple<>(null, "X", 8);
        t3.setFirst(t2.getFirst());

        VecT op = x ->{
            VecT [] t = new VecT[2];
            t[0] = Vec::norm; // oder c -> c.norm
            t[1] =  c -> new Vec(c.getX()+1, c.getY());
            x = VecT.add(t).andInvert().trans(x);
            return x;
        };

    }
}
