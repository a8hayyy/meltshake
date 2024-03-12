import React from 'react'
import axios from 'axios'

const instance = axios.create({
    // baseURL : process.env.PRODUCT_BASE_URL
    baseURL : "http://localhost:8080"
})

export const getAllProducts = async () =>{
    try{
        const response = await instance.get('/products');
        return response.data;
    }catch{
        console.log('Error fetching Products');
    }
}

export const getProductById = async (productCode) =>{
    try{
        const response = await instance.get(`/products/${productCode}`);
        return response.data;
    }catch{
        console.log('Error fetching Product by ID');
    }
}

