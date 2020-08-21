package br.univali.tortelli.order;

import br.univali.tortelli.client.Client;
import br.univali.tortelli.pizza.Pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que cadastra pedidos dos clientes
 */
public class Order {
    private static int id = 0;
    private Client client;
    private ChoosedPizza choosenPizza;
    private BigDecimal totalValue = new BigDecimal(0.00);

    /**
     * Instancia um novo cliente
     * @param client cliente
     */
    public Order(Client client) {
        this.client = client;
        id = ++id;
    }

    /**
     * @return id do cliente
     */
    public static int getId() {
        return id;
    }

    /**
     * @return cliente
     */
    public Client getClient() {
        return client;
    }

    /**
     * Método que simula se o cliente cancela a pizza ou confirma o pedido por números sorteados aleatoriamente
     * se numero sorteado for igual a 0 ou 1 o pedido é cancelado, se for de 2 até 7 o pedido é realizado
     * @param pizza array de pizzas
     * @param somePizza pizza qualquer
     * @return retorna um valor 0 se o pedido for cancelado ou retorna o valor total do pedido do cliente
     */
    public BigDecimal setConfirmation(ArrayList<Pizza> pizza, Pizza somePizza) {
        Random random = new Random();
        int number;
        number = random.nextInt(8);
        if (number <= 1) {
            return canceledOrder();
        } else {
            return setChoosenPizza(pizza, somePizza);
        }
    }

    /**
     * Método que sorteia um numero aleatório para indicar quantas pizzas o cliente quer pedir
     * @param pizza array de pizzas
     * @param somePizza pizza qualquer
     * @return retorna o valor total dos pedidos
     */
    public BigDecimal setChoosenPizza(ArrayList<Pizza> pizza, Pizza somePizza) {
        Random random = new Random();
        int numberPizzas;
        numberPizzas = random.nextInt(4) + 1;
        ChoosedPizza choosedPizza = setPizzaChoosed(numberPizzas, pizza, somePizza);
        return getTotalValue(choosedPizza);
    }

    /**
     * Método que escolhe as pizzas pelo numero sorteado  e tamanho sorteado
     * @param numberPizzas quantidade de pizzas escolhidas pelo cliente
     * @param pizza array de pizzas
     * @param somePizza pizza qualquer
     * @return pizzas escolhidas
     */
    public ChoosedPizza setPizzaChoosed(int numberPizzas, ArrayList<Pizza> pizza, Pizza somePizza){
        Random random1 = new Random();
        int[] numberSize = new int[numberPizzas];
        String[] choosedName = new String[numberPizzas];
        String[] size = new String[numberPizzas];
        BigDecimal[] price = new BigDecimal[numberPizzas];
        for(int i=0; i< numberPizzas; i++){
            numberSize[i] = random1.nextInt(pizza.size());
        }
        for(int i=0; i<numberSize.length; i++){
            choosedName[i] = pizza.get(numberSize[i]).getPizzaName();
            pizza.get(numberSize[i]).setAmountPizza(1);
            Random random2 = new Random();
            int numberAlea =  random2.nextInt(3);
            size[i] = pizza.get(numberSize[i]).getSizes().get(numberAlea).getSize();
            price[i] = pizza.get(numberSize[i]).getSizes().get(numberAlea).getPrice();
            somePizza.setPizzaSizes(pizza.get(numberSize[i]).getPizzaName(), pizza.get(numberSize[i]).getSizes().get(numberAlea).getSize());
        }
        choosenPizza = new ChoosedPizza(choosedName, size, price);
        return choosenPizza;
    }

    /**
     * Calcula valor total do pedido
     * @param choosedPizza pizzas escolhidas
     * @return valor total do pedido
     */
    public BigDecimal getTotalValue(ChoosedPizza choosedPizza){
        int numberPizzas = choosedPizza.getPizzaNameChoosed().length;
        for(int i=0; i<numberPizzas; i++){
            this.totalValue = this.totalValue.add(choosedPizza.getPricePizzaChoosed()[i]);
        }
        choosedPizza.setTotalValue(this.totalValue);
        return this.totalValue;
    }

    /**
     * Método para pedidos cancelados
     * @return retorna 0.00 se for cancelado
     */
    public BigDecimal canceledOrder(){
        return new BigDecimal(0.00);
    }

    /**
     * @return pizzas escolhidas
     */
    public ChoosedPizza getChoosenPizza() {
        return choosenPizza;
    }

}

