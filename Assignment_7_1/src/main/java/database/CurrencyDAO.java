package database;

import model.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDAO {

    /**
     * Load all currencies from the database table `Currency`.
     * Expects columns: abbreviation, name, rate_to_usd
     */
    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        String query = "SELECT abbreviation, name, rate_to_usd FROM Currency";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String abbreviation = rs.getString("abbreviation");
                String name = rs.getString("name");
                double rateToUsd = rs.getDouble("rate_to_usd");

                // Use the constructor without id (your model supports this)
                Currency currency = new Currency(abbreviation, name, rateToUsd);
                currencies.add(currency);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }

    /**
     * Convenience: fetch a single currency by abbreviation (optional).
     * Returns null if not found.
     */
    public Currency getCurrencyByAbbreviation(String abbreviation) {
        String query = "SELECT abbreviation, name, rate_to_usd FROM Currency WHERE abbreviation = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, abbreviation);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Currency(
                            rs.getString("abbreviation"),
                            rs.getString("name"),
                            rs.getDouble("rate_to_usd")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
