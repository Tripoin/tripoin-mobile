package com.tripoin.tripoin_model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tripoin.tripoin_common.constant.ApplicationConstant;

/**
 * Created by Achmad Fauzi on 6/4/2015 : 9:59 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = ApplicationConstant.Database.TableUser.TABLE_NAME)
public class ModelUser{

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID, unique = true)
    private int id;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.USER_NAME)
    private String userName;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.LOGIN_STATUS)
    private int loginStatus;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.IS_ACTIVE)
    private int isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getIsActive() {
        return isActive;
    }

    /**
     * 1 active
     * 0 / null is not active
     * @param isActive int
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ModelUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginStatus=" + loginStatus +
                ", isActive=" + isActive +
                '}';
    }
}
