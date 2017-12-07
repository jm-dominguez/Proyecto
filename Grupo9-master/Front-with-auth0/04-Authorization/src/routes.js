import React from 'react';
import { Redirect, Route, Router } from 'react-router-dom';
import App from './App';
import Home from './Home/Home';
import Profile from './Profile/Profile';
import Ping from './Ping/Ping';
import Admin from './Admin/Admin';
import Callback from './Callback/Callback';
import Auth from './Auth/Auth';
import history from './history';
import Pagina from './Pagina/Pagina';
import Funcionalidades from './Funcionalidades/Funcionalidades';
import CRUDMicrocontroladores from './Funcionalidades/CRUDMicrocontroladores';
import CRUDNiveles from './Funcionalidades/CRUDNiveles';
import CRUDAreas from './Funcionalidades/CRUDAreas';
import Reporte from './Funcionalidades/Reporte';
import Alertas from './Funcionalidades/Alertas';

const auth = new Auth();

const handleAuthentication = (nextState, replace) => {
  if (/access_token|id_token|error/.test(nextState.location.hash)) {
    auth.handleAuthentication();
  }
}

export const makeMainRoutes = () => {
  return (
    <Router history={history} component={App}>
        <div>
          <Route path="/" render={(props) => <App auth={auth} {...props} />} />
          <Route path="/home" render={(props) => <Home auth={auth} {...props} />} />
          <Route path="/profile" render={(props) => (
            !auth.isAuthenticated() ? (
              <Redirect to="/home"/>
            ) : (
              <Profile auth={auth} {...props} />
            )
          )} />
          <Route path="/ping" render={(props) => (
            !auth.isAuthenticated() ? (
              <Redirect to="/home"/>
            ) : (
              <Ping auth={auth} {...props} />
            )
          )} />
          <Route path="/por" render={(props) => (
            !auth.isAuthenticated() ? (
              <Redirect to="/home"/>
            ) : (
              <Funcionalidades auth={auth} {...props} />
            )
          )} />
          <Route path="/admin" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/home"/>
            ) : (
              <Admin auth={auth} {...props} />
            )
          )} />
          <Route path="/pagina" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/home"/>
            ) : (
              <Pagina auth={auth} {...props} />
            )
          )} />
          <Route path="/CRUDMicrocontroladores" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/CRUDMicrocontroladores"/>
            ) : (
              <CRUDMicrocontroladores auth={auth} {...props} />
            )
          )} />
          <Route path="/CRUDNiveles" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/CRUDNiveles"/>
            ) : (
              <CRUDNiveles auth={auth} {...props} />
            )
          )} />
          <Route path="/CRUDAreas" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/CRUDAreas"/>
            ) : (
              <CRUDAreas auth={auth} {...props} />
            )
          )} />
          <Route path="/Alertas" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/Alertas"/>
            ) : (
              <Alertas auth={auth} {...props} />
            )
          )} />
          <Route path="/Reporte" render={(props) => (
            !auth.isAuthenticated() || !auth.userHasRole(['admin']) ? (
              <Redirect to="/Reporte"/>
            ) : (
              <Reporte auth={auth} {...props} />
            )
          )} />
          <Route path="/callback" render={(props) => {
            handleAuthentication(props);
            return <Callback {...props} /> 
          }}/>        
        </div>
      </Router>
  );
}
