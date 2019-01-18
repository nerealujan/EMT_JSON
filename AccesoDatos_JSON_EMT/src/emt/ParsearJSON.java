package emt;


import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParsearJSON {

	public void getDatos(String respuesta) {
		long tiempo=(long) 0;
        String lineId="";
        
        JSONParser parser=new JSONParser();
        
        try {
        	JSONObject objeto_json = (JSONObject)parser.parse(respuesta);
        
            JSONArray lista_paradas=(JSONArray) objeto_json.get("arrives");
                for (int i=0; i<lista_paradas.size();i++)
                {
                    JSONObject objeto_llegada=(JSONObject)lista_paradas.get(i);
                    lineId=(String)objeto_llegada.get("lineId");
                    tiempo=(long)objeto_llegada.get("busTimeLeft");
                   
                    LocalTime tiempoEspera = Instant.ofEpochSecond(tiempo).atOffset(ZoneOffset.UTC).toLocalTime();
                    System.out.println("Linea: "+lineId+"\nTiempo de espera: "+tiempoEspera);
                }
        } catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }

}
