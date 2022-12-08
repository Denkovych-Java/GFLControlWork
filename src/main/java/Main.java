import IO.EditFiles;
import IO.Files;
import manufacturer.Manufacturer;
import souvenirs.Souvenir;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class Main {
    private String directory;

    public static void main(String[] args) {

        Souvenir souvenir1 = new Souvenir("Plate", new Manufacturer("Ferrari", "Italy"), new GregorianCalendar(2021, 3, 1), new BigDecimal("60.00"));
        Souvenir souvenir2 = new Souvenir("Shirt", new Manufacturer("Ferrari", "Italy"), new GregorianCalendar(2022, 12, 4), new BigDecimal("249.50"));
        Souvenir souvenir3 = new Souvenir("Sticker", new Manufacturer("Apple", "USA"), new GregorianCalendar(2018, 3, 27), new BigDecimal("40.50"));
        Souvenir souvenir4 = new Souvenir("Shirt", new Manufacturer("Apple", "USA"), new GregorianCalendar(2021, 1, 10), new BigDecimal("100.50"));
        Souvenir souvenir5 = new Souvenir("Shirt", new Manufacturer("Google", "USA"), new GregorianCalendar(2021, 8, 15), new BigDecimal("80.50"));
        Souvenir souvenir6 = new Souvenir("Backpack", new Manufacturer("Google", "USA"), new GregorianCalendar(2020, 3, 12), new BigDecimal("75.00"));
        Souvenir souvenir7 = new Souvenir("Plate", new Manufacturer("Amazon", "USA"), new GregorianCalendar(2019, 7, 23), new BigDecimal("60.00"));
        Souvenir souvenir8 = new Souvenir("Fork", new Manufacturer("Amazon", "USA"), new GregorianCalendar(2020, 9, 5), new BigDecimal("20.00"));
        Souvenir souvenir9 = new Souvenir("Puzzle", new Manufacturer("Tesco", "UK"), new GregorianCalendar(2018, 11, 20), new BigDecimal("35.50"));
        Souvenir souvenir10 = new Souvenir("Shirt", new Manufacturer("Kyivstar", "Ukraine"), new GregorianCalendar(2019, 5, 11), new BigDecimal("50.00"));
        Souvenir souvenir11 = new Souvenir("Sticker", new Manufacturer("Kyivstar", "Ukraine"), new GregorianCalendar(2022, 6, 18), new BigDecimal("30.00"));

        Manufacturer manufacturer1 = new Manufacturer("Ferrari", "Italy");
        Manufacturer manufacturer2 = new Manufacturer("Apple", "USA");
        Manufacturer manufacturer3 = new Manufacturer("Google", "USA");
        Manufacturer manufacturer4 = new Manufacturer("Amazon", "USA");
        Manufacturer manufacturer5 = new Manufacturer("Tesco", "UK");
        Manufacturer manufacturer6 = new Manufacturer("Kyivstar", "Ukraine");

        EditFiles.addSouvenir(souvenir1);
        EditFiles.addSouvenir(souvenir2);
        EditFiles.addSouvenir(souvenir3);
        EditFiles.addSouvenir(souvenir4);
        EditFiles.addSouvenir(souvenir5);
        EditFiles.addSouvenir(souvenir6);
        EditFiles.addSouvenir(souvenir7);
        EditFiles.addSouvenir(souvenir8);
        EditFiles.addSouvenir(souvenir9);
        EditFiles.addSouvenir(souvenir10);
        EditFiles.addSouvenir(souvenir11);

        EditFiles.addManufacturer(manufacturer1);
        EditFiles.addManufacturer(manufacturer2);
        EditFiles.addManufacturer(manufacturer3);
        EditFiles.addManufacturer(manufacturer4);
        EditFiles.addManufacturer(manufacturer5);
        EditFiles.addManufacturer(manufacturer6);

    }
}