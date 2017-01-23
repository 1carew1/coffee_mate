package ie.cm.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Coffee implements Serializable {

    int coffeeId;
    String coffeeName;
    String shop;
    double rating;
    double price;
    boolean favourite;


    public Coffee() {
    }

    public Coffee(String name, String shop, double rating, double price, boolean fav) {
        this.coffeeName = name;
        this.shop = shop;
        this.rating = rating;
        this.price = price;
        this.favourite = fav;
    }

    @Override
    public String toString() {
        return "Coffee [coffeeName=" + coffeeName
                + ", shop =" + shop + ", rating=" + rating + ", price=" + price
                + ", fav =" + favourite + "]";
    }

//	@Override
//	public int describeContents() {
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel dest, int flags) {
//		dest.writeInt(coffeeId);
//		dest.writeDouble(rating);
//		dest.writeDouble(price);
//		dest.writeString(coffeeName);
//		dest.writeString(shop);
//	}
}
