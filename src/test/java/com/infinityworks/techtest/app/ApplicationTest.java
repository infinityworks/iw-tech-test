package com.infinityworks.techtest.app;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void basicTest() {
        assertTrue(1 == 1);
    }

    @Test
    void testAppRuns() {
        ResponseEntity<String> resp = testRestTemplate.getForEntity("/api/status", String.class);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

}