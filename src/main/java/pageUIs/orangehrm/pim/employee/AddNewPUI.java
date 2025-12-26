package pageUIs.orangehrm.pim.employee;

public class AddNewPUI {
    public static final String FIRSTNAME_TEXTBOX = "name=firstName";
    public static final String LASTNAME_TEXTBOX = "name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div//input";
    public static final String SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER = "xpath=//h6[text()='Add Employee']/following-sibling::form//button[contains(string(),'Save')]";


    public static final String ERROR_TEXT_WITH_FIRSTNAME_NULL = "xpath=//input[@name='firstName']/parent::div/following-sibling::span";
}
