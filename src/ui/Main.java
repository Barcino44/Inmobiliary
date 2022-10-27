package ui; 

import java.util.Scanner; 
import model.*; 

public class Main{
	
	private Scanner reader; 

	private Inmobiliary inmobiliary; 

	public Main(){
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.initInmobiliary();

		int option = -1; 
		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

	}


	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(printMenu());

		option = validateIntegerOption(); 

		return option; 
	}

	public String printMenu(){
		return 
			"<<-<< <<-<< Welcome >>->> >>->>\n" +
			"1. Add a building \n" +
			"2. Add an apartment\n"+
			"3. Add an owner in a apartment\n" +
			"4. Add a tenant in a apartment\n" +
			"5. Show available apartments in a building\n" +
			"6. Calculate mensual payment in a building\n" +
			"7. Search if an apartment is available\n" +
			"8. Search the quantity of apartments rented by an owner\n" +
			"9. Calculate the gain of an owner by his/her apartments rented and the gain of the inmobiliary by administrate that apartments\n"+
			"0. Exit program";  
	}
	// this method executes the option
	public void executeOption(int option){
			String msj="";
			String nameBuilding="";
			String directionBuilding="";
			int apartmentNumber=0;
			int numberOfBedroomsOfApartment=0;
			int numberOfBathroomsOfApartment=0;
			boolean hasBalcony=false;
			String validationBoolean="Please write true or false";
			double mensualValue=0;
			int ownerSelectionTypeId=0;
			String validationTypeId="Enter the number that corresponds the owner's type of id\n"+
									"1. TI\n"+
									"2. CC\n"+
									"3. FOREIGNERID";
			String ownerId="";
			String ownerName="";
			String ownerPhoneNumber="";
			int ownerSelectionTypePhone=0;
			String validationTypePhone="Enter the number that corresponds the owner's type of phone\n"+
									     "1. HOME\n"+
									     "2. OFFICE\n"+
									     "3. MOVIL\n"+
									     "4. FAMILY\n"+
									     "5. OTHER";
			String ownerNumberOfAccount="";
			String ownerNameOfBank="";
			int tenantSelectionTypeId=0;
			String tenantId="";
			String tenantName="";
			String tenantPhoneNumber="";
			int tenantSelectionTypePhone=0;


		switch(option){
				case 1: 
					if(inmobiliary.searchEmptyposBuilding()==-1){
						System.out.println("You can't add more buildings, you have reached the limited");
					}
					else{
						System.out.println("Enter building's name");
						nameBuilding=reader.next();
						if(inmobiliary.searchBuildingByName(nameBuilding)!=-1){
							System.out.println("The building already exists");
						}
						else{
						System.out.println("Enter the direction of the building's direction");
						directionBuilding=reader.next();

						msj=inmobiliary.addBuilding(nameBuilding, directionBuilding);
						System.out.println(msj);
						}
					}
					break;
					
				case 2:
					System.out.println("Enter building's name where is going to be add the apartment");
					nameBuilding=reader.next();
						if(inmobiliary.searchBuildingByName(nameBuilding)==-1){
							System.out.println("The building doesn't exists");
						}
						else{
							System.out.println("Enter the number of apartment that you want to add");
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("The apartment number has to be an integer");
							}
							apartmentNumber=reader.nextInt();
							if(inmobiliary.validateIfApartmentNoExist(nameBuilding, apartmentNumber)!=true){
								System.out.println("The apartment already exists");
							}
							else{
								System.out.println("Enter the number of bedrooms that the apartment has");
								while(!reader.hasNextInt()){
									reader.next();
									System.out.println("The number of bedrooms has to be an integer");
								}
								numberOfBedroomsOfApartment=reader.nextInt();

								System.out.println("Enter the number of bathrooms that the apartment has");
								while(!reader.hasNextInt()){
									reader.next();
									System.out.println("The number of bathrooms has to be an integer");
								}
								numberOfBathroomsOfApartment=reader.nextInt();

								System.out.println("The apartment has Balcony?\n"+
												   validationBoolean);
								while(!reader.hasNextBoolean()){
									reader.next();
									System.out.println("The input has to be an boolean");
									System.out.println(validationBoolean);
								}
								hasBalcony=reader.hasNextBoolean(); reader.next();

								System.out.println("What is the mensual value of the apartment");
								while(!reader.hasNextDouble()){
									reader.next();
									System.out.println("The value has to be a double");
								}
								mensualValue=reader.nextInt();

								msj=inmobiliary.addApartmentToBuilding(nameBuilding, apartmentNumber, numberOfBedroomsOfApartment, numberOfBathroomsOfApartment, hasBalcony, mensualValue);
								System.out.println(msj);	
							}
						}
					break;
				case 3:
					System.out.println("Enter building's name where you want to add the owner");
					nameBuilding=reader.next();
					if(inmobiliary.searchBuildingByName(nameBuilding)==-1){
						System.out.println("The building doesn't exists");
						}
					else if(inmobiliary.searchBuildingByName(nameBuilding)!=-1){
						System.out.println("Enter the number of apartment where you want to add the owner");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("The apartment number has to be an integer");
						}
						apartmentNumber=reader.nextInt();
						if(inmobiliary.validateIfApartmentNoExist(nameBuilding,apartmentNumber)==true){
							System.out.println("The apartment doesn't exists");
						}
						else if(inmobiliary.validateIftheApartmentHasAOwner(nameBuilding, apartmentNumber)==true){
							System.out.println("The apartment has already an owner");
						}
						else{
							System.out.println(validationTypeId);
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("Invalid, please enter an integer");
								System.out.println(validationTypeId);
							}
							ownerSelectionTypeId=reader.nextInt();

							while(ownerSelectionTypeId!=1&&ownerSelectionTypeId!=2&&ownerSelectionTypeId!=3){
								System.out.println("That's not a type of id");
								System.out.println(validationTypeId);
								ownerSelectionTypeId=reader.nextInt();
							}

							System.out.println("Type the owner's number of id");
							ownerId=reader.next();
							System.out.println("Type the owner's name");
							ownerName=reader.next();
							System.out.println("Type the owner's phone");
							ownerPhoneNumber=reader.next();

							System.out.println(validationTypePhone);
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("Invalid, please enter an integer");
								System.out.println(validationTypePhone);
							}
							ownerSelectionTypePhone=reader.nextInt();

							while(ownerSelectionTypePhone!=1&&ownerSelectionTypePhone!=2&&ownerSelectionTypePhone!=3&&ownerSelectionTypePhone!=4&&ownerSelectionTypePhone!=5){
								System.out.println("That's not a type of phone");
								System.out.println(validationTypePhone);
								ownerSelectionTypePhone=reader.nextInt();
							}
							System.out.println("Type the owner's number of account");
							ownerNumberOfAccount=reader.next();
							System.out.println("Type the owner's name of bank");
							ownerNameOfBank=reader.next();

							msj=inmobiliary.addOwnerToApartment(nameBuilding, apartmentNumber, ownerSelectionTypeId, ownerId, ownerName, ownerPhoneNumber, ownerSelectionTypePhone, ownerNumberOfAccount, ownerNameOfBank);
							System.out.println(msj);
						}
					}
					break;
				case 4: 
					System.out.println("Enter building's name where you want to add the tenant");
					nameBuilding=reader.next();
						if(inmobiliary.searchBuildingByName(nameBuilding)==-1){
							System.out.println("The building doesn't exists");
						}
						else if(inmobiliary.searchBuildingByName(nameBuilding)!=-1){
						System.out.println("Enter the number of apartment where you want to add the tenant");
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("The apartment number has to be an integer");
							}
							apartmentNumber=reader.nextInt();
							if(inmobiliary.validateIfApartmentNoExist(nameBuilding,apartmentNumber)==true){
								System.out.println("The apartment doesn't exists");
							}
							else if(inmobiliary.validateIftheApartmentHasAOwner(nameBuilding, apartmentNumber)==false){
								System.out.println("Before to add a tenant you have to add the owner");
							}
							else if(inmobiliary.validateIfTheApartmentHasATennant(nameBuilding, apartmentNumber)==true){
								System.out.println("The apartment has already a tenant");
							}
							else{
								System.out.println(validationTypeId);
								while(!reader.hasNextInt()){
									reader.next();
									System.out.println("Invalid, please enter an integer");
									System.out.println(validationTypeId);
								}
								tenantSelectionTypeId=reader.nextInt();

								while(tenantSelectionTypeId!=1&&tenantSelectionTypeId!=2&&tenantSelectionTypeId!=3){
									System.out.println("That's not a type of id");
									System.out.println(validationTypeId);
									tenantSelectionTypeId=reader.nextInt();
								}

								System.out.println("Type the tenant's number of id");
								tenantId=reader.next();
								System.out.println("Type the tenant's name");
								tenantName=reader.next();
								System.out.println("Type the tenant's phone");
								tenantPhoneNumber=reader.next();

								System.out.println(validationTypePhone);
								while(!reader.hasNextInt()){
									reader.next();
									System.out.println("Invalid, please enter an integer");
									System.out.println(validationTypePhone);
								}
								tenantSelectionTypePhone=reader.nextInt();

								while(tenantSelectionTypePhone!=1&&tenantSelectionTypePhone!=2&&tenantSelectionTypePhone!=3&&tenantSelectionTypePhone!=4&&tenantSelectionTypePhone!=5){
									System.out.println("That's not a type of phone");
									System.out.println(validationTypePhone);
									tenantSelectionTypePhone=reader.nextInt();
								}
								msj=inmobiliary.addTenantToApartment(nameBuilding, apartmentNumber, tenantSelectionTypeId, tenantId, tenantName, tenantPhoneNumber, tenantSelectionTypePhone);
								System.out.println(msj);
							}
						}
					break;
				case 5: 
					System.out.println("All the buildings has 10 available apartments, the number will be decreising every time that a apartment be rented");
					System.out.println("Enter building's name");
					nameBuilding=reader.next();
						if(inmobiliary.searchBuildingByName(nameBuilding)==-1){
						System.out.println("The building doesn't exists");
					}
					else{
						msj=inmobiliary.countEmptyApartmentsInBuilding(nameBuilding);
						System.out.println(msj);
					}
					break;
				case 6:
					System.out.println("Aclaration!!!");
					System.out.println("If no one has rented an apartment, the mensual value of the building will be 0.0\n");
					System.out.println("Enter building's name");
					nameBuilding=reader.next();
					if(inmobiliary.searchBuildingByName(nameBuilding)==-1){
						System.out.println("The building doesn't exists");
					}
					else{
						msj=inmobiliary.calculateMensualGainOfBuilding(nameBuilding);
						System.out.println(msj);
					}
					break;
				case 7:
					System.out.println("Remember an apartment just will be available if it has an owner and it doesn't have a tenant\n");
					System.out.println("Type the building where you want to search the apartment");
					nameBuilding=reader.next();
						if(inmobiliary.searchBuildingByName(nameBuilding)==-1){
							System.out.println("The building doesn't exists");
						}
						else if(inmobiliary.searchBuildingByName(nameBuilding)!=-1){
						System.out.println("Enter the number of apartment which you want to validate if it is available");
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("The apartment number has to be an integer");
							}
							apartmentNumber=reader.nextInt();
							if(inmobiliary.validateIfApartmentNoExist(nameBuilding,apartmentNumber)==true){
								System.out.println("The apartment doesn't exist");
							}
							else{
								if(inmobiliary.validateIfTheApartmentHasATennant(nameBuilding,apartmentNumber)==false&&inmobiliary.validateIftheApartmentHasAOwner(nameBuilding, apartmentNumber)==true){
									System.out.println("The apartment is available");
								}
								else{
									System.out.println("The apartment is not available");
								}
							}
						}
					break;
				case 8:
				 	System.out.println("Enter the owner's name to search the information");
				 	ownerName=reader.next();
				 	msj=inmobiliary.countApartmentsByOwnerName(ownerName);
				 	System.out.println(msj);
				 	break;
				case 9:
					System.out.println("Enter the owner's name to search the information");
				 	ownerName=reader.next();
				 	msj=inmobiliary.calculateOwnerGain(ownerName);
				 	System.out.println(msj);
				 	break;
				case 0: 
					System.out.println("Exit program.");
					break; 

				default: 
					System.out.println("Invalid Option");
					break; 		

		}
	}
	public void initInmobiliary(){
		System.out.println("Welcome to the inmobiliary enter your name");
		String name = reader.nextLine(); 
		this.inmobiliary = new Inmobiliary(name);

	}

	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

}