package view;

import controller.CurrencyController;
import model.Currency;

import java.util.List;
import java.util.Scanner;

public class CurrencyConverterView {

    private CurrencyController controller;
    private Scanner scanner;

    public CurrencyConverterView(CurrencyController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Currency Converter!");

        List<Currency> currencies = controller.getAllCurrencies();
        System.out.println("Available currencies:");
        currencies.forEach(c -> System.out.println(c.getAbbreviation() + " - " + c.getName()));

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("From currency (abbreviation): ");
        String from = scanner.next();

        System.out.print("To currency (abbreviation): ");
        String to = scanner.next();

        try {
            double result = controller.convert(from, to, amount);
            System.out.println(amount + " " + from + " = " + result + " " + to);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
