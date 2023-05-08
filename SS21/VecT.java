@FunctionalInterface
public interface VecT {
    public Vec trans (Vec s);
    public static VecT add(VecT [] ts) {
        return x -> {
            Vec res = new Vec(0, 0);
            for (VecT vecT : ts) {
                res = res.add(vecT.trans(x));
            }
            return res;
        };

    }
    default VecT andInvert(){
        return x -> { x = this.trans(x);
                    x = x.invert();
                    return x;

        };

    }

}
