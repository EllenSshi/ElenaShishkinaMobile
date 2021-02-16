package setup;

import com.google.gson.Gson;
import dto.NativeTestDataDto;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class NativeTestData {

    @DataProvider(name="nativeTestDataProvider")
    public static Object[] testDataProvider() throws IOException, ParseException {
        Object obj = readJson("src/test/resources/nativeTestData.json");
        NativeTestDataDto[] testData = new Gson().fromJson(obj.toString(), NativeTestDataDto[].class);

        return testData;
    }

    public static Object readJson(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);
        return jsonParser.parse(fileReader);
    }
}
