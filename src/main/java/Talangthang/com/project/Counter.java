package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class Counter {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    void Counter(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @GetMapping("/Count")
    public String getCounter(){
        String sql ="Select * from Access where Access = ?" ;
        List<Acc> Count = jdbcTemplate.query(sql,new Object[]{"tm"}, new RowMapper<Acc>(){
            ResultSet rs = null;
            public Acc mapRow(ResultSet rs, int rowNum) throws SQLException {
                Acc test = new Acc();
                test.setTime(rs.getInt("Time"));
                test.setAccess(rs.getString("Access"));
                // ...

                return test;
            }
        });

        this.jdbcTemplate.update(
                "update Access set Time = ? where Access = ?",
                String.valueOf(Count.get(0).getTime()+1), "tm");
        return String.valueOf(Count.get(0).getTime());
    }
    @GetMapping("/CountNumber")
    public String getCount(){
        String sql ="Select * from Access where Access = ?" ;
        List<Acc> Count = jdbcTemplate.query(sql,new Object[]{"tm"}, new RowMapper<Acc>(){
            ResultSet rs = null;
            public Acc mapRow(ResultSet rs, int rowNum) throws SQLException {
                Acc test = new Acc();
                test.setTime(rs.getInt("Time"));
                test.setAccess(rs.getString("Access"));
                // ...

                return test;
            }
        });
        return String.valueOf(Count.get(0).getTime());
    }
    private class Acc{
        private String Access;
        private Integer Time;

        public String getAccess() {
            return Access;
        }

        public void setAccess(String access) {
            Access = access;
        }

        public Integer getTime() {
            return Time;
        }

        public void setTime(Integer time) {
            Time = time;
        }
    }
}
