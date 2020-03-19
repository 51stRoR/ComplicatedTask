import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Rnd {
    static String[] colors = {"red", "black", "green", "yellow", "white", "grey", "brown", "blue"};

    public static String getRndBirthDate(){
        int randomDays = new Random().nextInt((3650 - 365) + 1) + 365;
        return LocalDate.now().minusDays(randomDays).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String getRndColor(){
        int rndIndex = new Random().nextInt(colors.length);
        return colors[rndIndex];
    }

    public static Species getRndSpecies(){
        int rndIndex = new Random().nextInt(Species.values().length);
        return Species.values()[rndIndex];
    }

    public static int getRndEggs(){
        return new Random().nextInt(5)+1;
    }

    public static Animal getRandomAnimal(){
        return new Animal(getRndBirthDate(), getRndColor());
    }

    public static Bird getRandomBird(){
        return new Bird(getRndBirthDate(), getRndColor(), getRndSpecies(), getRndEggs());
    }
}
