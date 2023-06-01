import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { createTarea, updateTarea } from '../actions/tareasActions';
import { useNavigate } from 'react-router-dom';
import { useParams } from 'react-router-dom';

const TareaForm = () => {
  const dispatch = useDispatch();
  const { id } = useParams();
  const [descripcion, setDescripcion] = useState('');
  const [vigente, setVigente] = useState(true);
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const tarea = {
      descripcion,
      vigente,
      fechaCreacion: new Date().toISOString()
    };

    if (id) {
      dispatch(updateTarea(id, tarea));
    } else {
      dispatch(createTarea(tarea));
    }

    navigate('/');
  };

  return (
    <div>
      <h2>{id ? 'Editar Tarea' : 'Crear Tarea'}</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="descripcion">Descripción:</label>
          <input
            type="text"
            id="descripcion"
            value={descripcion}
            onChange={event => setDescripcion(event.target.value)}
          />
        </div>
        <div>
          <label htmlFor="vigente">Vigente:</label>
          <input
            type="checkbox"
            id="vigente"
            checked={vigente}
            onChange={event => setVigente(event.target.checked)}
          />
        </div>
        <button type="submit">{id ? 'Guardar Cambios' : 'Crear'}</button>
      </form>
    </div>
  );
};

export default TareaForm;
