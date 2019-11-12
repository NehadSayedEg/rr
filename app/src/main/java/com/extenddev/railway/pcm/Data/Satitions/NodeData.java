package com.extenddev.railway.pcm.Data.Satitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NodeData {
    @SerializedName("TimeZoneList")
    @Expose
    private List< TimeZoneList > timeZoneList ;

    @SerializedName("NodeList")
    @Expose
    private List< NodeList > nodeList ;

    @SerializedName("LocNodeList")
    @Expose
    private List<LocNodeList> locNodeList ;

    public NodeData(List< TimeZoneList > timeZoneList, List< NodeList > nodeList, List< LocNodeList > locNodeList) {
        this.timeZoneList = timeZoneList;
        this.nodeList = nodeList;
        this.locNodeList = locNodeList;
    }

    public List< TimeZoneList > getTimeZoneList() {
        return timeZoneList;
    }

    public void setTimeZoneList(List< TimeZoneList > timeZoneList) {
        this.timeZoneList = timeZoneList;
    }

    public List< NodeList > getNodeList() {
        return nodeList;
    }

    public void setNodeList(List< NodeList > nodeList) {
        this.nodeList = nodeList;
    }

    public List< LocNodeList > getLocNodeList() {
        return locNodeList;
    }

    public void setLocNodeList(List< LocNodeList > locNodeList) {
        this.locNodeList = locNodeList;
    }
}
