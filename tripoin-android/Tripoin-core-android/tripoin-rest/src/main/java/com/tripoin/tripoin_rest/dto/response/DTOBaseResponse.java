package com.tripoin.tripoin_rest.dto.response;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created on 9/26/2015 : 6:27 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOBaseResponse {

    @SerializedName("error_code")
    private String error_code;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DTOBaseResponse{" +
                "error_code='" + error_code + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
