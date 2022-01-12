package gr3c08.group3_case4.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int status;
    private int listens;

    @ManyToOne
    @JoinColumn(name = "singerId")
    private Singer singer;
    private LocalDateTime time;

    @Column(length = 100000)
    private String lyrics;

    private String mp3file;
    private String image;

    public Song() {
    }

    public Song(String name, String description, int status, Singer singer, String lyrics) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.singer = singer;
        this.lyrics = lyrics;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getListens() {
        return listens;
    }

    public void setListens(int listens) {
        this.listens = listens;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getMp3file() {
        return mp3file;
    }

    public void setMp3file(String mp3file) {
        this.mp3file = mp3file;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
