import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage'
import CartPage from './pages/CartPage'
import ProductPage from './pages/ProductPage'
import NavBar from './components/NavBar'
import { Link } from 'react-router-dom';

function App() {
  return (
    <Router>
    <div>
      <Link>
        <NavBar/>
      </Link>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<ProductPage />} />
        <Route path="/cart" element={<CartPage />} />
      </Routes>
    </div>
    </Router>
  );
}

export default App;
