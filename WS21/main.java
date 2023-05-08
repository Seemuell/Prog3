import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class main {


    public static void main(String... args) {
        CardComb add = (c1, c2) -> {
            return new Card(c1.getName() + " " + c2.getName(), c1.getAtt() + c2.getAtt());
        };
        Stream<Card> s = Deck.powerCards("Simon");
        List<Card> l = s.toList();
        //for (Card c : l) System.out.println(c.getName() + " " + c.getAtt());

        Deck deck = new Deck();
        deck.getCards().addAll(l);
        System.out.println(deck.max(new AttComperator()).getName());
        System.out.println(deck.hasSmallerThan(new LeshyCard("Test",1), new AttComperator()));



    }





       private static class AttComperator implements Comparator<Card>{
           @Override
           public int compare(Card o1, Card o2) {
               if(o1 == null || o2 == null) throw new IllegalArgumentException();
               int result = o1.getAtt() - o2.getAtt();
               return result;
           }
       }



}
