package com.example.giveback;

public class DonorRecord {
    private String donorName;
    private String address;
    private String contactInfoDonor;
    private String loginDonor;
    private String idDonor;
    private int numberOfItems;


    public DonorRecord(String donorName, String address, String contactInfoDonor, String loginDonor, String idDonor, int numberOfItems){
        this.donorName = donorName;
        this.address = address;
        this.contactInfoDonor = contactInfoDonor;
        this.loginDonor = loginDonor;
        this.idDonor = idDonor;
        this.numberOfItems = numberOfItems;
    }

    public String getDonorName() { return donorName; }

    public void setDonorName(String donorName) { this.donorName = donorName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getContactInfoDonor() { return contactInfoDonor; }

    public void setContactInfoDonor(String contactInfoDonor) { this.contactInfoDonor = contactInfoDonor; }

    public String getLoginDonor() { return loginDonor; }

    public void setLoginDonor(String loginDonor) { this.loginDonor = loginDonor; }

    public String getIdDonor() { return idDonor; }

    public void setIdDonor(String idDonor) { this.idDonor = idDonor; }

    public int getNumberOfItems() { return numberOfItems; }

    public void setNumberOfItems(int numberOfItems) { this.numberOfItems = numberOfItems; }

}
