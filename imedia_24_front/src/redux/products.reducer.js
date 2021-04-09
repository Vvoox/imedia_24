const intialState = [];

export const ACTION_TYPES = {
  products_GET_ALL: "products/GET_ALL",
  products_ADD: "products/ADD",
  products_UPDATE: "products/UPDATE",
  products_DELETE: "products/DELETE",
};

export const productsReducer = (state = intialState, action) => {
  switch (action.type) {
    case ACTION_TYPES.products_ADD:
      return [...state, action.payload];

    case ACTION_TYPES.products_GET_ALL:
      // console.log("Reducing", action);
      return action.payload;

    case ACTION_TYPES.products_UPDATE:
      return state.map((product) =>
          product.id === action.payload.id ? action.payload : product
      );

    case ACTION_TYPES.products_DELETE:
      return state.filter((product) => product.id !== action.payload);

    default:
      return state;
  }
};

export const fetchproducts = (payload) => {
  console.log("Exec act", payload);
  return {
    type: ACTION_TYPES.products_GET_ALL,
    payload,
  };
};

export const addproducts = (payload) => ({
  type: ACTION_TYPES.products_ADD,
  payload,
});

export const updateproducts = (payload) => ({
  type: ACTION_TYPES.products_UPDATE,
  payload,
});

export const deleteproducts = (payload) => ({
  type: ACTION_TYPES.products_DELETE,
  payload,
});
