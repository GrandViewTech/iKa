import React, { Component } from 'react';
import RouteProps from "react-route-props";
import { BrowserRouter as Router, Switch, Route, Redirect, Link } from "react-router-dom";
//

import { Menubar } from 'primereact/menubar';
import { Button } from 'primereact/button';
import { InputText } from "primereact/inputtext";
class Navigation extends Component {
    constructor() {
        super();

        this.state = {
            items: [
                {
                    label: '',
                    icon: 'pi pi-bars'

                },
                {
                    label: 'iKa',


                }
            ]
        };
    }

    render() {
        return (
            <Router>
                
                <div>
                <div className='menubar1 shadow' style={{ height: '55px', paddingRight: '10px', paddingLeft: '10px', paddingTop: '10px', paddingBottom: '15px' }}>
                    <div style={{ float: 'left', width: '8%', textAlign: 'left' }}>
                        <Button label="Menu" icon="pi pi-bars" className="p-button-secondary" />
                    </div>
                    <div  style={{ float: 'left', width: '30%', textAlign: 'left' ,paddingRight: '5px' }}>
                       <label style={{ fontFamily: "cursive" , fontSize:'33px'}}> iKa</label>
                    </div>

                    <div style={{ float: 'left', textAlign: 'left' }}>
                    <div className="p-inputgroup">
                        <InputText style={{ width: '450px' }} tooltip={'*Search through iKa'} placeholder="Search iKa" type="text" />
                        <span className="p-inputgroup-addon">
                            <i className="pi pi-search"></i>
                        </span>
                    </div>
                    </div>
                    <div style={{ float: 'right', textAlign: 'right' }}>
                        <Button label="Logout" icon="pi pi-power-off" className="p-button-secondary" />
                    </div>
                </div>
                </div>
            </Router>

        );
    }
}
export default Navigation