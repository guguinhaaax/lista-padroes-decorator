// CakeDecorator.java
public abstract class CakeDecorator extends Cake {
    protected Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public abstract String getDescription();
}