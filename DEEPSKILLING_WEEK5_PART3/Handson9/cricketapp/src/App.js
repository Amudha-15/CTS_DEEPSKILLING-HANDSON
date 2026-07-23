import './App.css';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {

  const flag = false;

  return (
    <div>

      {flag ? <ListofPlayers /> : <IndianPlayers />}

    </div>
  );
}

export default App;