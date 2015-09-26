package com.tripoin.tripoin_dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tripoin.tripoin_common.constant.ApplicationConstant;
import com.tripoin.tripoin_model.ModelDynamicConfiguration;
import com.tripoin.tripoin_model.ModelUser;

/**
 * Created by Achmad Fauzi on 6/4/2015 : 9:58 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class DAOHelper extends OrmLiteSqliteOpenHelper{

    private Dao genericDAO;

    public DAOHelper(Context ctx) {
        super(ctx, ApplicationConstant.Database.DATABASE_NAME, null, ApplicationConstant.Database.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ModelUser.class);
            TableUtils.createTable(connectionSource, ModelDynamicConfiguration.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ModelUser.class, true);
            TableUtils.dropTable(connectionSource, ModelDynamicConfiguration.class, true);
            onCreate(database, connectionSource);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Dao getGenericDAO(Class DATA) {
        try{
            genericDAO = getDao(DATA);
        }catch (Exception e){
            e.printStackTrace();
        }
         return genericDAO;
    }


}
