import React, { useState } from 'react';
import { Link } from 'react-router-dom'
import LOGO_IMG from '../resources/cart.png'
import '../App.js'

const NavBar = () => {
  return (
    <nav className="navbar">
      <div className="logo">
        {/* <img src={LOGO_IMG}/> */}
      </div>

      <div>
      <ul className="nav-menu">
        <li className='nav-item'>
          <Link to='/'>About</Link>
        </li>
        <li className='nav-item'><Link to='/products'>Products</Link></li>
      </ul>
      </div>

      <div className="user-icons">
          <ul className="nav-menu">
            <li className='nav-item'><Link to='/cart'>Shopping Cart</Link></li>
            <li className='nav-item'><Link to='/login'>Login</Link></li>
          </ul>
      </div>
    </nav>
  );
};

export default NavBar;
