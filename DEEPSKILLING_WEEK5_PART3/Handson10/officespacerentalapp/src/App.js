import './App.css';

function App() {

  const office = {
    name: "ABC Tech Park",
    rent: 55000,
    address: "Chennai"
  };

  const offices = [
    {
      id: 1,
      name: "ABC Tech Park",
      rent: 55000,
      address: "Chennai"
    },
    {
      id: 2,
      name: "XYZ Business Center",
      rent: 75000,
      address: "Bangalore"
    },
    {
      id: 3,
      name: "Elite Workspace",
      rent: 48000,
      address: "Hyderabad"
    },
    {
      id: 4,
      name: "Smart Office Hub",
      rent: 90000,
      address: "Coimbatore"
    }
  ];

  return (
    <div style={{ margin: "30px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=600"
        alt="Office Space"
        width="500"
      />

      <h2>Single Office Details</h2>

      <p><b>Name:</b> {office.name}</p>

      <p>
        <b>Rent:</b>{" "}
        <span
          style={{
            color: office.rent < 60000 ? "red" : "green"
          }}
        >
          ₹{office.rent}
        </span>
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Office List</h2>

      {offices.map((item) => (

        <div
          key={item.id}
          style={{
            border: "1px solid black",
            padding: "10px",
            marginBottom: "10px"
          }}
        >

          <h3>{item.name}</h3>

          <p>
            <b>Rent:</b>{" "}
            <span
              style={{
                color: item.rent < 60000 ? "red" : "green"
              }}
            >
              ₹{item.rent}
            </span>
          </p>

          <p><b>Address:</b> {item.address}</p>

        </div>

      ))}

    </div>
  );
}

export default App;