package com.example.giveback;

public class OrganizationRecord {
    private String acceptedCategories;
    private String orgNameOfficial;
    private String loginOrg;
    private String idOrg;
    private String pickUpRegions;
    private String pickUpHours;
    private String contactInfoOrg;
    private String orgDescription;
    private String acceptedItems;
    private String website;
    private boolean verification;
    private String advanceNoticeWindow;
    private String logo;



    public OrganizationRecord(String acceptedCategories, String orgNameOfficial, String loginOrg, String idOrg, String pickUpRegions, String pickUpHours, String contactInfoOrg, String orgDescription, String acceptedItems, String website, boolean verification, String advanceNoticeWindow, String logo){
        this.acceptedCategories = acceptedCategories;
        this.orgNameOfficial = orgNameOfficial;
        this.loginOrg = loginOrg;
        this.idOrg = idOrg;
        this.pickUpRegions = pickUpRegions;
        this.pickUpHours = pickUpHours;
        this.contactInfoOrg = contactInfoOrg;
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

    public String getLoginOrg() { return loginOrg; }

    public void setLoginOrg(String loginOrg) { this.loginOrg = loginOrg; }

    public String getIdOrg() { return idOrg; }

    public void setIdOrg(String idOrg) { this.idOrg = idOrg; }

    public String getPickUpRegions() { return pickUpRegions; }

    public void setPickUpRegions(String pickUpRegions) { this.pickUpRegions = pickUpRegions; }

    public String getPickUpHours() { return pickUpHours; }

    public void setPickUpHours(String pickUpHours) { this.pickUpHours = pickUpHours; }

    public String getContactInfoOrg() { return contactInfoOrg; }

    public void setContactInfoOrg(String contactInfoOrg) { this.contactInfoOrg = contactInfoOrg; }

    public String getOrgDescription() { return orgDescription; }

    public void setOrgDescription(String orgDescription) { this.orgDescription = orgDescription; }

    public String getAcceptedItems() { return acceptedItems; }

    public void setAcceptedItems(String acceptedItems) { this.acceptedItems = acceptedItems; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public boolean getVerification() { return verification; }

    public void setVerification(boolean verification) { this.verification = verification; }

    public String getAdvanceNoticeWindow() { return advanceNoticeWindow; }

    public void setAdvanceNoticeWindow(String advanceNoticeWindow) { this.advanceNoticeWindow = advanceNoticeWindow; }

    public String getLogo() { return logo; }

    public void setLogo(String logo) { this.logo = logo; }

}
