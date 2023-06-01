package com.example.displayimage.Model;

public class Image {
    String title="";
    String url="";
    String thumbnailUrl;
    int id;
    int albumId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public Image(String title, String url, String thumbnailUrl, int id, int albumId) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.id = id;
        this.albumId = albumId;
    }
}
