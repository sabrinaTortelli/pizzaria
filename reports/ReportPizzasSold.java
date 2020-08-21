package br.univali.tortelli.reports;

import br.univali.tortelli.compare.CompareAmount;
import br.univali.tortelli.pizza.Pizza;
import br.univali.tortelli.template.TemplateMethod;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe que extende o método template que faz o relatório das pizzas vendidas
 */
public class ReportPizzasSold  extends TemplateMethod {

    BigDecimal totalOrders = new BigDecimal(0.00);

    /**
     * Método sobreescrito do título do relatório
     */
    @Override
    protected void title() {
        String fileName = "simulation.txt";
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true))){
            write.write("RELATORIO DE PIZZAS VENDIDAS");
            write.newLine();
            write.newLine();
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
    }

    /**
     * Escreve no arquivo simulation.txt o relatório de pizzas vendidas
     * @param pizza array de pizza
     * @param report utilizado para pegar o valor total de todos os pedidos da pizzaria
     * @param somePizza pizza qualquer
     */
    @Override
    protected void writeReportSold(ArrayList<Pizza> pizza, ReportPizzasSold report, Pizza somePizza) {
        String fileName = "simulation.txt";
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true))){
            for(int i=0; i<pizza.size(); i++) {
                if (pizza.get(i).getAmountPizza() > 0) {
                    write.write("Pizza: " + pizza.get(i).getPizzaName());
                    write.newLine();
                    write.write("Quantidade vendida: " + pizza.get(i).getAmountPizza());
                    write.newLine();
                    for (int j = 0; j < somePizza.getPizzaSizes().size(); j++) {
                        if (pizza.get(i).getPizzaName().equals(somePizza.getPizzaSizes().get(j).getPizzaNameForSize())) {
                            write.write("Tamanho vendido: " + somePizza.getPizzaSizes().get(j).getSizeName());
                            write.newLine();
                       }
                    }
                }
            }
            write.newLine();
            write.write("Total dos pedidos: " + report.getTotalOrders());
            write.newLine();
            write.newLine();
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
    }

    /**
     * Calcula o valor total de todas as pizzas vendidas na pizzaria
     * @param totalValuePizzas array de total dos pedidos
     */
    public void setValueTotalPizzas(ArrayList<BigDecimal> totalValuePizzas) {
        for (int i = 0; i < totalValuePizzas.size(); i++) {
            this.totalOrders = totalOrders.add(totalValuePizzas.get(i));
        }
    }

    /**
     * @return valor total de todas os pedidos da pizzaria
     */
    public BigDecimal getTotalOrders() {
        return this.totalOrders;
    }

    /**
     * Ordena o array de pizzas por ordem decrescente de pizzas vendidas
     * @param pizza array de pizzas
     * @return array de pizzas ordenado
     */
    public ArrayList<Pizza> sortPizzasOrder(ArrayList<Pizza> pizza){
        ArrayList<Pizza> newPizza = new ArrayList<>();
        for(int i=0; i<pizza.size(); i++){
            newPizza.add(pizza.get(i));
        }
        newPizza.sort(new CompareAmount());
        return newPizza;
    }
}
