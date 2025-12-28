package data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonUtils {

    public static JsonObject readJson(String fileName) {
        try (InputStream is = JsonUtils.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            // Parse file json → JsonObject
            return JsonParser.parseReader(new InputStreamReader(is))
                    .getAsJsonObject();

        } catch (Exception e) {
            throw new RuntimeException("Cannot read json file: " + fileName);
        }
    }
}
