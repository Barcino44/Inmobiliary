package model;

public class Tenant extends Client{

	public Tenant(int selectiontypeId, String id, String name, String phoneNumber, int selectiontypePhone) {
		super(selectiontypeId, name, id, phoneNumber, selectiontypePhone);
	}
}