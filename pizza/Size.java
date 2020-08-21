package br.univali.tortelli.pizza;

import br.univali.tortelli.validates.Validates;

import java.math.BigDecimal;

/**
 * Classe de tamanhos de pizzas
 */
public class Size {
    private int slicesNumber;
    private String size;
    private BigDecimal price;

    /**
     * Instacia tamanhos de pizzas
     * @param slicesNumber numero de fatias
     * @param size tamanho
     * @param price preço
     */
    public Size(int slicesNumber, String size, BigDecimal price){
        Validates validates = new Validates();
        validates.validateNull(size, "Size");
        validates.validateNames(size, "Size");
        validates.validateNull(price, "Price");
        validates.validateInts(slicesNumber, "SlicesNumber");
        this.slicesNumber = slicesNumber;
        this.size = size;
        this.price = price;
    }

    /**
     * @return quantidade de fatias
     */
    public int getSlicesNumber() {
        return slicesNumber;
    }

    /**
     * @return tamanho da pizza
     */
    public String getSize() {
        return size;
    }

    /**
     * @return preço da pizza
     */
    public BigDecimal getPrice() {
        return price;
    }
}
