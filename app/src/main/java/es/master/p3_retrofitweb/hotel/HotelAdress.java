package es.master.p3_retrofitweb.hotel;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class HotelAdress {

    @SerializedName("streetAddress")
    public String streetAddress;

    @SerializedName("locality")
    private String locality;

    public HotelAdress() {
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @NonNull
    @Override
    public String toString() {
        return "HotelAdress{" +
                "streetAddress='" + streetAddress + '\'' +
                ", locality='" + locality + '\'' +
                '}';
    }
}
