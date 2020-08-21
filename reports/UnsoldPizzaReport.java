package br.univali.tortelli.reports;

import br.univali.tortelli.pizza.Pizza;
import br.univali.tortelli.template.TemplateMethod;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que extende o método template que faz o relatório das pizzas não vendidas
 */
public class UnsoldPizzaReport extends TemplateMethod {

    /**
     * Método sobreescrito do título do relatório
     */
    @Override
    protected void title() {
        String fileName = "simulation.txt";
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true))){
            write.write("RELATORIO DE PIZZAS NAO VENDIDAS");
            write.newLine();
            write.newLine();
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
    }

    /**
     * Escreve no arquivo simulation.txt o relatório de pizzas não vendidas
     * @param pizza array de pizzas
     * @param somePizza pizza qualquer
     */
    @Override
    protected void writeReportUnsold(ArrayList<Pizza> pizza, Pizza somePizza){
        String fileName = "simulation.txt";
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true))){
            for(int i=0; i<pizza.size(); i++) {
                if (pizza.get(i).getAmountPizza() == 0) {
                    write.write("Pizza: " + pizza.get(i).getPizzaName());
                    write.newLine();
                    for (int j = 0; j < pizza.get(i).getSizes().size(); j++) {
                        write.write("Tamanho nao vendido: " + pizza.get(i).getSizes().get(j).getSize());
                        write.newLine();
                    }
                }
                if (pizza.get(i).getAmountPizza() == 1) {
                    for (int k = 0; k < pizza.get(i).getSizes().size(); k++) {
                        for (int j = 0; j < somePizza.getPizzaSizes().size(); j++) {
                            if (pizza.get(i).getPizzaName().equals(somePizza.getPizzaSizes().get(j).getPizzaNameForSize())) {
                                if (!(pizza.get(i).getSizes().get(k).getSize().equals(somePizza.getPizzaSizes().get(j).getSizeName()))) {
                                    write.write("Pizza: " + pizza.get(i).getPizzaName());
                                    write.newLine();
                                    write.write("Tamanho nao vendido: " + pizza.get(i).getSizes().get(k).getSize());
                                    write.newLine();
                                }
                            }
                        }
                    }
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo");
        }
    }
}
