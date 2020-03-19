import org.testng.annotations.DataProvider;

public class AnimalsDataProvider {

    @DataProvider(name = "animalsListForFilter")
    public static Object[][] createListForFilter() {
        AnimalsList animals = new AnimalsList();
        animals.getList().add(new Animal("2019-02-21", "black"));
        animals.getList().add(new Bird("2016-12-23", "white", Species.CROW, 5));
        animals.getList().add(new Bird("2015-12-23", "black", Species.EAGLE, 7));
        animals.getList().add(new Animal("2000-12-23", "grey"));
        animals.getList().add(new Bird("2014-12-23", "red", Species.ALBATROSS, 2));
        animals.getList().add(new Bird("2015-01-14", "red", Species.WOODPECKER, 2));
        animals.getList().add(new Animal("2000-12-23", "yellow"));
        AnimalsList animalsFiltered = new AnimalsList();
        animalsFiltered.getList().add(new Bird("2014-12-23", "red", Species.ALBATROSS, 2));
        animalsFiltered.getList().add(new Bird("2015-01-14", "red", Species.WOODPECKER, 2));
        int yearToCheck = 4;
        return new Object[][] {
                new Object[] { animals, animalsFiltered, yearToCheck }
        };
    }

    @DataProvider(name = "animalsListForSorting")
    public static Object[][] createListForSorting() {
        AnimalsList animals = new AnimalsList();
        animals.getList().add(new Animal("2019-02-21", "black"));
        animals.getList().add(new Bird("2016-12-23", "white", Species.CROW, 5));
        animals.getList().add(new Bird("2015-12-23", "black", Species.EAGLE, 7));
        animals.getList().add(new Animal("2000-12-23", "grey"));
        animals.getList().add(new Bird("2014-12-23", "red", Species.ALBATROSS, 2));
        animals.getList().add(new Bird("2015-01-14", "red", Species.WOODPECKER, 2));
        animals.getList().add(new Animal("2000-12-23", "yellow"));
        AnimalsList sortedAnimals = new AnimalsList();
        sortedAnimals.getList().add(new Bird("2014-12-23", "red", Species.ALBATROSS, 2));
        sortedAnimals.getList().add(new Bird("2016-12-23", "white", Species.CROW, 5));
        sortedAnimals.getList().add(new Bird("2015-12-23", "black", Species.EAGLE, 7));
        sortedAnimals.getList().add(new Bird("2015-01-14", "red", Species.WOODPECKER, 2));
        return new Object[][] {
                new Object[] { animals, sortedAnimals }
        };
    }


    @DataProvider(name = "utilsList")
    public static Object[][] createList() {
        AnimalsList animals = new AnimalsList();
        animals.getList().add(new Animal("2019-02-21", "black"));
        animals.getList().add(new Bird("2016-12-23", "white", Species.CROW, 5));
        animals.getList().add(new Bird("2015-12-23", "black", Species.EAGLE, 7));
        animals.getList().add(new Animal("2000-12-23", "grey"));
        animals.getList().add(new Bird("2014-12-23", "red", Species.ALBATROSS, 2));
        animals.getList().add(new Bird("2015-01-14", "red", Species.WOODPECKER, 2));
        animals.getList().add(new Animal("2000-12-23", "yellow"));
        return new Object[][] {
                new Object[] { animals }
        };
    }

}
