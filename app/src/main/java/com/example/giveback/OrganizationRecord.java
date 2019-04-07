package com.example.giveback;

public class OrganizationRecord {
    private String acceptedCategories;
    private String orgName;
    private String login;
    private String id;
    private String pickUpRegions;
    private String pickUpHours;
    private String contactInfo;
    private String orgDescription;
    private String acceptedItems;
    private String website;
    private boolean verification;
    private String advanceNoticeWindow;
    private String logo;

    public OrganizationRecord(String acceptedCategories, String orgName, String login, String id, String pickUpRegions, String pickUpHours, String contactInfo, String orgDescription, String acceptedItems, String website, boolean verification, String advanceNoticeWindow, String logo){
        this.category = category;
        this.orgName = orgName;
        this.donation = donationInfo;
        this.location = location;
        this.time = time;
        this.tag = tag;
        this.contactInfo = contactInfo;
        this.orgDescription = orgDescription;
        this.acceptedItems = acceptedItems;
        this.website = website;
        this.verification = verification;
        this.advanceNoticeWindow = advanceNoticeWindow;
        this.logo = logo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDonation() { return donation; }

    public void setDonation(String donation) { this.donation = donation; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getTag() { return tag; }

    public void setTag(String tag) { this.tag = tag; }

}
