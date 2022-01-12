package gr3c08.group3_case4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private User user;

    private int status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "playlist_id")})
    private Set<Song> songs;

    public Playlist() {
    }

    public Playlist(String name, User user, Set<Song> songs) {
        this.name = name;
        this.user = user;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
