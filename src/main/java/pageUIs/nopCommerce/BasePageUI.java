package pageUIs.nopCommerce;

public class BasePageUI {
    // NopCommerce
    /* Only use for Level 07_Switch_Page_Object*/
    public static final String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
    public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
    public static final String ORDER_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Orders']";
    public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";

    // JQuery
    public static final String UPLOAD_FILE_TYPE = "css=input[type='file']";

    // Component
    public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String RADIO_BY_ID = "xpath=//input[@id='%s']";


}
