import React from "react";

function BookDetails() {

  const books = [
    {
      id: 1,
      name: "Java Programming",
      author: "Herbert Schildt",
      price: "₹650"
    },
    {
      id: 2,
      name: "Python Basics",
      author: "Mark Lutz",
      price: "₹550"
    },
    {
      id: 3,
      name: "React Essentials",
      author: "Dan Abramov",
      price: "₹700"
    }
  ];

  return (
    <div>

      <h2>Book Details</h2>

      <div
        style={{
          display: "flex",
          justifyContent: "center"
        }}
      >
        <table border="1" cellPadding="10">

          <thead>
            <tr>
              <th>Book</th>
              <th>Author</th>
              <th>Price</th>
            </tr>
          </thead>

          <tbody>

            {books.map((book) => (

              <tr key={book.id}>
                <td>{book.name}</td>
                <td>{book.author}</td>
                <td>{book.price}</td>
              </tr>

            ))}

          </tbody>

        </table>
      </div>

    </div>
  );
}

export default BookDetails;