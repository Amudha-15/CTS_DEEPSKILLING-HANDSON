import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard() {

  const theme = useContext(ThemeContext);

  return (

    <div>

      <h2>Employee Details</h2>

      <p>Name: John</p>

      <p>Role: Developer</p>

      <button className={theme}>
        View
      </button>

      <button className={theme}>
        Edit
      </button>

    </div>

  );

}

export default EmployeeCard;