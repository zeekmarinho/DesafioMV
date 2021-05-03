package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entidade.Colaborador;
import entidade.OpcaoCafe;
import fachada.Fachada;

@ManagedBean(name = "ControleBean")
@RequestScoped
public class ControleBean {
	
	private Colaborador colaborador;
	private OpcaoCafe opcaocafe;
	private Fachada fachada;
	private List<Colaborador> listaColaborador;
	
	public ControleBean() {
		this.colaborador = new Colaborador();
		this.opcaocafe = new OpcaoCafe();
		this.fachada = new Fachada();
		this.listaColaborador = new ArrayList<Colaborador>();
	}
	
	//Botão salvar Colaborador
	public void salvar() {		
		
		if (this.fachada.inserirColaborador(colaborador)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Colaborador cadastrado!"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro no cadastro!"));
		}

	}	
	
	//Pesquisar Colaborador
	public void pesquisar() {
		this.listaColaborador = fachada.pesquisarColaborador(this.colaborador);
	}
	
		
	//Adicionar Opção de Café
	public void adicionar() {		
		
		if (this.fachada.adicionarOpcaoCafeColaborador(opcaocafe)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Contato cadastrado!"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro no cadastro!"));
		}		
	}
	
	//Remover Opção de Café
	public void remover() {
		this.fachada.removerContatoCliente(this.opcaocafe);
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public OpcaoCafe getOpcaocafe() {
		return opcaocafe;
	}

	public void setOpcaocafe(OpcaoCafe opcaocafe) {
		this.opcaocafe = opcaocafe;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Colaborador> getListaColaborador() {
		return listaColaborador;
	}

	public void setListaColaborador(List<Colaborador> listaColaborador) {
		this.listaColaborador = listaColaborador;
	}	
	
}
