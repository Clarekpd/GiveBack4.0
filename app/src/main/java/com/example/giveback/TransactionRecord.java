package com.example.giveback;

public class TransactionRecord {
    private String category;
    private String orgName;
    private String donation;
    private String location;
    private String time;
    private String tag;

    public TransactionRecord(String category, String orgName, String donationInfo, String location, String time, String tag){
        this.category = category;
        this.orgName = orgName;
        this.donation = donationInfo;
        this.location = location;
        this.time = time;
        this.tag = tag;
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
