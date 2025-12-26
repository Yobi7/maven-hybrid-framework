package testData;

import com.github.javafaker.Faker;
import models.PIM.Employee;

public class EmployeeData {

    private static Faker faker = new Faker();

    public static Employee happyCase() {
        Employee data = new Employee();
        data.setFirstName(faker.name().firstName());
        data.setLastName(faker.name().lastName());
        data.setDriverLicenseNumber(faker.number().digits(8));
        data.setDriverLicenseExpiryDate("2030-10-10");
        data.setNationality("American");
        data.setMaritalStatus("Married");
        data.setDateOfBirth("1995-03-05");
        data.setGender("Male");
        return data;
    }

}
