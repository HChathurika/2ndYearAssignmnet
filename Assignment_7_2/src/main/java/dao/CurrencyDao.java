package dao;

import entity.Currency;
import datasource.MariaDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {

    // Method to fetch exchange rate for a given currency abbreviation
    public double getExchangeRate(String abbreviation) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT rate_to_usd FROM currency WHERE abbreviation = ?";
        double rate = 0.0; // default if not found

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, abbreviation);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rate = rs.getDouble("rate_to_usd");
                } else {
                    System.out.println("Currency not found: " + abbreviation);
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error while fetching rate: " + e.getMessage());
        }

        return rate;}
}