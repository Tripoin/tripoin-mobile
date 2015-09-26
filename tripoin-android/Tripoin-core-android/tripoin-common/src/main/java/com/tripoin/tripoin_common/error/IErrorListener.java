package com.tripoin.tripoin_common.error;

/**
 * Created on 9/22/2015 : 4:27 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IErrorListener {

    /**
     *Listen through component when an error occurred
     */
    void onError(String errorMessage);
}
