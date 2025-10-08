# Histórico de prompts

*A IA utilizada para a realização dessa atividade foi o Google Gemini na versão 2.5 Pro*

**Prompt**:

        Considerando os códigos anexados, resolva a questão com o seguinte enunciado:

        bolo de morango (em inglês, strawberry cake), que
        custa o dobro de um bolo padrão.
        ● Altere o código Main.java para adicionar o seguinte a uma Order (pedido) e imprima
        a Order:
        ○ Bolo de chocolate
        ○ Bolo de baunilha com o dizer "PLAIN!"
        ○ Bolo de baunilha com granulado com os dizeres "FANCY"
        ○ Bolo de morango em várias camadas com granulado duplo e dois dizeres "One
        of" e "EVERYTHING" (a saída esperada aqui é: Multi-layered Strawberry cake
        with sprinkles with sprinkles with saying "One of" with saying "EVERYTHING")

        Observações
        ● Adicionar um novo tipo de bolo não altera nenhum código existente (exceto para
        instanciá-lo)
        ● Adicionar uma nova maneira de decorar/estilizar o bolo (como multicamadas ou com
        granulado) não altera nenhum código existente (exceto para instanciá-lo)
        Exemplo de saída do programa:
        10 Chocolate cake
        10 Vanilla cake with saying "PLAIN!"
        12 Vanilla cake with sprinkles with saying "FANCY!"
        29 Multi-layered Strawberry cake with sprinkles with sprinkles with saying "One of" with saying "EVERYTHING"

**Resposta**:

Com certeza\! Para resolver este problema de forma que a adição de novos tipos de bolo e decorações não altere o código existente, a melhor abordagem é utilizar o **Padrão de Projeto Decorator**.

Este padrão permite adicionar novas funcionalidades a objetos dinamicamente, envolvendo-os em objetos especiais "decoradores" que contêm essas funcionalidades.

A solução consiste em:

1.  **Manter as classes existentes** (`Cake`, `VanillaCake`, `ChocolateCake`, `Order`) sem alterações.
2.  **Criar o novo bolo** `StrawberryCake` como uma subclasse de `Cake`.
3.  **Criar uma classe abstrata `CakeDecorator`** que estende `Cake` e serve como base para todas as decorações.
4.  **Criar classes de decoração concretas** (`MultiLayered`, `WithSprinkles`, `WithSaying`) que herdam de `CakeDecorator`. Cada uma adiciona um custo e/ou modifica a descrição do bolo que "decora".
5.  **Atualizar a classe `Main`** para construir os bolos complexos, envolvendo o bolo base com as decorações necessárias.

Abaixo estão os novos arquivos de código e o arquivo `Main.java` modificado para atender aos requisitos.

### 1\. Novo Bolo: StrawberryCake.java

Este arquivo define o bolo de morango, que tem o dobro do custo de um bolo padrão.

```java
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
```

### 2\. Decorador Base: CakeDecorator.java

Esta é uma classe abstrata que servirá como base para todas as nossas decorações. Ela estende `Cake` para que um bolo decorado ainda seja considerado um `Cake`.

```java
// CakeDecorator.java
public abstract class CakeDecorator extends Cake {
    protected Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public abstract String getDescription();
}
```

### 3\. Decoradores Concretos

#### **MultiLayered.java**

Adiciona a funcionalidade de "múltiplas camadas", com um custo adicional de 5 e um prefixo na descrição.

```java
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
```

#### **WithSprinkles.java**

Adiciona granulado, com um custo adicional de 2 e um sufixo na descrição.

```java
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
```

#### **WithSaying.java**

Adiciona um dizer personalizado ao bolo, sem custo adicional, apenas modificando a descrição.

```java
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
```

### 4\. Arquivo Principal Modificado: Main.java

Aqui, montamos os pedidos usando os novos bolos e decoradores. A beleza do padrão Decorator é vista na forma como "envolvemos" um bolo base com as decorações.

```java
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
```

Ao compilar e executar o `Main.java` com todas as classes novas e existentes no mesmo diretório, a saída será exatamente a esperada:

```
Order Details:
   10  Chocolate cake
   10  Vanilla cake with saying "PLAIN!"
   12  Vanilla cake with sprinkles with saying "FANCY!"
   29  Multi-layered Strawberry cake with sprinkles with sprinkles with saying "One of" with saying "EVERYTHING"
```

**Avaliação do Prompt**:
    A solução gerada pelo prompt foi bastante satisfatória e resolveu todas as exigências pedidas pela questão.