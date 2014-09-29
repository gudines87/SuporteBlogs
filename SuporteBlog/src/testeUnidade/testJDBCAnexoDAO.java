package testeUnidade;

import static org.junit.Assert.*;
import negocios.Anexo;
import negocios.Blog;
import negocios.Comentario;
import negocios.Post;
import negocios.Profile;

import org.junit.Test;

import fachada.Fachada;

public class testJDBCAnexoDAO {

	@Test
	public void testSalvarAnexo() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		int codPost = Fachada.getInstance().criarPostar("uno", "asmdsand", user.getLogin(), blog.getId());
		Post post = new Post("uno", "asmdsand", user, blog);
		Comentario coment = new Comentario("normal", "asdsfd", post , user);
		int codComent = Fachada.getInstance().criarComentario("normal", "asdsfd", post.getCod() , user.getLogin());
		Anexo anexo = new Anexo();
		anexo.setCod(Fachada.getInstance().salvarAnexo("Imagem de José", 1, "sadfsdfs", codComent , codPost));
		anexo.setComentario(coment);
		anexo.setEnd("sadfsdfs");
		anexo.setPost(post);
		anexo.setNome("Imagem de José");
		
		assertEquals(anexo, Fachada.getInstance().consultarAnexo(anexo.getCod()));
	}

	@Test
	public void testConsultarAnexo() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		int codPost = Fachada.getInstance().criarPostar("uno", "asmdsand", user.getLogin(), blog.getId());
		Post post = new Post("uno", "asmdsand", user, blog);
		Comentario coment = new Comentario("normal", "asdsfd", post , user);
		int codComent = Fachada.getInstance().criarComentario("normal", "asdsfd", post.getCod() , user.getLogin());
		Anexo anexo = new Anexo();
		anexo.setCod(Fachada.getInstance().salvarAnexo("Imagem de José", 1, "sadfsdfs", codComent , codPost));
		anexo.setComentario(coment);
		anexo.setEnd("sadfsdfs");
		anexo.setPost(post);
		anexo.setNome("Imagem de José");
		
		assertEquals(anexo, Fachada.getInstance().consultarAnexo(anexo.getCod()));
	}

	@Test
	public void testRemoverAnexo() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Blog blog = new Blog("Meu blog", "haha", "haha.pnb", true, false, Fachada.getInstance().consultaPorLogin("jose1"), "123");
		int codPost = Fachada.getInstance().criarPostar("uno", "asmdsand", user.getLogin(), blog.getId());
		Post post = new Post("uno", "asmdsand", user, blog);
		Comentario coment = new Comentario("normal", "asdsfd", post , user);
		int codComent = Fachada.getInstance().criarComentario("normal", "asdsfd", post.getCod() , user.getLogin());
		Anexo anexo = new Anexo();
		anexo.setCod(Fachada.getInstance().salvarAnexo("Imagem de José", 1, "sadfsdfs", codComent , codPost));
		anexo.setComentario(coment);
		anexo.setEnd("sadfsdfs");
		anexo.setPost(post);
		
		Fachada.getInstance().removerAnexo(anexo.getCod());
	}

}
