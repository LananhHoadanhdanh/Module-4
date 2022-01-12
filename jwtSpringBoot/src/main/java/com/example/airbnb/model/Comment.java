package gr3c08.group3_case4.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime time;

    @ManyToOne
    private User user;

    @ManyToOne
    private Song song;

    @ManyToOne
    private Playlist playlist;

    @ManyToOne
    private Singer singer;

    public Comment() {
    }

    public Comment(String content, User user, Song song) {
        this.content = content;
        this.user = user;
        this.song = song;
    }

    public Comment(String content, User user, Playlist playlist) {
        this.content = content;
        this.user = user;
        this.playlist = playlist;
    }

    public Comment(String content, User user, Singer singer) {
        this.content = content;
        this.user = user;
        this.singer = singer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
