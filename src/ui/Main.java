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
			"1.Add a building \n" +
			"2.Add an apartment\n"+
			"0.Exit program";  
	}
	// this method executes the option
	public void executeOption(int option){
			String msj="";
			String nameBuilding="";
			int numberOfApartmentsOfBuilding=0;
			String directionBuilding="";
			int apartmentNumber=0;
			int numberOfBedroomsOfApartment=0;
			int numberOfBathroomsOfApartment=0;
			boolean hasBalcony=false;
			String validationBoolean="Please write true or false";
			double mensualValue=0;
		switch(option){
				case 1: 
					if(inmobiliary.searchEmptyposBuilding()==-1){
						System.out.println("You can't add more buildings, you have reached the limited");
					}
					else{
						System.out.println("Enter building's name");
						nameBuilding=reader.next();

						System.out.println("Enter the number of apartments that the building has");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("The number of apartments has to be an integer");
						}
						numberOfApartmentsOfBuilding=reader.nextInt();

						System.out.println("Enter the direction of the building's direction");
						directionBuilding=reader.next();
						}
						msj=inmobiliary.addBuilding(nameBuilding,numberOfApartmentsOfBuilding, directionBuilding);
						System.out.println(msj);
					break;
					
				case 2:
					System.out.println("Enter building's name");
					nameBuilding=reader.next();
						if(inmobiliary.validateIfBuildingExist(nameBuilding)==-1){
							System.out.println("The building doen't exists");
						}
						else{
							System.out.println("Enter the number of apartment that you want to add");
							while(!reader.hasNextInt()){
								reader.next();
								System.out.println("The apartment number has to be an integer");
							}
							apartmentNumber=reader.nextInt();

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
								System.out.println("the input has to be an boolean");
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
							break;
						}


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