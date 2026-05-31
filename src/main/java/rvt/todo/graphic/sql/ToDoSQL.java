package rvt.todo.graphic.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import java.sql.SQLException;

public class ToDoSQL {
    private static final String db_url = "jdbc:sqlite:nkdata.db";

    public ToDoSQL() {
        initSchema();
    }

    public static void initSchema() {
        String sql =
        """
        CREATE TABLE IF NOT EXISTS todo (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        task TEXT NOT NULL
        ) STRICT;
        """;
        try (
            Connection conn =
            DriverManager.getConnection(db_url);
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeErrorException(null, "Schema init failed: " + e.getMessage());
        }
    }

    public void remove(int index) {
        String sql = "DELETE FROM todo WHERE id=?";
        try (
            Connection conn =
                DriverManager.getConnection(db_url);

            PreparedStatement prst =
                conn.prepareStatement(sql);
        ) {
            prst.setInt(1, index);
            prst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Aw man, no deletin' today, dawg");
        }
    }

    public ArrayList<String> getAll() {
        ArrayList<String> util = new ArrayList<>();
        String sql = "SELECT * FROM todo";
        try (
            Connection conn =
                DriverManager.getConnection(db_url);

            PreparedStatement prst =
                conn.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();
        ) {
            while (rs.next()) {

                int id = rs.getInt("id");
                String task = rs.getString("task");

                System.out.println(task + " (ID:" + " " + id + ")");
                util.add(task + " (ID:" + " " + id + ")");
            }
        } catch (Exception e) {
            System.out.println("Ouch! Errors!");
        }
        return util;
    }

    public void add(String task) {
        String sql =
            "INSERT INTO todo (task) VALUES (?);";

        try (
            Connection conn =
                DriverManager.getConnection(db_url);
            PreparedStatement stmt =
                conn.prepareStatement(sql);
        ) {

            stmt.setString(1, task);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeErrorException(
                null,
                "Error happened: " + e.getMessage()
            );
        }
    }
}