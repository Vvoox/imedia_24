import * as React from "react";
import Grid from "@material-ui/core/Grid";
import MaterialTable from "material-table";
import {connect} from "react-redux";
import {categoriesService} from "../services/categoriesService";
import {tableIcons} from "./tableIcons";
import PropTypes from 'prop-types';

class CategoriesView extends React.Component {
    constructor(props) {
        super(props);
        props.fetchAll();
        this.state = {
            columns: [{title: "id", field: "id", hidden: true},
                {
                    title: "Category Name",
                    field: "categoryName",
                },
                {title: "Category Type", field: "categoryType"},]
        };
    }

    handleRowAdd = (newData, resolve) => this.props.create(newData).then(resolve);

    handleRowUpdate = (newData, oldData, resolve) => this.props.update(newData, oldData.id).then(resolve);

    handleRowDelete = (oldData, resolve) => this.props.delete(oldData.id).then(resolve);


    render() {
        const {iserror, errorMessages, columns} = this.state;
        return (
            <div className="App">
                <Grid container spacing={1}>
                    <Grid item xs={1}></Grid>

                    <Grid item xs={10}>
                        <div>
                            {iserror && (
                                <div>
                                    {errorMessages.map((msg, i) => {
                                        return <div key={i}>{msg}</div>;
                                    })}
                                </div>
                            )}
                        </div>
                        <MaterialTable
                            title="Categories List"
                            columns={columns}
                            data={this.props.categories}
                            icons={tableIcons}
                            editable={{
                                onRowUpdate: (newData, oldData) =>
                                    new Promise((resolve) => {
                                        this.handleRowUpdate(newData, oldData, resolve);
                                    }),
                                onRowAdd: (newData) =>
                                    new Promise((resolve) => {
                                        this.handleRowAdd(newData, resolve);
                                    }),
                                onRowDelete: (oldData) =>
                                    new Promise((resolve) => {
                                        this.handleRowDelete(oldData, resolve);
                                    }),
                            }}
                            detailPanel={(rowData) => {
                                return (
                                    <div style={{padding: "10px"}}>
                                        <h1>
                                            <strong>Category Name</strong>
                                        </h1>
                                        <div style={{marginBottom: "10px"}}>
                                            {rowData.categoryName}
                                        </div>
                                        <h1>
                                            <strong>Category Type</strong>
                                        </h1>
                                        <div style={{marginBottom: "10px"}}>{rowData.categoryType}</div>
                                    </div>
                                );
                            }}
                        />
                    </Grid>
                    <Grid item xs={1}></Grid>
                </Grid>
            </div>
        );
    }
}

CategoriesView.propTypes = {
    fournisseurs: PropTypes.array,
    fetchAllo: PropTypes.func,
    create: PropTypes.func,
    update: PropTypes.func,
    delete: PropTypes.func,
};

export const CategoriesViewState = connect(
    state => state,
    categoriesService
)(CategoriesView);
