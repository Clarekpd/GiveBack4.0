package com.example.giveback;

public class OrganizationRecord {
    private String acceptedCategories;
    private String orgNameOfficial;
    private String login;
    private String id;
    private String pickUpRegions;
    private String pickUpHours;
    private String contactInfo;
    private String orgDescription;
    private String acceptedItems;
    private String website;
    private String verification;
    private String advanceNoticeWindow;
    private String logo;



    public OrganizationRecord(String acceptedCategories, String orgNameOfficial, String login, String id, String pickUpRegions, String pickUpHours, String contactInfo, String orgDescription, String acceptedItems, String website, String verification, String advanceNoticeWindow, String logo){
        this.acceptedCategories = acceptedCategories;
        this.orgNameOfficial = orgNameOfficial;
        this.login = login;
        this.id = id;
        this.pickUpRegions = pickUpRegions;
        this.pickUpHours = pickUpHours;
        this.contactInfo = contactInfo;
        this.orgDescription = orgDescription;
        this.acceptedItems = acceptedItems;
        this.website = website;
        this.verification = verification;
        this.advanceNoticeWindow = advanceNoticeWindow;
        this.logo = logo;
    }

    public String getAcceptedCategories() { return acceptedCategories; }

    public void setAcceptedCategories(String acceptedCategories) { this.acceptedCategories = acceptedCategories; }

    public String getOrgNameOfficial() { return orgNameOfficial; }

    public void setOrgNameOfficial(String orgNameOfficial) { this.orgNameOfficial = orgNameOfficial; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPickUpRegions() { return pickUpRegions; }

    public void setPickUpRegions(String pickUpRegions) { this.pickUpRegions = pickUpRegions; }

    public String getPickUpHours() { return pickUpHours; }

    public void setPickUpHours(String pickUpHours) { this.pickUpHours = pickUpHours; }

    public String getContactInfo() { return contactInfo; }

    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getOrgDescription() { return orgDescription; }

    public void setOrgDescription(String orgDescription) { this.orgDescription = orgDescription; }

    public String getAcceptedItems() { return acceptedItems; }

    public void setAcceptedItems(String acceptedItems) { this.acceptedItems = acceptedItems; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public String getVerification() { return verification; }

    public void setVerification(String verification) { this.verification = verification; }

    public String getAdvanceNoticeWindow() { return advanceNoticeWindow; }

    public void setAdvanceNoticeWindow(String advanceNoticeWindow) { this.advanceNoticeWindow = advanceNoticeWindow; }

    public String getLogo() { return logo; }

    public void setLogo(String logo) { this.logo = logo; }

}
