import React, { Component } from "react";

class Counter extends Component {

  constructor() {
    super();

    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState({
      count: this.state.count + 1
    });
  };

  decrement = () => {
    this.setState({
      count: this.state.count - 1
    });
  };

  sayHello = () => {
    alert("Hello! Have a nice day.");
  };

  increase = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  onPress = (event) => {
    alert("I was clicked");
    console.log(event);
  };

  render() {

    return (

      <div>

        <h2>Counter : {this.state.count}</h2>

        <button onClick={this.increase}>
          Increment
        </button>

        &nbsp;

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br /><br />

        <button onClick={() => this.sayWelcome("Welcome")}>
          Say Welcome
        </button>

        <br /><br />

        <button onClick={this.onPress}>
          Synthetic Event
        </button>

      </div>

    );
  }
}

export default Counter;