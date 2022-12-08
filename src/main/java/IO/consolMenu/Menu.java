package IO.consolMenu;

import IO.EditFiles;
import IO.Files;
import manufacturer.Manufacturer;
import souvenirs.Souvenir;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.stream.IntStream;



public class Menu {
    public static void getMenu() {
        System.out.println("Select:");
        System.out.println("Add,Edit,Print manufacturers and souvenirs:         1");
        System.out.println("Print information about manufacturer's souvenirs:   2");
        System.out.println("Print information about souvenirs from country:     3");
        System.out.println("Print information about manufacturers and +" +
                "souvenirs if their price less then specified:       4");
        System.out.println("Print information about all manufacturers and " +
                "their souvenirs:                                    5");
        System.out.println("Print information about manufacturers and +" +
                "souvenirs from year:                                6");
        System.out.println("Print the all souvenirs for each year:              7");
        System.out.println("Delete manufacturer and his souvenirs:              8");
        System.out.println("Exit:                                               0");
    }

    public static void getFirstMenu() {
        System.out.println("Add:       1");
        System.out.println("Edit:      2");
        System.out.println("Print:     3");
        System.out.println("Exit:      0");
        switch (getInt()) {
            case 1:
                menuAdd();
                break;
            case 2:
                menuEdit();
                break;
            case 3:
                menuPrint();
                break;
            case 0:
                return;
            default:
                System.out.println("default");
        }
    }

    private static void menuPrint() {
        ArrayList<Souvenir> souvenirs = EditFiles.getSouvenirs();
        ArrayList<Manufacturer> manufacturers = EditFiles.getManufacturers();
        System.out.println("All manufacturers:");
        for (Manufacturer manufacturer : manufacturers){
            manufacturer.print();
        }
        System.out.println("All souvenirs:");
        for (Souvenir souvenir : souvenirs){
            souvenir.print();
        }
    }

    private static void menuAdd() {
        printSelector();
        switch (getInt()) {
            case 1:
                addSouvenir();
                break;
            case 2:
                addManufacturer();
                break;
            case 3:
                return;
            default:
                System.out.println("default");
                menuAdd();
        }
    }

    private static void addManufacturer() {
        String nameManufacturer;
        String country;
        System.out.println("Enter name: ");
        nameManufacturer = getStr();
        System.out.println("Enter country: ");
        country = getStr();
        EditFiles.addManufacturer(new Manufacturer(nameManufacturer, country));
    }

    private static void addSouvenir() {
        String nameSouvenir;
        String nameManufacturer;
        String country = null;
        int day;
        int month;
        int year;
        BigDecimal price;
        System.out.print("Enter name: ");
        nameSouvenir = getStr();
        System.out.print("Enter manufacturer name: ");
        nameManufacturer = getStr();
        System.out.print("Enter day: ");
        day = getInt();
        System.out.print("Enter month: ");
        month = getInt();
        System.out.print("Enter year: ");
        year = getInt();
        System.out.print("Enter price: ");
        price = getBD();
        EditFiles.addSouvenir(new Souvenir(nameSouvenir, new Manufacturer(nameManufacturer, country), new GregorianCalendar(year, month, day), price));
    }

    private static void menuEdit() {
        printSelector();
        switch (getInt()) {
            case 1:
                editSouvenir();
                Files.writeFiles();
                break;
            case 2:
                editManufacturer();
                Files.writeFiles();
                break;
            case 3:
                return;
            default:
                System.out.println("default");
                menuEdit();
        }
    }

    private static void editManufacturer() {
        String nameManufacturer;
        String country;
        ArrayList<Manufacturer> manufacturers = EditFiles.getManufacturers();
        IntStream.range(0, manufacturers.size()).mapToObj(i -> "[" + i + "] manufacturer").forEachOrdered(System.out::println);
        System.out.println("Select a souvenir to edit: ");
        int selectM = getInt();
        manufacturers.get(selectM).print();
        System.out.println("Select what you want to edit: ");
        System.out.println("Name                         1");
        System.out.println("Country                      2");
        System.out.println("Exit                         0");
        int selectToEdit = getInt();
        switch (selectToEdit) {
            case 1:
                System.out.print("Enter name: ");
                nameManufacturer = getStr();
                manufacturers.get(selectM).setName(nameManufacturer);
                break;
            case 2:
                System.out.print("Enter country: ");
                country = getStr();
                manufacturers.get(selectM).setCountry(country);
                break;
            case 0:
                return;
            default:
                System.out.println("The manufacturer is unedited. Please select 1-2");
                editSouvenir();
        }
    }


    private static void editSouvenir() {
        String nameSouvenir;
        String nameManufacturer;
        String country = null;
        int day;
        int month;
        int year;
        BigDecimal price;
        ArrayList<Souvenir> souvenirs = EditFiles.getSouvenirs();
        IntStream.range(0, souvenirs.size()).mapToObj(i -> "[" + i + "] souvenir").forEach(System.out::println);
        System.out.println("Select a souvenir to edit: ");
        int selectS = getInt();
        souvenirs.get(selectS).print();
        System.out.println("Select what you want to edit: ");
        System.out.println("Name                         1");
        System.out.println("Manufacturer                 2");
        System.out.println("Date                         3");
        System.out.println("Price                        4");
        System.out.println("Exit                         0");
        int selectToEdit = getInt();
        switch (selectToEdit) {
            case 1:
                System.out.print("Enter name: ");
                nameSouvenir = getStr();
                souvenirs.get(selectS).setName(nameSouvenir);
                break;
            case 2:
                System.out.print("Print manufacturer name: ");
                nameManufacturer = getStr();
                for (Manufacturer manufacturer : EditFiles.getManufacturers()) {
                    if (manufacturer.getName().equals(nameManufacturer)) {
                        country = manufacturer.getCountry();
                    }
                }
                souvenirs.get(selectS).setManufacturer(new Manufacturer(nameManufacturer, country));
                break;
            case 3:
                System.out.print("Enter day: ");
                day = getInt();
                System.out.print("Enter month: ");
                month = getInt();
                System.out.print("Enter year: ");
                year = getInt();
                souvenirs.get(selectS).getDate().set(year, month, day);
                break;
            case 4:
                System.out.print("Print price: ");
                price = getBD();
                souvenirs.get(selectS).setPrice(price);
                break;
            case 0:
                return;
            default:
                System.out.println("The souvenir is unedited. Please select 1-4");
                editSouvenir();
        }
    }

    private static void printSelector() {
        System.out.println("Souvenir:    1");
        System.out.println("Manufacturer:        2");
        System.out.println("Exit:            0");
    }


    private static String getStr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static BigDecimal getBD() {
        Scanner scanner = new Scanner(System.in);
        return new BigDecimal(scanner.nextBigInteger());
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}