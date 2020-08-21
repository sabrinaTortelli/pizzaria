package br.univali.tortelli.pizza;

import br.univali.tortelli.validates.Validates;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe que cria o menu da pizzaria
 */
public class Menu {
    private String pizzeriaName;
    private int totalOptions;
    private int totalPizzas;
    Validates validates = new Validates();

    /**
     * Instancia o menu
     * @param pizzeriaName nome da pizzaria
     * @param totalOptions total de opções de tamanhos de pizzas
     * @param totalPizzas total de pizzas cadastradas
     */
    public Menu(String pizzeriaName, int totalOptions, int totalPizzas){
        validates.validateNull(pizzeriaName, "PizzeriaName");
        validates.validateNames(pizzeriaName, "PizzeriaName");
        validates.validateInts(totalOptions, "TotalOptions");
        validates.validateInts(totalPizzas, "TotalPizzas");
        this.pizzeriaName = pizzeriaName;
        this.totalOptions = totalOptions;
        this.totalPizzas = totalPizzas;
    }

    /**
     * @return total de pizzas cadastradas
     */
    public int getTotalPizzas() {
        return totalPizzas;
    }

    /**
     * @return total de opções de tamanhos de pizzas
     */
    public int getTotalOptions() {
        return totalOptions;
    }

    /**
     * @return nome da pizzaria
     */
    public String getPizzeriaName() {
        return pizzeriaName;
    }

    /**
     * Escreve o menu no arquivo menu.txt
     * @param pizza array de pizzas
     */
    public void writeFileMenu(ArrayList<Pizza> pizza) {
        String nameOfFile = "menu.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile))){
            writer.write(getPizzeriaName());
            writer.newLine();
            writer.write(String.valueOf(getTotalOptions()));
            writer.newLine();
            for(int i=0; i<pizza.get(0).getSizes().size(); i++){
                writer.write(pizza.get(0).getSizes().get(i).getSize());
                writer.newLine();
                writer.write(String.valueOf(pizza.get(0).getSizes().get(i).getSlicesNumber()));
                writer.newLine();
            }
            writer.write(String.valueOf(getTotalPizzas()));
            writer.newLine();
            for(int i=0; i<getTotalPizzas(); i++){
                writer.write(pizza.get(i).getPizzaName());
                writer.newLine();
                writer.write(String.valueOf(pizza.get(i).getIngredientsNumber()));
                writer.newLine();
                for(int j=0; j<pizza.get(i).getIngredientsNumber(); j++){
                    writer.write(pizza.get(i).getIngredients().get(j).getIngredient());
                    writer.newLine();
                }
                for(int j=0; j<pizza.get(i).getSizes().size(); j++){
                    writer.write(String.valueOf(pizza.get(i).getSizes().get(j).getPrice()));
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Erro na abertura do arquivo");
        } catch (IOException e){
            System.out.println("Erro de execução");
        }
    }
}
