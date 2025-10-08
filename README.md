# lista-padroes-decorator

Resposta da terceira questão da Lista Avaliativa I da disciplina Padrões de Objeto, relativo ao padrão Decorator.

--------------------------------------------------------------------------------

O pacote bakery (padaria) no código inicial contém código parcial para uma padaria. A padaria
faz dois tipos de bolos: baunilha (em inglês, vanilla) e chocolate. Eles agora querem fazer
bolos mais complexos, como um "bolo de baunilha em várias camadas com granulado que
diz 'Olá, mundo!' "

Altere o código para que um pedido possa conter esses bolos mais complexos usando o
padrão Decorator:

    ● Crie as seguintes classes de decorador necessárias:
        ○ Para bolos de várias camadas, adicione $5 e imprima "Multi-layered" na frente
        do nome.
        ○ Para granulado, adicione $2 e imprima "with sprinkles" no final do nome.
        ○ Para um bolo com o dizer X, não adicione nada ao custo e imprima "with saying
        'X''" no final do nome.

    ● Acrescente um novo tipo de bolo: bolo de morango (em inglês, strawberry cake), que
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