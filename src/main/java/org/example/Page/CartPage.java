package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    public  static WebDriver driver;
    private By btnItems(Integer value) {
        return By.xpath("//div[@class='product-item' and @data-productid='"+value+"']");
    }
    private By lblTotalItem(Integer value) {
        return By.xpath("//div[@class='product-price']//span[@class='price-value-"+value+"']");
    }
    private By lblQuantity(Integer value) {
        return By.xpath("//div[@class='add-to-cart-panel']//input[@id=\"product_enteredQuantity_"+value+"\"]");
    }
    private By btnAddToCart(Integer value) {
        return By.id("add-to-cart-button-"+value);
    }

    private static final By lblQuantityFromDetailsPage = By.xpath("//tr[2]//td[@class='quantity']//div[@class='product-quantity']//input[@name='itemquantity11228']");
    private static final By lblTotalPriceFromDetailsPage = By.xpath("//span[@class='product-unit-price']");
    private static final By lblItemTwoTotalPriceFromDetailsPage = By.xpath("//tr[2]//td[@class='unit-price']//span[@class='product-unit-price']");
    private static final By lblTotalFromDetailsPage = By.xpath("//span[@class='product-subtotal']");
    private static final By  lblItemTwoTotalFromDetailsPage = By.xpath("//tr[2]//td[@class='subtotal']//span[@class='product-subtotal']");
    private static final By  lblGiftWrapping = By.xpath("//*[@id=\"checkout_attribute_1\"]/option[2]");
    private static final By  lblWelcome = By.xpath(" //div[@class='page-title']//h1");
    private static final By  lblSubTotal = By.xpath("//tr[@class='order-subtotal']//span[@class='value-summary']");
    private static final By  lblTotal = By.xpath("//tr[@class='order-total']//span[@class='value-summary']");
    private static final By  lblSuccessMessage = By.xpath("//div[@class='bar-notification success']//p[@class='content']");
    private static final By  btnClose = By.xpath("//span[@class='close']");
    private static final By  btnShoppingCart = By.xpath("//span[@class='cart-label' and text()='Shopping cart' ]");
    private static final By  btnEdit = By.xpath("//a[text()='Edit']");


    private static final By  btnHome = By.xpath("//span[text()='Home']");
    private static final By  btnTerms = By.id("termsofservice");
    private static final By  btnCheckOut = By.id("checkout");
    private static final By  btnUpdate = By.id("add-to-cart-button-1");
    private static final By  btnItem = By.xpath("//div[@class='product-item' and @data-productid='1']");
    private By btnOs(Integer no,Integer value) {
        return By.xpath("//ul[@data-attr='"+ no +"']//input[@value='"+ value +"']");
    }

    public static void login()
    {   //set the path for webdriver
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    public void selectItem(Integer value) {
        WebElement itemButton = driver.findElement(this.btnItems(value));
        itemButton.click();
    }
    public static void selectAttributes() {
        selectOptionByIndex("product_attribute_1", 1);
        selectOptionByIndex("product_attribute_2", 1);
    }
    public static void selectAttribute() {
        selectOptionByIndex("product_attribute_2", 2);
    }
    private static void selectOptionByIndex(String attributeId, int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='" + attributeId + "']")));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }
    public void selectHdd(Integer no,Integer value) {
        WebElement hdd = driver.findElement(this.btnOs(no,value));
        hdd.click();
    }
    public void selectOs(Integer no,Integer value) {
        WebElement os = driver.findElement(this.btnOs(no,value));
        os.click();
    }
    public void selectSoftware(Integer no,Integer value) throws InterruptedException {
        WebElement os = driver.findElement(this.btnOs(no,value));
        os.click();
        Thread.sleep(8000);
    }
    public String totalAmount(Integer value){
        WebElement totalAmount = driver.findElement(this.lblTotalItem(value));
        return totalAmount.getText();
    }
    public String quantity(Integer value){
        WebElement totalQuantity = driver.findElement(this.lblQuantity(value));
        return totalQuantity.getAttribute("value");
    }
    public void buttonAddToCart(Integer value) throws InterruptedException {
        WebElement itemButton = driver.findElement(this.btnAddToCart(value));
        itemButton.click();
        Thread.sleep(8000);
    }
    public static String successfulMessage() throws InterruptedException {
        Thread.sleep(5000);
        WebElement totalAmount = driver.findElement(lblSuccessMessage);
        return totalAmount.getText();
    }
    public static void buttonClose() {
        WebElement closeButton = driver.findElement(btnClose);
        closeButton.click();
    }
    public static void buttonShoppingCart() {
        WebElement shoppingCartButton = driver.findElement(btnShoppingCart);
        shoppingCartButton.click();
    }
    public static String getTotalPriceFromDetailsPage(){
        WebElement totalAmount = driver.findElement(lblTotalPriceFromDetailsPage);
        return totalAmount.getText();
    }
    public static String getItemTwoTotalPriceFromDetailsPage(){
        WebElement totalAmount = driver.findElement(lblItemTwoTotalPriceFromDetailsPage);
        return totalAmount.getText();
    }
    public static String getQuantityFromDetailsPage() throws InterruptedException {
        Thread.sleep(8000);
        WebElement totalQuantity = driver.findElement(lblQuantityFromDetailsPage);
        return totalQuantity.getAttribute("value");
    }
    public static String getTotalFromDetailsPage(){
        WebElement totalAmount = driver.findElement(lblTotalFromDetailsPage);
        return totalAmount.getText();
    }
    public static String getItemTwoTotalFromDetailsPage(){
        WebElement totalAmount = driver.findElement(lblItemTwoTotalFromDetailsPage);
        return totalAmount.getText();
    }
    public static String getGiftWrappingPrice(){
        WebElement totalAmount = driver.findElement(lblGiftWrapping);
        return totalAmount.getText();
    }
    public static String getWelcomeMessage(){
        WebElement welcomeText = driver.findElement(lblWelcome);
        return welcomeText.getText();
    }

    public static String getSubTotal(){
        WebElement totalAmount = driver.findElement(lblSubTotal);
        return totalAmount.getText();
    }
    public static String getTotal(){
        WebElement totalAmount = driver.findElement(lblTotal);
        return totalAmount.getText();
    }
    public static void buttonEditCart() {
        WebElement editButton = driver.findElement(btnEdit);
        editButton.click();
    }
    public static void buttonUpdate() {
        WebElement updateButton = driver.findElement(btnUpdate);
        updateButton.click();
    }
    public static void buttonHome() throws InterruptedException {
        Thread.sleep(8000);
        WebElement editButton = driver.findElement(btnHome);
        editButton.click();
    }
    public static void selectGiftWrapping() throws InterruptedException {
        selectOptionByIndex("checkout_attribute_1", 1);
        Thread.sleep(5000);
    }
    public static void buttonTerms() {
        WebElement termsButton = driver.findElement(btnTerms);
        termsButton.click();
    }
    public static void buttonCheckout() {
        WebElement checkoutButton = driver.findElement(btnCheckOut);
        checkoutButton.click();
    }

    public static boolean isItemButtonEnable(){
        WebElement button = driver.findElement(btnItem);
        if (button.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }
}

