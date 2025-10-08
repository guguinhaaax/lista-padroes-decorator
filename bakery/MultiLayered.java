// MultiLayered.java
public class MultiLayered extends CakeDecorator {
    public MultiLayered(Cake cake) {
        super(cake);
    }

    @Override
    public int getCost() {
        return cake.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return "Multi-layered " + cake.getDescription();
    }
}