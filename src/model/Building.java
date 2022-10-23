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
	public Boolean addApartmentWithObject(Apartment apartment){
		boolean isAdded=false;
		for(int i = 1; i <APARTMENT_SIZE && !isAdded; i++){
			if(apartments[i] == null){
				apartments[i] = apartment; 
				isAdded = true; 
			}
		}
		return isAdded;
	}
	public int searchApartmentByNumber(int apartmentNumber){
		boolean isFound=false;
		int pos=-1;
		for (int i=1; i<APARTMENT_SIZE; i++){
			if(apartments[i]!=null){
				if(apartments[i].getNumber()==apartmentNumber){
					pos=i;
					isFound=true;
				}
			}
		}
		return pos;
	}
	public boolean addOwnerToApartment(int apartmentNumber, Owner owner){
		boolean isPossibleToAdd=false;
		int apartmentPos=searchApartmentByNumber(apartmentNumber);
		if(apartments[apartmentPos].addOwnerToApartment(owner)==true){
			isPossibleToAdd=true;
		}
		return isPossibleToAdd;
	}
	public boolean addTenantToApartment(int apartmentNumber, Tenant tenant){
		boolean isPossibleToAdd=false;
		int apartmentPos=searchApartmentByNumber(apartmentNumber);
		if(apartments[apartmentPos].addTenantToApartment(tenant)==true){
			isPossibleToAdd=true;
		}
		return isPossibleToAdd;
	}
	public boolean validateIfOwnerExist(int apartmentNumber){
		int apartmentPos=searchApartmentByNumber(apartmentNumber);
		boolean ownerExist=apartments[apartmentPos].validateIfOwnerExist();
		return ownerExist;
	}
	public boolean validateIfTenantExist(int apartmentNumber){
		int apartmentPos=searchApartmentByNumber(apartmentNumber);
		boolean tenantExist=apartments[apartmentPos].validateIfTenantExist();
		return tenantExist;
	}
}