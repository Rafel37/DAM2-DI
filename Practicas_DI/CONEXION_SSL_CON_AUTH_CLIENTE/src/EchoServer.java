

/*

El servidor carga el fichero AlmacenSR donde está un certificado autofirmado creado por el servidor con
la herramienta Keytool (key entry) y tambien el fichero AlmacenTrust con el certificado de clave publica.
Este segundo almacen lo utiliza para autenticar al cliente.

En este al tener un certificado Autofirmado es igual el certificado del cliente que el del servidor. Y por consiguiente
son iguales los almacenes AlmacenSR y AlmacenCL. Almacentrust tambien es igual en el cliente que el del servidor.

Los almacenes los cargamos con las properties


keytool -genkey -alias CertificadoAutofirmado  -keyalg RSA -validity "100" -keystore AlmacenSR -keypass oooooo -storepass oooooo

El servidor exporta el certificado con Keytool

keytool -export -alias CertificadoAutofirmado -keystore AlmacenSR -rfc -file CertAutofirmado.cer

y finalmente crea un almacen trust con el certificado de clave pública (sin clave privada)

keytool -import -alias CertificadoAutofirmado -file CertAutofirmado.cer -keystore AlmacenTrust

El fichero AlmacenTrust  se le da al cliente



*/

import java.net.*;								// Para ServerSocket
import java.util.*;
import javax.net.ssl.*;							// Para SSLSockets
import java.io.*;               //ENTRADA SALIDA
import java.security.cert.X509Certificate; // para Manejo del Certificado enviado por el servidor
import java.nio.charset.Charset; //para generar los certificados en fichero PEM
//import java.security.*;



public class EchoServer {

public static void

	main(String[] arstring)
	{
		PrintStream p;
				


		try {




			System.out.println("\n\n");



			System.out.println("-----------------------------------------------------------------------------|");
			System.out.println("|                  SERVIDOR SSL CON AUTENTICACION DE CLIENTE                 |");
			System.out.println("|        CARGADO CON PROPERTIES EL ALMACEN DEL SERVIDOR  (almacenSR)         |");
			System.out.println("|        Y ALMACEN AlmacenTrust. CERTIFICADO AUTOFIRMADO                     |");
			System.out.println("|             OBTENCION E IMPRESION CERTIFICADO DE CLIENTE                   |");
			System.out.println("|                     (C) Luis Mengual. Junio 2009                           |");
			System.out.println("-----------------------------------------------------------------------------|");


			System.out.println("\n");













			// Se carga el almacen que contiene la clave privada y Certificado del Servidor
			System.setProperty("javax.net.ssl.keyStore","AlmacenSR");
			System.setProperty("javax.net.ssl.keyStorePassword","oooooo");


			// Se carga el almacen que contiene el Certificado de clave pública del cliente o la CA que firma el cert del cliente
			// En este ejemplo como tenemos un certificado Autofirmado es igual el certificado del cliente que el del servidor
			System.setProperty("javax.net.ssl.trustStore","AlmacenTrust");




			SSLServerSocketFactory sslserversocketfactory =	(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

			

			SSLServerSocket sslserversocket =(SSLServerSocket) sslserversocketfactory.createServerSocket(10001);


			System.out.println("SERVIDOR ECO ESPERANDO PTO 10001 ....... ");

			
			//SERVIDOR CON AUTENTICACION DEL CLIENTE

			 sslserversocket.setNeedClientAuth(true);

			SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();



			p=new PrintStream(sslsocket.getOutputStream());

			InputStream inputstream = sslsocket.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
			String string = null;

		


			SSLSession sesion = sslsocket.getSession();

			
			System.out.println("Host: "+sesion.getPeerHost());
			

			//SERVIDOR SIN AUTENTICACION DEL CLIENTE



			// LEEMOS E IMPRIMIMOS CERTIFICADO DEL CLIENTE


			System.out.println("\n\n\n");

			System.out.println("**********************************************************************");


			System.out.println("CERTIFICADO RECIBIDO DEL CLIENTE");
			System.out.println("\n");



			


			
			X509Certificate certificate = (X509Certificate)sesion.getPeerCertificates()[0];



			//Certificate certificate = sesion.getPeerCertificates()[0];

			System.out.println("Propietario: "+certificate.getSubjectDN());
			System.out.println("Emisor: "+certificate.getIssuerDN());
			System.out.println("Numero Serie: "+certificate.getSerialNumber() );
			System.out.println("to string: "+certificate.toString()  );


			System.out.println("**********************************************************************");
			System.out.println("\n\n\n");




			
			byte[] buf = certificate.getEncoded();
			FileOutputStream os = new FileOutputStream("Cliente.cer");

			
				os.write(buf);
			

			os.close();



















/////////////////////////////////////////////////////////////////////////////////





			while ((string = bufferedreader.readLine()) != null) {
				System.out.println(string);
				System.out.flush();

				Thread.currentThread().sleep(1000);  
				p.println(string);


			}

		    }

               catch (Exception exception)
       		{
			exception.printStackTrace();
		}
	}//main
}//public