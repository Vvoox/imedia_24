import { apiClient } from "../api";

import {
  fetchcategory,
  addcategory,
  deletecategory,
  updatecategory,
} from "../redux/categories.reducer";

const API_URI = "/categories";
export const categoriesService = {
  fetchAll: () => (dispatch) =>
    apiClient
      .get(API_URI+"/all")
      .then(({ data }) => dispatch(fetchcategory(data))),
  create: (body) => (dispatch) =>
    apiClient
      .post(API_URI, body)
      .then(({ data }) => dispatch(addcategory(data))),
  delete: (id) => (dispatch) =>
    apiClient
      .delete("/categories/" + id+"/delete")
      .then(() => dispatch(deletecategory(id))),
  update: (body, id) => (dispatch) =>
    apiClient
      .put("/categories/" + id + "/modify", body)
      .then(() => dispatch(updatecategory(body))),
};
