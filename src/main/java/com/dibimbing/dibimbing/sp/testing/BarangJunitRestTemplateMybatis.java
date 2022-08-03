package com.dibimbing.dibimbing.sp.testing;

import com.dibimbing.dibimbing.utils.QueryPS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarangJunitRestTemplateMybatis {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    QueryPS queryPS;

    @Test
    public void callAllSP(){
        // Mmebuat Prosedure lewat APlikasi spring boot
        jdbcTemplate.execute(queryPS.getBarang1);
        jdbcTemplate.execute(queryPS.testInteger);
        jdbcTemplate.execute(queryPS.save);
        jdbcTemplate.execute(queryPS.testSP);
        jdbcTemplate.execute(queryPS.deletebarang);
        jdbcTemplate.execute(queryPS.updatebarang);
        jdbcTemplate.execute(queryPS.updatebarangoutwitheror);
        jdbcTemplate.execute(queryPS.testLong);
        jdbcTemplate.execute(queryPS.testDouble);
        jdbcTemplate.execute(queryPS.getByIDSP);

    }

    @Test
    public void listSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/sp/barang/list?nama=bar", HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    @Test
    public void getIdSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        Integer id = 1;
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/sp/barang/"+id, HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    @Test
    public void  saveSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "    \"id\":\"0\",\n" +
                "    \"nama\":\"barang baru 3\",\n" +
                "    \"stok\":\"1\",\n" +
                "    \"satuan\":\"pcs\",\n" +
                "    \"harga\":\"123\"\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        System.out.println("bodyTesting  =" + bodyTesting);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/sp/barang/save", HttpMethod.POST, entity, String.class);
        System.out.println("response  =" + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());

    }

    @Test
    public void  updateSukses() {
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

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9090/api/v1/sp/barang/update", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response  =" + exchange.getBody());
    }
    }
