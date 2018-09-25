webpackJsonp([1],{

/***/ 100:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AddPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(29);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/**
 * Generated class for the AddPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var AddPage = /** @class */ (function () {
    function AddPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    AddPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad AddPage');
    };
    AddPage = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'page-add',template:/*ion-inline-start:"/puneetsharma/project/startup/iKa/FrontEnd/src/pages/add/add.html"*/'<!--\n  Generated template for the AddPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n  <ion-navbar padding color="fblue">\n    <button ion-button menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Hom556666e</ion-title>\n  </ion-navbar>\n</ion-header>\n\n\n\n<ion-content padding>\n\n</ion-content>\n'/*ion-inline-end:"/puneetsharma/project/startup/iKa/FrontEnd/src/pages/add/add.html"*/,
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
    ], AddPage);
    return AddPage;
}());

//# sourceMappingURL=add.js.map

/***/ }),

/***/ 112:
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = 112;

/***/ }),

/***/ 154:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../pages/add/add.module": [
		278,
		0
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return __webpack_require__.e(ids[1]).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = 154;
module.exports = webpackAsyncContext;

/***/ }),

/***/ 197:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(29);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__add_add__ = __webpack_require__(100);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__list_list__ = __webpack_require__(198);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





//declare var window:any;
var HomePage = /** @class */ (function () {
    function HomePage(navCtrl, menuCtrl) {
        this.navCtrl = navCtrl;
        this.menuCtrl = menuCtrl;
        this.burgerMenu = [
            { name: "home", id: 1 },
            { name: "Add", id: 2 },
            { name: "Edit", id: 3 },
            { name: "Delete", id: 4 }
        ];
    }
    HomePage.prototype.ber_menu = function (me, id) {
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
                this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__add_add__["a" /* AddPage */]);
                break;
            }
            case "3": {
                // Edit
                this.menuCtrl.close();
                this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_3__list_list__["a" /* ListPage */]);
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
    };
    HomePage = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: "page-home",template:/*ion-inline-start:"/puneetsharma/project/startup/iKa/FrontEnd/src/pages/home/home.html"*/'<ion-menu id="dashboardmenu" [content]="dashboard" side="left" class="tparent dashboard" color="fblue" persistent="true">\n	<ion-header>\n		<ion-navbar color="fblue">\n			<button ion-button start clear class="menubutton" menuToggle>\n				<span>\n					<img src="assets/ic_back.png" style="width:40px">\n				</span>\n			</button>\n			<p class="btn-title-menu">InvenTm Menu</p>\n		</ion-navbar>\n	</ion-header>\n	<ion-content class="scroll">\n    <ion-list class="burgerMenu-list">\n			<button ion-item menuClose class="burgerMenu-item" *ngFor="let burmenu of burgerMenu" (tap)="ber_menu(burmenu.name,burmenu.id)">{{burmenu.name}}\n			</button>\n		</ion-list>\n	</ion-content>\n	<ion-footer>\n		<ion-list class="burgerMenu-list">\n			<button ion-item class="burgerMenu-item">Sign out</button>\n		</ion-list>\n	</ion-footer>\n</ion-menu>\n<ion-header>\n  <ion-navbar padding color="fblue">\n    <button ion-button menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Home</ion-title>\n  </ion-navbar>\n</ion-header>\n\n<ion-content class="bg-blue-color" #dashboard>\n\n  <ion-grid>\n    <ion-row style="text-align:center">\n      <ion-col col-6>\n        <div class="mymoney"><span>\n					<img src="assets/imgs/beneficiary.png" style="height:50px;width:50px">\n				</span></div>\n        <p>Add</p>\n      </ion-col>\n      <ion-col col-6>\n        <div class="mymoney"><span>\n					<img src="assets/imgs/edit_profile.png" style="height:50px;width:50px">\n				</span></div>\n        <p>Edit</p>\n      </ion-col>\n    </ion-row>\n\n    <ion-row style="text-align:center">\n      <ion-col col-6>\n        <div class="mymoney"><span>\n					<img src="assets/imgs/delete.png" style="height:50px;width:50px">\n				</span></div>\n        <p>Delete</p>\n      </ion-col>\n      <ion-col col-6>\n        <div class="mymoney"><span>\n					<img src="assets/imgs/edit_profile.png" style="height:50px;width:50px">\n				</span></div>\n        <p>Update</p>\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n  <!-- <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col>\n        2 of 3\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col col-8>\n        2 of 3 (wider)\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n    <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col col-6>\n        2 of 3 (wider)\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n\n  <ion-grid>\n    <ion-row>\n      <ion-col>\n        1 of 2\n      </ion-col>\n      <ion-col>\n        2 of 2\n      </ion-col>\n    </ion-row>\n    <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col>\n        2 of 3\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col col-8>\n        2 of 3 (wider)\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n    <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col col-6>\n        2 of 3 (wider)\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col>\n        1 of 3\n      </ion-col>\n      <ion-col col-auto>\n        Variable width content\n      </ion-col>\n      <ion-col>\n        3 of 3\n      </ion-col>\n    </ion-row>\n    <ion-row>\n      <ion-col>\n        1 of 4\n      </ion-col>\n      <ion-col>\n        2 of 4\n      </ion-col>\n      <ion-col col-auto>\n        <ion-input placeholder="Variable width input"></ion-input>\n      </ion-col>\n      <ion-col>\n        4 of 4\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col col-4>\n        1 of 4\n      </ion-col>\n      <ion-col col-2>\n        2 of 4\n      </ion-col>\n      <ion-col col-2>\n        3 of 4\n      </ion-col>\n      <ion-col col-4>\n        4 of 4\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col col-12 col-sm>\n        1 of 4\n      </ion-col>\n      <ion-col col-12 col-sm>\n        2 of 4\n      </ion-col>\n      <ion-col col-12 col-sm>\n        3 of 4\n      </ion-col>\n      <ion-col col-12 col-sm>\n        4 of 4\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col col-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3 offset-3>\n        2 of 2\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col col-md-3>\n        1 of 3\n      </ion-col>\n      <ion-col col-md-3>\n        2 of 3\n      </ion-col>\n      <ion-col col-md-3 offset-md-3>\n        3 of 3\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n\n  <ion-grid>\n    <ion-row>\n      <ion-col col-9 push-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3 pull-9>\n        2 of 2\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col col-md-6 push-md-3>\n        1 of 3\n      </ion-col>\n      <ion-col col-md-3 push-md-3>\n        2 of 3\n      </ion-col>\n      <ion-col col-md-3 pull-md-9>\n        3 of 3\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row align-items-start>\n      <ion-col>\n        1 of 4\n      </ion-col>\n      <ion-col>\n        2 of 4\n      </ion-col>\n      <ion-col>\n        3 of 4\n      </ion-col>\n      <ion-col>\n        4 of 4 <br>#<br>#<br>#\n      </ion-col>\n    </ion-row>\n\n    <ion-row align-items-center>\n      <ion-col>\n        1 of 4\n      </ion-col>\n      <ion-col>\n        2 of 4\n      </ion-col>\n      <ion-col>\n        3 of 4\n      </ion-col>\n      <ion-col>\n        4 of 4 <br>#<br>#<br>#\n      </ion-col>\n    </ion-row>\n\n    <ion-row align-items-end>\n      <ion-col>\n        1 of 4\n      </ion-col>\n      <ion-col>\n        2 of 4\n      </ion-col>\n      <ion-col>\n        3 of 4\n      </ion-col>\n      <ion-col>\n        4 of 4 <br>#<br>#<br>#\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row>\n      <ion-col align-self-start>\n        <div>\n          1 of 4\n        </div>\n      </ion-col>\n      <ion-col align-self-center>\n        <div>\n          2 of 4\n        </div>\n      </ion-col>\n      <ion-col align-self-end>\n        <div>\n          3 of 4\n        </div>\n      </ion-col>\n      <ion-col>\n        <div>\n          4 of 4 <br>#<br>#<br>#\n        </div>\n      </ion-col>\n    </ion-row>\n  </ion-grid>\n\n  <ion-grid>\n    <ion-row justify-content-start>\n      <ion-col col-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3>\n        2 of 2\n      </ion-col>\n    </ion-row>\n\n    <ion-row justify-content-center>\n      <ion-col col-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3>\n        2 of 2\n      </ion-col>\n    </ion-row>\n\n    <ion-row justify-content-end>\n      <ion-col col-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3>\n        2 of 2\n      </ion-col>\n    </ion-row>\n\n    <ion-row justify-content-around>\n      <ion-col col-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3>\n        2 of 2\n      </ion-col>\n    </ion-row>\n\n    <ion-row justify-content-between>\n      <ion-col col-3>\n        1 of 2\n      </ion-col>\n      <ion-col col-3>\n        2 of 2\n      </ion-col>\n    </ion-row>\n  </ion-grid> -->\n  <!-- <button ion-button secondary menuToggle>Toggle Menu</button> -->\n</ion-content>\n'/*ion-inline-end:"/puneetsharma/project/startup/iKa/FrontEnd/src/pages/home/home.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */],
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* MenuController */]])
    ], HomePage);
    return HomePage;
}());

