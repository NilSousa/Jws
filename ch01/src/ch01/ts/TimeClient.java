package ch01.ts;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TimeClient {

	public static void main(String[] args) throws Exception {
		try {
			URL url = new URL("http://localhost:9876/ts?wsdl");

			// Nome qualificado do servi�o
			// Primeiro argumento � o URI do servi�o
			// Segundo � o nome do servi�o publicado no WSDL

			QName qname = new QName("http://ts.ch01/", "TimeServerImplService");

			// Cria, de fato, uma f�brica para o servi�o
			Service service = Service.create(url, qname);

			// Extrai a interface endpoint, o servi�o "port".
			TimeServer eif = service.getPort(TimeServer.class);

			System.out.println(eif.getTimeAsString());
			System.out.println(eif.getTimeAsElapsed());
		} catch (Exception e) {
			System.out.println("Erro na conex�o com o servi�o.");
		}
	}

}
