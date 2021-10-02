import React, { useState, useEffect } from "react";
import Sidebar from "../components/SideBar";
import Navbar from "../components/NavBar";
import Footer from "../components/Footer";
import io from "socket.io-client";

const Admin = () => {
  const [socket, setSocket] = useState(null);

  return (
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
                <div class="card shadow mb-4">
                  <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">
                      Blank Page
                    </h6>
                  </div>
                  <div class="card-body">
                    <p>
                      This is an example of a blank page that you can use as a
                      starting point for creating new ones.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <Footer />
        </div>{" "}
      </div>
    </div>
  );
};
export default Admin;
