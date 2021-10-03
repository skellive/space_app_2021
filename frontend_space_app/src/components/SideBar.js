import React from 'react';
import {Link} from 'react-router-dom'
import routes from '../pages/routes'
const Sidebar = () => {
    return(
        <ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon">
          <img src="img/logo/logo2.png"/>
        </div>
        <div class="sidebar-brand-text mx-3">RuangAdmin</div>
      </a>
      <hr class="sidebar-divider my-0"/>
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>
      <hr class="sidebar-divider"/>
      <div class="sidebar-heading">
        Features
      </div>
      {
        routes.map((route, index) => {
          return (
            <li class="nav-item">
              <Link class="nav-link" to={route.path}>
                {route.icon}
                <span>{route.name}</span>
              </Link>
            </li>
          )
        })
      }
      
    </ul>
    )

}
export default Sidebar;