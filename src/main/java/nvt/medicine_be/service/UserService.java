package nvt.medicine_be.service;

import nvt.medicine_be.dto.UserDTO;

public interface UserService {
    UserDTO Save(UserDTO dto);
    UserDTO findOne(String email,String password);
}
