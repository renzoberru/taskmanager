import axios from 'axios';

// Constantes de acción
export const FETCH_TAREAS_REQUEST = 'FETCH_TAREAS_REQUEST';
export const FETCH_TAREAS_SUCCESS = 'FETCH_TAREAS_SUCCESS';
export const FETCH_TAREAS_FAILURE = 'FETCH_TAREAS_FAILURE';
export const CREATE_TAREA_SUCCESS = 'CREATE_TAREA_SUCCESS';
export const UPDATE_TAREA_SUCCESS = 'UPDATE_TAREA_SUCCESS';
export const DELETE_TAREA_SUCCESS = 'DELETE_TAREA_SUCCESS';

// Acción para obtener todas las tareas
export const fetchTareas = () => {
  return (dispatch) => {
    dispatch(fetchTareasRequest());
    axios.get('${process.env.REACT_APP_API_URL}/api/tasks/GetAll')
      .then(response => {
        dispatch(fetchTareasSuccess(response.data));
      })
      .catch(error => {
        dispatch(fetchTareasFailure(error.message));
      });
  };
};

const fetchTareasRequest = () => {
  return {
    type: FETCH_TAREAS_REQUEST
  };
};

const fetchTareasSuccess = (tareas) => {
  return {
    type: FETCH_TAREAS_SUCCESS,
    payload: tareas
  };
};

const fetchTareasFailure = (error) => {
  return {
    type: FETCH_TAREAS_FAILURE,
    payload: error
  };
};

// Acción para crear una tarea
export const createTarea = (tarea) => {
  return (dispatch) => {
    axios.post('${process.env.REACT_APP_API_URL}/api/tasks/Create', tarea)
      .then(response => {
        dispatch(createTareaSuccess(response.data));
      })
      .catch(error => {
        console.error(error);
      });
  };
};

const createTareaSuccess = (tarea) => {
  return {
    type: CREATE_TAREA_SUCCESS,
    payload: tarea
  };
};

// Acción para actualizar una tarea
export const updateTarea = (id, tarea) => {
  return (dispatch) => {
    axios.put(`${process.env.REACT_APP_API_URL}/api/tasks/Update`, tarea)
      .then(response => {
        dispatch(updateTareaSuccess(response.data));
      })
      .catch(error => {
        console.error(error);
      });
  };
};

const updateTareaSuccess = (tarea) => {
  return {
    type: UPDATE_TAREA_SUCCESS,
    payload: tarea
  };
};

// Acción para eliminar una tarea
export const deleteTarea = (id) => {
  return (dispatch) => {
    axios.delete(`${process.env.REACT_APP_API_URL}/api/tasks/Remove/${id}`)
      .then(() => {
        dispatch(deleteTareaSuccess(id));
      })
      .catch(error => {
        console.error(error);
      });
  };
};

const deleteTareaSuccess = (id) => {
  return {
    type: DELETE_TAREA_SUCCESS,
    payload: id
  };
};