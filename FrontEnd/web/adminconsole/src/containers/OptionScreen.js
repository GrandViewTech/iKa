import React, { Component } from 'react'
import { Card } from 'primereact/card';
import { Button } from 'primereact/button';

class OptionScreen extends Component {

    constructor() { super(); }

    render() {

        const header = <img alt="Card" src='resources/images/usercard.png' />;

        const footer = <span>
            <Button label="Save" icon="pi pi-check" style={{ marginRight: '.25em' }} />
            <Button label="Cancel" icon="pi pi-times" className="p-button-secondary" />
        </span>;


        return (
            <div style={{ padding: '25px',  textAlign: 'left' }}>
                <Card 
                    style={{ width: '300px', hieght: '100px' }}
                    className="ui-card-shadow shadow"
                    footer={footer}
                    header={header}
                    title="Inventory Management"
                    subTitle="Description"
                >
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Inventory management software is a software system for tracking inventory levels, orders, sales and deliveries. It can also be used in the manufacturing industry to create a work order, bill of materials and other production-related documents.
                </Card>
            </div>
        )

    }

}
export default OptionScreen
