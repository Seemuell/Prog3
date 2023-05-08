import java.util.*;
import java.util.function.Function;

public class main {

    public static void main(String [] args) {


        int[] b = {1, 2, 3, 5, 7};

        //Test eval
        Ints2D i = Ints2D.avg();
        double d = i.eval(b);
        //System.out.println(d);

        //Test sqr
        Ints2D i2 = i.sqr(0);
        double d2 = i2.eval(b);
        //System.out.println(d2);

        //AUfgabe d SS22
        // Instanz deklarieren, die zuerst quadriert und dann den durchschnitt berechnet
        Ints2D i3 = Ints2D.avg().sqr(0);
        i3.eval(b);

        //Streams
        List<String> l = new ArrayList<>();
        l.add("Test");
        l.add("Hallo");
        l.add("Hallo");
        //System.out.println(Koans.distinctEntries(l)); // Ausgabe:2


        //Stream SS22
        Desc<Integer> d1 = new Desc<>(6,"Sechs");
        Desc<Integer> d22 = new Desc<>(2,"Zwei");
        Desc<Integer> d3 = new Desc<>(3,"Drei");
        Desc<Integer> d4 = new Desc<>(4,null);
        Desc<Integer> d5 = new Desc<>(5,"Fünf");
        List<Desc<Integer>> dl =new ArrayList<>();
        dl.add(d1);
        dl.add(d22);
        dl.add(d3);
        dl.add(d4);
        dl.add(d5);
        dl = Desc.withoutEmpty(dl);
        for(Desc desc : dl){
            System.out.println(desc.getVal() + " " + desc.getDesc());
        }
        Integer[] integgers  = {10,3,4,7,6,5,8,13,15};
        List <Integer> integers = Arrays.stream(integgers).toList();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        map = Desc.remainderClasses(integers, 4);
        for(Integer ing : map.keySet()){
            System.out.println("===new=Key: "+ ing +" ===");
            for(Integer eng : map.get(ing)) System.out.println(eng);
        }



    }
}
