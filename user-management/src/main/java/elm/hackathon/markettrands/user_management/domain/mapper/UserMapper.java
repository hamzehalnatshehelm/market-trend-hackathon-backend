package elm.hackathon.markettrands.user_management.domain.mapper;

import elm.hackathon.markettrands.user_management.domain.dto.UserDTO;
import elm.hackathon.markettrands.user_management.domain.entity.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(AppUser appUser);
    AppUser toEntity(UserDTO userDTO);

}
