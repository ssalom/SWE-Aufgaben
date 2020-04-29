public class ExpeditionsGegenstand {

    private String name;
    private double weight;
    private double profit;

    public ExpeditionsGegenstand(String name, double weight, double profit) {
        this.name = name;
        this.weight = weight;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
