package interfaces;

import negocios.Blog;

public interface BlogDAO {
	
	public int createBlog(Blog blog);
	public Blog consultarBlog(int id);
	public void removerBlog(int id);
	public void changeBlogInformation(int id, String atributo, String conteudo);

}
