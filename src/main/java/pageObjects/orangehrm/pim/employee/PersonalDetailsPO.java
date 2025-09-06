package pageObjects.orangehrm.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeTabs {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
    }

    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }


    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        sleepInSecond(3);
        Dimension afterUpload = getAvatarSize();
        return  !(beforeUpload.equals(afterUpload));
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToDriverLicenseTextbox(String driverLicenseNumber) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, driverLicenseNumber);
    }

    public void enterToLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderMaleRadioButton(String gender) {
        clickToElementByJS(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        checkToCheckboxRadio(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }


    public boolean isGenderMaleRadioSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }
}
