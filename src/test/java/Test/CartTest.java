package Test;

import org.example.Common.Constants;
import org.example.Function.Cart;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {

    @BeforeMethod
    public static void testVerifyLogin()
    {
        Cart.login();
    }

    @Test(alwaysRun = true, priority = 1)
    public void testVerifySelectItems() throws InterruptedException {

        //Verify button is enable or not
        Assert.assertTrue(Cart.isItemButtonEnable(), "Button is not enabled");

        //select item
        Cart.selectItem(Constants.ITEM_ONE);

        //select item values
        Cart.selectProcessorAndRam();
        Cart.selectHdd(3,7);
        Cart.selectOs(4,9);
        Cart.selectSoftware(5,10);
        Cart.selectSoftware(5,11);

        //Verify total amount of the item
        String totalAmountOfItem = Cart.getTotalAmount(1);
        Assert.assertEquals(totalAmountOfItem, Constants.TOTAL_AMOUNT_OF_ITEM_ONE,Constants.ERROR_MESSAGE);

        //Verify Qty
        String Quantity = Cart.getQuantity(1);
        Assert.assertEquals(Quantity, "1",Constants.ERROR_MESSAGE);

        //item one is Adding to cart
        Cart.clickOnAddToCart(1);

        //Navigate to Cart
        Cart.clickOnShoppingCart();

        //Verify itemOne price
        String totalAmountFromDetailsPage = Cart.getTotalAmountFromDetailsPage();
        Assert.assertEquals(totalAmountFromDetailsPage, Constants.TOTAL_AMOUNT_OF_ITEM_ONE,Constants.ERROR_MESSAGE);

        //Verify itemOne Total
        String totalFromDetailsPage = Cart.getTotalFromDetailsPage();
        Assert.assertEquals(totalFromDetailsPage, Constants.TOTAL_AMOUNT_OF_ITEM_ONE,Constants.ERROR_MESSAGE);

        //Click on Edit button
        Cart.clickOnEdit();

        //Update ram value
        Cart.selectRam();

        //Update the cart clicking on update button
        Cart.clickOnAddToCart(1);

        //Verify total amount of item
        String totalUpdatedAmountFromDetailsPage = Cart.getTotalAmount(1);
        Assert.assertEquals(totalUpdatedAmountFromDetailsPage, Constants.ITEM_ONE_UPDATED_AMOUNT,Constants.ERROR_MESSAGE);

        //Navigate back to home page clicking on home button
        Cart.clickOnHomeButton();

        //select itemTwo
        Cart.selectItem(Constants.ITEM_TWO);

        //Verify total amount of item two
        String itemTwoAmountFromDetailsPage = Cart.getTotalAmount(4);
        Assert.assertEquals(itemTwoAmountFromDetailsPage, Constants.TOTAL_AMOUNT_OF_ITEM_TWO,Constants.ERROR_MESSAGE);

        //Verify Qty of item two
        String totalQuantity = Cart.getQuantity(4);
        Assert.assertEquals(totalQuantity, "2",Constants.ERROR_MESSAGE);

        //Adding to cart
        Cart.clickOnAddToCart(4);

        //Navigate to cart
        Cart.clickOnShoppingCart();

        //Verify itemTwo price
        String itemTwototalAmountFromDetailsPage = Cart.getItemTwoTotalPriceFromDetailsPage();
        Assert.assertEquals(itemTwototalAmountFromDetailsPage, Constants.TOTAL_AMOUNT_OF_ITEM_TWO,Constants.ERROR_MESSAGE);

        //Verify itemTwoTotal
        String itemTwoTotalPriceFromDetailsPage = Cart.getItemTwoTotalFromDetailsPage();
        Assert.assertEquals(itemTwoTotalPriceFromDetailsPage, Constants.ITEM_TWO_TOTAL_AMOUNT,Constants.ERROR_MESSAGE);

        //SelectWrapping
        Cart.selectgiftWrapping();

        //VerifyGift wrapping price
        String giftWrappingPrice = Cart.getGiftWrappingPrice();
        Assert.assertEquals(giftWrappingPrice,"Yes [+$10.00]");

        //Verify subtotal
        String subTotal=Cart.getSubTotal();
        Assert.assertEquals(subTotal,"$5,000.00");

        //Verify Total
        String total =Cart.getTotal();
        Assert.assertEquals(total,"$5,000.00");

        //Click on teams button
        Cart.clickOnButtonTerms();
        Cart.clickOnCheckOut();

        //Verify welcome message after navigation
        String welcomeMessage = Cart.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage,Constants.WELCOME_MESSAGE,Constants.ERROR_MESSAGE);
    }

    @Test(alwaysRun = true, priority = 2)
    public void testVerifySelectItemsAndVerifySuccessfulMessageAndQty() throws InterruptedException {
        //Verify button is enable
        Assert.assertTrue(Cart.isItemButtonEnable(), "Button is not enabled");
        //select item
        Cart.selectItem(Constants.ITEM_ONE);


        //select item values
        Cart.selectProcessorAndRam();
        Cart.selectHdd(3,7);
        Cart.selectOs(4,9);
        Cart.selectSoftware(5,10);
        Cart.selectSoftware(5,11);

        //Verify total amount of item
        String totalAmountOfItem = Cart.getTotalAmount(1);
        Assert.assertEquals(totalAmountOfItem, Constants.TOTAL_AMOUNT_OF_ITEM_ONE,Constants.ERROR_MESSAGE);

        //Verify Qty
        String Quantity = Cart.getQuantity(1);
        Assert.assertEquals(Quantity, "1",Constants.ERROR_MESSAGE);

        //Adding to cart
        Cart.clickOnAddToCart(1);

        String successfulMessage = Cart.getSuccessfulMessage();
        Assert.assertEquals(successfulMessage,"The product has been added to your shopping cart", "Item was not added to the cart successfully");

        //close successful message
        Cart.clickOnCloseButton();

        //Navigate to Cart
        Cart.clickOnShoppingCart();

        //Verify itemOne qty
        String QuantityFromDetailsPage = Cart.getQuantityFromDetailsPage();
        Assert.assertEquals(QuantityFromDetailsPage, "1",Constants.ERROR_MESSAGE);
    }
}


