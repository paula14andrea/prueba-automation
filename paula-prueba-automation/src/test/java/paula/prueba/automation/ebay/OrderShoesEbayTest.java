package paula.prueba.automation.ebay;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.CharMatcher;

import paula.prueba.automation.utilities.BaseUtilities;

public class OrderShoesEbayTest extends BaseUtilities {
	
	private OrderShoesEbayPage orderShoesEbayPage;
	
	@Test
	public void validatePriceAscendantOrder() {
		orderShoesEbayPage.mouseOverOrderByElement();
		orderShoesEbayPage.orderByPriceAscendant();
		
		// 5- Print the number of results
		System.out.println("Number of results: " + orderShoesEbayPage.getResult().getText());
		
		List<WebElement> shoes = orderShoesEbayPage.getFirstFiveShoes();
		for (int i = 0; i < shoes.size() - 1; i++) {
			//8- Take the first 5 products with their prices and print them in console.
			System.out.println("Shoe: " + shoes.get(i).getText());
			int currentShoeFinalPrice = getItemFinalPrice(shoes.get(i));
			int nextShoeFinalPrice = getItemFinalPrice(shoes.get(i+1));
			System.out.println("currentShoeFinalPrice: " + currentShoeFinalPrice);
			System.out.println("nextShoeFinalPrice: " + nextShoeFinalPrice);
			System.out.println();
			
			// 7. Assert the order taking the first 5 results.
			assertTrue(currentShoeFinalPrice <= nextShoeFinalPrice, 
						"Current (" + currentShoeFinalPrice + ") should be less or equal than next (" + nextShoeFinalPrice + ")");
		}
		
		// 10- Order and print the products by price in descendant mode.
		orderShoesEbayPage.mouseOverOrderByElement();
		orderShoesEbayPage.orderByPriceDescendant();
		shoes = orderShoesEbayPage.getFirstFiveShoes();
		for (int i = 0; i < shoes.size(); i++) {
			System.out.println("Shoe: " + shoes.get(i).getText());
			System.out.println();
		}
		
	}
	
	private int getItemFinalPrice(WebElement item) {
		String itemPrice = item.findElement(By.className("s-item__price")).getText();
		//https://stackoverflow.com/questions/4030928/extract-digits-from-a-string-in-java
		itemPrice = CharMatcher.is('.').or(CharMatcher.inRange('0','9')).retainFrom(itemPrice);
		itemPrice = itemPrice.substring(0, itemPrice.indexOf("."));
		String itemShipingPrice = item.findElement(By.className("s-item__shipping")).getText();
		itemShipingPrice = CharMatcher.is('.')
							.or(CharMatcher.inRange('0','9'))
							.retainFrom(itemShipingPrice);
		int shoeShipingPrice = 0;
		if(!itemShipingPrice.isEmpty()) {
			itemShipingPrice = itemShipingPrice.substring(0, itemShipingPrice.indexOf("."));
			shoeShipingPrice = Integer.valueOf(itemShipingPrice);
		}
		return Integer.valueOf(itemPrice) + shoeShipingPrice;
	}
	
	// 1- Enter to eBay.
	@BeforeEach
	public void arrange() {
		orderShoesEbayPage = new OrderShoesEbayPage (driver);
		navigateTo(URL_BASE);
		orderShoesEbayPage.setSearchInput("shoes");
		orderShoesEbayPage.clickBuscarButton();
		orderShoesEbayPage.setMarcaInput("puma");
		orderShoesEbayPage.clickCkeckPuma();
		orderShoesEbayPage.clickCkeckSize();
	}

}
