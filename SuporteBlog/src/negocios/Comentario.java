package negocios;

import interfaces.ComentarioDAO;

public class Comentario {
	
	private int cod;
	private String comentario;
	private Usuario usuario;

	
	public Comentario(){
		this.usuario = new Usuario();
	}

	public Comentario(int cod, String comentario, Usuario usuario) {
		this.usuario = new Usuario();
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

	public int salvarComentario(Comentario comentario){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.salvarComentario(comentario);
	}
	
	public Comentario consultarComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.consultarComentario(cod);
	}
	
	public void removerComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		cd.removerComentario(cod);
	}
	

}
