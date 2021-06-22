package carrinho.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;
import carrinho.Carrinho;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {
	private Carrinho car;
	private Produto choc;
	private Produto bis;
	@BeforeEach
	public void inicializa() {
		car = new Carrinho();
		choc=new Produto("chocolate",10);
		bis=new Produto("biscoito",5);
	}
	@DisplayName("Testa se identifica corretamente a quantidade de elementos no carrinho")
	@Test
	public void testGetQuantidadeDeElementos() {
			
		Assertions.assertEquals(0,car.getQtdeItems());		
	}
	@DisplayName("Testa a adição de um elemento")
	@Test
	public void testAdicaoElemento() {
		car.addItem(choc);	
		Assertions.assertEquals(1,car.getQtdeItems());		
	}
	@DisplayName("Testa a remoção de um elemento")
	@Test
	public void testRemocaoElemento() throws ProdutoNaoEncontradoException {
		car.addItem(choc);	
		car.removeItem(choc);	
		Assertions.assertEquals(0,car.getQtdeItems());		
	}
	@DisplayName("Testar a exceção lançada com throws a não achar o elemento a ser removido")
	@Test
	public void testRemoverProdutoInexistenteComAssertThrows() {
		car.addItem(choc);	
		assertThrows( ProdutoNaoEncontradoException.class,
				() ->car.removeItem(bis));
	}
	@DisplayName("Testar a exceção lançada com TryCatch a não achar o elemento a ser removido")
	@Test
	public void testRemoverProdutoInexistenteComTryCatch() {
		car.addItem(choc);
		try {
			car.removeItem(bis);
			fail("Exceção não lançada");
		} catch (ProdutoNaoEncontradoException e) {
			
		}	
		
	}
	@DisplayName("Testa a exibição do preço total do carrinho")
	@Test
	public void testGetValorTotal() {
		car.addItem(choc);
		car.addItem(bis);
		Assertions.assertEquals(15,car.getValorTotal());		
	}
	@DisplayName("Testa o esvaziamento do carrinho")
	@Test
	public void testEvaziarCarrinho() {
		car.addItem(choc);
		car.addItem(bis);
		car.esvazia();
		Assertions.assertEquals(0,car.getQtdeItems());		
	}
}
