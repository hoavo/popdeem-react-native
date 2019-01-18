
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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNPopdeem.sln` in `node_modules/react-native-popdeem/windows/RNPopdeem.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Popdeem.RNPopdeem;` to the usings at the top of the file
  - Add `new RNPopdeemPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNPopdeem from 'react-native-popdeem';

// TODO: What to do with the module?
RNPopdeem;
```
  