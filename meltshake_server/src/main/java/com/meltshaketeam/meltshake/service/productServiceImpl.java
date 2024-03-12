package com.meltshaketeam.meltshake.service;

import com.meltshaketeam.meltshake.dao.productDao;
import com.meltshaketeam.meltshake.dao.cartDao;
import com.meltshaketeam.meltshake.entity.cartEntity;
import com.meltshaketeam.meltshake.entity.productEntity;
import com.meltshaketeam.meltshake.bean.productBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meltshaketeam.meltshake.bean.cartBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@Service
public class productServiceImpl implements productService {
	
	
    private final productDao productDao;
    
    private final cartDao cartDao;

    @Autowired
    public productServiceImpl(productDao productDao, cartDao cartDao) {
        this.productDao = productDao;
        this.cartDao = cartDao;
    }
    
//    @PostConstruct
//    public void init() {
//        saveProducts();
//    }
//
//    private void saveProducts() {
//        productDao.saveAll(List.of(
//            new productEntity( "A","A", "500ml", 1, 120.0),
//            new productEntity("B","B", "500ml", 1, 120.0 ),
//            new productEntity( "C","C", "500ml", 1, 120.0),
//            new productEntity("D","D", "500ml", 1, 120.0 )
//        ));
//    }

    @Override
    public List<productBean> getAllProducts() {
        return convertToBeanList(productDao.findAll());
    }
    
    @Override
    public productBean getProductByProductcode(String productcode) {
    	productBean productbean = new productBean();
    	productEntity productentity = productDao.findByProductcode(productcode);
    	productbean = convertToBean(productentity);
    	
    	return productbean;
    }
    
    @Override
    public List<cartBean> getCart(){
    	return convertToCartBeanList(cartDao.findAll());
    }
    
    
//    @SuppressWarnings("null")
	@Override
    public String addItem(String productcode) {
    	cartEntity cartItem = cartDao.findByProductcode(productcode);
    	if(cartItem != null) {
    		cartItem.setQuantity(cartItem.getQuantity()+1);
    		cartDao.save(cartItem);
    		return "Saved";
    	}else {
    		cartItem = new cartEntity();
    		cartItem.setProductcode(productcode);
    		cartItem.setQuantity(1);
    		cartDao.save(cartItem);
    		return "Saved";
    	}
    }
    
    @Override
    public String removeItem(String productcode) {
    	cartEntity cartItem = cartDao.findByProductcode(productcode);
    	if(cartItem != null) {
    		if(cartItem.getQuantity()==1) {
    			cartDao.delete(cartItem);
        		return "No_Item_Left";
    		}
    		cartItem.setQuantity(cartItem.getQuantity()-1);
    		cartDao.save(cartItem);
    		return "Removed";
    	}
    	return "Not Found";
    }
    
    @Override
    public String deleteAll() {
    	cartDao.deleteAll();
    	return "Cart Deleted";
    }
    
    public productBean convertToBean(productEntity productentity) {
    	productBean productbean = new productBean();
    	productbean.setFlavour(productentity.getFlavour());
    	productbean.setSize(productentity.getSize());
    	productbean.setQuantity(productentity.getQuantity());
    	productbean.setPrice(productentity.getPrice());
    	productbean.setProductcode(productentity.getProductcode());
    	
    	return productbean;
    }
    
    public productEntity convertToEntity(productBean productbean) {
    	productEntity productentity = new productEntity();
    	productentity.setProductcode(productbean.getProductcode());
    	productentity.setFlavour(productbean.getFlavour());
    	productentity.setSize(productbean.getSize());
    	productentity.setQuantity(productbean.getQuantity());
    	productentity.setPrice(productbean.getPrice());
    	
    	return productentity;
    }
    
    public List<productBean> convertToBeanList(List<productEntity> productentitylist){
    	List<productBean> productbeanlist = new ArrayList<>();
    	for(productEntity productentity : productentitylist) {
    		productbeanlist.add(convertToBean(productentity));
    	}
    	return productbeanlist;
    }
    
    public List<productEntity> convertToEntityList(List<productBean> productbeanlist){
    	List<productEntity> productentitylist = new ArrayList<>();
    	for(productBean productbean : productbeanlist) {
    		productentitylist.add(convertToEntity(productbean));
    	}
    	return productentitylist;
    }
    
    public cartBean convertToCartBean(cartEntity cartEntity) {
        cartBean cartBean = new cartBean();
        cartBean.setId(cartEntity.getId());
        cartBean.setProductcode(cartEntity.getProductcode());
        cartBean.setQuantity(cartEntity.getQuantity());
        
        return cartBean;
    }

    public cartEntity convertToCartEntity(cartBean cartBean) {
        cartEntity cartEntity = new cartEntity();
        cartEntity.setId(cartBean.getId());
        cartEntity.setProductcode(cartBean.getProductcode());
        cartEntity.setQuantity(cartBean.getQuantity());
        
        return cartEntity;
    }

    public List<cartBean> convertToCartBeanList(List<cartEntity> cartEntityList) {
        List<cartBean> cartBeanList = new ArrayList<>();
        for (cartEntity cartEntity : cartEntityList) {
            cartBeanList.add(convertToCartBean(cartEntity));
        }
        return cartBeanList;
    }

    public List<cartEntity> convertToCartEntityList(List<cartBean> cartBeanList) {
        List<cartEntity> cartEntityList = new ArrayList<>();
        for (cartBean cartBean : cartBeanList) {
            cartEntityList.add(convertToCartEntity(cartBean));
        }
        return cartEntityList;
    }
}