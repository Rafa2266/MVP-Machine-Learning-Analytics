package calculadora.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtraçãoDoisNumeros() {
		int soma = calc.subtracao(10, 6);		
		Assertions.assertEquals(4, soma);		
	}
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int soma = calc.multiplicacao(4, 7);		
		Assertions.assertEquals(28, soma);		
	}
	@DisplayName("Testa a somatória de um número")
	@Test
	public void testSomatoriaUmNumero() {
		int soma = calc.somatoria(4);		
		Assertions.assertEquals(10, soma);
		Assertions.assertEquals(0, calc.somatoria(-4));
	}
	@DisplayName("Testa a identificação se um número é positivo")
	@Test
	public void testEhPositivo() {
		Assertions.assertEquals(false, calc.ehPositivo(-3));
		Assertions.assertEquals(true, calc.ehPositivo(3));
	}
	@DisplayName("Testa a comparação de dois números")
	@Test
	public void testCompara() {
		Assertions.assertEquals(-1,calc.compara(3, 6));
		Assertions.assertEquals(1,calc.compara(10, 6));
		Assertions.assertEquals(0,calc.compara(3, 3));
	}

}
