import React, { useEffect, useState } from 'react';
import { addToCart } from '../services/cartService';
import '../App.js'

function Product({ item }) {
  const { productcode, flavour, size, price, quantity } = item;
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    // Fetch any additional data if needed
  }, []);

  const addCart = async (code) => {
    try {
      setIsLoading(true);
      const result = await addToCart(code);
      if (result !== null) {
        console.log("Product Added: " + code);
        // Optionally, you can update the UI or do other tasks after adding to cart
      }
    } catch (error) {
      console.log("Error adding to cart:", error);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className='product-main'>
      <div>
        <p>Product Code: {productcode}</p>
        <p>Flavour: {flavour}</p>
        <p>Size: {size}</p>
        <p>Price: {price}</p>
        <p>Quantity: {quantity}</p>
      </div>
      <div>
        <button onClick={() => addCart(productcode)} disabled={isLoading}>
          {isLoading ? 'Adding...' : 'Add'}
        </button>
        {/* Uncomment this block if you want to add a remove button */}
        {/* <button onClick={() => removeCart(productcode)}>-</button> */}
      </div>
    </div>
  );
}

export default Product;
