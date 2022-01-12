package gr3c08.group3_case4.model;

import javax.persistence.*;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Song song;

    @ManyToOne
    private Playlist playlist;

    @ManyToOne
    private Singer singer;

    public Like() {
    }

    public Like(User user, Song song) {
        this.user = user;
        this.song = song;
    }

    public Like(User user, Playlist playlist) {
        this.user = user;
        this.playlist = playlist;
    }

    public Like(User user, Singer singer) {
        this.user = user;
        this.singer = singer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
