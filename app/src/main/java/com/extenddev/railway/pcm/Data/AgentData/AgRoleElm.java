package com.extenddev.railway.pcm.Data.AgentData;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgRoleElm {
    @SerializedName("id")
    @Expose
    private Integer id;


    @SerializedName("AgRoleElmID")
    @Expose
    private Integer agRoleElmID;

    private String RoleName;

    public AgRoleElm(Integer id, Integer agRoleElmID, String roleName) {
        this.id = id;
        this.agRoleElmID = agRoleElmID;
        RoleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgRoleElmID() {
        return agRoleElmID;
    }

    public void setAgRoleElmID(Integer agRoleElmID) {
        this.agRoleElmID = agRoleElmID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
