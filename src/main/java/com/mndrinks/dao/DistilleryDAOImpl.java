package com.mndrinks.dao;

import com.mndrinks.entities.Distillery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DistilleryDAOImpl extends JdbcDaoSupport implements DistilleryDAO {

    DataSource dataSource;

    @Autowired
    public DistilleryDAOImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void insert(Distillery distillery) {
        String sql = "insert into distillery (id, name, city) values (?, ?, ?)";
        getJdbcTemplate().update(sql, distillery.getId(), distillery.getName(), distillery.getCity());
    }

    @Override
    public void insertBatch(List<Distillery> distilleries) {

    }

    @Override
    public List<Distillery> findAllDistilleries() {
        return null;
    }

    @Override
    public Distillery findDistilleryById(long id) {
        String sql = "select * from distillery where id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Distillery dist = new Distillery();
            dist.setId(rs.getLong("id"));
            dist.setName(rs.getString("name"));
            dist.setCity(rs.getString("city"));
            return dist;
        });
    }
}
