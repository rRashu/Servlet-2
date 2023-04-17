finalizado aun que falta mejorar la interfaz y si se requiere conectarse a una bd falta implementar 

esto sirve para probar la app y pedir que envie tanto xml o json segun se requiera 
(es una clase aparte pero es lo que se necesita para llamar y usar en las html)

``` java
package com.alura.cliente;

import java.io.IOException;

import org.apache.hc.client5.http.fluent.Request;

public class clienet_webservice {

	public static void main(String[] args) throws IOException {
		String contenido = Request.post("http://localhost:8080/gerenciador/empresas")
				.addHeader("Accept", "Application/json").execute().returnContent()
				.toString();
		System.out.println(contenido);
	}

}

```

