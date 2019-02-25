
import com.popdeem.sdk.core.PopdeemSDK;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.popdeem.sdk.core.utils.PDLog;
import com.popdeem.sdk.core.api.PDAPICallback;
import com.popdeem.sdk.core.api.PDAPIClient;
import com.popdeem.sdk.core.api.response.PDBasicResponse;

public class RNPopdeemModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNPopdeemModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNPopdeem";
  }
  @ReactMethod
  private void enableSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
    PopdeemSDK.enableSocialMultiLogin(this.cordova.getActivity().getClass(), numberOfPrompts);
    PopdeemSDK.pushCordovaLogin(this.cordova.getActivity(), numberOfPrompts);
  }

  private void pushSocialLogin(int numberOfPrompts, CallbackContext callbackContext) {
      PopdeemSDK.enableSocialMultiLogin(this.cordova.getActivity().getClass(), numberOfPrompts);
  }

  private void pushPopdeemHome(CallbackContext callbackContext) {
    PopdeemSDK.showHomeFlow(this.cordova.getActivity());
  }

  private void deliverThirdPartyToken(String userToken, CallbackContext callbackContext) {
    PopdeemSDK.setThirdPartyToken(userToken);
  }

  private void logMoment(String momentString, CallbackContext callbackContext) {
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