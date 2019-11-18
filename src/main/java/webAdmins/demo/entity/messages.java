package webAdmins.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Messages")
public class messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MessageID;
    @NotNull
    @Column(name = "UserID")
    private int UserID;

    public messages(int messageID, int userID, String tag, String title, String body, String recipient) {
        MessageID = messageID;
        UserID = userID;
        Tag = tag;
        this.title = title;
        this.body = body;
        this.recipient = recipient;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    @Override
    public String toString() {
        return "messages{" +
                "MessageID=" + MessageID +
                ", UserID=" + UserID +
                ", Tag='" + Tag + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }

    public messages() {
    }
    @NotNull
    @Column(name = "Tag")
    @NotNull
    private  String Tag;
    @NotNull
    @Column(name = "title")
    private  String title;
    @NotNull
    @Column(name = "body")
    private  String body;
    @Column(name = "recipient")
    private  String recipient;

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int messageID) {
        MessageID = messageID;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

}
