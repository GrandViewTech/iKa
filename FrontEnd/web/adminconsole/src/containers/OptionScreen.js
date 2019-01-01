import React, { Component } from 'react'
import { Card } from 'primereact/card';
import { Button } from 'primereact/button';
import {Tooltip} from 'primereact/tooltip';
import OptionDataset from './../dataset/OptionDataset';

class OptionScreen extends Component {

    constructor() 
                { 
                    super(); 
                    this.optionDataset=new OptionDataset();
                }


    generateOptionList=()=>
    {
      let dataset=this.optionDataset.option();
      let cardList=[];
      for(let index in dataset)
      {   
            let floating=(index==0)?'left':'left';
            console.log(index+floating);
            var data=dataset[index];
            const header = (
                            <span>
                                <img alt="Card" src={data.image} />
                            </span>
                           );
            
            
            const footer = (
                            <div style={{height:'25px'}}>
                                <span style={{float:"right"}}>
                                    <Button label="Open" icon="pi pi-check" style={{ marginRight: '.25em' }} />
                                </span>
                            </div>
                           );
            let child=  (
                    <span id={'card_'+index} style={{height:'250px',width:'300px',padding:'10px',float:floating}}>
                        <Card 
                            key={'card_'+index}
                            id={'card_'+index}
                            
                            className="ui-card-shadow shadow"
                            footer={footer}
                            header={header}
                            title={data.title}
                            subTitle={data.subTitle}
                        >
                            <span>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{data.description}
                            </span>
                        </Card>
                     </span>
                    );
            cardList.push(child);
      }  
      return cardList;
    }


    render() {
            return (
                        <div style={{padding:'20px', paddingLeft:'10px',textAlign:'left'}}>
                            {this.generateOptionList()}
                        </div>
                  )
            }

}
export default OptionScreen
