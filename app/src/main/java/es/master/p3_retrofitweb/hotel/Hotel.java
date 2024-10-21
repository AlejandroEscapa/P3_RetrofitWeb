package es.master.p3_retrofitweb.hotel;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Hotel {

    @SerializedName("id")
    private int id;

    @SerializedName("starRating")
    private int starRating;

    @SerializedName("name")
    public String name;

    @SerializedName("address")
    private HotelAdress hotelAdress;

    @SerializedName("ratePlan")
    public RatePlan ratePlan;

    @SerializedName("optimizedThumbUrls")
    public ThumbURL thumbUrl;

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelAdress getHotelAdress() {
        return hotelAdress;
    }

    public void setHotelAdress(HotelAdress hotelAdress) {
        this.hotelAdress = hotelAdress;
    }

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan ratePlan) {
        this.ratePlan = ratePlan;
    }

    public ThumbURL getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(ThumbURL thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", starRating=" + starRating +
                ", name='" + name + '\'' +
                ", hotelAdress=" + hotelAdress +
                ", ratePlan=" + ratePlan +
                ", thumbUrl=" + thumbUrl +
                '}';
    }
}
