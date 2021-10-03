import { createStore, combineReducers, compose, applyMiddleware } from "redux";
import { loadState } from "./state";
import thunk from "redux-thunk";
import { persistStore, persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";

const rootReducer = combineReducers({});

const persistConfig = {
  key: "root",
  storage,
};

const persistedReducer = persistReducer(persistConfig, rootReducer);
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export const generateStore = () => {
  const initialData = loadState();

  const store = createStore(
    persistedReducer,
    initialData,
    composeEnhancers(applyMiddleware(thunk))
  );

  const persistor = persistStore(store);

  return { store, persistor };
};
