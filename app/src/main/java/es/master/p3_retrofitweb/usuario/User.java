package es.master.p3_retrofitweb.usuario;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    private String nombre, pass, userToken;
    private int edad, genero, idBdReference;

    public User(String nombre, String pass, String userToken, int edad, int genero, int idBdReference) {
        this.nombre = nombre;
        this.pass = pass;
        this.userToken = userToken;
        this.edad = edad;
        this.genero = genero;
        this.idBdReference = idBdReference;
    }

    protected User(Parcel in) {
        nombre = in.readString();
        pass = in.readString();
        userToken = in.readString();
        edad = in.readInt();
        genero = in.readInt();
        idBdReference = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int age) {
        this.edad = age;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getIdBdReference() {
        return idBdReference;
    }

    public void setIdBdReference(int idBdReference) {
        this.idBdReference = idBdReference;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "name='" + nombre + '\'' +
                ", pass='" + pass + '\'' +
                ", userToken='" + userToken + '\'' +
                ", age=" + edad +
                ", gender=" + genero +
                ", idBdReference=" + idBdReference +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(pass);
        parcel.writeString(userToken);
        parcel.writeInt(edad);
        parcel.writeInt(genero);
        parcel.writeInt(idBdReference);
    }
}
