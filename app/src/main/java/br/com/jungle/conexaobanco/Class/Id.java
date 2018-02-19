package br.com.jungle.conexaobanco.Class;

import com.google.gson.annotations.SerializedName;

/**
 * Created by neviton on 15/02/2018.
 */

public class Id {
    @SerializedName("$oid")
    private String oid;





    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
