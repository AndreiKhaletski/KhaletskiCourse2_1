package by.id_academy.jd2.dto;

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
}
