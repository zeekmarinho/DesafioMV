package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.primefaces.model.UploadedFile;

import entidade.Colaborador;
import entidade.OpcaoCafe;
import entidade.RetornoColaborador;
import servico.ColaboradorServico;

public class ImportacaoBean {
	
	private UploadedFile arquivo;
	private ColaboradorServico servico = new ColaboradorServico();
	
	public void importar() {
		if (arquivo != null) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo.getInputstream()));

				String linha;
				boolean primeiraLinha = true;

				while ((linha = reader.readLine()) != null) {

					if (primeiraLinha) {
						primeiraLinha = false;
					} else {

						String[] dados = linha.split(",");

						Colaborador colaborador = new Colaborador();
						OpcaoCafe opcaocafe = new OpcaoCafe();
						colaborador.setCpf(dados[0]);
						colaborador.setNome(dados[1]);
						opcaocafe.setOpcafe(dados[3]);
						

						RetornoColaborador retorno = servico.inserirColaborador(colaborador);
						
						if (retorno.getCodigoRetorno() == 0) {
							System.out.println(retorno.getMensagemRetorno());
						}

					}

				}

				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}	

}
