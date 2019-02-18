
#import "RNPopdeem.h"
#import "PopdeemSDK.h"
#import "PDUtils.h"

@implementation RNPopdeem

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(init:(NSString *) popdeemApiKey)
{
    if (popdeemApiKey != nil) {
        [PopdeemSDK withAPIKey:popdeemApiKey];
        NSString *popdeemThemeName = [PDUtils getThemeFileName];
        if (popdeemThemeName == nil) {
            NSLog(@"Popdeem Theme not specified in info.plist");
        } else {
            [PopdeemSDK setUpThemeFile:popdeemThemeName];
        }
    }
}


RCT_EXPORT_METHOD(enableSocialLoginWithNumberOfPrompts:(NSInteger )numberOfPrompts)
{
    [PopdeemSDK enableSocialLoginWithNumberOfPrompts:numberOfPrompts];
}

RCT_EXPORT_METHOD(pushPopdeemHome)
{
    [PopdeemSDK presentRewardFlow];
}

RCT_EXPORT_METHOD(deliverThirdPartyToken:(NSString *) userToken)
{
    [PopdeemSDK setThirdPartyUserToken:userToken];
}

RCT_EXPORT_METHOD(logMoment:(NSString *) momentString)
{
    [PopdeemSDK logMoment:momentString];
}
@end
  
