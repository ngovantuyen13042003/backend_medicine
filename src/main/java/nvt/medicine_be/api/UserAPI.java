package nvt.medicine_be.api;

import nvt.medicine_be.dto.UserDTO;
import nvt.medicine_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "User")
public class UserAPI {
    @Autowired
    private UserService userService;
    @PostMapping("/api/user")
    public UserDTO createUser(@RequestBody UserDTO dto) {
        return userService.Save(dto);
    }
    @PutMapping("/api/user")
    public UserDTO updateUser(@RequestBody UserDTO dto) {
        return userService.Save(dto);
    }
    @PostMapping("/api/user/login")
    public UserDTO getUser(@RequestBody UserDTO dto) {
        return userService.findOne(dto.getEmail(), dto.getPassword());
    }
}
