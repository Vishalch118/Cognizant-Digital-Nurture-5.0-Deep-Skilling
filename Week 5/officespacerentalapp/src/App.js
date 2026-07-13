import "./App.css";
import officeImage from "./Images/office.jpg";

function App() {
  const heading = "Office Space Rental Application";

  const office = {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
  };

  const officeList = [
    {
      id: 1,
      name: "DBS",
      rent: 50000,
      address: "Chennai",
    },
    {
      id: 2,
      name: "Regus",
      rent: 65000,
      address: "Bangalore",
    },
    {
      id: 3,
      name: "WeWork",
      rent: 70000,
      address: "Hyderabad",
    },
  ];

  return (
    <div className="App">
      <h1>{heading}</h1>

      <img
        src={officeImage}
        alt="Office Space"
        className="office-image"
      />

      <h2>Office Details</h2>

      <h3>Name: {office.name}</h3>

      <h3
        style={{
          color: office.rent < 60000 ? "red" : "green",
        }}
      >
        Rent: Rs. {office.rent}
      </h3>

      <h3>Address: {office.address}</h3>

      <hr />

      <h2>Available Office Spaces</h2>

      <div className="office-container">
        {officeList.map((item) => (
          <div className="office-card" key={item.id}>
            <h2>Name: {item.name}</h2>

            <h3
              style={{
                color:
                  item.rent < 60000
                    ? "red"
                    : "green",
              }}
            >
              Rent: Rs. {item.rent}
            </h3>

            <h3>Address: {item.address}</h3>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;