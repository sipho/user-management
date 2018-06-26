import com.bs.em.domain.User;
import com.bs.em.dto.UserDTO;
import com.bs.em.translator.Translator;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

public class TranlaterTest {
    @Test
    public void toUser(){
        Translator translator = new Translator();
        UserDTO dto = getUserDTO();
        Assert.assertNotNull(translator.toUser(dto));
    }

    @NotNull
    private UserDTO getUserDTO() {
        UserDTO dto = new UserDTO();
        dto.setEmail("sipamash@gmail.com");
        dto.setFirstName("Sipho");
        return dto;
    }

    @Test
    public void toUserDTO(){
        Translator translator = new Translator();
        User user = getUser();
        Assert.assertNotNull(translator.toUserDTO(user));
    }

    @NotNull
    private User getUser() {
        User user = new User();
        user.setEmail("sipamash@gmail.com");
        user.setFirstName("Sipho");
        return user;
    }

    @Test
    public void toUserDTO1(){
        Translator translator = new Translator();
        User user = getUser();
        Assert.assertNotNull(translator.toUser(user, getUserDTO()));
    }
}
