import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UtilsTest {
    static final String localDir = System.getProperty("user.dir");
    static final String expectedPath = String.format(
            "%s%ssrc%stest%sresources%s", localDir, File.separator, File.separator, File.separator, File.separator);


    @Test(dataProvider = "utilsList", dataProviderClass = AnimalsDataProvider.class)
    public void checkSavingToTxtTest(AnimalsList animals){
        //arrange
        boolean filesEqual = false;
        //act
        Utils.exportToFile("exportActual.txt", animals.getList());
        File actualResultFile = new File(expectedPath+"exportExpected.txt");
        File expectedResultFile = new File("exportActual.txt");
        try {
            filesEqual = FileUtils.contentEquals(actualResultFile, expectedResultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //assert
        Assert.assertTrue(filesEqual);
    }

    @Test(dataProvider = "utilsList", dataProviderClass = AnimalsDataProvider.class)
    public void checkSerializationTest(AnimalsList animals) {
        //arrange
        boolean filesEqual = false;
        //act
        Utils.serializeToXml(animals, "exportedActual.xml");
        File actualResultFile = new File(expectedPath+"exportedExpected.xml");
        File expectedResultFile = new File("exportedActual.xml");
        try {
            filesEqual = FileUtils.contentEquals(actualResultFile, expectedResultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //assert
        Assert.assertTrue(filesEqual);
    }

    @Test(dataProvider = "utilsList", dataProviderClass = AnimalsDataProvider.class)
    public void checkDeserializationTest(AnimalsList expectedAnimalsList) {
        //arrange
        AnimalsList actualDeserializedList = new AnimalsList();
        //act
        actualDeserializedList.setList(Utils.deserializeFromXml(expectedPath+"exportedExpected.xml"));
        //assert
        Assert.assertEquals(actualDeserializedList.getList(), expectedAnimalsList.getList());
    }
}
