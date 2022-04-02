package com.softlaboratory.springbootintegrationtest.controller;

import com.softlaboratory.springbootintegrationtest.repository.ProductRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    ProductController productController;

    @Test
    public void getAllProduct() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(200, response.getResponse().getStatus());

    }

    @Test
    public void getAllProductById() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/product/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void saveNewProduct_WithGoodPayload() throws Exception {

        JSONObject payload = new JSONObject();
        payload.put("name","test product");
        payload.put("description","test description");
        payload.put("stock", 916);
        payload.put("price",12000);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload.toString())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(200, response.getResponse().getStatus());

    }

    @Test
    public void saveNewProduct_WithBadPayload() throws Exception {

        JSONObject payload = new JSONObject();
        payload.put("name","test product");
        payload.put("description","test description");
        payload.put("stock", false);
        payload.put("price","asdasd");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload.toString())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(400, response.getResponse().getStatus());

    }

    @Test
    public void saveNewProduct_WithoutPayload() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(400, response.getResponse().getStatus());

    }

    @Test
    public void updateProduct_WithIdAndPayload() throws Exception {

    }

    @Test
    public void deleteProduct_WithId() throws Exception {

    }

}