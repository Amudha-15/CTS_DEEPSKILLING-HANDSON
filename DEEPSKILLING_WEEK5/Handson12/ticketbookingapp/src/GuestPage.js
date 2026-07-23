import React from "react";

function GuestPage() {
  return (
    <div>

      <h2>Welcome Guest</h2>

      <h3>Available Flights</h3>

      <div style={{ display: "flex", justifyContent: "center" }}>
        <table border="1" cellPadding="10">

          <thead>
            <tr>
              <th>Flight</th>
              <th>From</th>
              <th>To</th>
              <th>Price</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>AI101</td>
              <td>Chennai</td>
              <td>Delhi</td>
              <td>₹5500</td>
            </tr>

            <tr>
              <td>6E220</td>
              <td>Bangalore</td>
              <td>Mumbai</td>
              <td>₹4200</td>
            </tr>

            <tr>
              <td>SG310</td>
              <td>Hyderabad</td>
              <td>Kolkata</td>
              <td>₹4800</td>
            </tr>
          </tbody>

        </table>
      </div>

      <br />

      <p><b>Please Login to Book Tickets.</b></p>

    </div>
  );
}

export default GuestPage;