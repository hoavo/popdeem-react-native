
# react-native-popdeem

## Getting started

`$ npm install react-native-popdeem --save`

### Mostly automatic installation

`$ react-native link react-native-popdeem`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-popdeem` and add `RNPopdeem.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPopdeem.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPopdeemPackage;` to the imports at the top of the file
  - Add `new RNPopdeemPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-popdeem'
  	project(':react-native-popdeem').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-popdeem/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-popdeem')
  	```

## Social Login
To launch the social login popover from javascript, use the following:
`popdeem.enableSocialLogin(3, function() {}, function() {});`
The first parameter is the _numberOfPrompts_ argument. The popover is dismissible by the user - this argument denotes the maximum number of times a user can see this popover.


## Popdeem Home
To show the Popdeem Home flow from javascript, use the following:
`popdeem.pushPopdeemHome(function() {}, function() {});`. Popdeem Home encapsulates all of Popdeem’s functionality.


## Deliver Third Party Token
We may need you to deliver a user token. If so, you can do this by using this method:
`popdeem.deliverThirdPartyToken(“ThirdPartyToken", function() {}, function() {});`.

## Usage
```javascript
import {NativeModules} from 'react-native';
const RNPopdeem = NativeModules.RNPopdeem;

RNPopdeem.init('api_key')
RNPopdeem.enableSocialLoginWithNumberOfPrompts(3);
// TODO: What to do with the module?
RNPopdeem;
```
  