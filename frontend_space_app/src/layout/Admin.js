import React, { useState, useEffect } from "react";
import Sidebar from "../components/SideBar";
import Navbar from "../components/NavBar";
import Footer from "../components/Footer";
import io from "socket.io-client";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import routes from "../pages/routes";

const Admin = () => {
  const [socket, setSocket] = useState(null);

  return (
    <Router>
      <div id="wrapper">
        <Sidebar />
        <div id="content-wrapper" class="d-flex flex-column">
          <div id="content">
            <Navbar />

            <div class="container-fluid" id="container-wrapper">
              <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h3 mb-0 text-gray-800">Blank Page</h1>
                <ol class="breadcrumb">
                  <li class="breadcrumb-item">
                    <a href="./">Home</a>
                  </li>
                  <li class="breadcrumb-item">Pages</li>
                  <li class="breadcrumb-item active" aria-current="page">
                    Blank Page
                  </li>
                </ol>
              </div>
              <div class="row">
                <div class="col-xl-12 col-lg-12">
                  <Switch>
                    {routes.map((route, index) => {
                      return (
                        <Route
                          key={index}
                          path={route.path}
                          exact={route.exact}
                        >
                          {<route.component />}
                        </Route>
                      );
                    })}
                  </Switch>
                </div>
              </div>
            </div>
            <Footer />
          </div>{" "}
        </div>
      </div>
    </Router>
  );
};
export default Admin;