//# sourceMappingURL=home.js.map

/***/ }),

/***/ 198:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(29);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ListPage = /** @class */ (function () {
    function ListPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        // If we navigated to this page, we will have an item available as a nav param
        this.selectedItem = navParams.get('item');
        // Let's populate this page with some filler content for funzies
        this.icons = ['flask', 'wifi', 'beer', 'football', 'basketball', 'paper-plane',
            'american-football', 'boat', 'bluetooth', 'build'];
        this.items = [];
        for (var i = 1; i < 11; i++) {
            this.items.push({
                title: 'Item ' + i,
                note: 'This is item #' + i,
                icon: this.icons[Math.floor(Math.random() * this.icons.length)]
            });
        }
    }
    ListPage_1 = ListPage;
    ListPage.prototype.itemTapped = function (event, item) {
        // That's right, we're pushing to ourselves!
        this.navCtrl.push(ListPage_1, {
            item: item
        });
    };
    ListPage = ListPage_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'page-list',template:/*ion-inline-start:"/puneetsharma/project/startup/iKa/FrontEnd/src/pages/list/list.html"*/'<ion-header>\n  <ion-navbar>\n    <button ion-button menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>List</ion-title>\n  </ion-navbar>\n</ion-header>\n\n<ion-content>\n  <ion-list>\n    <button ion-item *ngFor="let item of items" (click)="itemTapped($event, item)">\n      <ion-icon [name]="item.icon" item-start></ion-icon>\n      {{item.title}}\n      <div class="item-note" item-end>\n        {{item.note}}\n      </div>\n    </button>\n  </ion-list>\n  <div *ngIf="selectedItem" padding>\n    You navigated here from <b>{{selectedItem.title}}</b>\n  </div>\n</ion-content>\n'/*ion-inline-end:"/puneetsharma/project/startup/iKa/FrontEnd/src/pages/list/list.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
    ], ListPage);
    return ListPage;
    var ListPage_1;
}());

//# sourceMappingURL=list.js.map

/***/ }),

