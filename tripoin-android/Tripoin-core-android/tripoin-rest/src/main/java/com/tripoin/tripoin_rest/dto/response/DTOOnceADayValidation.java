package com.tripoin.tripoin_rest.dto.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 9/26/2015 : 6:28 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOOnceADayValidation extends DTOBaseResponse{
    @SerializedName("validation_result")
    private Boolean validation_result;

    public Boolean getValidation_result() {
        return validation_result;
    }

    public void setValidation_result(Boolean validation_result) {
        this.validation_result = validation_result;
    }

    @Override
    public String toString() {
        return "DTOOnceADayValidation{" +
                "validation_result=" + validation_result +
                '}';
    }
}
