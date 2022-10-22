package model;

public class Building {

	public static final int APARTMENT_SIZE = 10;

	private Apartment[] apartments; 
	private String name;
	private int numberOfApartments;
	private String direction;

	public Building(String name, int numberOfApartments, String direction) {
		apartments = new Apartment[APARTMENT_SIZE];
		this.name = name;
		this.numberOfApartments = numberOfApartments;
		this.direction = direction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfApartments() {
		return numberOfApartments;
	}
	public void setTypeEnemy(int numberOfApartments){
		this.numberOfApartments = numberOfApartments;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction){
		this.direction = direction; 
	}
	public String addApartmentWithObject(Apartment apartment){
		String msj="Failed to add the apartment";
		boolean isEmpty=false;
		for(int i = 1; i <APARTMENT_SIZE && !isEmpty; i++){
			if(apartments[i] == null){
				apartments[i] = apartment; 
				isEmpty = true; 
				msj = "New apartment added to the building "; 
			}
		}
		return msj;
	}
}