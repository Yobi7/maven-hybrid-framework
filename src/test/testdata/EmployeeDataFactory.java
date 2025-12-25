package testdata;

import com.github.javafaker.Faker;
import testdata.PIM.EmployeeData;

public class EmployeeDataFactory {

    private static Faker faker = new Faker();

    public static EmployeeData happyCase() {
        EmployeeData data = new EmployeeData();
        data.setFirstName(faker.name().firstName());
        data.setMiddleName("A");
        data.setLastName(faker.name().lastName());
        return data;
    }

}
