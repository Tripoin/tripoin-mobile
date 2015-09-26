package com.tripoin.tripoin_dao.base;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.tripoin.tripoin_common.constant.ApplicationConstant;
import com.tripoin.tripoin_dao.DAOHelper;
import com.tripoin.tripoin_dao.IGenericDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 9/22/2015 : 7:39 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABaseGenericDAO<DATA> implements IGenericDAO<DATA> {

    private DAOHelper daoHelper;
    private Dao dao;

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    public ABaseGenericDAO(Context ctx) {
        daoHelper = new DAOHelper( ctx);
        if(dao == null){
            dao = getDaoHelper().getGenericDAO(getModelClass());
        }
    }


    @Override
    public int insertEntity(DATA entity) {
        int result = 0;
        try {
            result = dao.create((entity));
            Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Successful insert entity");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DATA> getAllData() {
        List<DATA> result = null;
        try {
            result = dao.queryForAll();
            Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Successful select all entity");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateEntity(DATA entity) {
        try {
            dao.update(entity);
            Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Successful update entity");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        try {
            dao.deleteById(id);
            Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Successful delete entity with id "+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeNativeCommand(String sqlCommand) {
        Log.d(ApplicationConstant.Log.TRIPOIN_INFO, sqlCommand);
        try{
            dao.executeRaw(sqlCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<DATA> getListDataFromQuery(String column, String value) {
        QueryBuilder<DATA, Integer> queryBuilder;
        PreparedQuery<DATA> preparedQuery;
        List<DATA> result = null;
        try {
            queryBuilder = dao.queryBuilder();
            queryBuilder.where().eq(column, value);
            preparedQuery = queryBuilder.prepare();
            result = dao.query(preparedQuery);
            Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Successful select where ? entity");
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
    public DATA getADataFromQuery(String column, String value) {
        DATA result = null;
        try{
            result = getListDataFromQuery(column, value).get(0);
            Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Successful select first data from entity");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
