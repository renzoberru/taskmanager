import {
  FETCH_TAREAS_REQUEST,
  FETCH_TAREAS_SUCCESS,
  FETCH_TAREAS_FAILURE,
  CREATE_TAREA_SUCCESS,
  UPDATE_TAREA_SUCCESS,
  DELETE_TAREA_SUCCESS
} from '../actions/tareasActions';

const initialState = {
  tareas: [],
  loading: false,
  error: null
};

const tareasReducer = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_TAREAS_REQUEST:
      return {
        ...state,
        loading: true,
        error: null
      };
    case FETCH_TAREAS_SUCCESS:
      return {
        ...state,
        loading: false,
        tareas: action.payload
      };
    case FETCH_TAREAS_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload
      };
    case CREATE_TAREA_SUCCESS:
      return {
        ...state,
        tareas: [...state.tareas, action.payload]
      };
    case UPDATE_TAREA_SUCCESS:
      return {
        ...state,
        tareas: state.tareas.map(tarea =>
          tarea.id === action.payload.id ? action.payload : tarea
        )
      };
    case DELETE_TAREA_SUCCESS:
      return {
        ...state,
        tareas: state.tareas.filter(tarea => tarea.id !== action.payload)
      };
    default:
      return state;
  }
};

export default tareasReducer;