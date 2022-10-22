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
	public int validateIfBuildingExist(String buildingName){
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
	public String addApartmentToBuilding(String buildingName, int apartmentNumber, int numberOfBedrooms, int numberOfBathroooms, boolean hasBalcony, double mensualValue){
		String msj="";
		int posBuilding=validateIfBuildingExist(buildingName);
		Apartment newApartment= new Apartment(apartmentNumber, numberOfBedrooms, numberOfBathroooms, hasBalcony, mensualValue);
		msj=buildings[posBuilding].addApartmentWithObject(newApartment)+buildings[posBuilding].getName();
		return msj;
	}
	
}
