package com.example.giveback;

import java.util.List;

public class OrganizationHolderFile {
        private List<OrganizationRecord> orgData;

        public List<OrganizationRecord> filteredOrgData;
        public List<OrganizationRecord> getOrgData() {
            return orgData;
        }
        public List<OrganizationRecord> getFilteredOrgData() {
            if (filteredOrgData == null){
                return orgData;
            }

            return filteredOrgData;
        }

        public void setOrgData(List<OrganizationRecord> orgData) {
            this.orgData = orgData;
        }
        public void setFilteredOrgData(List<OrganizationRecord> filteredOrgData) {this.filteredOrgData = filteredOrgData;}
        private static final OrganizationHolderFile holder=new OrganizationHolderFile ();
        public static OrganizationHolderFile getInstance(){return holder;}
        public void resetFilteredOrgData(){
            this.filteredOrgData = orgData;
        }
    }
