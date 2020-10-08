package com.fetchrewards.demo.emailvalidator;

import com.fetchrewards.demo.emailvalidator.controller.EmailValidatorController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

/**
 * @author: Chendi Zhang
 * @date: 10/7/20
 * @description:
 **/

public class APITest {

    String[] emails1;
    String[] emails2;


    @BeforeEach
    public void configMock() {
        emails1 = new String[]{"test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"};
        emails2 = new String[]{"test.email@gmail.com", "test.email@fetchrewards.com"};
        MockitoAnnotations.initMocks(this);
        RestAssuredMockMvc.standaloneSetup(new EmailValidatorController());
    }

    @Test
    public void testGetUniqueEmailNums() {
        given().accept("application/json").param("emailList", Arrays.asList(emails1)).get("/emails").peek().
                then().assertThat()
                .statusCode(200)
                .body(Matchers.equalTo("1"));
        given().accept("application/json").param("emailList", Arrays.asList(emails2)).get("/emails").peek().
                then().assertThat()
                .statusCode(200)
                .body(Matchers.equalTo("2"));

    }
}
