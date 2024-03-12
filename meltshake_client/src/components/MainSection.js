import React from 'react'
import '../App.js'
import Introduction from './Main/Introduction'
import Introduction2 from './Main/Introduction2'
import PopularProduct from './Main/PopularProduct'
import ProductPage from '../pages/ProductPage'

function MainSection() {
  return (
    <div>
      <Introduction/>
      <PopularProduct/>
      <Introduction2/>
      <ProductPage/>
    </div>
  )
}

export default MainSection
