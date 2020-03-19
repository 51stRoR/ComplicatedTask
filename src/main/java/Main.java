import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flow = true;
        String serializeFile = "serialized_collection.xml";
        String exportFile = "exported_collection.txt";
        List<Animal> olderBirds = new ArrayList<>();
        List<Animal> sortedBirds = new ArrayList<>();
        List<Animal> exportedBirds = new ArrayList<>();
        AnimalsList animals = new AnimalsList();
        for(int i=0;i<15;i++) {
            if((i % 3) == 0){
                animals.getList().add(Rnd.getRandomAnimal());
            } else {
                animals.getList().add(Rnd.getRandomBird());
            }
        }
        Scanner scanner = new Scanner(System.in);
        while(flow) {
            System.out.println("Select option: 1 - show list, 2 - add animal, 3 - add bird, 4 - filter older birds, " +
                    "5 - sort bird by species, 6 - export to .txt, 7 - serialize to xml, 8 - deserialize to xml");
            String option = scanner.next();
            switch(option) {
                case "1":{
                    animals.getList().stream().map(Animal::output).forEach(System.out::println);
                    break;
                }
                case "2":{
                    Animal added = Animal.input();
                    animals.getList().add(added);
                    break;
                }
                case "3":{
                    Bird added = Bird.input();
                    animals.getList().add(added);
                    break;
                }
                case "4":{
                    System.out.println("Enter year to filter:");
                    int year = scanner.nextInt();
                    olderBirds = animals.getBirdsOlderThenYear(year);
                    olderBirds.stream().map(Animal::output).forEach(System.out::println);
                    break;
                }
                case "5":{
                    sortedBirds = animals.sortBySpecies();
                    sortedBirds.stream().map(Animal::output).forEach(System.out::println);
                    break;
                }
                case "6":{
                    Utils.exportToFile(exportFile, animals.getList());
                    break;
                }
                case "7":{
                    Utils.serializeToXml(animals, serializeFile);
                    break;
                }
                case "8":{
                    exportedBirds = Utils.deserializeFromXml(serializeFile);
                    exportedBirds.stream().map(Animal::output).forEach(System.out::println);
                    break;
                }
                default:{
                    flow = false;
                    scanner.close();
                }
            }
        }
    }
}
