package com.cisco.mproduits.controller;

import com.mproduits.dao.ProductDao;
import com.cisco.mproduits.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundException;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest extends TestCase {

    @Mock
    ProductDao productDao;

    @InjectMocks
    private com.mproduits.web.controller.ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("GET /Produits")
    public void testListeDesProduitsNulle() throws ProductNotFoundException {

        Mockito.when(productDao.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            productController.listeDesProduits();
        });

    }

    @Test
    @DisplayName("GET /Produits")
    public void testListeDesProduits() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Iphone 11","Apple Product",null,200000.0));
        Mockito.when(productDao.findAll()).thenReturn(products);
        assertThat(productController.listeDesProduits().isEmpty(), is(false));

    }

    @Test
    @DisplayName("GET /Produits/{id}")
    public void testRecupererUnProduit() {

        Product product = new Product(1,"Iphone 11","Apple Product",null,200000.0);
        Mockito.when(productDao.findById(1)).thenReturn(Optional.of(product));
        assertThat(productController.recupererUnProduit(1).get().getPrix(), is(product.getPrix()));

    }
}