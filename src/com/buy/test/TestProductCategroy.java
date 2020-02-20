package com.buy.test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCategoryServiceImpl;
import entity.EasybuyProductCategory;
import org.junit.Test;

import java.util.List;

public class TestProductCategroy {
    @Test
    public void testProductCategory(){
        IProductCategoryService service=new ProductCategoryServiceImpl();
        List<EasybuyProductCategory> productCategories = service.queryAllProductCategory("0");
        for (EasybuyProductCategory category: productCategories){
            System.out.println(category.getName());
        }

    }
}
