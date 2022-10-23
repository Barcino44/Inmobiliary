package model;
public class Inmobiliary {

	public static final int BUILDING_SIZE = 5;

	private Building[] buildings; 

	public Inmobiliary(String nit) {
		buildings = new Building[BUILDING_SIZE];
		buildings[1]=new Building("Lantana",10,"Calle20#68-72");
		buildings[2]=new Building("Pradera",10,"Carrera15#87-14");
	}
	public String addBuilding(String name, int numberOfApartments, String direction){
		String msj="";
		Building newBulding = new Building(name, numberOfApartments,direction);
		int emptyPos = searchEmptyposBuilding();
			if (emptyPos != -1){
				buildings[emptyPos]=newBulding;
				msj="New building added";
			}
		return msj;
	}
	public int searchEmptyposBuilding(){
		int pos= -1;
		boolean isEmpty=false;
		for(int i = 1; i < BUILDING_SIZE && !isEmpty; i++){
			if(buildings[i] == null){
				pos=i;
				isEmpty = true; 
			}
		}
		return pos;
	}
	public int searchBuildingByName(String buildingName){
		int pos=-1;
		boolean buildingExist=false;
		for(int i=1; i<BUILDING_SIZE&&!buildingExist; i++){
			if(buildings[i]!=null){
				if(buildings[i].getName().equals(buildingName)){
					pos=i;
					buildingExist=true;
				}
			}
		}
		return pos;
	}
	public boolean validateIfApartmentNoExist(String buildingName, int apartmentNumber){
		boolean apartmentNoExist=false;
		int posBuilding=searchBuildingByName(buildingName);
		if(buildings[posBuilding].searchApartmentByNumber(apartmentNumber)==-1){
			apartmentNoExist=true;
		}
	return apartmentNoExist;
	}
	public String addApartmentToBuilding(String buildingName, int apartmentNumber, int numberOfBedrooms, int numberOfBathroooms, boolean hasBalcony, double mensualValue){
		String msj="";
		int posBuilding=searchBuildingByName(buildingName);
		Apartment newApartment= new Apartment(apartmentNumber, numberOfBedrooms, numberOfBathroooms, hasBalcony, mensualValue);
		if(buildings[posBuilding].addApartmentWithObject(newApartment)==true){
			msj="The apartment " + apartmentNumber + " has been added to the building " + buildingName;
		}
		return msj;
	}
	public boolean validateIfOwnerExist(String buildingName, int apartmentNumber){
		int posBuilding=searchBuildingByName(buildingName);
		boolean ownerExist=buildings[posBuilding].validateIfOwnerExist(apartmentNumber);
		return ownerExist;
	}
	public boolean validateIfTenantExist(String buildingName, int apartmentNumber){
		int posBuilding=searchBuildingByName(buildingName);
		boolean tenantExist=buildings[posBuilding].validateIfTenantExist(apartmentNumber);
		return tenantExist;
	}
	public String addOwnerToApartment(String buildingName, int apartmentNumber, int selectiontypeId, String numberOfId, String name, String phoneNumber, int selectiontypePhone, String numberOfAccount, String nameOfBank){
		String msj="";
		int buildingPos=searchBuildingByName(buildingName);
		Owner newOwner = new Owner(selectiontypeId, numberOfId, name, phoneNumber, selectiontypePhone, numberOfAccount, nameOfBank);
		if(buildings[buildingPos].addOwnerToApartment(apartmentNumber,newOwner)==true){
			msj="Owner added sucefully to the apartment "+apartmentNumber+" in the building "+ buildingName;
		}
	return msj;
	}
	public String addTenantToApartment(String buildingName, int apartmentNumber, int selectiontypeId, String numberOfId, String name, String phoneNumber, int selectiontypePhone){
		String msj="";
		int buildingPos=searchBuildingByName(buildingName);
		Tenant newTenant = new Tenant(selectiontypeId, numberOfId, name, phoneNumber, selectiontypePhone);
		if(buildings[buildingPos].addTenantToApartment(apartmentNumber,newTenant)==true){
			msj="Tenant added sucefully to the apartment "+apartmentNumber+" in the building "+ buildingName;
		}
	return msj;
	}
}
