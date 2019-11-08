
/*



El cliente SSL carga el fichero AlmacenTrust creado  con la herramienta Keytool conteniendo el
certificado de clave pública del servidor

El cliente ademas carga el almacen AlmacenCL que es el mismo fichero que AlmacenSR. Este fichero contendrá
la claveprivada y el certificado del cliente que en este ejemplo es un certificado autofirmado igual en el
cliente y en servidor.


Los almacenes los cargamos con las properties


El cliente obtiene el certificado de clave publica del servidor y lo imprime a fichero





*/












import java.net.*;  // para sockets
import java.io.*;
import javax.net.ssl.*;   //sockets SSL
import java.util.*;
import java.security.cert.X509Certificate; // para Manejo del Certificado enviado por el servidor
import java.nio.charset.Charset; //para generar los certificados en fichero PEM




public class EchoClient 
{
	public	static void

		main(String[] arstring)
	 {
		try {
			
					


			String dirip;




// Se carga el almacen que contiene la clave privada y Certificado del Cliente
			System.setProperty("javax.net.ssl.keyStore","AlmacenCL");
			System.setProperty("javax.net.ssl.keyStorePassword","oooooo");





System.setProperty("javax.net.ssl.trustStore","AlmacenTrust");

//esto no hace falta
//System.setProperty("javax.net.ssl.keyStorePassword", "oooooo"); 





System.out.println("\n\n\n");



			System.out.println("--------------------------------------------------------------------------|");
			System.out.println("|                  CLIENTE SSL CON AUTENTICACION                          |");
			System.out.println("|           CARGADO CON PROPERTIES EL ALMACEN AlmacenCL                   |");
			System.out.println("|       CON CERTIFICADO CLIENTE Y EL ALMACEN AlmacenTrust                 |");
			System.out.println("|            PARA AUTENTICAR AL SERVIDOR. CERTIFICADO AUTOFIRMADO         |");
			System.out.println("|                      AlmacenCL=AlmacenSR                                |");
			System.out.println("|                                                                         |");
			System.out.println("|                    (C) Luis Mengual. Junio 2009                         |");
			System.out.println("--------------------------------------------------------------------------|");


System.out.println("\n\n\n");







			InputStreamReader Flujo = new InputStreamReader(System.in);
			BufferedReader teclado = new BufferedReader(Flujo);
			System.out.print("Direccion IP: " );
			dirip=teclado.readLine();
			//System.out.println("la direccion IP metida es:"+dirip );
				
					
			System.out.print("Puerto:" );
			Scanner sc =new Scanner(System.in);
			String pto= sc.nextLine();
			int ptoint= Integer.parseInt(pto);
			
			//System.out.printf("el pto metido es %d: \n", ptoint);

			


	


		
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

			

			SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(dirip, ptoint);
			System.out.println("CREADO SOCKET SSL");





			// OBTENCION DE LA SESION Y  DEL CERTIFICADO RECIBIDO DEL SERVIDOR



			SSLSession sesion = sslsocket.getSession();


			System.out.println("\n\n\n");

			System.out.println("**********************************************************************");


			System.out.println("CERTIFICADO RECIBIDO DEL SERVIDOR");
			System.out.println("\n");

			System.out.println("Host: "+sesion.getPeerHost());

			X509Certificate certificate = (X509Certificate)sesion.getPeerCertificates()[0];
			
			System.out.println("Propietario: "+certificate.getSubjectDN());
			System.out.println("Emisor: "+certificate.getIssuerDN());
			System.out.println("Numero Serie: "+certificate.getSerialNumber() );
			System.out.println("to string: "+certificate.toString()  );


			System.out.println("**********************************************************************");
			System.out.println("\n\n\n");	
		




			// IMPRIMIMOS EL CERTIFICADO


			byte[] buf = certificate.getEncoded();
			FileOutputStream os = new FileOutputStream("server.cer");

			
				os.write(buf);
			

			os.close();


			// IMPRIMIMOS EL CERTIFICADO



			
			InputStream inputstream = System.in;
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
			
			OutputStream outputstream = sslsocket.getOutputStream();
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
			BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);


			OutputStreamWriter outputstreamwriter2 = new OutputStreamWriter(outputstream);
			BufferedWriter bufferedwriter2 = new BufferedWriter(outputstreamwriter2);
			
			
			String string = null;
   			
	
			InputStream inputstream2 = sslsocket.getInputStream();
			InputStreamReader inputstreamreader2 = new InputStreamReader(inputstream2);
			BufferedReader bufferedreader2 = new BufferedReader(inputstreamreader2);

			while ((string = bufferedreader.readLine()) != null) {
				bufferedwriter.write(string + '\n');
				bufferedwriter.flush();

				System.out.println(bufferedreader2.readLine() );
					


			}




		} 
	      catch (Exception exception) 	
		{
			exception.printStackTrace();
		}
	}//main

}//public