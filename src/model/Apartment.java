package model;

public class Apartment {

	public static final int CLIENT_SIZE = 2;

	private Client[] clients; 
	private int number;
	private int numberOfBedrooms;
	private int numberOfBathrooms;
	private boolean hasBalcony;
	private double mensualValue;

	public Apartment(int number, int numberOfBedrooms, int numberOfBathrooms, boolean hasBalcony, double mensualValue) {
		clients = new Client[CLIENT_SIZE];
		this.number = number;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.hasBalcony = hasBalcony;
		this.mensualValue = mensualValue;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}
	public void setNumberOfBedrooms(int numberOfBedrooms){
		this.numberOfBedrooms = numberOfBedrooms;
	}
	public boolean gethasBalcony() {
		return hasBalcony;
	}
	public void setHasBalcony(boolean hasBalcony){
		this.hasBalcony = hasBalcony; 
	}
	public double getMensualValue() {
		return mensualValue;
	}
	public void setMensualValue(double mensualValue){
		this.mensualValue = mensualValue; 
	}
}