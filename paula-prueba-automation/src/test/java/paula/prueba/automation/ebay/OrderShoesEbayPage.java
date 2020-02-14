package paula.prueba.automation.ebay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderShoesEbayPage {
	
	private WebDriver driver;	
	private WebDriverWait wait;
	
	private By buscarButtonLocator;
	private By searchInputLocator;
	private By marcaInputLocator;
	private By pumaCheckLocator;
	private By sizeCheckLocator;
	private By resultLocator;
	private By orderByLocator;
	private By orderByOptionsLocator;
	private By resultListLocator;
		
	public OrderShoesEbayPage(WebDriver driver) {
		this.driver = driver;
		
		buscarButtonLocator = By.id("gh-btn");
		searchInputLocator = By.id("gh-ac"); 
		marcaInputLocator = By.id("w4-w12-0[0]");
		pumaCheckLocator = By.xpath("//*[@id=\"w4-w12\"]/ul/li[7]/div/a/div/div/span[1]");
		sizeCheckLocator = By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[5]/div/a/div/div/span[1]");
		resultLocator = By.cssSelector(".srp-controls__count-heading .BOLD");
		orderByLocator = By.id("w9");
		orderByOptionsLocator =	By.className("srp-sort__menu");
		resultListLocator = By.id("srp-river-results");
		
		wait = new WebDriverWait(driver, 60);
}
	
	/**
	 * Method wait until an element to be visible
	 * 
	 * @param locator
	 */
	public void waitLoadLocator(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	// 2. Search for shoes.
	/**
	 * Method to return search input. 
	 * 
	 * @return WebElement
	 */
	public WebElement getSearch() {
		waitLoadLocator(searchInputLocator);
		return driver.findElement(searchInputLocator);
	}
	
	// 2. Search for shoes.
	/**
	 * Method to set search input
	 * 
	 * @param search input String
	 */
	public void setSearchInput(String search) {
		getSearch().sendKeys(search);
		getSearch().sendKeys(Keys.TAB);		
	}
	
	//2. Search for shoes.
	/**
	 * click over the Buscar button
	 */
	public void clickBuscarButton() {
		waitLoadLocator(buscarButtonLocator);
		driver.findElement(buscarButtonLocator).click();
	}
	
	//3. Select brand PUMA.
	/**
	 * Method to return marca input. 
	 * 
	 * @return WebElement
	 */
	public WebElement getMarca() {
		waitLoadLocator(marcaInputLocator);
		return driver.findElement(marcaInputLocator);
	}
	
	//3. Select brand PUMA.
	/**
	 * Method to set marca input
	 * 
	 * @param marca input String
	 */
	public void setMarcaInput(String marca) {
		getMarca().sendKeys(marca);
		getMarca().sendKeys(Keys.TAB);		
	}
	
	//3. Select brand PUMA.
	/**
	 * click over the check puma 
	 */
	public void clickCkeckPuma() {
		waitLoadLocator(pumaCheckLocator);
		driver.findElement(pumaCheckLocator).click();
	}
	
	// 4. Select size 10.
	/**
	 * click over the check size 
	 */
	public void clickCkeckSize() {
		waitLoadLocator(sizeCheckLocator);
		driver.findElement(sizeCheckLocator).click();
	}
	
	//5. Print the number of results
	/**
	 * Method to return result section. 
	 * 
	 * @return WebElement
	 */
	public WebElement getResult() {
		waitLoadLocator(resultLocator);
		return driver.findElement(resultLocator);
	}
	
	// 6- Order by price ascendant
	/**
	 * Method to return order by element. 
	 * 
	 * @return WebElement
	 */
	public WebElement getOrderByElement() {
		waitLoadLocator(orderByLocator);
		return driver.findElement(orderByLocator).findElement(By.className("x-flyout__button"));
	}
	
	// 6- Order by price ascendant
	/**
	 * click over the order by 
	 */
	public void mouseOverOrderByElement() {
		Actions action = new Actions(driver);
		WebElement element = getOrderByElement();
		action.moveToElement(element).perform();
	}
	
	// 6- Order by price ascendant
	/**
	 * click over the order by price ascendant 
	 */
	public void orderByPriceAscendant() {
		waitLoadLocator(orderByOptionsLocator);
		WebElement select = driver.findElement(orderByOptionsLocator).findElements(By.tagName("li")).get(3);
		System.out.println("Element to be selected: " + select.getText());
		select.click();
	}
	
	//8- Take the first 5 products with their prices and print them in console.
	/**
	 * Method to return the five first elements of the result list.
	 * 
	 * @return WebElement
	 */
	public List<WebElement> getFirstFiveShoes() {
		waitLoadLocator(resultListLocator);
		return driver.findElement(resultListLocator).findElement(By.tagName("ul")).findElements(By.className("s-item")).subList(0, 5);
	}
	
	// 10- Order and print the products by price in descendant mode.
	/**
	 * click over the order by price descendant.
	 */
	public void orderByPriceDescendant() {
	waitLoadLocator(orderByOptionsLocator);
	WebElement select = driver.findElement(orderByOptionsLocator).findElements(By.tagName("li")).get(4);
	System.out.println("Element to be selected: " + select.getText());
	select.click();
	}
	
}