package com.tripoin.tripoin_common.component;

/**
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITRIPOINComponent<PARAM> {

    public void setParameter(PARAM _param);

    public PARAM getParameter();
}


