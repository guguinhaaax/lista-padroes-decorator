// Main.java
/**
 * Create an order and print it
 */
public class Main {
    public static void main(String[] args) {
        // Create the order
        Order order = new Order();

        // Bolo de chocolate
        order.addCake(new ChocolateCake());

        // Bolo de baunilha com o dizer "PLAIN!"
        order.addCake(new WithSaying(new VanillaCake(), "PLAIN!"));

        // Bolo de baunilha com granulado com os dizeres "FANCY"
        order.addCake(new WithSaying(new WithSprinkles(new VanillaCake()), "FANCY!"));

        // Bolo de morango em várias camadas com granulado duplo e dois dizeres
        Cake strawberrySpecial = new StrawberryCake();
        strawberrySpecial = new MultiLayered(strawberrySpecial);
        strawberrySpecial = new WithSprinkles(strawberrySpecial);
        strawberrySpecial = new WithSprinkles(strawberrySpecial); // Segundo granulado
        strawberrySpecial = new WithSaying(strawberrySpecial, "One of");
        strawberrySpecial = new WithSaying(strawberrySpecial, "EVERYTHING");
        order.addCake(strawberrySpecial);


        // Print the order
        System.out.println("Order Details:");
        order.printOrder();
    }
}