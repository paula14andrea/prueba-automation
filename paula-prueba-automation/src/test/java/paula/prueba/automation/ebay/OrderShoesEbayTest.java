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
		orderShoesEbayPage.setSearchInput("shoes");
		orderShoesEbayPage.clickBuscarButton();
		orderShoesEbayPage.setMarcaInput("puma");
		orderShoesEbayPage.clickCkeckPuma();
		orderShoesEbayPage.clickCkeckSize();
		orderShoesEbayPage.mouseOverOrderByElement();
		orderShoesEbayPage.orderByPriceAscendant();
		// 5- Print the number of results
		System.out.println("Number of results: " + orderShoesEbayPage.getResult().getText());
		
		List<WebElement> shoes = orderShoesEbayPage.getFirstFiveShoes();
		for (int i = 0; i < shoes.size() - 1; i++) {
			float currentShoeFinalPrice = getItemPrice(shoes.get(i));
			float nextShoeFinalPrice = getItemPrice(shoes.get(i+1));
			System.out.println("Shoe: " + shoes.get(i).getText());
			System.out.println("Shoe price " + i + ": " + currentShoeFinalPrice);
			System.out.println("Shoe price " + (i+1) + ": " + nextShoeFinalPrice);
			System.out.println();
			
			// 7. Assert the order taking the first 5 results.
			assertTrue(currentShoeFinalPrice <= nextShoeFinalPrice, "Current (" + currentShoeFinalPrice + ") should be less or equal than next (" + nextShoeFinalPrice + ")");
		}
		
	}
	
	private float getItemPrice(WebElement item) {
		String itemPrice = item.findElement(By.className("s-item__price")).getText();
		//https://stackoverflow.com/questions/4030928/extract-digits-from-a-string-in-java
		itemPrice = CharMatcher.is('.').or(CharMatcher.inRange('0','9')).retainFrom(itemPrice);
		String itemShipingPrice = item.findElement(By.className("s-item__shipping")).getText();
		itemShipingPrice = CharMatcher.is('.')
							.or(CharMatcher.inRange('0','9'))
							.retainFrom(itemShipingPrice);
		float shoeShipingPrice = 0;
		if(!itemShipingPrice.isEmpty()) {
			shoeShipingPrice = Float.valueOf(itemShipingPrice);
		}
		return Float.valueOf(itemPrice) + shoeShipingPrice;
	}
	
	// 1- Enter to eBay.
	@BeforeEach
	public void arrange() {
		orderShoesEbayPage = new OrderShoesEbayPage (driver);
		navigateTo(URL_BASE);
	}

}
