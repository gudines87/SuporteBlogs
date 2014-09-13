package negocios;

import interfaces.ComentarioDAO;

public class Comentario {
	
	private int cod;
	private String comentario;
	private Profile usuario;

	
	public Comentario(){
		this.usuario = new Profile();
	}

	public Comentario(String comentario, Profile usuario) {
		this.usuario = new Profile();
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

	public Profile getUsuario() {
		return usuario;
	}

	public void setUsuario(Profile usuario) {
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
