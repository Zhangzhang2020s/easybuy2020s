package com.buy.service.product;

import java.util.List;

public interface IProductCategoryService {
    //获取商品的一级分类
    List<entity.EasybuyProductCategory> queryAllProductCategory(String parentId);
}
