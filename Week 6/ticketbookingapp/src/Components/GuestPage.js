import FlightDetails from "./FlightDetails";

function GuestPage() {
  return (
    <div>
      <h1>Please Sign Up</h1>

      <p>
        You can browse the available flights.
        Please log in to book a ticket.
      </p>

      <FlightDetails />
    </div>
  );
}

export default GuestPage;