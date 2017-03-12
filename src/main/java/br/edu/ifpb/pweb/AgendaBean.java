package br.edu.ifpb.pweb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="agendaBean")
@SessionScoped
public class AgendaBean {
	private List<Contato> contatos;

	@PostConstruct
	public void init(){
		this.contatos = new ArrayList<Contato>();
		adicionar(new Contato("João","joao@email.com","9999-9999"));
		adicionar(new Contato("Maria","maria@email.com","888-8888"));
		adicionar(new Contato("Pedro","pedro@email.com","7777-7777"));
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public String adicionar(Contato c){
		c.setId(new Long(this.contatos.size()+1));
		this.contatos.add(c);
		return "index";
	}
	
	public void excluir(Contato c){
		this.contatos.remove(c);
	}
	
	public void atualizar(Contato c){
		for (Contato contato : contatos) {
			if(contato.getId() == c.getId()){
				contato = c;
			}
		}
	}
}
