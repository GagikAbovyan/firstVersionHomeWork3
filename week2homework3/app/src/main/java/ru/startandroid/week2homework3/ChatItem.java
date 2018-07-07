package ru.startandroid.week2homework3;


public class ChatItem {
    private String botMessage;
    private String userMessage;

    public ChatItem() {
    }

    public ChatItem(String botMessage) {
        this.botMessage = botMessage;
    }

    public String getBotMessage() {
        return botMessage;
    }

    public void setBotMessage(String botMessage) {
        this.botMessage = botMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
