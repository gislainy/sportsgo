package br.com.sempreufg.service;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sempreufg.dao.interfaces.IEmailDAO;
import br.com.sempreufg.model.usuario.Usuario;
import br.com.sempreufg.model.utils.Email;

@Service
@RequestMapping("/email")
public class EmailService {

	@Autowired
	private IEmailDAO emailDao;

	@ResponseBody
	@RequestMapping(value = "/emailExiste", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean valideEmail(Email email) throws SQLException, MalformedURLException {
		ArrayList<Email> listaDeEmail = (ArrayList<Email>) emailDao.lista();
		return listaDeEmail.contains(email);
	}
	
	@ResponseBody
	@RequestMapping(value = "/valideEmailsDoUsuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean valideEmailsDoUsuario(Usuario usuario) throws SQLException, MalformedURLException {
		Boolean EmailExiste =  false;
		for(Email email : usuario.getEmails()){
			EmailExiste = this.valideEmail(email);
			if (EmailExiste)  break;
			//throw EmailJaExiteExeption();
		}
		
		return EmailExiste;
	}
	
	@ResponseBody
	@RequestMapping(value = "/emailBlank", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Email emailVazio() {
		Email email = new Email();
		return email;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listaEmails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Email> listaUsuarios() throws SQLException {
		return (ArrayList<Email>) emailDao.lista();
	}
}
