package com.tripoin.tripoin_dao.impl;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.tripoin.tripoin_dao.IGenericDAO;

import java.sql.SQLException;
import java.util.List;

import id.co.telkomsigma.arium.mforce.mqa.testing.persistence.DAO.DAOHelper;
import id.co.telkomsigma.arium.mforce.mqa.testing.persistence.IBaseDBHandler;
import id.co.telkomsigma.arium.mforce.mqa.testing.persistence.model.ModelUser;


/**
 * Created on 5/27/2015 : 4:24 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOUser implements IGenericDAO {

    static private TBManagerUser instance;

    static public void init( Context ctx ){
        if( instance == null ){
            instance = new TBManagerUser( ctx );
        }
    }

    static public TBManagerUser getInstance(){
        return instance;
    }

    private DAOHelper daoHelper;

    public DAOUser(Context ctx) {
        daoHelper = new DAOHelper( ctx);
    }

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    @Override
    public int insertEntity(Object entity) {
        int result = 0;
        try {
            result = getDaoHelper().getDaoUser().create((ModelUser) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelUser> getAllData() {
        List<ModelUser> result = null;
        try {
            result = (List<ModelUser>) getDaoHelper().getDaoUser().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateEntity(Object entity) {
        try {
            getDaoHelper().getDaoUser().update((ModelUser) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        try {
            getDaoHelper().getDaoUser().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeNativeCommand(String sqlCommand) {
        Log.d("QUERY", sqlCommand);
        try{
            getDaoHelper().getDaoUser().executeRaw(sqlCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelUser> getListDataFromQuery(String column, String value) {
        QueryBuilder<ModelUser, Integer> queryBuilder = null;
        PreparedQuery<ModelUser> preparedQuery = null;
        List<ModelUser> result = null;
        try {
            queryBuilder = getDaoHelper().getDaoUser().queryBuilder();
            queryBuilder.where().eq(column,value);
            preparedQuery = queryBuilder.prepare();
            result = (List<ModelUser>) getDaoHelper().getDaoUser().query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result != null) {
            if(result.size() == 0)
                return null;
        }
        return result;
    }

    @Override
    public Object getADataFromQuery(String column, String value) {
        return getListDataFromQuery(column, value).get(0);
    }
}
