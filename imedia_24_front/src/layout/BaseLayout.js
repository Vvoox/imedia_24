// import getRoutes from "./routes";
// import { ReduxAsyncConnect } from "redux-async-connect";
// import { applyRouterMiddleware, browserHistory, Router } from "react-router";
// import useScroll from "react-router-scroll";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
// import { Fournisseurs } from "../views/Fournisseurs";
import { BonCommandeRecus } from "../views/BonCommandeRecus";
import { FactureEmises } from "../views/FactureEmises";

import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import Box from "@material-ui/core/Box";
import Link from "@material-ui/core/Link";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export const BaseLayoutRouter = (props) => {
  const classes = useStyles();

  return (
    <Router>
      <div>
        <AppBar position="static">
          <Typography className={classes.root}>
            <Link component="button" to="/">
              Fournisseurs
            </Link>
            <Link component="button" to="/bons">
              Bon de commades
            </Link>
          </Typography>
        </AppBar>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          {/* <Route path="/" exact="true">
            <Fournisseurs />
          </Route> */}
          <Route path="/bons">
            <BonCommandeRecus />
          </Route>
          <Route path="/factures">
            <FactureEmises />
          </Route>
        </Switch>
      </div>
    </Router>
  );
};
