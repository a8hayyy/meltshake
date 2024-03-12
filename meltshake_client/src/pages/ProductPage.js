import React,{ useEffect, useState } from 'react'
import Product from '../components/Product'
import { getAllProducts } from '../services/productService'

function ProductPage() {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await getAllProducts();
        setData(result);
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };

    fetchData();
  }, []);
  return (
    <>
      <h2>All Products</h2>
      <div className='productpage-container'>
          {data.map((item)=>(
            <Product
              item = {item}
            />
            ))}
      </div>
    </>
  )
}

export default ProductPage
