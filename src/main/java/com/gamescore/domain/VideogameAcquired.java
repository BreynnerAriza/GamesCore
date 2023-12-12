package com.gamescore.domain;

import org.bson.types.ObjectId;
import java.time.LocalDate;
import java.util.Objects;

public class VideogameAcquired {

    private ObjectId videogame_id;
    private LocalDate adquisition_date;

    public VideogameAcquired(ObjectId videogame_id) {
        this.videogame_id = videogame_id;
    }

    public VideogameAcquired(LocalDate adquisition_date) {
        this.adquisition_date = adquisition_date;
    }

    public VideogameAcquired(ObjectId videogame_id, LocalDate adquisition_date) {
        this.videogame_id = videogame_id;
        this.adquisition_date = adquisition_date;
    }

    @Override
    public String toString() {
        return "VideogameAcquired{" +
                "videogame_id=" + videogame_id +
                ", adquisition_date=" + adquisition_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideogameAcquired that = (VideogameAcquired) o;
        return Objects.equals(videogame_id, that.videogame_id) && Objects.equals(adquisition_date, that.adquisition_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videogame_id, adquisition_date);
    }

    public ObjectId getVideogame_id() {
        return videogame_id;
    }

    public void setVideogame_id(ObjectId videogame_id) {
        this.videogame_id = videogame_id;
    }

    public LocalDate getAdquisition_date() {
        return adquisition_date;
    }

    public void setAdquisition_date(LocalDate adquisition_date) {
        this.adquisition_date = adquisition_date;
    }
}
