package com.tea.modules.model.po;

public class RedisMessage {
    private String id;
    private Object message;

    @Override
    public String toString() {
        return "RedisMessage{" +
                "id='" + id + '\'' +
                ", message=" + message +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
