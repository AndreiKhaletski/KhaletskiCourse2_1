package by.id_academy.jd2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDTO {
    private String sendingDataTime;
    private String sender;
    private String recipient;
    private String text;

    public MessageDTO(String recipient, String text) {
        this.recipient = recipient;
        this.text = text;
    }
}

