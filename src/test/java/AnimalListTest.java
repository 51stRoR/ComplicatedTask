import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AnimalListTest {

    @Test(dataProvider = "animalsListForFilter", dataProviderClass = AnimalsDataProvider.class)
    public void checkFilterByAgeTest(AnimalsList animals, AnimalsList filteredBirdsExpected, int yearToCheck){
        //arrange - by data provider
        //act
        List<Animal> filteredBirdsActual = animals.getBirdsOlderThenYear(yearToCheck);;
        //assert
        Assert.assertEquals(filteredBirdsActual, filteredBirdsExpected.getList());
    }
    @Test(dataProvider = "animalsListForSorting", dataProviderClass = AnimalsDataProvider.class)
    public void checkSortingBySpeciesTest(AnimalsList animals, AnimalsList sortedAnimalsExpected){
        //arrange
        //act
        List<Animal> sortedAnimalsActual = animals.sortBySpecies();
        //assert
        Assert.assertEquals(sortedAnimalsActual, sortedAnimalsExpected.getList());
    }

}
