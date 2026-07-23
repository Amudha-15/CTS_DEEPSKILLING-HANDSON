import React from "react";
import Cart from "./Cart";

function OnlineShopping() {

    const cartItems = [
        new Cart("Laptop", 55000),
        new Cart("Mobile", 25000),
        new Cart("Headphones", 3000),
        new Cart("Smart Watch", 5000),
        new Cart("Keyboard", 1500)
    ];

    return (
        <div>
            <h1>Online Shopping Cart</h1>

            <table border="1" cellPadding="10">
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Price (₹)</th>
                    </tr>
                </thead>

                <tbody>
                    {cartItems.map((item, index) => (
                        <tr key={index}>
                            <td>{item.itemName}</td>
                            <td>{item.price}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default OnlineShopping;