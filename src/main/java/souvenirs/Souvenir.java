package souvenirs;

import manufacturer.Manufacturer;
import manufacturer.ManufacturerInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

public class Souvenir implements SouvenirInterface {
    private String name;
    private ManufacturerInterface manufacturer;
    private Calendar date;
    private BigDecimal price;

    public Souvenir(String name, ManufacturerInterface manufacturer, Calendar date, BigDecimal price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.date = date;
        this.price = price;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Manufacturer getManufacturer() {
        return (Manufacturer) manufacturer;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.CEILING);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setManufacturer(ManufacturerInterface manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name);
        manufacturer.print();
        System.out.println("Date: " + date.getTime());
        System.out.println("Price: " + getPrice());
        System.out.println();
    }
}
