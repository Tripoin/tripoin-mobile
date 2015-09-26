package com.tripoin.tripoin_rest.post;

import com.tripoin.tripoin_rest.dto.response.DTOOnceADayValidation;

import retrofit.RetrofitError;

/**
 * Created on 6/1/2015 : 4:11 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPostOnceADayValidation {

    void onPostSuccessOnceADayValidation(DTOOnceADayValidation dtoOnceADayValidation);

    void onPostFailureOnceADayValidation(RetrofitError retrofitError);

}
