package servico;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import entidade.Colaborador;
import entidade.RetornoColaborador;

public class ColaboradorServico {
	
	private String URL_ENCODE = 
			"http://localhost:9090/DesafioMV/rest/colaborador/";

		Client client = Client.create();

		public RetornoColaborador inserirColaborador(Colaborador colaborador) {

			RetornoColaborador retorno = null;

			try {
 
				WebResource webResource = client.resource(URL_ENCODE + "inserirCliente");

				ClientResponse response = webResource.accept("application/json")
													.post(ClientResponse.class, colaborador);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
				}
				
				retorno = response.getEntity(RetornoColaborador.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return retorno;
		}
		
		public RetornoColaborador pesquisarColaborador(String cpf) {

			RetornoColaborador retorno = null;

			try {
 
				WebResource webResource = client.resource(URL_ENCODE + "pesquisarCliente?cpf=" + cpf);

				ClientResponse response = webResource.accept("application/json")
													.get(ClientResponse.class);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
				}
				
				retorno = response.getEntity(RetornoColaborador.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return retorno;
		}

}
