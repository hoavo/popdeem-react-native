package com.reactlibrary;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.popdeem.sdk.core.PopdeemSDK;
import com.popdeem.sdk.core.utils.PDLog;
import com.popdeem.sdk.core.api.PDAPICallback;
import com.popdeem.sdk.core.api.PDAPIClient;
import com.popdeem.sdk.core.api.response.PDBasicResponse;
import com.popdeem.sdk.uikit.fragment.multilogin.PDUISocialMultiLoginFragment;

import android.app.Activity;
import android.content.Intent;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class RNPopdeemModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {
        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            PDUISocialMultiLoginFragment frag = (PDUISocialMultiLoginFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag("PDUISocialMultiLoginFragment");
            if(frag!=null){
                frag.onActivityResult(64206, resultCode, data);
            }
        }
    };

    public RNPopdeemModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        reactContext.addActivityEventListener(mActivityEventListener);
        PopdeemSDK.initializeSDK((Application)(reactContext.getApplicationContext()));
    }

    @Override
    public String getName() {
        return "RNPopdeem";
    }

    @ReactMethod
    public void enableSocialLogin(int numberOfPrompts, Callback successCallback, Callback errorCallback) {
        try {
            PopdeemSDK.enableSocialMultiLogin(getCurrentActivity().getClass(), 100);
            successCallback.invoke();
        }catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void pushSocialLogin(int numberOfPrompts, Callback successCallback, Callback errorCallback) {

        try {
            PopdeemSDK.enableSocialMultiLogin(getCurrentActivity().getClass(), 100);
            PopdeemSDK.pushCordovaLogin(getCurrentActivity(), numberOfPrompts);
            successCallback.invoke();
        }catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void pushPopdeemHome(Callback successCallback, Callback errorCallback) {
        try {
            PopdeemSDK.showHomeFlow(getCurrentActivity());
            successCallback.invoke();
        }catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }

    }

    @ReactMethod
    public void deliverThirdPartyToken(String userToken, Callback successCallback, Callback errorCallback) {
        try {
            PopdeemSDK.setThirdPartyToken(userToken);
            successCallback.invoke();
        }catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }

    }

    @ReactMethod
    public void logMoment(String momentString) {
        PopdeemSDK.logMoment(momentString, new PDAPICallback<PDBasicResponse>() {
            @Override
            public void success(PDBasicResponse response) {
                PDLog.d(PDAPIClient.class, response.toString());
            }

            @Override
            public void failure(int statusCode, Exception e) {
                PDLog.w(PDAPIClient.class, "code=" + statusCode + ", message=" + e.getMessage());
            }
        });
    }

}