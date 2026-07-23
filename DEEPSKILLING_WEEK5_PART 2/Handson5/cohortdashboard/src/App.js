import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div>
      <CohortDetails
        code="INTADMDF10 .NET FSD"
        technology=".NET FSD"
        trainer="Rohit"
        coach="Apoorv"
        startDate="22-Feb-2022"
        status="Ongoing"
      />

      <CohortDetails
        code="ADM21JF014 Java FSD"
        technology="Java FSD"
        trainer="Rahul"
        coach="Priya"
        startDate="10-Jan-2022"
        status="Completed"
      />

      <CohortDetails
        code="INTADMJF15 Java FSD"
        technology="Java FSD"
        trainer="Kiran"
        coach="Anita"
        startDate="15-Mar-2022"
        status="Ongoing"
      />
    </div>
  );
}

export default App;