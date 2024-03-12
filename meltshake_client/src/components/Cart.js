import React, { useEffect, useState } from 'react';
import '../App.css'
import { removeFromCart,addToCart } from '../services/cartService';


function Cart({ item }) {
    const {productcode, quantity} = item;
    const addCart = async (productCode)=>{
      try{
        const result = await addToCart(productCode)
        if(result){
          console.log("ADDED "+productCode)
        }
      }catch(error){
        console.log("Error adding to cart in Cart Component", error)
      } 
    }

    const removeCart = async (productCode)=>{
      try{
        const result = await removeFromCart(productCode)
        if(result){
          console.log("REMOVED "+productCode)
        }
      }catch(error){
        console.log("Error removing to cart in Cart Component", error)
      } 
    }

    useEffect(()=>{

    },[quantity])


  return (
    <div className='cart-container'>
          <div><p>{productcode}</p></div>
          <div className='cart-inner-container'>
          <button onClick={()=> removeCart(productcode)}>-</button>
          <p>{quantity}</p>
          <button onClick={()=> addCart(productcode)}>+</button>
          </div>
    </div>
  )
}

export default Cart
