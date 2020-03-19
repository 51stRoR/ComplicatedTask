import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "animals")
@XmlSeeAlso({Animal.class, Bird.class})
public class AnimalsList {

    List<Animal> list = new ArrayList<>();

    @XmlElement(name = "animal")
    public List<Animal> getList() {
        return list;
    }

    public void setList(List<Animal> list) {
        this.list = list;
    }

    public List<Animal> sortBySpecies(){
        return this.list
                .stream()
                .filter(o -> o instanceof Bird)
                .map(o -> (Bird)o)
                .sorted(Bird.compareBySpecies)
                .collect(Collectors.toList());
    }

    public List<Animal> getBirdsOlderThenYear(int year){
        return this.list
                .stream()
                .filter(o -> o instanceof Bird)
                .filter(o -> o.getAge()>year)
                .collect(Collectors.toList());
    }
}
