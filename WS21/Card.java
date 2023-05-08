import java.util.Comparator;

public class Card implements Comparator <Card> {
    private String name;
    private int att;
    private int health;

    public Card(String name, int attack){
        this.name = name;
        this.att = attack;
        health = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int compare(Card o1, Card o2) {
        if(o1 == null || o2 == null) throw new IllegalArgumentException();
        int result = o1.getAtt() - o2.getAtt();
        return result;
    }
}
