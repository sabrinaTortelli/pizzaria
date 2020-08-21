package br.univali.tortelli.order;

import java.math.BigDecimal;

/**
 * Classe que guarda as pizzas escolhidas pelos clientes
 */
public class ChoosedPizza {
    private String[] pizzaNameChoosed;
    private String[] sizePizzaChoosed;
    private BigDecimal[] pricePizzaChoosed;
    private BigDecimal totalValue = new BigDecimal(0.00);

    /**
     * Instancia as pizzas escolhidas
     * @param pizzaNameChoosed array de nomes de pizzas escolhidas
     * @param sizePizzaChoosed array de tamanhos de pizzas escolhidas
     * @param pricePizzaChoosed array de preços das pizzas escolhidas
     */
    public ChoosedPizza(String[] pizzaNameChoosed, String[] sizePizzaChoosed, BigDecimal[] pricePizzaChoosed){
        this.pizzaNameChoosed = pizzaNameChoosed;
        this.sizePizzaChoosed = sizePizzaChoosed;
        this.pricePizzaChoosed = pricePizzaChoosed;
    }

    /**
     * @param totalValue retorna o total das pizzas escolhidas
     */
    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * @return array de preços das pizzas escolhidas
     */
    public BigDecimal[] getPricePizzaChoosed() {
        return pricePizzaChoosed;
    }

    /**
     * @return array de nome das pizzas escolhidas
     */
    public String[] getPizzaNameChoosed() {
        return pizzaNameChoosed;
    }

    /**
     * @return array de tamanhos das pizzas escolhidas
     */
    public String[] getSizePizzaChoosed() {
        return sizePizzaChoosed;
    }

}
