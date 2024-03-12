import React,{ useState, useEffect } from 'react'
import { getProductById } from '../../services/productService'
import Product from '../Product';
import '../../App.js'

function PopularProduct() {
  const [item1,setItem1] = useState([]);
  const [item2,setItem2] = useState([]);
  const [item3,setItem3] = useState([]);
  const [item4,setItem4] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result1 = await getProductById("A");
        const result2 = await getProductById("B");
        const result3 = await getProductById("C");
        const result4 = await getProductById("D");
        setItem1(result1);
        setItem2(result2);
        setItem3(result3);
        setItem4(result4);
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <div>
        <h2>Popular Products</h2>
      </div>
      <div className='productpage-container'>
      <Product
        item = {item1}
      />
      <Product
        item = {item2}
      />
      <Product
        item = {item3}
      />
      <Product
        item = {item4}
      />
      </div>
    </div>
  )
}

export default PopularProduct
