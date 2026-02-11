package streg;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TablePrintUtility  {
    private final String path = "src/main/java/streg/regdata.csv";

    public void printTable(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));

        List<String[]> rows = new ArrayList<>();
        for (String line : lines) {
            rows.add(line.split(","));
        }

        if (rows.isEmpty()) return;

        int columnCount = rows.get(0).length;
        int[] columnWidths = new int[columnCount];

        // Calculate max width of each column
        for (String[] row : rows) {
            for (int i = 0; i < columnCount; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].trim().length());
            }
        }

        // Print top border
        printBorder(columnWidths);

        // Print rows
        for (int i = 0; i < rows.size(); i++) {
            printRow(rows.get(i), columnWidths);

            // Print separator after header
            if (i == 0) {
                printBorder(columnWidths);
            }
        }

        // Print bottom border
        printBorder(columnWidths);
    }

    private void printBorder(int[] widths) {
        System.out.print("+");
        for (int width : widths) {
            System.out.print("-".repeat(width + 2) + "+");
        }
        System.out.println();
    }

    private void printRow(String[] row, int[] widths) {
        System.out.print("|");
        for (int i = 0; i < widths.length; i++) {
            System.out.print(" " + padRight(row[i].trim(), widths[i]) + " |");
        }
        System.out.println();
    }

    private String padRight(String text, int length) {
        return String.format("%-" + length + "s", text);
    }
}
