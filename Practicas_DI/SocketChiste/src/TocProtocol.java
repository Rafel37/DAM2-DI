
import java.security.*;

public class TocProtocol {
    private static final int espera = 0;
    private static final int sentToc = 1;
    private static final int sentChiste = 2;
    private static final int otro = 3;

    private static final int contador = 5;

    private int state = espera;
    private int currentJoke = 0;

    private String[] clues = { "Juan ",
                               "Lola",
                               "Beny"};

    private String[] answers = { "¡Juan, Two, Three!",
                                 "Lola drones",
                                 "Ben y acercame el mando que no llego..."};

    public String processInput(String theInput) {
        String theOutput = null;
        
        //FIRMA DE CLAVES
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            // SE INICIALIZA EL GENERADOR DE CLAVES
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize(1024, numero);
            // SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
            KeyPair par = keyGen.generateKeyPair();
            PrivateKey clavepriv = par.getPrivate();
            PublicKey clavepub = par.getPublic();
            // FIRMA CON CLAVE PRIVADA EL MENSAJE
            // AL OBJETO Signature SE LE SUMINISTRAN LOS DATOS A FIRMAR
            Signature dsa = Signature.getInstance("SHA1withDSA");
            dsa.initSign(clavepriv);
            String mensaje = theInput;
            mensaje = " Este mensaje va a ser firmado";
            dsa.update(mensaje.getBytes());
            byte[] firma = dsa.sign(); // MENSAJE FIRMADO
            // EL RECEPTOR DEL MENSAJE
            // VERIFICA CON LA CLAVE PÚBLICA EL MENSAJE FIRMADO
            // AL OBJETO Signature SE LE SUMINISTRA. LOS DATOS A VERIFICAR
            Signature verificadsa = Signature.getInstance("SHA1withDSA");
            verificadsa.initVerify(clavepub);
            verificadsa.update(mensaje.getBytes());
            boolean check = verificadsa.verify(firma);
            if (check)
                System.out.println(" FIRMA VERIFICADA CON CLAVE PÚBLICA");
            else
                System.out.println("FIRMA NO VERIFICADA");
        } catch (NoSuchAlgorithmException el) {
            el.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }

        
        //VOLVEMOS AL PROGRAMA
        if (state == espera) {
            theOutput = "TOC! TOC!";
            state = sentToc;
        } else if (state == sentToc) {
            if (theInput.equalsIgnoreCase("Quien es?")) {
                theOutput = clues[currentJoke];
                state = sentChiste;
            }
            else if (theInput.equalsIgnoreCase("Pase")) {
                theOutput = "Listillo...";
                state = espera;
            }
            else {
                theOutput = "Escribe: \"Quien es?\"! " +
                        "Empezamos... TOC! TOC!";
            }
        } else if (state == sentChiste) {
            if (theInput.equalsIgnoreCase("que " + clues[currentJoke] + "?")) {
                theOutput = answers[currentJoke] + " Otra? (y/n)";
                state = otro;
            } else {
                theOutput = "Escribe: \"" + "que " +
                        clues[currentJoke] +
                        "?\"" +
                        "Empezamos... TOC! TOC!";
                state = sentToc;
            }
        } else if (state == otro) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "TOC! TOC!";
                if (currentJoke == (contador - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = sentToc;
            } else {
                theOutput = "Adios";
                state = espera;
            }
        }
        return theOutput;
    }
}
