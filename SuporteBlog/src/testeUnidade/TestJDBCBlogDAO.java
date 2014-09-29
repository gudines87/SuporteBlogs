package testeUnidade;

import static org.junit.Assert.*;
import negocios.Blog;

import org.junit.Test;

import fachada.Fachada;

public class TestJDBCBlogDAO {

	@Test
	public void testCreateBlog() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		int cod = Fachada.getInstance().createBlog("Meu Blog", "haha", "haha.png", true, false, "asdf", "jose1");
		
		assertEquals(blog, Fachada.getInstance().consultarBlog(cod));
	}

	@Test
	public void testConsultarBlog() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		int cod = Fachada.getInstance().createBlog("Meu Blog", "haha", "haha.png", true, false, "asdf", "jose1");
		
		assertEquals(blog, Fachada.getInstance().consultarBlog(cod));
	}

	@Test
	public void testRemoverBlog() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		int cod = Fachada.getInstance().createBlog("Meu Blog", "haha", "haha.png", true, false, "asdf", "jose1");
		
		Fachada.getInstance().deletarBlog(cod);
		
		assertEquals(null, Fachada.getInstance().consultarBlog(cod));
		
	}

	@Test
	public void testChangeBlogInformation() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		int cod = Fachada.getInstance().createBlog("Meu Blog", "haha", "haha.png", true, false, "asdf", "jose1");

		Fachada.getInstance().changeBlogInformation(cod, "decricao", "novaDescricao");
		assertEquals("novaDescricao", Fachada.getInstance().getBlogInformation(cod, "descricao"));
	
	}

}
