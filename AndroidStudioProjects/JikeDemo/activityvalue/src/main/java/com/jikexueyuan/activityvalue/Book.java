package com.jikexueyuan.activityvalue;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huan on 15/4/20.
 */
public class Book implements Parcelable{

    private String name;
    private int price;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getPrice());
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            Book book = new Book(source.readString(), source.readInt());
            return book;
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
