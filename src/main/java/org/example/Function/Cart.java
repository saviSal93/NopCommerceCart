package org.example.Function;

import org.example.Page.CartPage;

public class Cart {
    public  static CartPage cartPage = new CartPage();

    public static void login(){
        CartPage.login();
    }
    public static void selectItem(Integer value) {
        cartPage.selectItem(value);
    }
    public static void selectProcessorAndRam()
    {
        CartPage.selectAttributes();
    }
    public static void selectHdd(Integer no,Integer value)
    {
        cartPage.selectHdd(no,value);
    }
    public static void selectOs(Integer no,Integer value)
    {
        cartPage.selectOs(no,value);
    }
    public static void selectSoftware(Integer no,Integer value) throws InterruptedException {
        cartPage.selectSoftware(no,value);
    }
    public static String getTotalAmount(Integer value)
    {
        return cartPage.totalAmount(value);
    }
    public static String getQuantity(Integer value)
    {
        return cartPage.quantity(value);
    }
    public static void clickOnAddToCart(Integer value) throws InterruptedException {
        cartPage.buttonAddToCart(value);
    }
    public static String getSuccessfulMessage() throws InterruptedException {
        return CartPage.successfulMessage();
    }
    public static void clickOnCloseButton() {
        CartPage.buttonClose();
    }
    public static void clickOnShoppingCart() {
        CartPage.buttonShoppingCart();
    }
    public static String getTotalAmountFromDetailsPage()
    {
        return CartPage.getTotalPriceFromDetailsPage();
    }
    public static String getItemTwoTotalPriceFromDetailsPage(){
        return CartPage.getItemTwoTotalPriceFromDetailsPage();
    }
    public static String getTotalFromDetailsPage () throws InterruptedException {
        return CartPage.getTotalFromDetailsPage();
    }
    public static String getItemTwoTotalFromDetailsPage () throws InterruptedException {
        return CartPage.getItemTwoTotalFromDetailsPage();
    }
    public static String getGiftWrappingPrice ()  {
        return CartPage.getGiftWrappingPrice();
    }
    public static String getWelcomeMessage ()  {
        return CartPage.getWelcomeMessage();
    }
    public static String getSubTotal ()  {
        return CartPage.getSubTotal();
    }
    public static String getTotal ()  {
        return CartPage.getTotal();
    }
    public static void clickOnEdit() {
        CartPage.buttonEditCart();
    }
    public static void selectRam()
    {
        CartPage.selectAttribute();
    }
    public static void clickOnHomeButton() throws InterruptedException {
        CartPage.buttonHome();
    }
    public static String  getQuantityFromDetailsPage() throws InterruptedException {
        return   CartPage.getQuantityFromDetailsPage();
    }
    public static void selectgiftWrapping() throws InterruptedException {
        CartPage.selectGiftWrapping();
    }
    public static void clickOnButtonTerms() {
        CartPage.buttonTerms();
    }
    public static void clickOnCheckOut() {
        CartPage.buttonCheckout();
    }
    public static boolean isItemButtonEnable()
    {
        return CartPage.isItemButtonEnable();
    }
}

