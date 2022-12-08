package souvenirs;

import manufacturer.Manufacturer;
import manufacturer.ManufacturerInterface;

import java.math.BigDecimal;
import java.util.Calendar;

public interface SouvenirInterface {
    String getName();

    Manufacturer getManufacturer();

    Calendar getDate();

    BigDecimal getPrice();

    void setName(String name);


    void setManufacturer(ManufacturerInterface manufacturer);

    void setDate(Calendar date);

    void setPrice(BigDecimal price);

    void print();


}
