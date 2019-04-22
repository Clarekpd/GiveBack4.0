package com.example.giveback;

public class SearchRecord {
    private String NameofOrg;
    private String Website;
    private String Location;
    private String OrgName;
    private String FilteredOrgData;
    private String ProgramList;

    public SearchRecord(String nameofOrg, String website, String location, String orgName, String filteredOrgData, String programList) {
        NameofOrg = nameofOrg;
        Website = website;
        Location = location;
        OrgName = orgName;
        FilteredOrgData = filteredOrgData;
        ProgramList = programList;
    }

    public String getNameofOrg() { return NameofOrg; }

    public void setNameofOrg(String nameofOrg) { NameofOrg = nameofOrg; }

    public String getWebsite() { return Website; }

    public void setWebsite(String website) { Website = website; }

    public String getLocation() { return Location; }

    public void setLocation(String location) { Location = location; }

    public String getOrgName() { return OrgName; }

    public void setOrgName(String orgName) { OrgName = orgName; }

    public String getFilteredOrgData() { return FilteredOrgData; }

    public void setFilteredOrgData(String filteredOrgData) { FilteredOrgData = filteredOrgData; }

    public String getProgramList() { return ProgramList; }

    public void setProgramList(String programList) { ProgramList = programList; }

}