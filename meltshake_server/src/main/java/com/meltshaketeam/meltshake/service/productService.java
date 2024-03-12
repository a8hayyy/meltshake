package com.meltshaketeam.meltshake.service;


import java.util.List;

import com.meltshaketeam.meltshake.bean.cartBean;
import com.meltshaketeam.meltshake.bean.productBean;

public interface productService {
    List<productBean> getAllProducts();
    productBean getProductByProductcode(String productCode);
    
    List<cartBean> getCart();
    String addItem(String id);
    String removeItem(String id);
    String deleteAll();
}

