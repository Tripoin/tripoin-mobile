package com.tripoin.tripoin_component.ui.fragment;

import android.support.v4.app.Fragment;

import com.tripoin.tripoin_component.ui.activity.INavigation;

/**
 * Created by Achmad Fauzi on 5/7/2015 : 4:55 PM.
 * mailto : achmad.fauzi@sigma.co.id
 */
public interface INavigationFragment extends INavigation {

    public void gotoNextFragment(int containerId, Fragment fragmentView);

    public void gotoPreviousFragment(int containerId, Fragment fragmentView);

}
