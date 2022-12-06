package IO;

import manufacturer.Manufacturer;
import souvenirs.Souvenir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class EditFiles {

    public static ArrayList<Manufacturer> manufacturersList = new ArrayList<>();
    public static ArrayList<Souvenir> souvenirsList = new ArrayList<>();

    public static void addManufacturer(Manufacturer manufacturer) {
        manufacturersList.add(manufacturer);
    }

    public static void addSouvenir(Souvenir souvenir) {
        souvenirsList.add(souvenir);
        for (Manufacturer m : manufacturersList) {
            if (m.getName().equals(souvenir.getManufacturer().getName())) return;
        }
    }

    public static boolean deleteSouvenir(Souvenir souvenir) {
        return souvenirsList.remove(souvenir);
    }

    public static ArrayList<Souvenir> getSouvenirs() {
        return souvenirsList;
    }

    public static ArrayList<Manufacturer> getManufacturers() {
        return manufacturersList;
    }

    public static void getSouvenirsFromManufacturer(String nameM){
        if(checkSouvenirsFromManufacturer(nameM)){
            souvenirsList.stream().filter(s -> s.getManufacturer().getName().equals(nameM)).forEach(Souvenir::print);
        }
    }
    private static boolean checkSouvenirsFromManufacturer(String nameM){
        return manufacturersList.stream().anyMatch(m -> m.getName().equals(nameM));
    }

    public static void getSouvenirsFromCountry(String country){
        if(checkSouvenirsFromCountry(country)){
            souvenirsList.stream().filter(s -> s.getManufacturer().getCountry().equals(country)).forEach(Souvenir::print);
        }
    }
    private static boolean checkSouvenirsFromCountry(String country){
        return manufacturersList.stream().anyMatch(m -> m.getCountry().equals(country));
    }
}
