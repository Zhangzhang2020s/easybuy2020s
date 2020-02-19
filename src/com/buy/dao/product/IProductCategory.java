package com.buy.dao.product;

import java.util.List;

public interface IProductCategory {
    //获取商品的一级分类
    List<entity.EasybuyProductCategory> queryAllProductCategory(String parentId);
}
