package paula.prueba.automation.tyba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.CharMatcher;

import paula.prueba.automation.utilities.BaseUtilities;

public class CalculadoraCreditoViviendaTest extends BaseUtilities {
	
	private String ERROR_INGRESOS = "Los ingresos deben ser mayores o iguales a $737,717.";
	private String INGRESO_MENOR_SALARIO= "500";
	private String INGRESO_MAYOR_SALARIO= "800000";
	
	private CalculadoraCreditoViviendaPage calculadoraCreditoViviendaPage;
	
	@Test 
	public void validarIngresoMenorDelRequerido() {
		calculadoraCreditoViviendaPage.setFieldIngresosMensuales(INGRESO_MENOR_SALARIO);

		assertFalse(calculadoraCreditoViviendaPage.calcularCreditoButton().isEnabled());
		assertEquals(ERROR_INGRESOS, calculadoraCreditoViviendaPage.getErrorMinimoRequerido().getText());
				
	}
	
	@Test
	public void validarBotonHabilitadoIngresoMayorDelRequerido() {
		calculadoraCreditoViviendaPage.setFieldIngresosMensuales(INGRESO_MAYOR_SALARIO);
		
		assertTrue(calculadoraCreditoViviendaPage.calcularCreditoButton().isEnabled());
					
	}
	
	@Test
	public void validarIngresoMayorDelRequerido() {
		calculadoraCreditoViviendaPage.setFieldIngresosMensuales(INGRESO_MAYOR_SALARIO);
		calculadoraCreditoViviendaPage.clickCalcularCreditoButton();
		
		assertTrue(calculadoraCreditoViviendaPage.tramitarCreditoButton().isDisplayed());					
	}
		
	@BeforeEach
	public void arrange() {
		calculadoraCreditoViviendaPage = new CalculadoraCreditoViviendaPage (driver);
		navigateTo(URL_BASE);		
	}
}
