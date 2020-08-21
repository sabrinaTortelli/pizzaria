package br.univali.tortelli.client;

import br.univali.tortelli.validates.Validates;

/**
 * Classe para cadastro do endereço do Cliente
 */
public class Address {
    private final String streetAddress;
    private final String neighborhood;
    private final String zipCode;
    private final String city;
    private final String state;

    /**
     * Instancia um novo endereço
     * @param streetAddress nome da rua
     * @param neighborhood bairro
     * @param zipCode cep
     * @param city cidade
     * @param state estado
     */
    public Address(String streetAddress, String neighborhood, String zipCode, String city, String state){
        Validates validates = new Validates();
        validates.validateNull(streetAddress, "Street Address");
        validates.validateNames(streetAddress, "Street Address");
        validates.validateNull(neighborhood, "Neighborhood");
        validates.validateNames(neighborhood, "Neighborhood");
        validates.validateNull(zipCode, "Zipcode");
        validates.validateNames(zipCode, "Zipcode");
        validates.validateNull(city, "City");
        validates.validateNames(city, "City");
        validates.validateNull(state, "State");
        validates.validateNames(state, "State");
        this.streetAddress = streetAddress;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    /**
     * @return nome da rua
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @return nome do bairro
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @return cep
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @return nome da cidade
     */
    public String getCity() {
        return city;
    }

    /**
     * @return nome do estado
     */
    public String getState() {
        return state;
    }

    /**
     * Reescreve a classe Address
     * @return retorna String com os dados de Address
     */
    @Override
    public String toString() {
        return getStreetAddress() + " - " + getNeighborhood() + " - " + getZipCode() + " - " + getCity() + "/" + getState();
    }
}
