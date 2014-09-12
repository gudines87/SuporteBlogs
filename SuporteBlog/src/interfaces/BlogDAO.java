package interfaces;

import negocios.Blog;

public interface BlogDAO {
	
	public int criarBlog(Blog blog);
	public Blog consultarBlog(int cod);
	public void removerBlog(int cod);

}
