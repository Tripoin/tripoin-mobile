package com.tripoin.tripoin_model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tripoin.tripoin_common.constant.ApplicationConstant;
import com.tripoin.tripoin_common.constant.GeneralConstant;

/**
 * Created on 9/22/2015 : 5:10 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = ApplicationConstant.Database.TableTestConfiguration.TABLE_NAME)
public class ModelDynamicConfiguration {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID)
    private int id;

    /*### START GLOBAL CONFIG ###*/
    @DatabaseField(columnName = ApplicationConstant.Database.TableTestConfiguration.HOST)
    private String host;

    @DatabaseField(columnName = ApplicationConstant.Database.TableTestConfiguration.PORT)
    private int port;
    /*### END GLOBAL CONFIG ###*/

    /*### START SCHEDULER CONFIG ###*/
    @DatabaseField(columnName = ApplicationConstant.Database.TableTestConfiguration.SCHEDULER_INTERVAL)
    private int schedulerInterval;

    @DatabaseField(columnName = ApplicationConstant.Database.TableTestConfiguration.START_WORKING_HOUR)
    private int startWorkingHour;

    @DatabaseField(columnName = ApplicationConstant.Database.TableTestConfiguration.STOP_WORKING_HOUR)
    private int stopWorkingHour;
    /*### END SCHEDULER CONFIG ###*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getSchedulerInterval() {
        return schedulerInterval;
    }

    public void setSchedulerInterval(int schedulerInterval) {
        this.schedulerInterval = schedulerInterval;
    }

    public int getStartWorkingHour() {
        return startWorkingHour;
    }

    public void setStartWorkingHour(int startWorkingHour) {
        this.startWorkingHour = startWorkingHour;
    }

    public int getStopWorkingHour() {
        return stopWorkingHour;
    }

    public void setStopWorkingHour(int stopWorkingHour) {
        this.stopWorkingHour = stopWorkingHour;
    }

    public String getBasicUrl(){
        if(getHost() != null){
            return GeneralConstant.WebServiceCode.HTTP
                    .concat(GeneralConstant.Punctuation.COLON)
                    .concat(GeneralConstant.Punctuation.DOUBLE_SLASH)
                    .concat(getHost())
                    .concat(GeneralConstant.Punctuation.COLON)
                    .concat(String.valueOf(getPort()))
                    .concat(GeneralConstant.Punctuation.SLASH)
                    .concat("mforce-rest/ws/service/");
        }else{
            return GeneralConstant.Punctuation.EMPTY;
        }
    }

    @Override
    public String toString() {
        return "ModelDynamicConfiguration{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", schedulerInterval=" + schedulerInterval +
                ", startWorkingHour=" + startWorkingHour +
                ", stopWorkingHour=" + stopWorkingHour +
                '}';
    }
}
