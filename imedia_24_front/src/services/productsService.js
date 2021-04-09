import {apiClient} from "../api";

import {
    addproducts,
    deleteproducts,
    fetchproducts,
    updateproducts,
} from "../redux/products.reducer";

const API_URI = "/products";
export const productsService = {
    fetchAll: () => (dispatch) =>
        apiClient
            .get(API_URI+"/all")
            .then(({data}) => dispatch(fetchproducts(data))),
    create: (body) => (dispatch) =>
        apiClient
            .post(API_URI, body)
            .then(({data}) => dispatch(addproducts(data))),
    delete: (id) => (dispatch) =>
        apiClient
            .delete(`${API_URI}/${id}/delete`)
            .then(() => dispatch(deleteproducts(id))),
    update: (body, id) => (dispatch) =>
        apiClient
            .put(`${API_URI}/${id}/modify`, body)
            .then(() => dispatch(updateproducts(body))),
};
