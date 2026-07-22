import React, { Component } from "react";

class EventExamples extends Component {
  constructor(props) {
    super(props);

    this.state = {
      counter: 0,
    };
  }

  incrementValue = () => {
    this.setState({
      counter: this.state.counter + 1,
    });
  };

  decrementValue = () => {
    this.setState({
      counter: this.state.counter - 1,
    });
  };

  sayHello = () => {
    alert("Hello! Member");
  };

  incrementAndSayHello = () => {
    this.incrementValue();
    this.sayHello();
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleSyntheticEvent = (event) => {
    alert("I was clicked");
    console.log(event);
  };

  render() {
    return (
      <div>
        <h1>{this.state.counter}</h1>

        <button onClick={this.incrementAndSayHello}>
          Increment
        </button>

        <button onClick={this.decrementValue}>
          Decrement
        </button>

        <br />
        <br />

        <button
          onClick={() => this.sayWelcome("Welcome")}
        >
          Say Welcome
        </button>

        <br />
        <br />

        <button onClick={this.handleSyntheticEvent}>
          Click on me
        </button>
      </div>
    );
  }
}

export default EventExamples;