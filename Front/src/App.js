import logo from './logo.svg';
import './App.css';
import React from 'react';
import { Link } from 'react-router-dom';

const App = () => {
  return (
    <div>
      <h1>Mantenedor de Tareas</h1>
      <nav>
        <ul>
          <li>
            <Link to="/tareas/nueva">Crear Tarea</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default App;
