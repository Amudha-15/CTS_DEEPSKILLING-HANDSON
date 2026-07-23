import React from "react";

function UserPage() {
  return (
    <div>

      <h2>Welcome User</h2>

      <h3>Flight Booking</h3>

      <div style={{ display: "flex", justifyContent: "center" }}>
        <table border="1" cellPadding="10">

          <thead>
            <tr>
              <th>Flight</th>
              <th>From</th>
              <th>To</th>
              <th>Price</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>AI101</td>
              <td>Chennai</td>
              <td>Delhi</td>
              <td>₹5500</td>
              <td>
                <button>Book Ticket</button>
              </td>
            </tr>

            <tr>
              <td>6E220</td>
              <td>Bangalore</td>
              <td>Mumbai</td>
              <td>₹4200</td>
              <td>
                <button>Book Ticket</button>
              </td>
            </tr>

            <tr>
              <td>SG310</td>
              <td>Hyderabad</td>
              <td>Kolkata</td>
              <td>₹4800</td>
              <td>
                <button>Book Ticket</button>
              </td>
            </tr>
          </tbody>

        </table>
      </div>

    </div>
  );
}

export default UserPage;