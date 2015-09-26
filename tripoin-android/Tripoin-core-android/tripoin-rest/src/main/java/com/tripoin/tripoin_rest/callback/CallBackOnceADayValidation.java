package com.tripoin.tripoin_rest.callback;

import android.util.Log;

import com.tripoin.tripoin_rest.dto.response.DTOOnceADayValidation;
import com.tripoin.tripoin_rest.post.IPostOnceADayValidation;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created on 6/1/2015 : 4:11 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CallBackOnceADayValidation implements Callback<DTOOnceADayValidation> {

    private IPostOnceADayValidation iPostOnceADayValidation;

    public CallBackOnceADayValidation(IPostOnceADayValidation iPostOnceADayValidation) {
        this.iPostOnceADayValidation = iPostOnceADayValidation;
    }

    @Override
    public void success(DTOOnceADayValidation dtoOnceADayValidation, Response response) {
        iPostOnceADayValidation.onPostSuccessOnceADayValidation(dtoOnceADayValidation);
    }

    @Override
    public void failure(RetrofitError error) {
        iPostOnceADayValidation.onPostFailureOnceADayValidation(error);
    }
}
