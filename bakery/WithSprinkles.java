// WithSprinkles.java
public class WithSprinkles extends CakeDecorator {
    public WithSprinkles(Cake cake) {
        super(cake);
    }

    @Override
    public int getCost() {
        return cake.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + " with sprinkles";
    }
}