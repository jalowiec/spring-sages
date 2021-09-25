package pl.training.shop.users;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.shop.common.PagedResult;
import pl.training.shop.common.web.PagedResultTransferObject;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    User toUser(UserTransferObject userTransferObject);

    @Mapping(source = "firstName", target = "name")
    @Mapping(source = "lastName", target = "surname")
    UserTransferObject toUserTransferObject(User user);

    @IterableMapping(elementTargetType = UserTransferObject.class)
    List<UserTransferObject> toUserTransferObjects(List<User> users);

    PagedResultTransferObject<UserTransferObject> toUserTransferObjectsPage(PagedResult<User> usersPage);

}
