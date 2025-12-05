package elm.hackathon.markettrands.user_management.service;

import elm.hackathon.markettrands.user_management.domain.dto.UserDTO;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    UserDTO getUserById(int id);
}
