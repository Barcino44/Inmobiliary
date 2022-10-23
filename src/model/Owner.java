package model;

public class Owner extends Client{

	private String numberOfAccount;
	private String nameOfBank;

	public Owner(int selectiontypeId, String id, String name, String phoneNumber, int selectiontypePhone, String numberOfAccount, String nameOfBank) {
		super(selectiontypeId, name, id, phoneNumber, selectiontypePhone);
		this.numberOfAccount = numberOfAccount;
		this.nameOfBank=nameOfBank; 
	}

	public String getNumberOfAccount(){
		return numberOfAccount;
	}

	public void setNumberOfAccount(String numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public String getNameOfBank(){
		return nameOfBank;
	}

	public void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}

}
