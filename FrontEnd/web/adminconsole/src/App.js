import React, { Component } from 'react';
import Navigation from "./containers/Navigation";
import OptionScreen from "./containers/OptionScreen";
import './components/css/Custom.css';
import './components/css/App.css';

require("primereact/resources/themes/nova-light/theme.css");
require("primereact/resources/primereact.min.css");
require("primeicons/primeicons.css");
require("react-fontawesome");

class App extends Component {
  render() {
    return (
      <div className="App title-header ui-widget">
        <div style={{height:'55px'}}>
          <Navigation />
        </div>
        <div>
          <OptionScreen/>
        </div>
      </div>
    );
  }
}

export default App;
