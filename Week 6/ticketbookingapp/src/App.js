import React, { Component } from "react";
import "./App.css";

import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false,
    };
  }

  handleLogin = () => {
    this.setState({
      isLoggedIn: true,
    });
  };

  handleLogout = () => {
    this.setState({
      isLoggedIn: false,
    });
  };

  render() {
    let page;
    let button;

    if (this.state.isLoggedIn) {
      page = <UserPage />;

      button = (
        <button onClick={this.handleLogout}>
          Logout
        </button>
      );
    } else {
      page = <GuestPage />;

      button = (
        <button onClick={this.handleLogin}>
          Login
        </button>
      );
    }

    return (
      <div className="App">
        <h1>Ticket Booking Application</h1>

        {button}

        <hr />

        {page}
      </div>
    );
  }
}

export default App;