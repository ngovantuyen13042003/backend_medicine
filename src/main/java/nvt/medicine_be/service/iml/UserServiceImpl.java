package nvt.medicine_be.service.iml;


import lombok.RequiredArgsConstructor;
import nvt.medicine_be.dto.UserDTO;
import nvt.medicine_be.model.Role;
import nvt.medicine_be.model.User;
import nvt.medicine_be.repository.RoleRepository;
import nvt.medicine_be.repository.UserRepository;
import nvt.medicine_be.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    // Default constructor for Spring to instantiate the service
    public UserServiceImpl() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public UserDTO Save(UserDTO dto) {
        User newUser = new User();
        if(dto.getId()!=null) {
            User oldUser = userRepository.findById(dto.getId()).get();
            Role role = roleRepository.findById(dto.getRoleId()).get();
            oldUser = modelMapper.map(dto, User.class);
            oldUser.setRole(role);
            return modelMapper.map(userRepository.save(oldUser), UserDTO.class);
        }else {
            newUser = modelMapper.map(dto, User.class);
            newUser.setRole(roleRepository.findById(2).get());
            return modelMapper.map(userRepository.save(newUser), UserDTO.class);
        }
    }
    @Override
    public UserDTO findOne(String email, String password) {
        // TODO Auto-generated method stub
        return modelMapper.map(userRepository.findOneByEmailAndPassword(email, password), UserDTO.class);
    }
}
