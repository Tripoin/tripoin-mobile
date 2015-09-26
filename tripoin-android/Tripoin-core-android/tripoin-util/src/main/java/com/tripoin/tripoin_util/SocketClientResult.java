package com.tripoin.tripoin_util;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Achmad Fauzi on 6/11/2015 : 3:13 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SocketClientResult implements Parcelable {

    private String startDate;
    private String endDate;
    private Long result;

    public SocketClientResult() {
    }

    public SocketClientResult(Parcel in) {
        readFromParcel(in);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SocketClientResult{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", result=" + result +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(startDate);
        dest.writeString(endDate);
        dest.writeLong(result);
    }

    private void readFromParcel(Parcel in) {
        startDate = in.readString();
        endDate = in.readString();
        result = in.readLong();
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new SocketClientResult(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new SocketClientResult[size];
        }
    };
}
