package emt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClasePrincipal {

	private static String parada;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué parada quieres?");
		parada = sc.nextLine();
		String respuesta ="";
		
	PeticionPost p;

	try {
		p = new PeticionPost("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetArriveStop.php");
		p.add("idClient", "WEB.SERV.ataraxa@hotmail.com");
		p.add("passKey","83D88CD0-8A9B-4CE6-B976-B922B61FAE6D");
		p.add("idStop", parada);
		
		respuesta = p.getRespueta();
	
		ParsearJSON pj = new ParsearJSON();
		pj.getDatos(respuesta);
		
		
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	

	}
}
