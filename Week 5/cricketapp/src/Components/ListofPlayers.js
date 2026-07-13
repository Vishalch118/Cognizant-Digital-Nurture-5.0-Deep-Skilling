export function ListofPlayers({ players }) {
  return (
    <ul>
      {players.map((player) => (
        <li key={player.name}>
          Mr. {player.name} <span>{player.score}</span>
        </li>
      ))}
    </ul>
  );
}

export function Scorebelow70({ players }) {
  const playersBelow70 = players.filter(
    (player) => player.score < 70
  );

  return (
    <ul>
      {playersBelow70.map((player) => (
        <li key={player.name}>
          Mr. {player.name} <span>{player.score}</span>
        </li>
      ))}
    </ul>
  );
}