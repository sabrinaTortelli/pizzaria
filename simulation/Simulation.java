package br.univali.tortelli.simulation;

import br.univali.tortelli.client.Client;
import br.univali.tortelli.order.Order;
import br.univali.tortelli.pizza.Pizza;
import br.univali.tortelli.reports.ReportPizzasSold;
import br.univali.tortelli.reports.UnsoldPizzaReport;
import br.univali.tortelli.template.TemplateMethod;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe da simulação do programa
 */
public class Simulation {
    /**
     * Escreve em simulation.txt os dados dos clientes
     */
    public void readArchiveClients(){
        String fileName = "client.txt";
        String nameOfFile = "simulation.txt";
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            try(BufferedWriter write = new BufferedWriter(new FileWriter(nameOfFile, true))){
                while((line = reader.readLine()) != null){
                    write.write(line);
                    write.newLine();
                }
            } catch(FileNotFoundException e){
                System.out.println("Erro na abertura do arquivo");
            } catch(IOException e){
                System.out.println("Erro na leitura do arquivo");
            }
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
    }

    /**
     * Escreve no arquivo simulation.txt o menu da pizzaria
     */
    public void readArchiveMenu(){
        String fileName = "menu.txt";
        String nameOfFile = "simulation.txt";
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            try(BufferedWriter write = new BufferedWriter(new FileWriter(nameOfFile, true))){
                while((line = reader.readLine()) != null){
                    write.write(line);
                    write.newLine();
                }
                write.newLine();
            } catch(FileNotFoundException e){
                System.out.println("Erro na abertura do arquivo");
            } catch(IOException e){
                System.out.println("Erro na leitura do arquivo");
            }
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
    }

    /**
     * Escreve no arquivo simulation.txt os dados dos pedidos dos clientes
     * @param pizza array de pizza
     * @param client cliente
     * @param somePizza pizza qualquer
     * @return retorna total do pedido do cliente
     */
    public BigDecimal orderSimulation(ArrayList<Pizza> pizza, Client client, Pizza somePizza){
        String fileName = "simulation.txt";
        Order order = new Order(client);
        BigDecimal totalOrderClient1 = order.setConfirmation(pizza, somePizza);
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true))){
            if(totalOrderClient1.equals(new BigDecimal(0.00))){
                write.write("Id: " + Order.getId());
                write.newLine();
                write.write("Cliente: " + order.getClient().getName());
                write.newLine();
                write.write("Contato: " + order.getClient().getContactPhone());
                write.newLine();
                write.write("O cliente cancelou a pizza");
                write.newLine();
                write.newLine();
            } else{
                write.write("Id: " + order.getId());
                write.newLine();
                write.write("Cliente: " + order.getClient().getName());
                write.newLine();
                write.write("Contato: " + order.getClient().getContactPhone());
                write.newLine();
                write.newLine();
                for(int i=0; i<order.getChoosenPizza().getPizzaNameChoosed().length; i++){
                    write.write("Pizza escolhida: " + order.getChoosenPizza().getPizzaNameChoosed()[i]);
                    write.newLine();
                    write.write("Valor da pizza pedida: " + order.getChoosenPizza().getPricePizzaChoosed()[i]);
                    write.newLine();
                    write.write("Tamanho pedido: " + order.getChoosenPizza().getSizePizzaChoosed()[i]);
                    write.newLine();
                    write.newLine();
                }
                write.write("Total do pedido: " + totalOrderClient1);
                write.newLine();
                write.newLine();
                write.newLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
        return totalOrderClient1;
    }

    /**
     * Escreve no arquivo sumulation.txt os relatórios de pizzas vendidas e não vendidas
     * @param pizza array de pizzas
     * @param report referência para a classe ReportPizzasSold
     * @param somePizza pizza qualquer
     */
    public void reportsSimulation(ArrayList<Pizza> pizza, ReportPizzasSold report, Pizza somePizza){
        TemplateMethod templateSolded = new ReportPizzasSold();
        TemplateMethod templateUnsolded = new UnsoldPizzaReport();
        templateSolded.templateMethod(pizza, report, somePizza);
        templateUnsolded.templateMethod(pizza, report, somePizza);
    }

}
