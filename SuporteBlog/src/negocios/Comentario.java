package negocios;

import interfaces.ComentarioDAO;

public class Comentario {
	
	private int cod;
	private String comentario;
	private Administrador administrador;
	private Espectador espectador;

	
	public Comentario(){

	}
	
	public Comentario(String comentario, Administrador administrador,
			Espectador espectador) {
		super();
		this.comentario = comentario;
		this.administrador = administrador;
		this.espectador = espectador;
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
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Espectador getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}
	
	@Override
	public String toString() {
		return "Comentario [cod=" + cod + ", comentario=" + comentario
				+ ", administrador=" + administrador + ", espectador="
				+ espectador + "]";
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
