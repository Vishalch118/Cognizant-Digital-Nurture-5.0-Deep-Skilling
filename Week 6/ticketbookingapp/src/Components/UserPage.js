import FlightDetails from "./FlightDetails";

function UserPage() {
  const bookTicket = () => {
    alert("Your ticket has been booked successfully!");
  };

  return (
    <div>
      <h1>Welcome Back</h1>

      <p>
        You are logged in. You can now book tickets.
      </p>

      <FlightDetails />

      <br />

      <button onClick={bookTicket}>
        Book Ticket
      </button>
    </div>
  );
}

export default UserPage;