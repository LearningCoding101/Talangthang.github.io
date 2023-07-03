package Talangthang.com.project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImgMapper implements RowMapper<Picture> {

    public ImgMapper() {
    }

    @Override
    public Picture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Picture picture = new Picture();
        picture.setDestinationID(rs.getString("ID"));
        picture.setImg(rs.getString("Link"));
        return picture;
    }
}
