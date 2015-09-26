package com.tripoin.tripoin_rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 9/26/2015 : 6:30 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOOnceADayValidationRequest extends DTOGetConfigs {
    @SerializedName("poi_code")
    private String poi_code;

    public String getPoi_code() {
        return poi_code;
    }

    public void setPoi_code(String poi_code) {
        this.poi_code = poi_code;
    }

    @Override
    public String toString() {
        return "OnceADayValidationDTO{" +
                "poi_code='" + poi_code + '\'' +
                '}';
    }
}
