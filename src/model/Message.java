package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseEntity {
    private User sender;
    private User receiver;
    private String content;
    private String title;
    private Boolean seen;
    private Date sentDate;
    private Date readDate;
}
