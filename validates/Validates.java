package br.univali.tortelli.validates;

import java.math.BigDecimal;

/**
 * Classe de validação
 */
public class Validates {
    /**
     * Valida se String é nula
     * @param name nome
     * @param valueLabel título da String
     */
    public void validateNull(String name, String valueLabel) {
        if(name == null){
            throw new IllegalArgumentException("Argumento '" + valueLabel + "' nao pode ser nulo");
        }
    }

    /**
     * Valida se preço é nulo
     * @param price preço
     * @param valueLabel título do preço
     */
    public void validateNull(BigDecimal price, String valueLabel) {
        if(price == null){
            throw new IllegalArgumentException("Argumento '" + valueLabel + "' nao pode ser nulo");
        }
    }

    /**
     * Valida se nomes são vazios
     * @param name nome
     * @param valueLabel título da String
     */
    public void validateNames(String name, String valueLabel) {
        if(name.equals("")){
            throw new IllegalArgumentException("Nome '" + valueLabel + "' nao deve ser vazia");
        }
    }

    /**
     * Valida se inteiros são menores que 0
     * @param object inteiro
     * @param valueLabel título do inteiro
     */
    public void validateInts(int object, String valueLabel) {
        if(object<0){
            throw new IllegalArgumentException(valueLabel + "' nao deve ser menor que 0");
        }
    }

}
