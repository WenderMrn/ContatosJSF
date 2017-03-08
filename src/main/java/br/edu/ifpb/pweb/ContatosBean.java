package br.edu.ifpb.pweb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="contatosBean")
@SessionScoped
public class ContatosBean {
	private List<Contato> contatos;
	private Contato contato;
	
	@PostConstruct
	public void init(){
		this.contato = new Contato();
		this.contatos = new ArrayList<Contato>();
		this.contatos.add(new Contato("João","joao@email.com","9999-9999"));
		this.contatos.add(new Contato("Maria","maria@email.com","888-8888"));
		this.contatos.add(new Contato("Pedro","pedro@email.com","7777-7777"));
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public String adicionar(){
		this.contatos.add(this.contato);
		this.contato = new Contato();
		return "index";
	}
}
