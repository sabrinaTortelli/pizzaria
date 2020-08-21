package br.univali.tortelli.pizza;

import br.univali.tortelli.validates.Validates;

import java.util.ArrayList;

/**
 * Classe que cadastra as pizzas
 */
public class Pizza {
    private ArrayList<Ingredients> ingredients;
    private ArrayList<Size> size;
    private String pizzaName;
    private int ingredientsNumber;
    private int amountPizza = 0;
    private ArrayList<PizzaSize> pizzaSizes = new ArrayList<>();

    /**
     * Instacia uma pizza
     * @param pizzaName nome da pizza
     * @param ingredients ingredientes
     * @param size array de tamanhos da pizza
     * @param ingredientsNumber numero de ingredientes da pizza
     */
    public Pizza(String pizzaName, ArrayList<Ingredients> ingredients, ArrayList<Size> size, int ingredientsNumber){
        Validates validates = new Validates();
        validates.validateNull(pizzaName, "PizzaName");
        validates.validateNames(pizzaName, "PizzaName");
        validates.validateInts(ingredientsNumber, "IngredientsNumber");
        this.pizzaName = pizzaName;
        this.ingredients = ingredients;
        this.size = size;
        this.ingredientsNumber = ingredientsNumber;
    }

    /**
     * @return nome da pizza
     */
    public String getPizzaName() {
        return pizzaName;
    }

    /**
     * @return array de ingredientes
     */
    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    /**
     * @return array de tamanhos de pizzas
     */
    public ArrayList<Size> getSizes() {
        return size;
    }

    /**
     * @return numero de ingredientes das pizzas
     */
    public int getIngredientsNumber() {
        return ingredientsNumber;
    }

    /**
     * Seta a quantidade de cada pizza vendida
     * @param amountPizza quantidade de pizza
     */
    public void setAmountPizza(int amountPizza) {
        this.amountPizza += amountPizza;
    }

    /**
     * @return quantidade de pizza
     */
    public int getAmountPizza() {
        return amountPizza;
    }

    /**
     * Instacia um array de pizzas e tamanhos escolhidos pelos clientes para auxiliar nos relatórios
     * @param pizzaNameSize nome da pizza escolhida
     * @param nameSizePizza tamanho de pizza escolhido
     */
    public void setPizzaSizes(String pizzaNameSize, String nameSizePizza) {
        PizzaSize pizzaSize = new PizzaSize(nameSizePizza, pizzaNameSize);
        this.pizzaSizes.add(pizzaSize);
    }

    /**
     * @return array de tamanhos de pizzas e tamanhos
     */
    public ArrayList<PizzaSize> getPizzaSizes() {
        return pizzaSizes;
    }
}
