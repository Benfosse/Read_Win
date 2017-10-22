package bookmanager.chalmers.edu.readwin.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by andreranito on 18/10/2017.
 */

public class OrderingQuestion implements Parcelable {

    private String Question;
    private String[] Events;


    public OrderingQuestion(String question, String[] events) {

        Question = question;
        Events = events;
    }

    public String getQuestion() { return Question; }

    public String[] getEvents() { return Events; }

    @Override
    public String toString() {
        return "...";
    }

    public OrderingQuestion(Parcel parcel) {
        this.Question = parcel.readString();
        this.Events = parcel.createStringArray();
    }

    public static final Parcelable.Creator<OrderingQuestion> CREATOR = new Parcelable.Creator<OrderingQuestion>() {
        @Override
        public OrderingQuestion createFromParcel(Parcel in) {
            return new OrderingQuestion(in);
        }

        @Override
        public OrderingQuestion[] newArray(int size) {
            return new OrderingQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Question);
        parcel.writeArray(this.Events);
    }
}
