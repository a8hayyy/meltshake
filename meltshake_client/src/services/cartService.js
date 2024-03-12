import React from 'react'
import axios from 'axios'

const instance = axios.create({
    // baseURL : process.env.CART_BASE_URL
    baseURL : "http://localhost:8080/cart"
})

export const getCart = async () =>{
    try{
        const response = await instance.get('/');
        return response.data;
    }catch{
        console.log('Error fetching Cart Items');
    }
}

export const addToCart = async (productCode) =>{
    try{
        const response = await instance.post(`/add/${productCode}`);
        return response.data;
    }catch{
        console.log('Error adding to Cart');
    }
}

export const removeFromCart = async (productCode) =>{
    try{
        const response = await instance.delete(`/remove/${productCode}`);
        return response.data;
    }catch{
        console.log('Error removing from Cart');
    }
}

export const deleteCart = async () =>{
    try{
        const response = await instance.delete('/clear');
        return response.data;
    }catch{
        console.log('Error removing from Cart');
    }
}

