package interfaces;

import negocios.Comentario;

public interface ComentarioDAO {

	public void salvarComentario(Comentario comentario);
	public Comentario consultarComentario(int cod);
	public void removerComentario(int cod);
	
}
