package testeUnidade;

import static org.junit.Assert.*;
import negocios.Blog;
import negocios.Comentario;
import negocios.Post;
import negocios.Profile;

import org.junit.Test;

import fachada.Fachada;

public class TestJDBCComentarioDAO {

	@Test
	public void testSalvarComentario() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		Post post = new Post("uno", "asmdsand", user, blog);
		Comentario coment = new Comentario("normal", "asdsfd", post , user);
		int cod = Fachada.getInstance().criarComentario("normal", "asdsfd", post.getCod() , user.getLogin());
		
		assertEquals(coment, Fachada.getInstance().consultarComentario(cod));
	}

	@Test
	public void testConsultarComentario() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		Post post = new Post("uno", "asmdsand", user, blog);
		Comentario coment = new Comentario("normal", "asdsfd", post , user);
		int cod = Fachada.getInstance().criarComentario("normal", "asdsfd", post.getCod() , user.getLogin());
		
		assertEquals(coment, Fachada.getInstance().consultarComentario(cod));
	}

	@Test
	public void testRemoverComentario() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		Post post = new Post("uno", "asmdsand", user, blog);
		int cod = Fachada.getInstance().criarComentario("normal", "asdsfd", post.getCod() , user.getLogin());
	
		Fachada.getInstance().removerComentario(cod);
		assertEquals(null, Fachada.getInstance().consultarBlog(cod));
	}

}    
