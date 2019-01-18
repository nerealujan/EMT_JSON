package emt;

public class Autobus {
	
	private String lineID;
	private long tiempo;
	
	public String getLineID() {
		return lineID;
	}
	public long getTiempo() {
		return tiempo;
	}
	public Autobus(String lineID, long tiempo) {
		super();
		this.lineID = lineID;
		this.tiempo = tiempo;
	}
	

}
