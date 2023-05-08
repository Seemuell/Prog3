public class LeshyCard extends Card{

    private int cost;
    public LeshyCard(String name, int attack) {
        super(name, attack);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
