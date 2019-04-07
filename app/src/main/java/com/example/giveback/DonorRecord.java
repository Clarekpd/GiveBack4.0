package com.example.giveback;

public class TransactionRecord {
    private String donorName;
    private String address;
    private String contactInfo;
    private String login;
    private String id;
    private int numberOfItems;


    public TransactionRecord(String donorName, String address, String contactInfo, String login, String id, int numberOfItems){
        this.donorName = donorName;
        this.orgName = address;
        this.contactInfo = contactInfo;
        this.login = login;
        this.id = id;
        this.numberOfItems = numberOfItems;
    }

    public String getDonorName() { return donorName; }

    public void setDonorName(String donorName) { this.donorName = donorName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getContactInfo() { return contactInfo; }

    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public int getNumberOfItems() { return numberOfItems; }

    public void setNumberOfItems(int numberOfItems) { this.numberOfItems = numberOfItems; }

}
