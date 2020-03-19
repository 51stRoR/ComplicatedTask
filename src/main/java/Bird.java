import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

@XmlRootElement(name = "bird")
@XmlAccessorType (XmlAccessType.FIELD)
public class Bird extends Animal{
    private Species species;
    private int eggCount;

    public Bird(String birthYear, String color, Species species, int eggCount) {
        super(birthYear, color);
        this.species = species;
        this.eggCount = eggCount;
    }

    public Bird() {
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getEggCount() {
        return eggCount;
    }

    public void setEggCount(int eggCount) {
        this.eggCount = eggCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return eggCount == bird.eggCount &&
                Objects.equals(species, bird.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), species, eggCount);
    }

    @Override
    public String voice(){
        return "I am a bird!!!";
    }

    @Override
    public String output(){
        return String.format("Bird - birtdate: %s, bird color: %s, bird species: %s, bird egg count: %s",
                super.getBirthYear(),super.getColor(), this.species, this.eggCount);
    }

    public static Bird input(){
        System.out.println("Create bird:");
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            System.out.println("Enter bird birthdate(only 'yyyy-mm-dd' format accepted):");
            String birthDate = reader.readLine();
            LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
            System.out.println("Enter bird color:");
            String color = reader.readLine();
            System.out.println("Enter bird species:");
            String species = reader.readLine();
            System.out.println("Enter bird egg count:");
            int eggCount = Integer.parseInt(reader.readLine());
            return new Bird(birthDate, color, Species.valueOf(species), eggCount);
        } catch (IOException | java.time.format.DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    static Comparator<Bird> compareBySpecies = Comparator.comparing(Bird::getSpecies);
}
