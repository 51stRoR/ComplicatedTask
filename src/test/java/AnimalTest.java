import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalTest {
    @DataProvider(name = "checkAge")
    public Object[][] createAge() {
        return new Object[][]{
                {LocalDate.now().minusMonths(35).format(DateTimeFormatter.ISO_LOCAL_DATE), 2}
        };
    }

    @Test(dataProvider = "checkAge")
    public void checkGetAgeMethodTest(String birthYear, int expectedResult){
        //arrange
        Bird testBird = new Bird(birthYear, "white", Species.EAGLE, 5);
        //act
        int actualResult = testBird.getAge();
        //assert
        Assert.assertEquals(actualResult, expectedResult, "GetAge method calculate full years incorrectly");
    }
}
