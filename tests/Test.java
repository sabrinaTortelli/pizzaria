package br.univali.tortelli.tests;

import br.univali.tortelli.client.Address;
import br.univali.tortelli.client.Client;
import br.univali.tortelli.pizza.*;
import br.univali.tortelli.reports.ReportPizzasSold;
import br.univali.tortelli.simulation.Simulation;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe de teste do programa da pizzaria
 */
public class Test {
    private Client client1;
    private Client client2;
    private Client client3;
    private Ingredients molhoDeTomate;
    private Ingredients mussarela;
    private Ingredients parmesao;
    private Ingredients gorgonzola;
    private Ingredients requeijao;
    private Ingredients atum;
    private Ingredients cebola;
    private Ingredients alho;
    private Ingredients azeitona;
    private Ingredients tomate;
    private Ingredients manjericao;
    private Ingredients frango;
    private Ingredients calabresa;
    private Ingredients ervaDoce;
    private Ingredients tomateCereja;
    private Ingredients muzzarelaBufala;
    private Ingredients rucula;
    private Ingredients presunto;
    private Ingredients camarao;
    private Ingredients salsinha;
    private Ingredients chocolate;
    private Ingredients cremeDeLeite;
    private Ingredients morango;
    private Size pequenaNormais;
    private Size mediaNormais;
    private Size grandeNormais;
    private Size pequenaEspeciais;
    private Size mediaEspeciais;
    private Size grandeEspeciais;
    private Size pequenaDoces;
    private Size mediaDoces;
    private Size grandeDoces;
    private ArrayList<Size> normal = new ArrayList<>();
    private ArrayList<Size> especial = new ArrayList<>();
    private ArrayList<Size> doce = new ArrayList<>();
    private ArrayList<Ingredients> ingQuatroQueijos = new ArrayList<>();
    private ArrayList<Ingredients> ingAtum = new ArrayList<>();
    private ArrayList<Ingredients> ingAlho = new ArrayList<>();
    private ArrayList<Ingredients> ingMarguerita = new ArrayList<>();
    private ArrayList<Ingredients> ingFrango = new ArrayList<>();
    private ArrayList<Ingredients> ingCalabresa = new ArrayList<>();
    private ArrayList<Ingredients> ingArtesanal = new ArrayList<>();
    private ArrayList<Ingredients> ingTomazza = new ArrayList<>();
    private ArrayList<Ingredients> ingNapoli = new ArrayList<>();
    private ArrayList<Ingredients> ingCamarao= new ArrayList<>();
    private ArrayList<Ingredients> ingChocolate= new ArrayList<>();
    private ArrayList<Ingredients> ingSensacao= new ArrayList<>();
    private Pizza pizzaQuatroQueijos;
    private Pizza pizzaAtum;
    private Pizza pizzaAlho;
    private Pizza pizzaMarguerita;
    private Pizza pizzaFrango;
    private Pizza pizzaCalabresa;
    private Pizza pizzaArtesanal;
    private Pizza pizzaTomazza;
    private Pizza pizzaNapoli;
    private Pizza pizzaCamarao;
    private Pizza pizzaChocolate;
    private Pizza pizzaSensacao;
    private ArrayList<Pizza> pizza = new ArrayList<>();
    private ArrayList<Pizza> pizzaSorted = new ArrayList<>();
    private Menu menu;
    private BigDecimal totalClient1 = new BigDecimal(0.00);
    private BigDecimal totalClient2 = new BigDecimal(0.00);
    private BigDecimal totalClient3 = new BigDecimal(0.00);
    private ArrayList<BigDecimal> totalOrders = new ArrayList<>();
    private ReportPizzasSold report = new ReportPizzasSold();
    private Simulation simulation1 = new Simulation();


    private void iniClients() {
        client1 = new Client("Sabrina Tortelli", "98465-9823", "356.459.257-69",
                new Address("Avenida Rio Branco, 58", "Joao Paulo", "88498-25", "Florianopolis", "SC"));
        client2 = new Client("Ana Paula Figueira", "98719-6589", "525.789.365-48",
                new Address("Rua Gerônimo Coelho, 417", "Centro", "88528-47", "Florianopolis", "SC"));
        client3 = new Client("Francisco Klein", "99478-2536", "489.126.487-42",
                new Address("Rua Paulo Gustavo, 787", "Felizardo", "87488-47", "Sao Jose", "SC"));
    }

