package com.github.prgrms.socialserver.repository;

import com.github.prgrms.socialserver.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
class JdbcUserRepositoryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void 전체_유저를_조회한다() {
        // given
        JdbcUserRepository jdbcUserRepository = new JdbcUserRepository(jdbcTemplate);

        // when
        List<User> users = jdbcUserRepository.findAll();

        // then
        assertThat(users.size()).isEqualTo(2);
    }
}