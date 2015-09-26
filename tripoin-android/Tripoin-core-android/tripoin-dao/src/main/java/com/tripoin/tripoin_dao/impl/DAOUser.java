package com.tripoin.tripoin_dao.impl;

import android.content.Context;

import com.tripoin.tripoin_dao.base.ABaseGenericDAO;
import com.tripoin.tripoin_model.ModelUser;

/**
 * Created on 5/27/2015 : 4:24 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class DAOUser extends ABaseGenericDAO {

    public DAOUser(Context ctx) {
        super(ctx);
    }

    @Override
    public Class getModelClass() {
        return ModelUser.class;
    }
}
