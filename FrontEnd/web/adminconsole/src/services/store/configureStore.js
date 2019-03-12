import {createStore , applyMiddleware} from  "react-redux";
import rootReducer from "./reducer";
import  reduxImmutableStateInvariant from "redux-immutable-state-invariant";
import thunk from "redux-thunk";
export default function configureStore(initialState)
{
return createStore(rootReducer,initialState),applyMiddleware(thunk,reduxImmutableStateInvariant());   


}