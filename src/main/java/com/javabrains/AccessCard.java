package com.javabrains;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issuesDate;
    private boolean iActive;
    private String firmwareVersion;

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuesDate=" + issuesDate +
                ", iActive=" + iActive +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssuesDate() {
        return issuesDate;
    }

    public void setIssuesDate(Date issuesDate) {
        this.issuesDate = issuesDate;
    }

    public boolean isiActive() {
        return iActive;
    }

    public void setiActive(boolean iActive) {
        this.iActive = iActive;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
}
