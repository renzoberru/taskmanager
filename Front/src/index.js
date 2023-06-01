import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './store';
import TareasList from './components/TareasList';
import TareaForm from './components/TareaForm';

ReactDOM.render(
  <Provider store={store}>
    <Router>
      <Routes>
        <Route path="/" element={<TareasList />} />
        <Route path="/tareas/nueva" element={<TareaForm />} />
        <Route path="/tareas/editar/:id" element={<TareaForm />} />
      </Routes>
    </Router>
  </Provider>,
  document.getElementById('root')
);