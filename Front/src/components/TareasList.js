import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTareas, deleteTarea } from '../actions/tareasActions';

const TareasList = () => {
  const dispatch = useDispatch();
  const tareas = useSelector(state => state.tareas);
  const loading = useSelector(state => state.loading);
  const error = useSelector(state => state.error);

  useEffect(() => {
    dispatch(fetchTareas());
  }, [dispatch]);

  const handleDelete = (id) => {
    if (window.confirm('¿Estás seguro de eliminar esta tarea?')) {
      dispatch(deleteTarea(id));
    }
  };

  if (loading) {
    return <div>Cargando...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <div>
      <h2>Lista de Tareas</h2>
      <table>
        <thead>
          <tr>
            <th>Identificador</th>
            <th>Descripción</th>
            <th>Fecha de Creación</th>
            <th>Vigente</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {tareas.map(tarea => (
            <tr key={tarea.id}>
              <td>{tarea.id}</td>
              <td>{tarea.descripcion}</td>
              <td>{tarea.fechaCreacion}</td>
              <td>{tarea.vigente ? 'Sí' : 'No'}</td>
              <td>
                <button onClick={() => handleDelete(tarea.id)}>Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TareasList;