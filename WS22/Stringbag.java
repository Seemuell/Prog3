public class Stringbag {
private String [] xs;
    public Stringbag(String[] xs) {
        if (xs == null )throw new IllegalArgumentException();
        for(String s : xs){
            if(s == null) throw new IllegalArgumentException();
        }

        this.xs = xs;
    }

    public String get(int i) {
        return xs[i];
    }


    public int size(){
        return xs.length;
    }
    public String pick(int i){
        //platzhalterMethode
        if(i == 0) return "";
        if(i == 4) return null;
        return "dd";

    }

}
