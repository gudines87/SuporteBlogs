package testeUnidade;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import negocios.Profile;

import org.junit.Test;

import fachada.Fachada;

public class TestJDBCProfileDAO {

	@Test
	public void testCreateProfile() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		
		assertEquals("jose1", Fachada.getInstance().getProfileInformation("jose1", "login"));
	}

	@Test
	public void testChangeProfileInformation() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Fachada.getInstance().changeProfileInformation("jose1", "senha", "novaSenha");
		
		assertEquals("novaSenha", Fachada.getInstance().getProfileInformation("jose1", "senha"));
		
	}


	@Test
	public void testRemoverUsuario() {
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Fachada.getInstance().removerUsuario("jose1");
		
		assertEquals(null, Fachada.getInstance().consultarUsuario("jose1"));
	}

	@Test
	public void testConsultarUsuario() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		assertEquals(user, Fachada.getInstance().consultarUsuario("jose1"));
		
	}

	@Test
	public void testListarUsuarios() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Profile user2 = new Profile("jose2", "Jose", "zezinho", "Masculino",
				"jose2@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Fachada.getInstance().createProfile("jose2", "Jose", "zezinho", "Masculino",
				"jose2@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		List<Profile> users = new ArrayList<Profile>();
		users.add(user);
		users.add(user2);
		assertEquals(users, Fachada.getInstance().consultarUsuarios());
	}

	@Test
	public void testConsultaPorLogin() {
		Profile user = new Profile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		Fachada.getInstance().createProfile("jose1", "Jose", "zezinho", "Masculino",
				"jose@gmail.com", "06/06/1990", "Rua tal", "mulheres", "uma pessoa",
				"um, dois e tres", "uma, duas e tres", "tal tal e tal");
		assertEquals(user, Fachada.getInstance().consultaPorLogin("jose1"));
	}

}
