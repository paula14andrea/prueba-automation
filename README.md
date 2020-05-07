# prueba-automation
Prueba automation Paula Andrea Vallejo
Para la automatización de algunos de  los test de la página https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/, se utilizó Selenium - JAVA,  IDE eclipse,  se aplicaron los patrones de diseño POM (page object model) y AAA (arrange, actions, Assert), y se extendió de una clase BaseUtilities donde se hizo todo el setup del ambiente para la ejecución de los test.
 

TEST 1.  
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
2.	click pestania ‘’calcula cuanto te prestan’’.
3.	Ingresar ingresos mensuales  < 737.717
4.	Assert el sistema deberá mostrar alerta ‘’ingresos mensuales deben ser mayores o iguales  a  737.717’’ debajo del  campo ‘’ingresos mensuales’’.
5.	Assert  el botón ‘’CALCULAR CREDITO’’ no deberá  activarse.

TEST 2. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
2.	click pestania ‘’calcula cuanto te prestan’’.
3.	Ingresar ingresos mensuales  >= 737.717
4.	Assert  el botón ‘’CALCULAR CREDITO’’ deberá  activarse.

TEST 3. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
1.	click pestania ‘’calcula cuanto te prestan’’.
2.	Ingresar ingresos mensuales  >= 737.717
3.	Dar click en el botón ‘’CALCULAR CREDITO’’ 
4.	Assert el sistema deberá mostrar al lado derecho de  la pantalla el botón “TRAMITAR CREDITO’’. 
5.	Assert al dar click en el botón “TRAMITAR” deberá abrirse el modal ‘’tramitamos tu crédito”’. 
6.	Assert el sistema deberá mostrar al lado derecho de  la pantalla la información de las secciones: Banco, Valor de cuota mensual, valor estimado del préstamo, tasa de interés (tasa EA).


TEST 4. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
2.	click pestania ‘’calcula valor de las cuotas.
3.	Ingresar  valor del crédito  < 15000000
4.	Assert el sistema deberá mostrar alerta ‘’el valor del crédito debe ser  mayor o igual a  15000000’’, debajo del  campo ‘’valor del crédito’’. 
5.	Assert  el botón ‘’CALCULAR CUOTAS’’ no deberá  activarse.’


TEST 5. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
2.	click pestania ‘’calcula valor de las cuotas.
3.	Ingresar ingresos mensuales  >= 15000000
4.	Assert  el botón ‘’CALCULAR CUOTAS’’ deberá  activarse.


TEST 6. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
2.	click pestania ‘’calcula valor de las cuotas.
3.	Ingresar ingresos mensuales  >= 15000000
4.	Dar click en el botón ‘’CALCULAR CUOTAS’’ 
5.	Assert el sistema deberá mostrar al lado derecho de  la pantalla el botón “TRAMITAR CREDITO’’. 
6.	Assert al dar click en el botón “TRAMITAR” deberá abrirse el modal ‘’tramitamos tu crédito”’. 
7.	Assert el sistema deberá mostrar al lado derecho de  la pantalla la información de las secciones: Banco, Valor de cuota mensual, valor estimado del préstamo, tasa de interés (tasa EA).

TEST 7. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/ 
2.	Assert las secciones de la página: apartamentos en venta y arriendo, casas en venta y arriendo, proyectos de vivienda nueva en Colombia, otros inmuebles en venta y arriendo deberán estar presentes. 
3.	Assert Los links por secciones deberán estar activas y redireccionaran correctamente a la página asociada.
4.	Assert las secciones Buscar inmueble, noticias y  tendencias y herramientas deberán estar presentes. 

TEST 8. 
1.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/
2.	Assert el botón  “PUBLICA TU INMUEBLE ” deberá estar presente 
3.	Assert el botón  “PUBLICA TU INMUEBLE ” deberá estar activo 
4.	Assert al dar click en el botón  “PUBLICA TU INMUEBLE ” deberá re direccionar correctamente a la página https://www.metrocuadrado.com/publicar-inmuebles/

TEST 9. 
5.	Ingresar a  https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/
6.	Assert el botón  “Ingresar ” deberá estar presente 
7.	Assert el botón  “Ingesar ” deberá estar activo 
8.	Assert al dar click en el botón  “Ingresar ” deberá re direccionar correctamente a la página https://www.metrocuadrado.com/cas/login 

Reportes pruebas automatizadas: 

ReportePrincipal.JPG
ReporteDetalle.JPG
