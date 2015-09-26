package com.tripoin.tripoin_rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 9/26/2015 : 6:30 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOGetConfigs {
    @SerializedName("user_code")
    private String user_code;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    @Override
    public String toString() {
        return "DTOGetConfigs{" +
                "user_code='" + user_code + '\'' +
                '}';
    }
}
