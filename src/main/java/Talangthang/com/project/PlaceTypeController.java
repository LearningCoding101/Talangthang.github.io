package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
class PlaceTypeController {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void PlaceTypeController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/PlaceType")
    public List<Map<String, Object>> getData() {
        String sql = "SELECT * FROM PlaceType";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/DestinationResources")
    public List<Map<String, Object>> getDes(){
        /*String sql = "Select Destination.*, Picture.* FROM Destination Join Picture Where Destination.DesID = Picture.DestinationID ";*/
        String sql ="SELECT " +
                "Destination.WardID, " +
                "Destination.DesID, " +
                "Destination.TypeID, " +
                "Destination.DesName, " +
                "Ward.WardID, " +
                "Ward.DistrictID, " +
                "District.ProvinceID, " +
                "District.DistrictID, " +
                "Province.ProvinceID, " +
                "Province.ProvinceName, " +
                "Picture.* " +
                "FROM " +
                "Destination " +
                "JOIN " +
                "Picture ON Destination.DesID = Picture.DestinationID " +
                "JOIN " +
                "Ward ON Destination.WardID = Ward.WardID " +
                "JOIN " +
                "District ON Ward.DistrictID = District.DistrictID " +
                "JOIN " +
                "Province ON District.ProvinceID = Province.ProvinceID " +
                "UNION " +
                "SELECT " +
                "Destination.WardID, " +
                "Destination.DesID, " +
                "Destination.TypeID, " +
                "Destination.DesName, " +
                "Ward.WardID, " +
                "Ward.DistrictID, " +
                "District.ProvinceID, " +
                "District.DistrictID, " +
                "Province.ProvinceID, " +
                "Province.ProvinceName, " +
                "Picture.* " +
                "FROM " +
                "Destination " +
                "JOIN " +
                "Ward ON Destination.WardID = Ward.WardID " +
                "JOIN " +
                "District ON Ward.DistrictID = District.DistrictID " +
                "JOIN " +
                "Province ON District.ProvinceID = Province.ProvinceID " +
                "JOIN " +
                "Picture ON Ward.WardID = Picture.DestinationID " +
                "UNION " +
                "SELECT " +
                "Destination.WardID, " +
                "Destination.DesID, " +
                "Destination.TypeID, " +
                "Destination.DesName, " +
                "Ward.WardID, " +
                "Ward.DistrictID, " +
                "District.ProvinceID, " +
                "District.DistrictID, " +
                "Province.ProvinceID, " +
                "Province.ProvinceName, " +
                "Picture.* " +
                "FROM " +
                "Destination " +
                "JOIN " +
                "Ward ON Destination.WardID = Ward.WardID " +
                "JOIN " +
                "District ON Ward.DistrictID = District.DistrictID " +
                "JOIN " +
                "Province ON District.ProvinceID = Province.ProvinceID " +
                "JOIN " +
                "Picture ON Province.ProvinceID = Picture.DestinationID;"
        ;
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/ProvinceResource")
    public List<Map<String, Object>> getProvince(){
        String sql = "Select Province.* From Province";
        return jdbcTemplate.queryForList(sql);
    }

}