/***/ 199:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(200);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(220);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 220:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(26);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(29);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_background_mode__ = __webpack_require__(262);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__(270);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__pages_home_home__ = __webpack_require__(197);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__pages_list_list__ = __webpack_require__(198);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_add_add__ = __webpack_require__(100);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__ionic_native_status_bar__ = __webpack_require__(195);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__ionic_native_splash_screen__ = __webpack_require__(196);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_common_http__ = __webpack_require__(271);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_http__ = __webpack_require__(277);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};












var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* MyApp */],
                __WEBPACK_IMPORTED_MODULE_5__pages_home_home__["a" /* HomePage */],
                __WEBPACK_IMPORTED_MODULE_6__pages_list_list__["a" /* ListPage */],
                __WEBPACK_IMPORTED_MODULE_7__pages_add_add__["a" /* AddPage */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_common_http__["a" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_11__angular_http__["a" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* MyApp */], {}, {
                    links: [
                        { loadChildren: '../pages/add/add.module#AddPageModule', name: 'AddPage', segment: 'add', priority: 'low', defaultHistory: [] }
                    ]
                }),
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["a" /* IonicApp */]],
            entryComponents: [
                __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* MyApp */],
                __WEBPACK_IMPORTED_MODULE_5__pages_home_home__["a" /* HomePage */],
                __WEBPACK_IMPORTED_MODULE_6__pages_list_list__["a" /* ListPage */],
                __WEBPACK_IMPORTED_MODULE_7__pages_add_add__["a" /* AddPage */]
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_8__ionic_native_status_bar__["a" /* StatusBar */],
                __WEBPACK_IMPORTED_MODULE_9__ionic_native_splash_screen__["a" /* SplashScreen */],
                __WEBPACK_IMPORTED_MODULE_3__ionic_native_background_mode__["a" /* BackgroundMode */],
                { provide: __WEBPACK_IMPORTED_MODULE_1__angular_core__["u" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["b" /* IonicErrorHandler */] }
            ]
        })
    ], AppModule);
    return AppModule;
}());

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 270:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(29);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(195);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(196);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pages_home_home__ = __webpack_require__(197);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





//import { BackgroundMode } from "@ionic-native/background-mode";
//declare var PhoneCallTrap: any;
var MyApp = /** @class */ (function () {
    function MyApp(platform, statusBar, splashScreen) {
        this.platform = platform;
        this.statusBar = statusBar;
        this.splashScreen = splashScreen;
        this.rootPage = __WEBPACK_IMPORTED_MODULE_4__pages_home_home__["a" /* HomePage */];
        this.initializeApp();
        // used for an example of ngFor and navigation
    }
    MyApp.prototype.initializeApp = function () {
        var _this = this;
        this.platform.ready().then(function () {
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
            _this.statusBar.styleDefault();
            _this.splashScreen.hide();
        });
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_8" /* ViewChild */])(__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* Nav */]),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* Nav */])
    ], MyApp.prototype, "nav", void 0);
    MyApp = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({template:/*ion-inline-start:"/puneetsharma/project/startup/iKa/FrontEnd/src/app/app.html"*/'\n<ion-nav [root]="rootPage" #content swipeBackEnabled="false"></ion-nav>\n'/*ion-inline-end:"/puneetsharma/project/startup/iKa/FrontEnd/src/app/app.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* Platform */],
            __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */],
            __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */]])
    ], MyApp);
    return MyApp;
}());

//# sourceMappingURL=app.component.js.map

/***/ })

},[199]);
//# sourceMappingURL=main.js.map