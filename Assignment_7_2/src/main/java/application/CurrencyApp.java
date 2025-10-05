package application;

import dao.CurrencyDao;

import javax.swing.*;
import java.awt.*;

public class CurrencyApp extends JFrame {

    private JTextField currencyField;
    private JTextField amountField;
    private JTextArea outputArea;
    private CurrencyDao currencyDao = new CurrencyDao();

    public CurrencyApp() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Currency (e.g., USD, EUR):"));
        currencyField = new JTextField();
        inputPanel.add(currencyField);

        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        JButton convertButton = new JButton("Convert");
        inputPanel.add(convertButton);

        add(inputPanel, BorderLayout.NORTH);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button Action
        convertButton.addActionListener(e -> convertCurrency());
    }

    private void convertCurrency() {
        String currency = currencyField.getText().trim();
        double amount;

        try {
            amount = Double.parseDouble(amountField.getText().trim());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid amount entered!");
            return;
        }

        double rate = currencyDao.getExchangeRate(currency);
        if (rate == 0.0) {
            outputArea.setText("Error: Could not fetch exchange rate. Please check currency or database connection.");
            return;
        }

        double converted = amount * rate;
        outputArea.setText(amount + " " + currency + " = " + converted + " in base currency");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CurrencyApp().setVisible(true);
   });
}
}
