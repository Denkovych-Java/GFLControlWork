package manufacturer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManufacturerTest {
    Manufacturer manufacturer;
    @BeforeMethod
    public void setUp() {
        manufacturer = new Manufacturer("testName","testCountry");
    }


    @Test
    public void testGetName() {
        String expected = "testName";
        assertThat(manufacturer.getName()).isEqualTo(expected);
    }

    @Test
    public void testSetName() {
        String expected = "new"+"Name";
        manufacturer.setName(expected);
        assertThat(manufacturer.getName()).isEqualTo(expected);
    }

    @Test
    public void testGetCountry() {
        String expected = "testCountry";
        assertThat(manufacturer.getCountry()).isEqualTo(expected);
    }

    @Test
    public void testSetCountry() {
        String expected = "newCountry" ;
        manufacturer.setName(expected);
        assertThat(manufacturer.getName()).isEqualTo(expected);
    }

}