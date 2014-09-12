package interfaces;

import negocios.Blog;

public interface BlogDAO {
	
	public void criarBlog(Blog blog);
	public Blog consultarBlog(int cod);
	public void removerBlog(int cod);

}
