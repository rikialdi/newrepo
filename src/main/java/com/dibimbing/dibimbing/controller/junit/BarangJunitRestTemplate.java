package com.dibimbing.dibimbing.controller.junit;


import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarangJunitRestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void insert() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "*/*");
            headers.set("Content-Type", "application/json");
            String bodyTesting = "{\n" +
                    "    \"nama\":\"pulpen789\",\n" +
                    "    \"stok\":\"1\",\n" +
                    "    \"satuan\":\"pcs\",\n" +
                    "    \"harga\":\"123\"\n" +
                    "}";
            HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);

            ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/barang/save", HttpMethod.POST, entity, String.class);
            System.out.println("response  =" + exchange.getBody());
            Assert.assertEquals(HttpStatus.OK, exchange.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update123() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "    \"id\":\"1\",\n" +
                "    \"nama\":\"pulpen update\",\n" +
                "    \"stok\":\"1\",\n" +
                "    \"satuan\":\"pcs\",\n" +
                "    \"harga\":\"123\"\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/barang/update", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response  =" + exchange.getBody());
    }

    @Test
    public void deleted() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        Long idBarang = 2L;

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/barang/deleted/" + idBarang, HttpMethod.DELETE, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response  =" + exchange.getBody());
    }

    @Test
    public void list() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/barang/list?page=0&size=10", HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());

    }
}