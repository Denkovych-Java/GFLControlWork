package IO;

import manufacturer.Manufacturer;
import souvenirs.Souvenir;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Files {
    private static String directory;

    private void setProperties() {
        Properties properties = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config.properties"));
            properties.load(reader);
            directory = properties.getProperty("data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFiles() {
        writeFileManufacturer("souvenir.txt");
        writeFileSouvenir("manufacturer.txt");
    }

    private static void writeFileManufacturer(String dir) {
        try {
            FileWriter fileWriter = new FileWriter(directory + dir);
            ArrayList<Manufacturer> manufacturers = EditFiles.getManufacturers();
            for (Manufacturer manufacturer : manufacturers) {
                for (String m : Arrays.asList(" ", "\n" + manufacturer.getName(), "\n" + manufacturer.getCountry() + "\n")) {
                    fileWriter.write(m);
                }
            }
            fileWriter.write(";");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFileSouvenir(String dir) {
        try {
            FileWriter fileWriter = new FileWriter(directory + dir);
            ArrayList<Souvenir> souvenirs = EditFiles.getSouvenirs();
            for (Souvenir s : souvenirs) {
                fileWriter.write(" ");
                fileWriter.write("\n" + s.getName());
                fileWriter.write("\n" + s.getManufacturer().getName());
                fileWriter.write("\n" + s.getManufacturer().getCountry());
                fileWriter.write("\n" + s.getDate().getTime());
                fileWriter.write("\n" + s.getPrice() + "\n");
            }
            fileWriter.write(";");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void readFileManufacturer(String dir){
        try {
            File file = new File(directory + dir);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String sep = scanner.nextLine();
                if(sep.equals(" ")){
                    String nameSouvenir  = scanner.nextLine();
                    String nameManufacturer  = scanner.nextLine();
                    String country = scanner.nextLine();
                    String str = scanner.nextLine();
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    Calendar date = checkData(str);
                    EditFiles.addSouvenir(new Souvenir(nameSouvenir, new Manufacturer(nameManufacturer, country),date,price));
                }
                else if (sep.equals(";")){
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Calendar checkData(String str) {
        int day;
        int month;
        int year;
        day = Integer.parseInt(str.substring(0,str.indexOf(".")));
        month = Integer.parseInt(str.substring(str.indexOf(".")+1),str.lastIndexOf("."));
        year = Integer.parseInt(str.substring(str.lastIndexOf(".")+1,str.length()));
        return new GregorianCalendar(year, month, day);
    }

}