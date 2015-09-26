package com.tripoin.tripoin_common.dto;

import org.parceler.Parcel;

/**
 * Created on 1/19/2015.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOPasswordValidMessenger{

    private String message;

    private boolean result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
