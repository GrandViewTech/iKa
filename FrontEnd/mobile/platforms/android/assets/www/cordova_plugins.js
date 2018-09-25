cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
  {
    "id": "cordova-plugin-device.device",
    "file": "plugins/cordova-plugin-device/www/device.js",
    "pluginId": "cordova-plugin-device",
    "clobbers": [
      "device"
    ]
  },
  {
    "id": "cordova-plugin-background-mode.BackgroundMode",
    "file": "plugins/cordova-plugin-background-mode/www/background-mode.js",
    "pluginId": "cordova-plugin-background-mode",
    "clobbers": [
      "cordova.plugins.backgroundMode",
      "plugin.backgroundMode"
    ]
  },
  {
    "id": "cordova-plugin-ionic-keyboard.keyboard",
    "file": "plugins/cordova-plugin-ionic-keyboard/www/android/keyboard.js",
    "pluginId": "cordova-plugin-ionic-keyboard",
    "clobbers": [
      "window.Keyboard"
    ]
  },
  {
    "id": "cordova-plugin-ionic-webview.IonicWebView",
    "file": "plugins/cordova-plugin-ionic-webview/src/www/util.js",
    "pluginId": "cordova-plugin-ionic-webview",
    "clobbers": [
      "Ionic.WebView"
    ]
  },
  {
    "id": "cordova-plugin-splashscreen.SplashScreen",
    "file": "plugins/cordova-plugin-splashscreen/www/splashscreen.js",
    "pluginId": "cordova-plugin-splashscreen",
    "clobbers": [
      "navigator.splashscreen"
    ]
  },
  {
    "id": "cozzbie.plugin.phonecalltrap.PhoneCallTrap",
    "file": "plugins/cozzbie.plugin.phonecalltrap/www/PhoneCallTrap.js",
    "pluginId": "cozzbie.plugin.phonecalltrap",
    "clobbers": [
      "window.PhoneCallTrap"
    ]
  },
  {
    "id": "io.gvox.plugin.phonecalltrap.PhoneCallTrap",
    "file": "plugins/io.gvox.plugin.phonecalltrap/www/PhoneCallTrap.js",
    "pluginId": "io.gvox.plugin.phonecalltrap",
    "clobbers": [
      "window.PhoneCallTrap"
    ]
  }
];
module.exports.metadata = 
// TOP OF METADATA
{
  "cordova-plugin-device": "2.0.2",
  "cordova-plugin-background-mode": "0.7.2",
  "cordova-plugin-ionic-keyboard": "2.1.2",
  "cordova-plugin-ionic-webview": "2.1.0",
  "cordova-plugin-splashscreen": "5.0.2",
  "cordova-plugin-whitelist": "1.3.3",
  "cozzbie.plugin.phonecalltrap": "0.1.3",
  "io.gvox.plugin.phonecalltrap": "0.1.2"
};
// BOTTOM OF METADATA
});