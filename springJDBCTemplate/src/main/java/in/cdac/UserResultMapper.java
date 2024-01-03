package in.cdac;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserResultMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUseremail(rs.getString("useremail"));
        user.setUsername(rs.getString("username"));
        user.setUsermobile(rs.getString("usermobile"));
        user.setUserpassword(rs.getString("userpassword"));
        return user;
    }
    
}
