package es.master.p3_retrofitweb.hotel;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("exactCurrent")
    private float exactPrice;

    public Price() {
    }

    public float getExactPrice() {
        return exactPrice;
    }

    public void setExactPrice(float exactPrice) {
        this.exactPrice = exactPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return "Price{" +
                "exactPrice=" + exactPrice +
                '}';
    }
}
