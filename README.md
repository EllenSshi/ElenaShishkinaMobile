To prepare the environment for Android tests you need to:
1. Run Appium server
2. Launch Android Virtual Device from AVD Manager

To run Android tests, please, use the following commands:
* to run tests for <b>native</b> application: <b>mvn clean test -P native</b>
* to run tests for <b>web</b> application: <b>mvn clean test -P web</b>

To run CLOUD tests, please, use the following commands:
* to run tests for <b>native</b> application on <b>Android</b> device: <b>mvn clean test -P cloudNativeAndroid -Dtoken=[you access token for mobilecloud.epam.com]</b>
* to run tests for <b>native</b> application on <b>iOS</b> device: <b>mvn clean test -P cloudNativeIos -Dtoken=[you access token for mobilecloud.epam.com]</b>
* to run tests for <b>web</b> application on <b>Android</b> device: <b>mvn clean test -P cloudWebAndroid -Dtoken=[you access token for mobilecloud.epam.com]</b>
* to run tests for <b>web</b> application on <b>iOS</b> device: <b>mvn clean test -P cloudWebIos -Dtoken=[you access token for mobilecloud.epam.com]</b>