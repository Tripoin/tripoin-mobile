package com.tripoin.tripoin_rest.engine;

import android.content.Context;

import org.parceler.Parcel;

/**
 * Created on 9/26/2015 : 11:08 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class RestParameter {

    private Context context;
    private String userName;
    private String password;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RestParameter{" +
                "context=" + context +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
