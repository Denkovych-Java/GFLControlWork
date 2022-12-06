package manufacturer;

public class Manufacturer implements ManufacturerInterface{
    private String name;
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Country: " + country);
        System.out.println();
    }

}
