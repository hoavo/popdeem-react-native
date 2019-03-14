package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.popdeem.sdk.core.PopdeemSDK;
import com.popdeem.sdk.core.utils.PDLog;
import com.popdeem.sdk.core.api.PDAPICallback;
import com.popdeem.sdk.core.api.PDAPIClient;
import com.popdeem.sdk.core.api.response.PDBasicResponse;
import android.app.Activity;
import android.content.Intent;

public class RNPopdeemModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
      super.onActivityResult(requestCode, resultCode, intent);
      //implement code here
    }
  };

  public RNPopdeemModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    reactContext.addActivityEventListener(mActivityEventListener);
  }

  @Override
  public String getName() {
    return "RNPopdeem";
  }
  @ReactMethod
  public void enableSocialLogin(int numberOfPrompts) {
    PopdeemSDK.enableSocialMultiLogin(getCurrentActivity().getClass(), numberOfPrompts);
  }

  public void pushSocialLogin(int numberOfPrompts) {
    PopdeemSDK.enableSocialMultiLogin(getCurrentActivity().getClass(), numberOfPrompts);
  }

  public void pushPopdeemHome() {
    PopdeemSDK.showHomeFlow(getCurrentActivity());
  }

  public void deliverThirdPartyToken(String userToken) {
    PopdeemSDK.setThirdPartyToken(userToken);
  }

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