import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {

        static void exportToFile(String filename, List<Animal> inputList){
            try {
                FileWriter fileWriter = new FileWriter(filename);
                for (Animal animal: inputList){
                    fileWriter.write(animal.output()+"\n");
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        static void serializeToXml(AnimalsList animals, String filename){
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(AnimalsList.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(animals, new FileWriter(filename));
            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }

        static List<Animal> deserializeFromXml(String filename){
            AnimalsList deserializedAnimals = new AnimalsList();
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(AnimalsList.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                deserializedAnimals = (AnimalsList) unmarshaller.unmarshal( new File(filename) );
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return deserializedAnimals.getList();
        }
}
