package com.github.prgrms.socialserver.service;

import com.github.prgrms.socialserver.domain.Email;
import com.github.prgrms.socialserver.domain.Password;
import com.github.prgrms.socialserver.domain.User;
import com.github.prgrms.socialserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void 유저_목록을_가져온다() {
        // given
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, new Email("test00@gmail.com"), new Password("abc123!@#"), 0, null, null));
        userList.add(new User(2L, new Email("test01@gmail.com"), new Password("bcd234@#$"), 0, null, null));
        when(userRepository.findAll()).thenReturn(userList);

        // when
        List<User> usersFound = userService.findAll();

        // then
        assertThat(usersFound.size()).isEqualTo(2);
        assertThat(usersFound.get(0)).isEqualTo(userList.get(0));
        assertThat(usersFound.get(1)).isEqualTo(userList.get(1));
    }
}