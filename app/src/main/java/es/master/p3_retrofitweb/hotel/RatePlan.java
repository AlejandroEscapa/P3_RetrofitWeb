package es.master.p3_retrofitweb.hotel;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RatePlan {

    @SerializedName("price")
    private Price price = new Price();

    public RatePlan() {
        // Constructor vacío
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return "RatePlan{" +
                "price=" + price +
                '}';
    }
}
