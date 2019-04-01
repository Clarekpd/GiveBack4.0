package com.example.giveback;

public class TransactionRecord {
    private String category;
    private String orgName;

    public TransactionRecord(String category, String orgName){
        this.category = category;
        this.orgName = orgName;
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
}
