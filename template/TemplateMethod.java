package br.univali.tortelli.template;

import br.univali.tortelli.pizza.Pizza;
import br.univali.tortelli.reports.ReportPizzasSold;

import java.util.ArrayList;

/**
 * Método de modelo de escrita dos relatórios no arquivo
 */
public abstract class TemplateMethod {
    /**
     * Metodo modelo
     * @param pizza array de pizzas
     * @param report referência para relatório
     * @param somePizza pizza qualquer
     */
    public final void templateMethod(ArrayList<Pizza> pizza, ReportPizzasSold report, Pizza somePizza) {
        title();
        writeReportSold(pizza, report, somePizza);
        writeReportUnsold(pizza, somePizza);
    }

    /**
     * Método abstrato de título
     */
    protected abstract void title();

    /**
     * Método para escrever o relatório de pizzas vendidas
     * @param pizza array de pizzas
     * @param report referência de relatórios
     * @param somePizza pizza qualquer
     */
    protected void writeReportSold(ArrayList<Pizza> pizza, ReportPizzasSold report, Pizza somePizza){}

    /**
     * Método para escrever o relatório de pizzas não vendidas
     * @param pizza array de pizzas
     * @param somePizza pizza qualquer
     */
    protected void writeReportUnsold(ArrayList<Pizza> pizza, Pizza somePizza){}


}
