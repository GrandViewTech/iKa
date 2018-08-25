import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { MenuController } from "ionic-angular";
import { AddPage } from "../add/add";
import { ListPage } from "../list/list";

//declare var window:any;

@Component({
  selector: "page-home",
  templateUrl: "home.html"
})
export class HomePage {
  burgerMenu: any = [
    { name: "home", id: 1 },
    { name: "Add", id: 2 },
    { name: "Edit", id: 3 },
    { name: "Delete", id: 4 }
  ];
  constructor(
    public navCtrl: NavController,
    public menuCtrl: MenuController
  ) {

  }

  ber_menu(me, id) {
    console.log("SELECTED BERGER MENU NAME = " + me);
    console.log("SELECTED BERGER MENU ID = " + id);

    switch (id) {
      case "1": {
        //Home
        this.menuCtrl.close();
        break;
      }
      case "2": {
        //Add
        this.menuCtrl.close();
        this.navCtrl.push(AddPage);
        break;
      }
      case "3": {
        // Edit
        this.menuCtrl.close();
        this.navCtrl.push(ListPage);
        break;
      }
      case "4": {
        //Delete
        this.menuCtrl.close();
        break;
      }

      default: {
        break;
      }
    }
  }

}
