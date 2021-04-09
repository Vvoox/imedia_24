import * as React from "react";
import Grid from "@material-ui/core/Grid";
import MaterialTable from "material-table";
import {tableIcons} from "./tableIcons";
import {connect} from "react-redux";
import { productsService} from "../services/productsService";

class ProductsView extends React.Component {
    constructor(props) {
        super();
        this.state = {
            columns: [{title: "id", field: "id", hidden: true},
                {title: "Product Name", field: "productName"},
                {title: "Price", field: "price"},
                // {title: "Designation", field: "designationBCRecu"},
                // {title: "Devise Facture", field: "devise"},
                // {title: "Date Facture", field: "dateFacture", type: "date"},
                // {
                //     title: "Statut Facture",
                //     field: "statut",
                //     lookup: {PAYÉ: "Payée", "EN ATTENTE": "En attente"},
                // },
            ]
        }
        props.fetchAll();
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
                            title="Products List"
                            columns={columns}
                            data={this.props.products}
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
                                            <strong>Product Name</strong>
                                        </h1>
                                        <div style={{marginBottom: "10px"}}>
                                            {rowData.productName}
                                        </div>
                                        <h1>
                                            <strong>Price</strong>
                                        </h1>
                                        <div style={{marginBottom: "10px"}}>
                                            {rowData.price}
                                        </div>
                                        {/*<h1>*/}
                                        {/*    <strong>Designation de bon de commande reçu</strong>*/}
                                        {/*</h1>*/}
                                        {/*<div style={{marginBottom: "10px"}}>*/}
                                        {/*    {rowData.designationBCRecu}*/}
                                        {/*</div>*/}
                                        {/*<h1>*/}
                                        {/*    <strong>Date de la facture</strong>*/}
                                        {/*</h1>*/}
                                        {/*<div style={{marginBottom: "10px"}}>*/}
                                        {/*    {new Date(rowData.dateFacture).toLocaleString()}*/}
                                        {/*</div>*/}
                                        {/*<h1>*/}
                                        {/*    <strong>Devise de la facture</strong>*/}
                                        {/*</h1>*/}
                                        {/*<div style={{marginBottom: "10px"}}>{rowData.devise}</div>*/}
                                        {/*<h1>*/}
                                        {/*    <strong>statut</strong>*/}
                                        {/*</h1>*/}
                                        {/*<div style={{marginBottom: "10px"}}>{rowData.statut}</div>*/}
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

export const ProductsViewState = connect(
    state => state,
    productsService
)(ProductsView);
