package Talangthang.com.project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PictureRowMapper implements RowMapper<Picture> {
    public Picture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Picture picture = new Picture();
        picture.setDestinationID(rs.getString("DestinationID"));
        picture.setImg(rs.getString("Img"));
        return picture;
    }
}
