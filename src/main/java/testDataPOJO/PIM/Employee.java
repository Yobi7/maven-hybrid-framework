package testDataPOJO.PIM;

public class Employee {
    private String firstName;
    private String lastName;

    private String driverLicenseNumber;
    private String driverLicenseExpiryDate;
    private String nationality;
    private String maritalStatus;
    private String dateOfBirth;
    private String gender;
    private String employeeId;


    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseExpiryDate() {
        return driverLicenseExpiryDate;
    }

    public void setDriverLicenseExpiryDate(String driverLicenseExpiryDate) {
        this.driverLicenseExpiryDate = driverLicenseExpiryDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
