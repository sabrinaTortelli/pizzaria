package br.univali.tortelli.compare;

import br.univali.tortelli.pizza.Pizza;
import java.util.Comparator;

/**
 * Classe para comparar os valores das quantidades das pizzas
 */
public class CompareAmount implements Comparator<Pizza> {
    /**
     * Método de comparação de duas pizzas
     * @param pizza1 pizza 1
     * @param pizza2 pizza 2
     * @return retorna qual o valor maior
     */
    @Override
    public int compare(Pizza pizza1, Pizza pizza2) {
        return Integer.compare(pizza2.getAmountPizza(), pizza1.getAmountPizza());
    }
}
