// WithSaying.java
public class WithSaying extends CakeDecorator {
    private String saying;

    public WithSaying(Cake cake, String saying) {
        super(cake);
        this.saying = saying;
    }

    @Override
    public int getCost() {
        return cake.getCost();
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + " with saying \"" + saying + "\"";
    }
}