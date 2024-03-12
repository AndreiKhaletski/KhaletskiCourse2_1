package by.id_academy.jd2.service.api;

import by.id_academy.jd2.dto.UserDTO;

import java.io.IOException;

public interface IUserService {

    void accoutUser (UserDTO userDTO, String login) throws IOException;
}
