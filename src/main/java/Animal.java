import javax.xml.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Scanner;

@XmlRootElement(name = "animal")
@XmlAccessorType (XmlAccessType.FIELD)
public class Animal {
    private String birthYear;
    private String color;

    public Animal() {
    }

    public Animal(String birthYear, String color) {
        this.birthYear = birthYear;
        this.color = color;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public Species getSpecies() {
        return null;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(birthYear, animal.birthYear) &&
                Objects.equals(color, animal.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthYear, color);
    }

    @Override
    public String toString() {
        return voice();
    }

    public String voice(){
        return "I am an animal!!!";
    }

    public int getAge() {
        try {
            LocalDate yearOfBirth = LocalDate.parse(this.birthYear, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate yearNow = LocalDate.now();
            return Math.toIntExact(ChronoUnit.YEARS.between(yearOfBirth, yearNow));
        } catch (java.time.format.DateTimeParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String output(){
        return String.format("Animal - birthdate: %s, animal color: %s", this.birthYear,this.color);
    }

    public static Animal input(){
        System.out.println("Create animal:");
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            System.out.println("Enter animal birthdate(only 'yyyy-mm-dd' format accepted):");
            String birthDate = reader.readLine();
            LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
            System.out.println("Enter animal color:");
            String color = reader.readLine();
            return new Animal(birthDate, color);
        } catch (IOException | java.time.format.DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
