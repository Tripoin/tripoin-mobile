package com.tripoin.tripoin_component.ui.fragment.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tripoin.tripoin_component.ComponentConstant;
import com.tripoin.tripoin_component.ui.fragment.INavigationDrawerFragment;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Achmad Fauzi on 4/25/2015 : 11:20 PM.
 * mailto : fauzi.knightmaster.achmad@gmail.com
 */
public abstract class ANavigationDrawerFragment extends Fragment implements INavigationDrawerFragment {

    protected Typeface typeface;
    protected List<TextView> textViews;
    protected List<Button> buttons;
    protected List<EditText> editTexts;
    protected View rootView = null;

    protected ANavigationDrawerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{
            rootView = inflater.inflate( getViewLayoutId(), container, false );
        }catch ( Exception e ){
            if ( container != null ){
                container.removeView( rootView );
            }
            try{
                rootView = inflater.inflate(getViewLayoutId(), container, false);
            }catch (InflateException ie){
                e.printStackTrace();
            }
        }
        getActivity().setTitle(getFragmentTitle());
        ButterKnife.inject(this, rootView);

        initializeFragment();

        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        onLowMemory();
    }

    private void initializeFragment(){
        try{
            initWidget();
        }catch ( Exception e ){
            Toast.makeText(getActivity(), "Application error initializing Fragment".concat(e.toString()), Toast.LENGTH_SHORT).show();
        }

        try {
            typeface = Typeface.createFromAsset(getActivity().getAssets(), initAssetName()[0]);
            if( getTextViews() != null )
                assignContentTypeFace( getTextViews() );

            typeface = Typeface.createFromAsset(getActivity().getAssets(), initAssetName()[1]);
            if( getEditTexts() != null )
                assignEditTextTypeFace(getEditTexts());

            typeface = Typeface.createFromAsset(getActivity().getAssets(), initAssetName()[2]);
            if( getButtons() != null )
                assignButtonTypeFace( getButtons() );
        }catch (Exception e){
            Log.w("Fragment Warning", "No TypeFace Assignment found");
        }

        //release unused objects
        textViews = null;
        editTexts = null;
        buttons = null;
    }

    private void assignEditTextTypeFace(List<EditText> editTexts){
        for(EditText editText: editTexts){
            editText.setTypeface(typeface);
        }
    }

    private void assignContentTypeFace( List<TextView> textViews ){
        for ( TextView tv: textViews ){
            tv.setTypeface(typeface);
        }
    }

    private void assignButtonTypeFace( List<Button> buttons ){
        for ( Button button : buttons ){
            button.setTypeface(typeface);
        }
    }
    /**
     * Initiate asset names ( font ) which will be used in that activity or Fragment
     * @return String[]
     */
    public String[] initAssetName() {
        return new String[]{
                ComponentConstant.fonts.ROBOT_LIGHT,
                ComponentConstant.fonts.ROBOT_LIGHT_ITALIC,
                ComponentConstant.fonts.ROBOT_BOLD
        };
    }

    @Override
    public List<TextView> getTextViews() {
        return null;
    }

    @Override
    public List<EditText> getEditTexts() {
        return null;
    }

    @Override
    public List<Button> getButtons() {
        return null;
    }

    @Override
    public void gotoNextFragment(int containerId, Fragment fragmentView){
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(containerId, fragmentView).commit();
    }

    @Override
    public void gotoPreviousFragment(int containerId, Fragment fragmentView) {
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(containerId, fragmentView).commit();
    }

    @Override
    public void goToMainView(String extraKey, String extraContent) {
        Log.d("F", "not implemented yet");
    }

    @Override
    public void exitApplication(Context context) {
        Log.d("F", "not implemented yet");
    }
}
