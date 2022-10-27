package model;

public class Apartment {

	public static final int CLIENT_SIZE=3;

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
	public boolean addOwnerToApartment(Owner owner){
		boolean isAdded=false;
		for(int i=1; i<CLIENT_SIZE; i++){
			if(clients[1]==null){
				clients[1]=owner;
				isAdded=true;
			}
		}
	return isAdded;
	}
	public boolean addTenantToApartment(Tenant tenant){
		boolean isAdded=false;
		for(int i=1; i<CLIENT_SIZE; i++){
			if(clients[2]==null){
				clients[2]=tenant;
				isAdded=true;
			}
		}
	return isAdded;
	}
	public boolean validateIftheApartmentHasAOwner(){
		boolean ownerExist=true;
		for(int i=1; i<CLIENT_SIZE; i++){
			if(clients[1]==null){
				ownerExist=false;
			}
		}
	return ownerExist;
	}
	public boolean validateIfTheApartmentHasATennant(){
		boolean tenantExist=true;
		for(int i=1; i<CLIENT_SIZE; i++){
			if(clients[2]==null){
				tenantExist=false;
			}
		}
	return tenantExist;
	}
	public boolean validateIfOwnerHasTheApartment(String ownerName){
		boolean ownerHasTheApartment=false;
		for(int i=1; i<CLIENT_SIZE;i++){
			if(clients[i]!=null){
				if(clients[1].getName().equals(ownerName)){
					ownerHasTheApartment=true;
				}
			}
		}
	return ownerHasTheApartment;
	}
}
