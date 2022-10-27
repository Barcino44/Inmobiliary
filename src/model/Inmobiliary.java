package model;
public class Inmobiliary {

	public static final int BUILDING_SIZE = 5;

	private Building[] buildings; 

	public Inmobiliary(String nit) {
		buildings = new Building[BUILDING_SIZE];
		buildings[1]=new Building("Lantana","Calle20#68-72");
		buildings[2]=new Building("Pradera","Carrera15#87-14");
	}

	public String addBuilding(String name, String direction){
		String msj="";
		Building newBulding = new Building(name,direction);
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

	public boolean validateIftheApartmentHasAOwner(String buildingName, int apartmentNumber){
		int posBuilding=searchBuildingByName(buildingName);
		boolean ownerExist=buildings[posBuilding].validateIftheApartmentHasAOwner(apartmentNumber);
		return ownerExist;
	}

	public boolean validateIfTheApartmentHasATennant(String buildingName, int apartmentNumber){
		int posBuilding=searchBuildingByName(buildingName);
		boolean tenantExist=buildings[posBuilding].validateIfTheApartmentHasATennant(apartmentNumber);
		return tenantExist;
	}

	public String addOwnerToApartment(String buildingName, int apartmentNumber, int selectiontypeId, String numberOfId, String name, String phoneNumber, int selectiontypePhone, String numberOfAccount, String nameOfBank){
		String msj="";
		int buildingPos=searchBuildingByName(buildingName);
		Owner newOwner = new Owner(selectiontypeId, numberOfId, name, phoneNumber, selectiontypePhone, numberOfAccount, nameOfBank);
		if(buildings[buildingPos].addOwnerToApartment(apartmentNumber,newOwner)==true){
			msj="The owner " + name + " added sucefully to the apartment "+apartmentNumber+" in the building "+ buildingName;
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

	public String countEmptyApartmentsInBuilding(String buildingName){
		String msj="";
		int posBuilding=searchBuildingByName(buildingName);
		int counter=buildings[posBuilding].countEmptyApartments();
		msj="The quantity of empty apartments in the building "+ buildingName + " is " + counter;
		return msj;
	}
	public String calculateMensualGainOfBuilding(String buildingName){
		String msj="";
		int posBuilding=searchBuildingByName(buildingName);
		double totalPaying = buildings[posBuilding].calculateInmobiliaryGain();
		msj="The mensual value that the inmobiliary will recieve by the apartments of the building " + buildingName + " is " + totalPaying;
		return msj;
	}
	public String countApartmentsByOwnerName(String ownerName){
		int count=0;
		String msj="";
		for(int i=1; i<BUILDING_SIZE; i++){
			if(buildings[i]!=null){
				count=count+buildings[i].countApartmentsByOwner(ownerName);
				if(count==0){
					msj="The owner "+ ownerName+ " hasn't been registered yet";
				}
				else{
					msj="The quantity of apartments that the owner " + ownerName + " has are: " + count;
				}
			}
		}
	return msj;
	}
	public String calculateOwnerGain(String ownerName){
		String msj="";
		double totalOwnerGain=0;
		double inmobiliaryGain=0;
		for(int i=1; i<BUILDING_SIZE; i++){
			if(buildings[i]!=null){
				totalOwnerGain=totalOwnerGain+buildings[i].calculateOwnerGain(ownerName);
				if(totalOwnerGain!=0){
					msj="The total gain that the owner "+ownerName+ " will recieve by his/her apartments is " + totalOwnerGain*0.9+ "\n" +
						"The total gain of the inmobiliary will recieve for the administration of the apartments of the owner " +ownerName+ " is " + totalOwnerGain*0.1; 
				}
				else{
					msj="The owner "+ownerName+ " doesn't exist or his/her apartment(s) doesn't have any tenant";
				}
			}
		}
		return msj;
	}
}
