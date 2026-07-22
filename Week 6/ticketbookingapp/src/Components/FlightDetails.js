function FlightDetails() {
  return (
    <div>
      <h2>Flight Details</h2>

      <table>
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Departure</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>IndiGo 6E-123</td>
            <td>Chennai</td>
            <td>Bangalore</td>
            <td>10:00 AM</td>
            <td>₹3,500</td>
          </tr>

          <tr>
            <td>Air India AI-456</td>
            <td>Hyderabad</td>
            <td>Delhi</td>
            <td>1:30 PM</td>
            <td>₹6,800</td>
          </tr>

          <tr>
            <td>IndiGo 6E-789</td>
            <td>Bangalore</td>
            <td>Mumbai</td>
            <td>6:00 PM</td>
            <td>₹4,700</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default FlightDetails;