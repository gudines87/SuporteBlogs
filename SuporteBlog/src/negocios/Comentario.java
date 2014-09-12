package negocios;

public class Comentario {
	
	private int cod;
	private String comentario;
	private Usuario usuario;

	
	public Comentario(){

	}
	
	public Comentario(int cod, String comentario, Usuario usuario) {
		this.cod = cod;
		this.comentario = comentario;
		this.usuario = usuario;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Comentario [cod=" + cod + ", comentario=" + comentario
				+ ", usuario=" + usuario + "]";
	}
	
	public void salvarComentario(Comentario coment){
		
	}
	
	public Comentario consultarComentario(int cod){
		return null;
	}
	
	public void removerComentario(int cod){
		
	}
	

}
