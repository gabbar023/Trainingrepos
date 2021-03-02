import React,{Component} from 'react';
import './Person.css';


class Person extends Component{

    render(){
        return  (
            <div>
                <h3 className="personal-detail">Helloo {this.props.name}. Ssup buddy I know you are a living legend  and dats what i want to explain myself and my swag is  {this.props.swag}</h3>
            </div>
        )
    }    
}

export default   Person;