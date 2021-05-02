package entidade;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RetornoColaborador {
	
	private int codigoRetorno; // 0-Sucesso 1-Falha
	private String mensagemRetorno;
	private List<Colaborador> listaColaborador;
	
	public int getCodigoRetorno() {
		return codigoRetorno;
	}
	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
	public String getMensagemRetorno() {
		return mensagemRetorno;
	}
	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}
	public List<Colaborador> getListaColaborador() {
		return listaColaborador;
	}
	public void setListaColaborador(List<Colaborador> listaColaborador) {
		this.listaColaborador = listaColaborador;
	}	

}
