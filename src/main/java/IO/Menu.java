package IO;

public class Menu {
}
//        Souvenir souvenir1 = new Souvenir("Cup", new Manufacturer("Roshen", "Ukraine"), new GregorianCalendar(2020, 7 , 4), 120.50f);
//        Souvenir souvenir2 = new Souvenir("Candy", new Manufacturer("Roshen", "Ukraine"), new GregorianCalendar(2021, 5 , 25), 25.75f);
//        Souvenir souvenir3 = new Souvenir("Painting", new Manufacturer("Roshen", "Ukraine"), new GregorianCalendar(2019, 6 , 22), 50.00f);
//        Souvenir souvenir4 = new Souvenir("Cup", new Manufacturer("Milka", "France"), new GregorianCalendar(2020, 7 , 21), 55.00f);
//        Souvenir souvenir5 = new Souvenir("Case", new Manufacturer("Milka", "France"), new GregorianCalendar(2021, 9 , 15), 100.00f);
//        Souvenir souvenir6 = new Souvenir("Packet", new Manufacturer("Valve", "Poland"), new GregorianCalendar(2022, 1 , 19), 160.20f);
//        Souvenir souvenir7 = new Souvenir("Golden apple", new Manufacturer("Google", "USA"), new GregorianCalendar(2018, 7 , 5), 200.99f);
//        Souvenir souvenir8 = new Souvenir("Trinket", new Manufacturer("Microsoft", "USA"), new GregorianCalendar(2022, 10 , 4), 50.00f);
//        Souvenir souvenir9 = new Souvenir("Cup", new Manufacturer("Privat", "Ukraine"), new GregorianCalendar(2016, 4 , 22), 89.00f);
//        Souvenir souvenir10 = new Souvenir("Trinket", new Manufacturer("Prada", "Italy"), new GregorianCalendar(2016, 1 , 30), 180.00f);
//        Manufacturer manufacturer1 = new Manufacturer("Roshen", "Ukraine");
//        Manufacturer manufacturer2 = new Manufacturer("Milka", "France");
//        Manufacturer manufacturer3 = new Manufacturer("Valve", "Poland");
//        Manufacturer manufacturer4 = new Manufacturer("Google", "USA");
//        Manufacturer manufacturer5 = new Manufacturer("Microsoft", "USA");
//        Manufacturer manufacturer6 = new Manufacturer("Privat", "Ukraine");
//        Manufacturer manufacturer7 = new Manufacturer("Prada", "Italy");
//        SouvenirsUtils.addSouvenirToList(souvenir1);
//        SouvenirsUtils.addSouvenirToList(souvenir2);
//        SouvenirsUtils.addSouvenirToList(souvenir3);
//        SouvenirsUtils.addSouvenirToList(souvenir4);
//        SouvenirsUtils.addSouvenirToList(souvenir5);
//        SouvenirsUtils.addSouvenirToList(souvenir6);
//        SouvenirsUtils.addSouvenirToList(souvenir7);
//        SouvenirsUtils.addSouvenirToList(souvenir8);
//        SouvenirsUtils.addSouvenirToList(souvenir9);
//        SouvenirsUtils.addSouvenirToList(souvenir10);
//        SouvenirsUtils.addManufacturerToList(manufacturer1);
//        SouvenirsUtils.addManufacturerToList(manufacturer2);
//        SouvenirsUtils.addManufacturerToList(manufacturer3);
//        SouvenirsUtils.addManufacturerToList(manufacturer4);
//        SouvenirsUtils.addManufacturerToList(manufacturer5);
//        SouvenirsUtils.addManufacturerToList(manufacturer6);
//        SouvenirsUtils.addManufacturerToList(manufacturer7);
        Backup.readFromFile();
                while(true) {
                Menu.printMenu();
                int choise = getChoise(8);
                String str;
                switch (choise) {
                case 1:
                Menu.menuAddEditPrint();
                break;
                case 2:
                System.out.print("Print manufacturer: ");
                str = getString();
                SouvenirsUtils.printSouvenirsFromOneManufacturer(str);
                break;
                case 3:
                System.out.print("Print country: ");
                str = getString();
                SouvenirsUtils.printSouvenirsFromOneCountry(str);
                break;
                case 4:
                System.out.print("Print price: ");
                float price = getFloat();
                SouvenirsUtils.printManufacturerWithLowerPrice(price);
                break;
                case 5:
                SouvenirsUtils.printAllManufacturerWithAllSouvenir();
                break;
                case 6:
                System.out.print("Print name souvenir: ");
                str = getString();
                System.out.print("Print year:");
                int year = getInt();
                SouvenirsUtils.printManufacturerWithSpecifiedYear(str, year);
                break;
                case 7:
                SouvenirsUtils.printSouvenirsByYear();
                break;
                case 8:
                System.out.print("Print manufacturer name: ");
                str = getString();
                SouvenirsUtils.deleteManufacturerWithSouvenir(str);
                break;
                case 0:
                Backup.writeInFile();
                return;
                }
                }

                }

