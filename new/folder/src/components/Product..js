import React, { Component } from 'react';

class Product extends Component {
    render() {
        return (<div className="ui card">
            <div className="image">
                <img src="https://picsum.photos/100/150"></img>
  </div>
                <div className="content">
                    <a className="header">{this.props.name}</a>
                    <div className="meta">
                        <span className="date">{this.props.qoh}</span>
                    </div>
                    <div className="description">
                        {this.props.price}
    </div>
                </div>
                <div className="extra content">
                    <a>
                        <i className="user icon"></i>
      mariiii click madu
      
    </a>
                </div>
            </div>);
    }
}

export default Product;