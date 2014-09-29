package testeUnidade;

import static org.junit.Assert.*;
import negocios.Blog;
import negocios.Post;
import negocios.Profile;

import org.junit.Test;

import fachada.Fachada;

public class TestJDBCPostDAO {

	@Test
	public void testCriarPost() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		Post post = new Post("uno", "asmdsand", user, blog);
		int cod = Fachada.getInstance().criarPostar("uno", "asmdsand", user.getLogin(), blog.getId());
		
		assertEquals(post, Fachada.getInstance().consultarPost(cod));
	}

	@Test
	public void testConsultarPost() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		Post post = new Post("uno", "asmdsand", user, blog);
		int cod = Fachada.getInstance().criarPostar("uno", "asmdsand", user.getLogin(), blog.getId());
		
		assertEquals(post, Fachada.getInstance().consultarPost(cod));
	}

	@Test
	public void testRemoverPost() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		int cod = Fachada.getInstance().criarPostar("uno", "asmdsand", user.getLogin(), blog.getId());
	
		Fachada.getInstance().removerPost(cod);
		assertEquals(null, Fachada.getInstance().consultarPost(cod));
	}

}