public static int getChoise(int max){
        int choise = -1;
        while(choise < 0 || choise > max){
        Scanner scanner = new Scanner(System.in);
        choise = scanner.nextInt();
        }
        return choise;
        }

public static String getString(){
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        return str;
        }

public static float getFloat(){
        float f;
        Scanner scanner = new Scanner(System.in);
        f = scanner.nextFloat();
        return f;
        }

public static Integer getInt(){
        int i;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        return i;
        }

        }
        }










public class Menu {
    public static void printMenu(){
        System.out.println("[1] Add/Edit/Print all manufacturers/souvenirs");
        System.out.println("[2] Display information about souvenirs of the given manufacturer");
        System.out.println("[3] Display information about souvenirs made in the given country");
        System.out.println("[4] Display information about manufacturers whose prices for souvenirs less than specified");
        System.out.println("[5] Display information on all manufacturers and, for each manufacturer, display information about all the souvenirs he produces");
        System.out.println("[6] Display information about the manufacturers of the given souvenir, made in the given time year");
        System.out.println("[7] For each year, list the souvenirs made that year");
        System.out.println("[8] Delete a given manufacturer and its souvenirs");
        System.out.println("[0] Exit");
        System.out.print("  Make choise: ");
    }

    public static int getChoise(int max){
        int choise = -1;
        while(choise < 0 || choise > max){
            Scanner scanner = new Scanner(System.in);
            choise = scanner.nextInt();
        }
        return choise;
    }

    public static String getString(){
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        return str;
    }

    public static float getFloat(){
        float f;
        Scanner scanner = new Scanner(System.in);
        f = scanner.nextFloat();
        return f;
    }

    public static Integer getInt(){
        int i;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        return i;
    }

    public static void menuAddEditPrint(){
        int choise;
        while(true) {
            printMenuAddEditPrint();
            choise = getChoise(3);
            switch (choise) {
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
            }
        }
    }
    public static void printMenuAddEditPrint(){
        System.out.println("[1] Add");
        System.out.println("[2] Edit");
        System.out.println("[3] Print");
        System.out.println("[0] Exit");
        System.out.print("  Make choise: ");
    }

    public static void menuAdd(){
        int choise;
        while(true) {
            printMenuAdd();
            choise = getChoise(2);
            switch (choise) {
                case 1:
                    addSouvenir();
                    Backup.writeInFile();
                    break;
                case 2:
                    addManufacturer();
                    Backup.writeInFile();
                    break;
                case 0:
                    return;
            }
        }
    }
    public static void printMenuAdd(){
        System.out.println("[1] Add souvenir");
        System.out.println("[2] Add manufacturer");
        System.out.println("[0] Exit");
        System.out.print("  Make choise: ");
    }

    public static void addSouvenir(){
        String nameSouvenir, nameManufacturer, country = null;
        int day,mounth,year;
        float price;
        System.out.print("Print name: ");
        nameSouvenir = getString();
        System.out.print("Print manufacturer name: ");
        nameManufacturer = getString();
        if(!SouvenirsUtils.manufacturerExist(nameManufacturer)){
            System.out.println("This manufacturer isn't exist");
            return;
        }
        for (Manufacturer manufacturer : SouvenirsUtils.getManufacturerList()) {
            if (manufacturer.getName().equals(nameManufacturer)) {
                country = manufacturer.getCountry();
            }
        }
        System.out.print("Print day: ");
        day = getInt();
        System.out.print("Print mounth: ");
        mounth = getInt();
        System.out.print("Print year: ");
        year = getInt();
        System.out.print("Print price: ");
        price = getFloat();

        SouvenirsUtils.addSouvenirToList(new Souvenir(nameSouvenir, new Manufacturer(nameManufacturer, country), new GregorianCalendar(year, mounth, day), price));
    }

