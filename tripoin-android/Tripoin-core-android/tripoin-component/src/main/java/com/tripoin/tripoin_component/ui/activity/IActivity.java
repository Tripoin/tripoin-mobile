package com.tripoin.tripoin_component.ui.activity;

/**
 * Created by Achmad Fauzi on 11/19/2014.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 *
 * This interface is used as common functions for Activity
 */
public interface IActivity extends INavigationActivity {

    /**
     * This method is used to initiate current active activity's widgets
     */
    public void initWidget();

    /**
     * This method is used to setup TypeFace for widgets within current active Activity
     */
    public void setupTypeFace();

    /**
     * This method used to get view id that will be set into activity
     * @return int
     */
    public int getViewLayoutId();

    /**
     * Font assets initiation
     * 1 : TextView
     * 2 : EditText
     * 3 : Button
     * @return String[]
     */
    public String[] initFontAssets();
}
