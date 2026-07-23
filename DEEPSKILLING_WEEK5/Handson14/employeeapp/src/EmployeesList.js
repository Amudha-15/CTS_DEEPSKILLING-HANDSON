import React from "react";
import EmployeeCard from "./EmployeeCard";

class EmployeesList extends React.Component {

  render() {

    return (

      <div>

        <EmployeeCard />

        <EmployeeCard />

        <EmployeeCard />

      </div>

    );

  }

}

export default EmployeesList;