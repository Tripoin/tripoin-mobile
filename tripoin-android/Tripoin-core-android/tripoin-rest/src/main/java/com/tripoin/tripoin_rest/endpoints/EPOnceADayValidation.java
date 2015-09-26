package com.tripoin.tripoin_rest.endpoints;

import com.tripoin.tripoin_rest.dto.request.DTOOnceADayValidationRequest;
import com.tripoin.tripoin_rest.dto.response.DTOOnceADayValidation;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPOnceADayValidation {

    @POST("/validation/val001")
    void validateOnceADay(@Body DTOOnceADayValidationRequest dtoOnceADayValidationRequest, Callback<DTOOnceADayValidation> dtoOnceADayValidationCallback);
}
