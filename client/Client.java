package br.univali.tortelli.client;

import br.univali.tortelli.validates.Validates;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe para cadastro do cliente
 */
public class Client {
    private final String name;
    private final String contactPhone;
    private final String cpf;
    private final Address address;

    /**
     * Instancia novo cliente
     * @param name nome do cliente
     * @param contactPhone telefone
     * @param cpf cpf
     * @param address endereço
     */
    public Client(String name, String contactPhone, String cpf, Address address){
        Validates validates = new Validates();
        validates.validateNull(name, "Name");
        validates.validateNames(name, "Name");
        validates.validateNull(contactPhone, "Contact Phone");
        validates.validateNames(contactPhone, "Contact Phone");
        validates.validateNull(cpf, "CPF");
        validates.validateNames(cpf, "CPF");
        this.name = name;
        this.contactPhone = contactPhone;
        this.cpf = cpf;
        this.address = address;
    }

    /**
     * @return nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * @return telefone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @return cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return endereço
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Escreve no arquivo client.txt os dados de todos os clientes cadastrados
     * @param client cliente cadastrado
     */
    public void writeFile(Client client) {
        String nameOfFile = "client.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile, true))){
            writer.write(client.toString());
            writer.newLine();
        } catch (FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch (IOException e){
            System.out.println("Erro de execução");
        }
    }

    /**
     * Sobrescreve o método toString() com os dados dos clientes
     * @return String com dados dos clientes
     */
    @Override
    public String toString() {
        return "Client Name: " + getName() + "\r\n" +
                "Contact Phone: " + getContactPhone() + "\r\n" +
                "Cpf: " + getCpf() + "\r\n" +
                "Address: " + getAddress().toString() + "\r\n";

    }
}
