package com.tripoin.tripoin_dao.impl;

import com.j256.ormlite.dao.Dao;
import com.tripoin.tripoin_dao.DAOHelper;
import com.tripoin.tripoin_dao.IGenericDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 9/22/2015 : 7:39 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ABaseGenericDAO<A_DAO extends Dao<DATA, Id>> implements IGenericDAO<DATA> {

    private DAOHelper daoHelper;
    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    @Override
    public int insertEntity(DATA entity) {
        int result = 0;
        try {
            result = getDaoHelper().getDaoUser().create((DATA) entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DATA> getAllData() {
        return null;
    }

    @Override
    public void updateEntity(DATA entity) {

    }

    @Override
    public void deleteEntity(Integer id) {

    }

    @Override
    public void executeNativeCommand(String sqlCommand) {

    }

    @Override
    public <DATA1> Object getADataFromQuery(String column, String value) {
        return null;
    }

    @Override
    public List<DATA> getListDataFromQuery(String column, String value) {
        return null;
    }
}
