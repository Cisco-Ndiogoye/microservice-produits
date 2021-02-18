package com.cisco.mproduits.model;

import com.cisco.mproduits.model.Product;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ProductTest {

    private static Product product;

    @Rule
    public ExpectedException expectation = ExpectedException.none();

    @BeforeEach
    public void setup() {
        product = new com.cisco.mproduits.model.Product(1,"Iphone 11","Apple Product",null,200000.0);
    }

    @Test
    public void testGetId() {
        assertThat(product.getId(), is(1));
    }

    @Test
    public void testSetId() {
        product.setId(2);
        assertThat(product.getId(), not(1));
    }

    @Test
    public void testGetTitre() {
        assertThat(product.getTitre(), is("Iphone 11"));
    }

    @Test
    public void testSetTitre() {
        product.setTitre("Iphone 12");
        assertThat(product.getTitre(), not("Iphone 11"));
    }

    @Test
    public void testGetDescription() {
        assertThat(product.getDescription(), is("Apple Product"));
    }

    @Test
    public void testSetDescription() {
        product.setDescription("Apple Product 2");
        assertThat(product.getDescription(), not("Apple Product"));
    }

    @Test
    public void testGetImage() {

        expectation.expect(NullPointerException.class);
        product.getImage();

    }

    @Test
    public void testSetImage() {
        product.setImage("Image");
        Assert.assertNotNull(product.getImage());
    }

    @Test
    public void testGetPrix() {
        assertThat(product.getPrix(), is(200000.0));
    }

    @Test
    public void testSetPrix() {
        product.setPrix(350000.00);
        assertThat(product.getPrix(), not(200000.0));
    }

    @Test
    public void testToString() {
        Assertions.assertTrue(product.toString().contains(product.getTitre()));
    }
}