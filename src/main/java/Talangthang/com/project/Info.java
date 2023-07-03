package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Info {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public Info(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/Information/{name}/Resources")
    public List<Map<String, Object>> testing(@PathVariable String name) {
        String sql = "SELECT Destination.*, Picture.* " +
                "FROM Destination " +
                "JOIN Picture ON Destination.DesID = Picture.DestinationID " +
                "WHERE Destination.DesID = ? " +
                "LIMIT 1;";

        return jdbcTemplate.queryForList(sql, name);
    }
    @GetMapping("/Information/{name}/Picture")
    public List<Picture> Picture(@PathVariable String name) {
        String sql = "SELECT * FROM Picture WHERE Picture.DestinationID = ?";
        return jdbcTemplate.query(sql, new PictureRowMapper(), name);
    }
    @GetMapping("/ComboResources")
    public List<Map<String, Object>> getComboResource(){
        String sql = "SELECT ComboProvince.ID, ComboProvince.DesID, ComboProvince.ComboID, ComboProvince.DesName, Picture.*" +
                "FROM ComboProvince " +
                "JOIN (" +
                "    SELECT DestinationID, Img AS Img," +
                "    ROW_NUMBER() OVER (PARTITION BY DestinationID ORDER BY Img) AS RowNum " +
                "    FROM Picture " +
                ") AS Picture ON ComboProvince.DesID = Picture.DestinationID AND Picture.RowNum = 3 " +
                "GROUP BY ComboProvince.ID, ComboProvince.DesID, ComboProvince.ComboID, ComboProvince.DesName, Picture.Img;";

        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/ComboDetail")
    public List<Map<String,Object>> getComboDetail(){
        String sql = "Select * from Combo";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/Combo/{id}/Resources")
    public List<Map<String, Object>> getComboResource(@PathVariable String id){
        String sql = "SELECT ComboProvince.*, Picture.* " +
                "FROM ComboProvince " +
                "JOIN Picture ON ComboProvince.DesID = Picture.DestinationID " +
                "WHERE ComboProvince.DesID = ? " +
                "LIMIT 1;";
        return jdbcTemplate.queryForList(sql, id);
    }
    @GetMapping("/Combo/{id}/Picture")
    public List<Picture> ComboPicture(@PathVariable String id) {
        String sql = "SELECT * FROM Picture WHERE Picture.DestinationID = ?";
        return jdbcTemplate.query(sql, new PictureRowMapper(), id);
    }
    @GetMapping("/Combo/{id}/Img360")
    public List<Picture> ComboPano(@PathVariable String id){
        String sql = "Select * From img360 where img360.ID = ?";
        return jdbcTemplate.query(sql, new ImgMapper(), id);

    }
    @GetMapping("/Information/{id}/Img360")
    public List<Picture> InfoPano(@PathVariable String id){
        String sql = "Select * From img360 where img360.ID = ?";
        return jdbcTemplate.query(sql, new ImgMapper(), id);

    }
}
