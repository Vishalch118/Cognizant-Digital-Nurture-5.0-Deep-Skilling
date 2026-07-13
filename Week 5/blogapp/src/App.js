import "./App.css";
import CohortDetails from "./Components/CohortDetails";

function App() {
  const cohorts = [
    {
      cohortCode: "INTADMDF10",
      technology: ".NET FSD",
      startDate: "22-Feb-2022",
      currentStatus: "Scheduled",
      coachName: "Aathma",
      trainerName: "Jojo Jose",
    },
    {
      cohortCode: "ADM21JF014",
      technology: "Java FSD",
      startDate: "10-Sep-2021",
      currentStatus: "ongoing",
      coachName: "Apoorv",
      trainerName: "Elsa Smith",
    },
    {
      cohortCode: "CDBJF21025",
      technology: "Java FSD",
      startDate: "24-Dec-2021",
      currentStatus: "ongoing",
      coachName: "Aathma",
      trainerName: "John Doe",
    },
  ];

  return (
    <div className="App">
      <h1>Cohorts Details</h1>

      {cohorts.map((cohort) => (
        <CohortDetails
          key={cohort.cohortCode}
          cohort={cohort}
        />
      ))}
    </div>
  );
}

export default App;