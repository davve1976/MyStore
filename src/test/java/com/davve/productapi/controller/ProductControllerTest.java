package com.davve.productapi.controller;

import com.davve.productapi.model.Product;
import com.davve.productapi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void testListProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(Arrays.asList(
                new Product(1L, "Product A", "Description A", 100.0),
                new Product(2L, "Product B", "Description B", 150.0)
        ));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'name':'Product A'},{'id':2,'name':'Product B'}]"));
    }

    @Test
    void testGetProduct() throws Exception {
        when(productService.getProductById(1L)).thenReturn(new Product(1L, "Product A", "Description A", 100.0));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'name':'Product A'}"));
    }
}


