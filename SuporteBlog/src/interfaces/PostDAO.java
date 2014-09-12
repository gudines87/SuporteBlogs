package interfaces;

import negocios.Post;

public interface PostDAO {
	
	public void criarPost(Post post);
	public Post consultarPost(int cod);
	public void removerPost(int cod);

}
