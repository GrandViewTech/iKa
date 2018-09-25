import { Component, ViewChild } from "@angular/core";
import { Nav, Platform } from "ionic-angular";
import { StatusBar } from "@ionic-native/status-bar";
import { SplashScreen } from "@ionic-native/splash-screen";

import { HomePage } from "../pages/home/home";
import { ListPage } from "../pages/list/list";
//import { BackgroundMode } from "@ionic-native/background-mode";

//declare var PhoneCallTrap: any;
@Component({
  templateUrl: "app.html"
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = HomePage;

  pages: Array<{ title: string; component: any }>;

  constructor(
    public platform: Platform,
    public statusBar: StatusBar,
    public splashScreen: SplashScreen,
  //  private backgroundMode: BackgroundMode
  ) {
    this.initializeApp();

    // used for an example of ngFor and navigation
  }

  initializeApp() {
    this.platform.ready().then(() => {
      // this.backgroundMode.enable();

      // if (this.platform.is("cordova")) {
      //   //Subscribe on pause
      //   this.platform.pause.subscribe(() => {
      //     PhoneCallTrap.onCall(function(obj) {
      //       var callObj = JSON.parse(obj),
      //         state = callObj.state,
      //         callingNumber = callObj.incomingNumber;

      //       switch (state) {
      //         case "RINGING":
      //           alert("RINGING");
      //           this.backgroundMode.moveToForeground();
      //           console.log("Phone is ringing", callingNumber);
      //           break;
      //         case "OFFHOOK":
      //           //alert(2);
      //           console.log("Phone is off-hook");
      //           break;

      //         case "IDLE":
      //           //alert(3);
      //           console.log("Phone is idle");
      //           break;
      //       }
      //     });
      //   });

      //   //Subscribe on resume
      //   this.platform.resume.subscribe(() => {
      //     window["paused"] = 0;
      //     PhoneCallTrap.onCall(function(obj) {
      //       var callObj = JSON.parse(obj),
      //         state = callObj.state,
      //         callingNumber = callObj.incomingNumber;

      //       switch (state) {
      //         case "RINGING":
      //           alert("RINGING");
      //           this.backgroundMode.moveToForeground();
      //           console.log("Phone is ringing", callingNumber);
      //           break;
      //         case "OFFHOOK":
      //           //alert(2);
      //           console.log("Phone is off-hook");
      //           break;

      //         case "IDLE":
      //           //alert(3);
      //           console.log("Phone is idle");
      //           break;
      //       }
      //     });
      //   });
     // }
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

}
