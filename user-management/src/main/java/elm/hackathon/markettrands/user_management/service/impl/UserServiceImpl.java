package elm.hackathon.markettrands.user_management.service.impl;

import elm.hackathon.markettrands.user_management.domain.mapper.UserMapper;
import elm.hackathon.markettrands.user_management.domain.dto.UserDTO;
import elm.hackathon.markettrands.user_management.domain.entity.AppUser;
import elm.hackathon.markettrands.user_management.general.exception.schema.response.BusinessException;
import elm.hackathon.markettrands.user_management.repository.UserRepository;
import elm.hackathon.markettrands.user_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getUserById(int id) {
        Optional<AppUser> appUserOptional = userRepository.findById((long) id);
        if(appUserOptional.isEmpty()){
            throw new BusinessException("User not found");
        }
        return userMapper.toDto(userRepository.findById((long)id).get());
    }

    public UserDTO getUserByEmail(String email) {
        Optional<AppUser> appUserOptional = userRepository.findByEmail(email);
        if(appUserOptional.isEmpty()){
            throw new BusinessException("User not found");
        }
        return userMapper.toDto(userRepository.findByEmail(email).get());
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if(Objects.isNull(userDTO) || Objects.isNull(userDTO.getEmail())){
            throw new BusinessException("Invalid user email");
        }
        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            throw new BusinessException("User already exists");
        }
        AppUser appUser = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(appUser);
    }
}
