package br.edu.ifpb.pweb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="contatoBean")
@SessionScoped
public class ContatoBean {
	
	@ManagedProperty(value="#{agendaBean}")
	private AgendaBean agendabean;
	
	private Contato contato;
	
	public ContatoBean(){}
	
	@PostConstruct
	public void init(){
		this.contato = new Contato();
	}
	
	public String init(Contato c){
		this.contato = c;
		return "contato";
	}

	public AgendaBean getAgendabean() {
		return agendabean;
	}

	public void setAgendabean(AgendaBean agendabean) {
		this.agendabean = agendabean;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public String salvar(){
		
		if(this.contato.getId() == null)
			this.agendabean.adicionar(this.contato);
		else
			this.agendabean.atualizar(this.contato);
		
		this.contato = new Contato();
		return "index?faces-redirect=true";
	}
}
