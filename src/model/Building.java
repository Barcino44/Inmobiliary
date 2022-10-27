package model;

public class Building {

	public static final int APARTMENT_SIZE = 11;

	private Apartment[] apartments; 
	private String name;
	private String direction;

	public Building(String name, String direction) {
		apartments = new Apartment[APARTMENT_SIZE];
		this.name = name;
		this.direction = direction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public boolean validateIftheApartmentHasAOwner(int apartmentNumber){
		int apartmentPos=searchApartmentByNumber(apartmentNumber);
		boolean ownerExist=apartments[apartmentPos].validateIftheApartmentHasAOwner();
		return ownerExist;
	}
	public boolean validateIfTheApartmentHasATennant(int apartmentNumber){
		int apartmentPos=searchApartmentByNumber(apartmentNumber);
		boolean tenantExist=apartments[apartmentPos].validateIfTheApartmentHasATennant();
		return tenantExist;
	}
	public int countEmptyApartments(){
		int emptyApartments=10; 
		for(int i=1; i<APARTMENT_SIZE; i++){
			if(apartments[i]!=null){
				if(apartments[i].validateIfTheApartmentHasATennant()==true){
				emptyApartments=emptyApartments-1;
				}
			}
		}
	return emptyApartments;
	}
	public double calculateInmobiliaryGain(){
		double payment=0;
		for (int i=1;i<APARTMENT_SIZE ;i++) {
			if(apartments[i]!=null){
				if(apartments[i].validateIfTheApartmentHasATennant()==true){
				payment = payment + apartments[i].getMensualValue();
				}
			}	
		}
	return payment;
	}
	public int countApartmentsByOwner(String ownerName){
		int countApartmentsByOwner=0;
		for(int i=1; i<APARTMENT_SIZE; i++){
			if(apartments[i]!=null){
				if(apartments[i].validateIfOwnerHasTheApartment(ownerName)==true){
					countApartmentsByOwner=countApartmentsByOwner+1;
				}
			}
		}
	return countApartmentsByOwner;
	}
	public double calculateOwnerGain(String ownerName){
		double ownerGain=0;
		for(int i=1; i<APARTMENT_SIZE; i++){
			if(apartments[i]!=null){
				if(apartments[i].validateIfOwnerHasTheApartment(ownerName)==true&&apartments[i].validateIfTheApartmentHasATennant()==true){
					ownerGain=ownerGain+apartments[i].getMensualValue();
				}		
			}
		}
	return ownerGain;
	}
}