    public static void addManufacturer(){
        String nameManufacturer, country;
        System.out.print("Print name: ");
        nameManufacturer = getString();
        if(SouvenirsUtils.manufacturerExist(nameManufacturer)){
            System.out.println("This manufacturer exist");
            return;
        }
        System.out.print("Print country: ");
        country = getString();
        SouvenirsUtils.addManufacturerToList(new Manufacturer(nameManufacturer, country));
    }

    public static void menuEdit(){
        int choise;
        while(true) {
            printMenuEdit();
            choise = getChoise(2);
            switch (choise) {
                case 1:
                    editSouvenir();
                    Backup.writeInFile();
                    break;
                case 2:
                    editManufacturer();
                    Backup.writeInFile();
                    break;
                case 0:
                    return;
            }
        }
    }
    public static void printMenuEdit(){
        System.out.println("[1] Edit souvenirs");
        System.out.println("[2] Edit manufacturers");
        System.out.println("[0] Exit");
        System.out.print("  Make choise: ");
    }

    public static void editSouvenir(){
        String nameSouvenir, nameManufacturer, country = null;
        int day,mounth,year;
        float price;
        ArrayList<Souvenir> souvenirArrayList = SouvenirsUtils.getSouvenirList();
        for(int i = 0; i < souvenirArrayList.size(); i++){
            System.out.println("["+i+"] souvenir");
        }
        System.out.print("Print choise: ");
        int choise = getChoise(souvenirArrayList.size());
        int i = choise;
        souvenirArrayList.get(choise).print();
        System.out.println("Choose what to edit:");
        System.out.println("[1] Name");
        System.out.println("[2] Manufacturer name");
        System.out.println("[3] Date");
        System.out.println("[4] Price");
        System.out.println("[0] Exit");
        System.out.print("  Please, make a choise: ");
        choise = getChoise(4);
        switch (choise) {
            case 1:
                System.out.print("Print name: ");
                nameSouvenir = getString();
                souvenirArrayList.get(i).setName(nameSouvenir);
                break;
            case 2:
                System.out.print("Print manufacturer name: ");
                nameManufacturer = getString();
                if(!SouvenirsUtils.manufacturerExist(nameManufacturer)){
                    System.out.println("This manufacturer isn't exist");
                    return;
                }
                for (Manufacturer manufacturer : SouvenirsUtils.getManufacturerList()) {
                    if (manufacturer.getName().equals(nameManufacturer)) {
                        country = manufacturer.getCountry();
                    }
                }
                souvenirArrayList.get(i).setManufacturer(new Manufacturer(nameManufacturer, country));
                break;
            case 3:
                System.out.print("Print day: ");
                day = getInt();
                System.out.print("Print mounth: ");
                mounth = getInt();
                System.out.print("Print year: ");
                year = getInt();
                souvenirArrayList.get(i).getDate().set(year, mounth, day);
                break;
            case 4:
                System.out.print("Print price: ");
                price = getFloat();
                souvenirArrayList.get(i).setPrice(price);
                break;
            case 0:
                return;
        }
    }

    public static void editManufacturer(){
        String nameManufacturer, country;
        ArrayList<Manufacturer> manufacturerArrayList = SouvenirsUtils.getManufacturerList();
        for(int i = 0; i < manufacturerArrayList.size(); i++){
            System.out.println("["+i+"] manufacturer");
        }
        System.out.print("Print choise: ");
        int choise = getChoise(manufacturerArrayList.size());
        int i = choise;
        manufacturerArrayList.get(choise).print();
        System.out.println("Choose what to edit:");
        System.out.println("[0] Name");
        System.out.println("[1] Country");
        System.out.println("[2] Exit");
        System.out.print("  Please, make a choise: ");
        choise = getChoise(2);
        switch (choise) {
            case 0:
                System.out.print("Print name: ");
                nameManufacturer = getString();
                manufacturerArrayList.get(i).setName(nameManufacturer);
                break;
            case 1:
                System.out.print("Print country: ");
                country = getString();
                manufacturerArrayList.get(i).setCountry(country);
                break;
            case 2:
                return;
        }
    }

    public static void menuPrint(){
        ArrayList<Souvenir> souvenirArrayList = SouvenirsUtils.getSouvenirList();
        ArrayList<Manufacturer> manufacturerArrayList = SouvenirsUtils.getManufacturerList();
        System.out.println("    All manufacturers:");
        for (Manufacturer manufacturer : manufacturerArrayList){
            manufacturer.print();
        }
        System.out.println("    All souvenirs:");
        for (Souvenir souvenir : souvenirArrayList){
            souvenir.print();
        }
    }
}