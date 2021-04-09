const intialState = [];

export const ACTION_TYPES = {
    category_GET_ALL: "category/GET_ALL",
    //   categorys_GET_ONE: "categorys/GET_ONE",
    category_ADD: "category/ADD",
    category_UPDATE: "category/UPDATE",
    category_DELETE: "category/DELETE",
};

export const categoriesReducer = (state = intialState, action) => {
  switch (action.type) {
    case ACTION_TYPES.category_ADD:
      return [...state, action.payload];

    case ACTION_TYPES.category_GET_ALL:
      return action.payload;

    case ACTION_TYPES.category_UPDATE:
      return state.map((category) =>
        category.id === action.payload.id ? action.payload : category
      );

    case ACTION_TYPES.category_DELETE:
      return state.filter((category) => category.id !== action.payload);

    default:
      return state;
  }
};

// export const categorysReducer = (state = [], action) => ({
//     categorys_GET_ALL: action.payload,
//     categorys_ADD: [...state, action.payload],
//     categorys_UPDATE: state.map((category) =>
//         category.id === action.payload.id ? action.payload : category
//     ),
//     categorys_DELETE: state.filter((category) => category.id !== action.payload)
// });

// var c = categorysReducer()['categorys_GET_ALL'];

export const fetchcategory = (payload) => {
    console.log("Exec act", payload);
    return {
        type: ACTION_TYPES.category_GET_ALL,
        payload,
    };
};

export const addcategory = (payload) => ({
    type: ACTION_TYPES.category_ADD,
    payload,
});

export const updatecategory = (payload) => ({
    type: ACTION_TYPES.category_UPDATE,
    payload,
});

export const deletecategory = (payload) => ({
    type: ACTION_TYPES.category_DELETE,
    payload,
});
