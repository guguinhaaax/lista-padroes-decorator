// StrawberryCake.java
public class StrawberryCake extends Cake {
    @Override
    public int getCost() {
        // Custa o dobro de um bolo padrão
        return super.getCost() * 2;
    }

    @Override
    public String getDescription() {
        return "Strawberry cake";
    }
}