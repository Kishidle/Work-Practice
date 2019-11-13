/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.Model;

/**
 *
 * @author ramon
 */
public class Remark {
    
    private int remarkID;
    private String remark;
    private int patronID;
    private String remarkBy;
    private String collectAgent;
    private String remarkDate;

    public int getRemarkID() {
        return remarkID;
    }

    public void setRemarkID(int remarkID) {
        this.remarkID = remarkID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPatronID() {
        return patronID;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public String getRemarkBy() {
        return remarkBy;
    }

    public void setRemarkBy(String remarkBy) {
        this.remarkBy = remarkBy;
    }

    public String getCollectAgent() {
        return collectAgent;
    }

    public void setCollectAgent(String collectAgent) {
        this.collectAgent = collectAgent;
    }

    public String getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(String remarkDate) {
        this.remarkDate = remarkDate;
    }
    
    
}
