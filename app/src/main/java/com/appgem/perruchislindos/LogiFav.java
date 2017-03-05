package com.appgem.perruchislindos;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.Serializable;



/**
 * Created by Usuario on 05/03/2017.
 */

public class LogiFav implements Parcelable{


    private ArrayList<ArregloPerruchis> mascotasFavoritas;

    public LogiFav(ArrayList<ArregloPerruchis>mascotasFavoritas){

        this.mascotasFavoritas  =   mascotasFavoritas;
    }

    public ArrayList<ArregloPerruchis>getMascotasFavoritas(){

        return mascotasFavoritas;
    }

    public void setMascotasFavoritas(ArrayList<ArregloPerruchis>mascotasFavoritas){

        this.mascotasFavoritas = mascotasFavoritas;
    }

    protected LogiFav(Parcel in){

        if (in.readByte()==0x01){
            mascotasFavoritas   = new ArrayList<ArregloPerruchis>();
            in.readList(mascotasFavoritas,ArregloPerruchis.class.getClassLoader());
        }
        else{
            mascotasFavoritas = null;
        }

    }

    public int describeContents(){return 0;}

    public void writeToParcel(Parcel dest,int flags){
        if (mascotasFavoritas==null){
            dest.writeByte((byte)(0x00));
        }
        else {
            dest.writeByte((byte)(0x01));
            dest.writeList(mascotasFavoritas);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LogiFav> CREATOR = new Parcelable.Creator<LogiFav>() {
        @Override
        public LogiFav createFromParcel(Parcel in) { return new LogiFav(in);}

        @Override
        public LogiFav[] newArray(int size) {
            return new LogiFav[size];
        }
    };



}
