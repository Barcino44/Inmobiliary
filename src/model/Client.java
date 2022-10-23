package model;

public abstract class Client {
	private int selectiontypeId;
	private TypeId typeId;
	private String numberOfId;
	private String name;
	private String phoneNumber;
	private int selectiontypePhone;
	private TypePhone typePhone;

	public Client(int selectiontypeId, String numberOfId, String name, String phoneNumber, int selectiontypePhone){
		this.selectiontypeId = selectiontypeId;
		setTypeId();
		this.numberOfId=numberOfId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.selectiontypePhone = selectiontypePhone;
		setTypePhone();
	}

	public void setTypeId(){
		if(selectiontypeId==1){
			typeId=TypeId.TI;
		}
		else if(selectiontypeId==2){
			typeId=TypeId.CC;
		}
		else if(selectiontypeId==3){
			typeId=TypeId.FOREIGNERID;
		}
	}
	public String getNumberOfId(){
		return numberOfId;
	}
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setTypePhone(){
		if(selectiontypePhone==1){
			typePhone=TypePhone.HOME;
		}
		else if(selectiontypePhone==2){
			typePhone=TypePhone.OFFICE;
		}
		else if(selectiontypePhone==3){
			typePhone=TypePhone.MOVIL;
		}
		else if(selectiontypePhone==4){
			typePhone=TypePhone.FAMILY;
		}
		else if(selectiontypePhone==5){
			typePhone=TypePhone.OTHER;
		}
	}
} 