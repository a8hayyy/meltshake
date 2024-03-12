import React, { useState, useEffect } from 'react';
import '../App.css'
import Cart from '../components/Cart';
import { getCart, deleteCart } from '../services/cartService';
import { getProductById } from '../services/productService';

function CartPage() {
  const [cartItems, setCartItems] = useState([]);
  const [totalBill, setTotalBill] = useState(0);

  useEffect(() => {
    const fetchData = async ()=>{
      try {
        const cart = await getCart();
        // const items = cart.items || [];
        setCartItems(cart);
        // console.log(cartItems);
        
        let totalPrice = 0;
        for (const item of cart) {
          const product = await getProductById(item.productcode);
          totalPrice += product.price * item.quantity;
        }
        setTotalBill(totalPrice);
      } catch (error) {
        console.error('Error fetching cart items:', error);
      }
    };
    
    fetchData();
  }, [cartItems]);

  const clearCart = async ()=>{
    try{
      const result = await deleteCart();
      console.log(result);
    }catch(error){
      console.error('Error Deleting cart: '+error);
    }
  };

  return (
    <div className='cartpage-container'>
      {
        cartItems.map((item)=>(
          <Cart
            item={item}
          />
        ))
      }
      <div className='cartpage2'>
      <h2>Total Bill: ${totalBill}</h2>
        <button onClick={()=>{clearCart()}}>
          Clear Cart
        </button>
      </div>
    </div>
  );
}

export default CartPage;
