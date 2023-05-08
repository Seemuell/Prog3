@FunctionalInterface
public interface CardComb {
    public Card combine(Card c1, Card c2);

    public static CardComb maxAttack(){
        return (c1,c2) -> c1.getAtt()>c2.getAtt()?c1:c2;
    }

    default CardComb argsSwapped(){
        return (c1,c2) -> combine(c2,c1);
    }

}
