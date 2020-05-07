package paula.prueba.automation.tyba;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraCreditoViviendaPage {
	
	private WebDriver driver;	
	private WebDriverWait wait;
	
	private By ingresosMensualesLocator;
	private By calcularCreditoButtonLocator;
	private By errorIngresosLocator;	
	private By tramitarCreditoButtonLocator;
	private By modalOpenTramiteLocator;
	
	
	public CalculadoraCreditoViviendaPage(WebDriver driver) {
		this.driver = driver;
		
		ingresosMensualesLocator = By.id("ingresosMensuales"); 
		calcularCreditoButtonLocator = By.cssSelector("button.btn.btn-upload.credito");
		errorIngresosLocator = By.cssSelector("p.validacion.ingresos_mensuales.ng-binding");
		tramitarCreditoButtonLocator = By.cssSelector("a.lqn-bar-btn.general-lightbox-trigger");
		modalOpenTramiteLocator = By.className("main-description-text");
		
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
		
	/**
	 * Method to return ingresos mensuales input. 
	 * 
	 * @return WebElement
	 */
	public WebElement getFieldIngresosMensuales() {
		waitLoadLocator(ingresosMensualesLocator);
		return driver.findElement(ingresosMensualesLocator);
	}
		
	/**
	 * Method to set ingresos mensuales input.
	 * 
	 * @param search input String
	 */
	public void setFieldIngresosMensuales(String ingresos) {
		getFieldIngresosMensuales().sendKeys(ingresos);
		getFieldIngresosMensuales().sendKeys(Keys.TAB);		
	}
		
	/**
	 * Method to check calcular credito button
	 * 
	 * @return WebElement
	 */
	public WebElement calcularCreditoButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(calcularCreditoButtonLocator));
		return driver.findElement(calcularCreditoButtonLocator);
	}
	
	/**
	 * Method to return mensaje de error minimo requerido. 
	 * 
	 * @return WebElement
	 */
	public WebElement getErrorMinimoRequerido() {
		waitLoadLocator(errorIngresosLocator);
		return driver.findElement(errorIngresosLocator);
	}
	
	/**
	 * click over calcular credito button
	 */
	public void clickCalcularCreditoButton() {
		waitLoadLocator(calcularCreditoButtonLocator);
		driver.findElement(calcularCreditoButtonLocator).click();
	}
	
	/**
	 * Method to check tramitar credito button
	 * 
	 * @return WebElement
	 */
	public WebElement tramitarCreditoButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(tramitarCreditoButtonLocator));
		return driver.findElement(tramitarCreditoButtonLocator);
	}
	
	/**
	 * Method to return tramite modal
	 * 
	 * @return WebElement
	 */
	public WebElement getOpenModalTramite() {
		waitLoadLocator(modalOpenTramiteLocator);
		return driver.findElement(modalOpenTramiteLocator);
	}
	
}	