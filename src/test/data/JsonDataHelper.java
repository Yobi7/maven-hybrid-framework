package data;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import models.PIM.Employee;

public class JsonDataHelper {

    private static Faker faker = new Faker();

    public static Employee getEmployee(String key) {

        // Lấy block "happyCase" trong json
        JsonObject json = JsonUtils.readJson("employee.json")
                .getAsJsonObject(key);

        Employee emp = new Employee();

        // Nếu là "AUTO" → sinh data bằng Faker
        emp.setFirstName(
                json.get("firstName").getAsString().equals("AUTO")
                        ? faker.name().firstName()
                        : json.get("firstName").getAsString()
        );

        emp.setLastName(
                json.get("lastName").getAsString().equals("AUTO")
                        ? faker.name().lastName()
                        : json.get("lastName").getAsString()
        );

        emp.setDriverLicenseNumber(
                json.get("driverLicenseNumber").getAsString().equals("AUTO")
                        ? faker.number().digits(8)
                        : json.get("driverLicenseNumber").getAsString()
        );

        emp.setDriverLicenseExpiryDate(json.get("driverLicenseExpiryDate").getAsString());
        emp.setNationality(json.get("nationality").getAsString());
        emp.setMaritalStatus(json.get("maritalStatus").getAsString());
        emp.setDateOfBirth(json.get("dateOfBirth").getAsString());
        emp.setGender(json.get("gender").getAsString());

        return emp;
    }
}

