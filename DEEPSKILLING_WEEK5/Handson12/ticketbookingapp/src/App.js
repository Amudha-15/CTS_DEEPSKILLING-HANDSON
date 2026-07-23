import React, { useState } from "react";
import "./App.css";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div
      style={{
        textAlign: "center",
        marginTop: "20px"
      }}
    >
      <h1>Ticket Booking Application</h1>

      {isLoggedIn ? (
        <>
          <button onClick={() => setIsLoggedIn(false)}>
            Logout
          </button>

          <UserPage />
        </>
      ) : (
        <>
          <button onClick={() => setIsLoggedIn(true)}>
            Login
          </button>

          <GuestPage />
        </>
      )}
    </div>
  );
}

export default App;