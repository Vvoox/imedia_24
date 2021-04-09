import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import {Provider} from "react-redux";
import {applyMiddleware, createStore} from "redux";
import {ChakraProvider} from "@chakra-ui/react";
import {NavigationLayout} from "./layout/NavigationLayout";
import thunk from "redux-thunk";
import rootReducer from "./redux";

export const store = createStore(rootReducer, applyMiddleware(thunk));



ReactDOM.render(
        <ChakraProvider>
            <Provider store={store}>
                <NavigationLayout/>
            </Provider>
        </ChakraProvider>,
    document.getElementById("root")
);

reportWebVitals();
