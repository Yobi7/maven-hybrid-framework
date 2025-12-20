package testdata.jsonData.orangeHRM;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import io.qameta.allure.Step;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class LoginInfoJSON {
    public static Map<String, LoginInfoJSON> getLoginInfoAsMap() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(
                    new File(GlobalConstants.RESOURCE_PATH + "loginData.json"),
                    new TypeReference<Map<String, LoginInfoJSON>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("❌ Error when read file JSON: " + e.getMessage(), e);
        }
    }

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @Step("Get User Name: {0}")
    public String getUsername() {
        return username;
    }

    @Step("Get Password: {0}")
    public String getPassword() {
        return password;
    }
}
