package souvenirs;

import manufacturer.Manufacturer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class SouvenirTest {
    Souvenir souvenir;
    @BeforeMethod
    public void setUp() {
        souvenir = new Souvenir("Name",new Manufacturer("ManufacturerName","Country"),new GregorianCalendar(2021, 1, 1),new BigDecimal("10.00"));
    }

    @Test
    public void testGetName() {
        String expected = "Name";
        assertThat(souvenir.getName()).isEqualTo(expected);
    }

    @Test
    public void testGetManufacturer() {
        String expectedName = "ManufacturerName";
        String expectedCountry = "Country";
        Manufacturer expected = new Manufacturer(expectedName,expectedCountry);
        assertThat(souvenir.getManufacturer().getName()).isEqualTo(expected.getName());
        assertThat(souvenir.getManufacturer().getCountry()).isEqualTo(expected.getCountry());
    }

    @Test
    public void testGetDate() {
        Calendar expected = new GregorianCalendar(2021, 1, 1);
        assertThat(souvenir.getDate()).isEqualTo(expected);
    }

    @Test
    public void testGetPrice() {
        BigDecimal expected = new BigDecimal("10.00");
        assertThat(souvenir.getPrice()).isEqualTo(expected);
    }
    @DataProvider(name = "tester1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Name1"},
                {"Name2"},
                {"Name3"}
        };
    }
    @Test(dataProvider = "tester1")
    public void testSetName(String name) {
        String expected = name;
        souvenir.setName(name);
        assertThat(souvenir.getName()).isEqualTo(expected);
    }

    @DataProvider(name = "tester2")
    public Object[][] createData2() {
        return new Object[][]{
                {"NameManufacturer1","Country1"},
                {"NameManufacturer2","Country2"},
                {"NameManufacturer3","Country3"}
        };
    }
    @Test(dataProvider = "tester2")
    public void testSetManufacturer(String nameManufacturer, String country) {
        souvenir.setManufacturer(new Manufacturer(nameManufacturer,country));
        assertThat(souvenir.getManufacturer().getName()).isEqualTo(nameManufacturer);
        assertThat(souvenir.getManufacturer().getCountry()).isEqualTo(country);

    }
    @Test
    public void testSetDate() {
        Calendar expected = new GregorianCalendar(2022, 2, 2);
        int year = 2022;
        int month = 2;
        int day = 2;
        souvenir.setDate(new GregorianCalendar(year,month,day));
        assertThat(souvenir.getDate()).isEqualTo(expected);
    }

    @Test
    public void testSetPrice() {
        BigDecimal expected = new BigDecimal("99.99");
        souvenir.setPrice(new BigDecimal("99.99"));
        assertThat(souvenir.getPrice()).isEqualTo(expected);
    }
}