import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 82 },
        { name: "Rohit Sharma", score: 95 },
        { name: "Shubman Gill", score: 76 },
        { name: "KL Rahul", score: 65 },
        { name: "Hardik Pandya", score: 89 },
        { name: "Ravindra Jadeja", score: 58 },
        { name: "Rishabh Pant", score: 91 },
        { name: "Suryakumar Yadav", score: 67 },
        { name: "Jasprit Bumrah", score: 72 },
        { name: "Mohammed Siraj", score: 60 },
        { name: "Kuldeep Yadav", score: 85 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <h3>All Players</h3>

            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

            <h3>Players with Score Below 70</h3>

            <ul>
                {lowScorePlayers.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default ListofPlayers;