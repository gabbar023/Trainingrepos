import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Person from './components/Person';
import Product from './components/Product.';
import axios from 'axios';


class App extends Component {

  state = {
    personList: [{name:'Lohith s',swag:'Infinity'},{name:'Raghav D  souza',swag:'Zero'},{name:'Jandu',swag:'pandu'}],
    productList :[]
  }

  componentDidMount(){
    axios.get("http://localhost:8080/products").then(resp => {
      this.setS/poitate(productList =  resp.data);
    })
  }

  render() {
    return (
      <div className="App">
        {
          this.state.productList.map((aPerson) => {
            return (<Product name = {aPerson.name} price= {aPerson.price} qoh =  {aPerson.qoh}/> );
          })
        }
        
      </div>
    );
  }
}

export default App;
