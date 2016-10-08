package client;

//i Orbacus packages
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import CaesarAlgorithm.CaesarAlgorithm;
import CaesarAlgorithm.CaesarAlgorithmHelper;

/**
 * Dies ist der Java-Client der Orbacus implementiert und sich somit ueber die CORBA Architektur
 * mit einem C++-Server der ebenfalls Orbacus implementiert verbinden kann. Dies funktionkiert
 * sowohl ueber den localhost am eigenen Computer oder ueber die IP-Adresse, die so wie andere
 * CORBA-Informationen im Konsolenparamter uebergeben wird, ueber das Netzwerk. Wenn der Client
 * nun mit einem Server verbunden ist, hat er die Aufgabe 
 * 
 * @author Gabriel Pawlowsky & Josef Sochovsky
 * @version 2012-03-22
 */

public class Client {
	/**
	 * Diese Methode setzt die Orbacus-Einstellungen und versucht diese in eine Datei zu schreiben, wenn diese nicht
	 * existriert gibt er das aus, das ist aber nicht schlecht, sondern es wird einfach eine neue erzeugt.
	 * 
	 * @param props Die bereits vorher gesetzten System Properties, die in das orbacus.properties File uebernommen werden,
	 * 				um den Client mit diesem lauffaehig zu machen.
	 */
	public static void setOrbacusProperties(java.util.Properties props)
			throws java.io.FileNotFoundException, java.io.IOException {
		//Speichern des Java_home Ordners der angibt wo sich die Java-Installation befindet
		//dies wird benoetigt, um gegebenefalls ein bereits existierendes orbacus.properties
		//file zu finden und sonst eines dort zu erstellen.
		String javaHome = System.getProperty("java.home");
		//Versucht orbacus.properties im Projekt zu finden
		File propFile = new File("orbacus.properties");
		if (!propFile.exists())
			//Wenn es dort nicht ist, dann suche im java_home Ordner
			propFile = new File(javaHome + File.separator + "lib"
					+ File.separator + "orbacus.properties");
		//Wenn es da auch nicht ist gib das aus und erstelle mit den uebergebenen props ein neues
		if (!propFile.exists())
			System.out.println("Cannot find file: orbacus.properties");
		else {
			FileInputStream fis = new FileInputStream(propFile);
			System.out.println("Loading " + propFile.getPath());
			props.load(fis);
			fis.close();
		}
	} 
	/**
	 * main-Methode
	 * @param args genaue Informationen welche Argumente uebergeben werden sind im Protokoll nachzulesen 
	 */
	public static void main(String args[]) {
		try {
			System.out.println("running client..\n");
			// setzen der properties von Orbacus
			java.util.Properties props = System.getProperties();
			System.out.println(System.getProperties().toString());
			setOrbacusProperties(props);
			System.out.println("init ORB.\n");
			// erstellen eines ORBs zur Kommunikation mit dem Server und dem Nameservice das in dem Aufruf-Argumenten uebergeben wurde
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
			// hier werden die Referenz auf den gesamten Nameservice erstellt um dann spaeter resolven zu koennen
			System.out.println("\n connecting to nameservice...\n");
			org.omg.CORBA.Object objNaming = orb
					.resolve_initial_references("NameService");
			NamingContext ncRef = NamingContextHelper.narrow(objNaming);
			// finden des Objekts 'CryptographicService' 
			// dieses speichert eine Namensreferez auf dem Server indem es den richtigen Servicenamen speichert 
			NameComponent nc = new NameComponent("CryptographicService", "");
			NameComponent path[] = { nc };
			// erstellen eines CaesarAlgorithmHelper Objekts
			// dieses Objekt ist dazu da um die referenzierten Methoden vom Server aufzurufen
			CaesarAlgorithm calg = CaesarAlgorithmHelper.narrow(ncRef.resolve(path));
			//Anbieten der Funktionalität des Servers bis der User exit aufruft
			while(true){
				System.out.println("Cryptographic service client");
				System.out.println("----------------------------");
				System.out.println("Enter encryption key: ");
				// einlesen der Eingaben fuer CAESAR Verschluesselung
				String encryptionKey = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				System.out.println("Enter a shift: ");
				String shift = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				System.out.println("Enter a plain text to encrypt: ");
				String plainText = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				// hier wird das Ergebnis der Verschluesselung vom Server gespeichert damit man es spaeter ausgeben kann
				char[] encryptedText = calg.encrypt(plainText, Integer.parseInt(encryptionKey), Integer.parseInt(shift));
				
				System.out.println("\nEncrypted Text: ");
				System.out.print(encryptedText);
				// hier wird das Ergebnis der Entschluesselung vom Server gespeichert damit man es spaeter ausgeben kann
				String decryptedText = calg.decrypt(encryptedText, Integer.parseInt(encryptionKey), Integer.parseInt(shift));
				
				System.out.println("\nDecrypted Text: " + decryptedText);
				System.out.println("Exit?y/n");
				//abfrage ob der User nocheinmal verschluesseln moechte
				if((new BufferedReader(new InputStreamReader(System.in))).readLine().equals("y"))
					break;

			}
			
		} catch (Exception e) {
			System.out.println("!Exception...: " + e);
		}
	} 
} 