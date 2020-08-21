package br.univali.tortelli.pizza;

import br.univali.tortelli.validates.Validates;

/**
 * Classe de ingredientes das pizzas
 */
public class Ingredients {
    private String ingredient;
    Validates validates = new Validates();

    /**
     * Instancia os ingredintes
     * @param ingredient ingrediente da pizza
     */
    public Ingredients(String ingredient){
        validates.validateNull(ingredient, "Ingredient");
        validates.validateNames(ingredient, "Ingredient");
        this.ingredient = ingredient;
    }

    /**
     * @return ingrediente
     */
    public String getIngredient() {
        return ingredient;
    }

}