    private void iniArchiveClients() {
        client1.writeFile(client1);
        client2.writeFile(client2);
        client3.writeFile(client3);
    }

    private void iniIngredients() {
        molhoDeTomate = new Ingredients("MOLHO DE TOMATE");
        mussarela = new Ingredients("MUSSARELA");
        parmesao = new Ingredients("PARMESAO");
        gorgonzola = new Ingredients("GORGONZOLA");
        requeijao = new Ingredients("REQUEIJAO");
        atum = new Ingredients("ATUM");
        cebola = new Ingredients("CEBOLA");
        alho = new Ingredients("ALHO FRITO");
        azeitona = new Ingredients("AZEITONA PRETA");
        tomate = new Ingredients("TOMATE");
        manjericao = new Ingredients("MANJERICAO");
        frango = new Ingredients("FRANGO DESFIADO");
        calabresa = new Ingredients("CALABRESA MOIDA");
        ervaDoce = new Ingredients("ERVA DOCE");
        tomateCereja = new Ingredients("TOMATE CEREJA");
        muzzarelaBufala = new Ingredients("MUSSARELA DE BUFALA");
        rucula = new Ingredients("RUCULA");
        presunto = new Ingredients("PRESUNTO CRU");
        camarao = new Ingredients("CAMARAO");
        salsinha = new Ingredients("SALSINHA");
        chocolate = new Ingredients("CHOCOLATE");
        cremeDeLeite = new Ingredients("CREME DE LEITE");
        morango = new Ingredients("MORANGO");
        ingQuatroQueijos.add(molhoDeTomate);
        ingQuatroQueijos.add(mussarela);
        ingQuatroQueijos.add(parmesao);
        ingQuatroQueijos.add(gorgonzola);
        ingQuatroQueijos.add(requeijao);
        ingAtum.add(molhoDeTomate);
        ingAtum.add(atum);
        ingAtum.add(mussarela);
        ingAtum.add(cebola);
        ingAlho.add(molhoDeTomate);
        ingAlho.add(mussarela);
        ingAlho.add(alho);
        ingAlho.add(azeitona);
        ingMarguerita.add(molhoDeTomate);
        ingMarguerita.add(mussarela);
        ingMarguerita.add(tomate);
        ingMarguerita.add(manjericao);
        ingMarguerita.add(parmesao);
        ingFrango.add(molhoDeTomate);
        ingFrango.add(frango);
        ingFrango.add(mussarela);
        ingFrango.add(requeijao);
        ingFrango.add(azeitona);
        ingCalabresa.add(molhoDeTomate);
        ingCalabresa.add(mussarela);
        ingCalabresa.add(calabresa);
        ingCalabresa.add(cebola);
        ingArtesanal.add(calabresa);
        ingArtesanal.add(molhoDeTomate);
        ingArtesanal.add(ervaDoce);
        ingArtesanal.add(manjericao);
        ingTomazza.add(molhoDeTomate);
        ingTomazza.add(mussarela);
        ingTomazza.add(parmesao);
        ingTomazza.add(tomateCereja);
        ingTomazza.add(manjericao);
        ingTomazza.add(muzzarelaBufala);
        ingCamarao.add(molhoDeTomate);
        ingCamarao.add(camarao);
        ingCamarao.add(alho);
        ingCamarao.add(salsinha);
        ingCamarao.add(mussarela);
        ingChocolate.add(chocolate);
        ingChocolate.add(cremeDeLeite);
        ingSensacao.add(chocolate);
        ingSensacao.add(cremeDeLeite);
        ingSensacao.add(morango);
        ingNapoli.add(molhoDeTomate);
        ingNapoli.add(mussarela);
        ingNapoli.add(rucula);
        ingNapoli.add(presunto);
        ingNapoli.add(muzzarelaBufala);
        ingNapoli.add(azeitona);

    }

