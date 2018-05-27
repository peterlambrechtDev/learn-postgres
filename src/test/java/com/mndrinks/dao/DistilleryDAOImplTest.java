package com.mndrinks.dao;

import com.mndrinks.entities.Distillery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistilleryDAOImplTest {
    @Autowired
    private DistilleryDAOImpl distilleryDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        jdbcTemplate.execute("delete from distillery");
    }

    @Test
    public void testInsert() {
        Distillery distillery = new Distillery();
        distillery.setId(1L);
        distillery.setName("jcarver");
        distillery.setCity("waconia");
        distilleryDAO.insert(distillery);

        Distillery result = distilleryDAO.findDistilleryById(1L);
        assertEquals(1L, result.getId().longValue());
        assertEquals("jcarver", result.getName());
        assertEquals("waconia", result.getCity());
    }


}