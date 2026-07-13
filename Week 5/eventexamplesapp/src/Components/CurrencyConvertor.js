import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);

    this.state = {
      rupees: "",
      euros: "",
    };
  }

  handleChange = (event) => {
    this.setState({
      rupees: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const euro = (
      Number(this.state.rupees) / 90
    ).toFixed(2);

    this.setState({
      euros: euro,
    });
  };

  render() {
    return (
      <div>
        <h1>Currency Convertor</h1>

        <form onSubmit={this.handleSubmit}>
          <label>
            Amount in Rupees:
          </label>

          <br />

          <input
            type="number"
            value={this.state.rupees}
            onChange={this.handleChange}
            placeholder="Enter amount in INR"
            required
          />

          <br />
          <br />

          <button type="submit">
            Convert
          </button>
        </form>

        {this.state.euros !== "" && (
          <h3>
            Amount in Euro: €
            {this.state.euros}
          </h3>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;