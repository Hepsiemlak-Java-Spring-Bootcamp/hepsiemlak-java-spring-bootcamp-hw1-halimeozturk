package dto;

import lombok.Data;
import model.User;

@Data
public class MessageFilterDTO {
    private User sender;
    private User receiver;
    private String content;
}
