package by.id_academy.jd2.dto;

import java.util.Objects;

public class MessageDTO {

    private String sendingDataTime;
    private String sender;
    private String recipient;
    private String text;

    public MessageDTO(String recipient, String text) {
        this.recipient = recipient;
        this.text = text;
    }

    public String getSendingDataTime() {
        return sendingDataTime;
    }

    public void setSendingDataTime(String sendingDataTime) {
        this.sendingDataTime = sendingDataTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MessageDTO that = (MessageDTO) o;
//        return Objects.equals(sender, that.sender) && Objects.equals(text, that.text);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(sender, text);
//    }
}
