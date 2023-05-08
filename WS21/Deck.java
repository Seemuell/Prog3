import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Deck<T extends Card>{
 List<T> cards = new ArrayList<>();

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> cards) {
        this.cards = cards;
    }

    public void add(T card){
     cards.add(card);
 }

 public T max(Comparator<T> comp){
   T nmax = null;
     for(T ca : cards){
       if(nmax == null && ca != null)nmax = ca;
       if(ca!= null && comp.compare(ca,nmax)>0) nmax = ca;
     }
   return nmax;
 }
 public void appendTo(Deck<? extends T> deck){
       this.cards.addAll(deck.cards);

 }
 public boolean hasSmallerThan(T c, Comparator <T> comp){
    for(T ca: cards){
       if(comp.compare(c,ca)>0){
        return true;
       }

    }
  return false;
 }

 public static long distinctCards(List<Card> cards, int minAtt){
     return cards.stream()
             .filter(x -> x.getAtt()>= minAtt)
             .distinct()
             .count();
 }
 public static int sumOfCosts(List <Card> cards){
       return cards.stream()
               .filter(x -> x instanceof LeshyCard)
               .mapToInt(x -> ((LeshyCard) x).getCost())
               .sum();

 }
 public static List<Card> minCardAmount(Map<Card,Integer> deck, int min){
    return  deck.keySet().stream()
             .filter(x -> deck.get(x)>= min)
             .toList();
 }
 public static Stream<Card> powerCards(String name){
     return Stream
             .iterate(new Card(name,1),x  -> new Card(x.getName() +"!",x.getAtt()*2) )
             .takeWhile(x-> x.getAtt() <= 128);
 }





}
