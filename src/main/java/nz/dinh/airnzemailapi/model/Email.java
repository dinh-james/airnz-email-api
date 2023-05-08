package nz.dinh.airnzemailapi.model;

import jakarta.validation.constraints.NotEmpty;

public class Email {
    @NotEmpty private final String id;
    @NotEmpty private String status;
    @NotEmpty private String from;
    @NotEmpty private String[] to;
    @NotEmpty private String subject;
    @NotEmpty private String body;
    private String[] cc;
    private String[] bcc;

    public Email(String id, String status, String from, @NotEmpty String[] to, String subject, String body, String[] cc, String[] bcc) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }
}
