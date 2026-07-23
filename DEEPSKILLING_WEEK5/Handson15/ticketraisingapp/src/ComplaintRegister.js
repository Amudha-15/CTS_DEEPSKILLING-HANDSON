import React, { Component } from "react";

class ComplaintRegister extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employeeName: "",
            complaint: ""
        };
    }


    handleNameChange = (event) => {

        this.setState({
            employeeName: event.target.value
        });

    };


    handleComplaintChange = (event) => {

        this.setState({
            complaint: event.target.value
        });

    };


    handleSubmit = (event) => {

        event.preventDefault();

        let referenceNumber = Math.floor(
            Math.random() * 100000
        );

        alert(
            "Complaint Registered Successfully!\nReference Number: " 
            + referenceNumber
        );

    };


    render() {

        return (

            <div style={{textAlign:"center"}}>

                <h1>Complaint Register</h1>


                <form onSubmit={this.handleSubmit}>


                    <label>
                        Employee Name:
                    </label>

                    <br/>

                    <input
                        type="text"
                        value={this.state.employeeName}
                        onChange={this.handleNameChange}
                    />


                    <br/><br/>


                    <label>
                        Complaint:
                    </label>

                    <br/>

                    <textarea
                        rows="5"
                        cols="30"
                        value={this.state.complaint}
                        onChange={this.handleComplaintChange}
                    />


                    <br/><br/>


                    <button type="submit">
                        Submit
                    </button>


                </form>


            </div>

        );

    }

}

export default ComplaintRegister;