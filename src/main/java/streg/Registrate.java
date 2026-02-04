package streg;

import java.io.*;
import java.util.*;
import java.time.*;

public class Registrate {
    //intermediary array to store the data from csv
    private ArrayList<String> intermed = new ArrayList<>();; 
    //names of the csv columns
    private final String columnnames = "vards,uzvards,epasts,perskods,timestamp";
    private final Scanner scanner = new Scanner(System.in); //scanner inside the class
    private final String path = "src/main/java/streg/regdata.csv"; //path to csv

    public Registrate() {
        // each time a registrate class is created, the data from csv is loaded
        loadFromFile();
    }

    public void register() {
        /**
         * The function to register a student
         * In separate variables are saved
         * the NAME, the SURNAME, the EMAIL, the PERSONAL CODE,
         * and a TIMESTAMP of registration is created
         * Then, they are written to the CSV   
         * TODO: add regex for data integrity checking
         */
        System.out.println("Ievadi studenta vardu: ");
        String vards = scanner.nextLine();
        System.out.println("Ievadi studenta uzvardu: ");
        String uzvards = scanner.nextLine();
        System.out.println("Ievadi studenta e-pastu: ");
        String epasts = scanner.nextLine();
        System.out.println("Ievadi studenta personalo kodu: ");
        String perskod = scanner.nextLine();
        LocalDateTime stamp = LocalDateTime.now();
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println(vards + "," + uzvards + "," + epasts + "," + perskod + "," + stamp);
        }
        catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void show() {
        /**
         * Function for reading all data from the CSV
         */
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

    }

    public void remove() {

    }

    public void edit() {

    }

    private void loadFromFile() {
        /**
         * The function that loads the CSV contents
         * to the intermediary ArrayList
         */
        String line;
        boolean isHeader = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                if (!line.trim().isEmpty()) {
                    intermed.add(line.trim());
                }
            }
            br.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    private void uploadToFile() {
        /**
         * Internal function made to upload data
         * from the ArrayList to the CSV
         * TODO: finish and test the function
         */
        try {
            FileWriter overwriter = new FileWriter(path,false);
            FileWriter fw = new FileWriter(path,true);
            overwriter.write(columnnames);
            for (int i = 0; i < intermed.size(); i++) {
                fw.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}