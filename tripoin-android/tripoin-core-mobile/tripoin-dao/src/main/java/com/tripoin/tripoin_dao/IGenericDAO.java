package com.tripoin.tripoin_dao;

import java.util.List;

/**
 * Created on 5/27/2015 : 12:00 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <DATA>
 */
public interface IGenericDAO<DATA> {

    /**
     * This function will add one entity which is 1 complete row in table
     * @param entity DATA
     */
    public int insertEntity(DATA entity);

    /**
     * This function will return all data from a table in an array list form
     * @return List<DATA>
     */
    public List<DATA> getAllData();

    /**
     * This function will update value from an entity
     * @param entity DATA
     */
    public void updateEntity(DATA entity);

    /**
     * This function will delete entity in table
     * @param id Integer
     */
    public void deleteEntity(Integer id);

    /**
     * This function will execute mqaclient sql command
     * @param sqlCommand
     */
    public void executeNativeCommand(String sqlCommand);

    /**
     * This function will select one row from table with one condition only
     * @param column
     * @param value
     * @param <DATA>
     * @return <DATA>
     */
    public <DATA>Object getADataFromQuery(String column, String value);

    /**
     * This function will select list rows from table with one condition only
     * @param column
     * @param value
     * @return List<DATA>
     */
    public List<DATA> getListDataFromQuery(String column, String value);

}