    private void iniSize() {
        pequenaNormais = new Size(4,"PEQUENA", new BigDecimal(37.00));
        mediaNormais = new Size(6,"MEDIA", new BigDecimal(43.00));
        grandeNormais = new Size(8, "GRANDE", new BigDecimal(50.00));
        pequenaEspeciais = new Size(4,"PEQUENA", new BigDecimal(45.00));
        mediaEspeciais = new Size(6,"MEDIA", new BigDecimal(51.00));
        grandeEspeciais = new Size(8, "GRANDE", new BigDecimal(61.00));
        pequenaDoces = new Size(4,"PEQUENA", new BigDecimal(35.00));
        mediaDoces = new Size(6,"MEDIA", new BigDecimal(41.00));
        grandeDoces= new Size(8, "GRANDE", new BigDecimal(48.00));
        normal.add(pequenaNormais);
        normal.add(mediaNormais);
        normal.add(grandeNormais);
        especial.add(pequenaEspeciais);
        especial.add(mediaEspeciais);
        especial.add(grandeEspeciais);
        doce.add(pequenaDoces);
        doce.add(mediaDoces);
        doce.add(grandeDoces);
    }

    private void iniPizza() {
        pizzaQuatroQueijos = new Pizza("PIZZA DE QUATRO QUEIJOS", ingQuatroQueijos, normal, ingQuatroQueijos.size());
        pizzaAtum = new Pizza("PIZZA DE ATUM", ingAtum, normal, ingAtum.size());
        pizzaAlho = new Pizza("PIZZA DE ALHO", ingAlho, normal, ingAlho.size());
        pizzaMarguerita = new Pizza("PIZZA DE MARGUERITA", ingMarguerita, normal, ingMarguerita.size());
        pizzaFrango = new Pizza("PIZZA DE FRANGO", ingFrango, normal, ingFrango.size());
        pizzaCalabresa = new Pizza("PIZZA DE CALABRESA", ingCalabresa, normal, ingCalabresa.size());
        pizzaArtesanal = new Pizza("PIZZA ARTESANAL", ingArtesanal, especial, ingArtesanal.size());
        pizzaTomazza = new Pizza("PIZZA TOMAZZA", ingTomazza, especial, ingTomazza.size());
        pizzaNapoli = new Pizza("PIZZA NAPOLI", ingNapoli, especial, ingNapoli.size());
        pizzaCamarao = new Pizza("PIZZA DE CAMARAO", ingCamarao, especial, ingCamarao.size());
        pizzaChocolate = new Pizza("PIZZA DE CHOCOLATE", ingChocolate, doce, ingChocolate.size());
        pizzaSensacao = new Pizza("PIZZA DE SENSACAO", ingSensacao, doce, ingSensacao.size());
        pizza.add(pizzaQuatroQueijos);
        pizza.add(pizzaAtum);
        pizza.add(pizzaAlho);
        pizza.add(pizzaMarguerita);
        pizza.add(pizzaFrango);
        pizza.add(pizzaCalabresa);
        pizza.add(pizzaArtesanal);
        pizza.add(pizzaTomazza);
        pizza.add(pizzaNapoli);
        pizza.add(pizzaCamarao);
        pizza.add(pizzaChocolate);
        pizza.add(pizzaSensacao);
    }

    private void iniMenu(){
        menu = new Menu("PIZZARIA TUDO ACABA EM PIZZA", normal.size(), pizza.size());
        menu.writeFileMenu(pizza);
    }

    private void iniOrder(){
        totalClient1 = simulation1.orderSimulation(pizza, client1, pizzaAlho);
        totalClient2 = simulation1.orderSimulation(pizza, client2, pizzaAlho);
        totalClient3 = simulation1.orderSimulation(pizza, client3, pizzaAlho);
        totalOrders.add(totalClient1);
        totalOrders.add(totalClient2);
        totalOrders.add(totalClient3);
        report.setValueTotalPizzas(totalOrders);
        System.out.println(report.getTotalOrders());
        pizzaSorted = report.sortPizzasOrder(pizza);
    }

    private void iniReports(){
        simulation1.reportsSimulation(pizzaSorted, report, pizzaAlho);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.iniClients();
        test.iniArchiveClients();
        test.iniIngredients();
        test.iniSize();
        test.iniPizza();
        test.iniMenu();
        Simulation simulation = new Simulation();
        simulation.readArchiveClients();
        simulation.readArchiveMenu();
        test.iniOrder();
        test.iniReports();
    }
}
