@FunctionalInterface
public interface StringTrafo {
    public String transform(String s);

    public static StringTrafo appender(String x){
        return c-> { String s = c + x;
                    return s;
        };
    }
    public default  StringTrafo repeat(int n) {
        return x -> {
            for (int i = 0; i < n; i++) {
                x = this.transform(x);
            }
            return x;
        };
    }


}
