package br.univali.tortelli.pizza;

/**
 * Classe para auxiliar o relatório
 */
public class PizzaSize {
    private String pizzaNameForSize;
    private String sizeName;

    /**
     * Instacia pizza e tamanho vendidos
     * @param sizeName tamanho da pizza vendida
     * @param pizzaNameForSize nome da pizza vendida
     */
    public PizzaSize(String sizeName, String pizzaNameForSize){
        this.sizeName = sizeName;
        this.pizzaNameForSize = pizzaNameForSize;
    }

    /**
     * @return nome da pizza vendida
     */
    public String getPizzaNameForSize() {
        return pizzaNameForSize;
    }

    /**
     * @return tamanho da pizza vendida
     */
    public String getSizeName() {
        return sizeName;
    }
}
