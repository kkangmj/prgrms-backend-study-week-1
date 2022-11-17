package com.github.prgrms.socialserver.repository;

import com.github.prgrms.socialserver.domain.Email;
import com.github.prgrms.socialserver.domain.Password;
import com.github.prgrms.socialserver.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.prgrms.socialserver.util.LocalDateTimeUtil.toLocalDateTime;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
            "SELECT u.* "
                + "FROM users u", mapper
        );
    }

    static RowMapper<User> mapper = (rs, rowNum) ->
        new User(
            rs.getLong("seq"),
            new Email(rs.getString("email")),
            new Password(rs.getString("passwd")),
            rs.getInt("login_count"),
            toLocalDateTime(rs.getTimestamp("last_login_at")),
            toLocalDateTime(rs.getTimestamp("create_at"))
        );
}
