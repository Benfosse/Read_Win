package bookmanager.chalmers.edu.readwin.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by andreranito on 18/10/2017.
 */

public class MultipleQuestion implements Parcelable {

    private String Question;
    private String[] Options;

    public MultipleQuestion(String question, String[] options) {
        Question = question;
        Options = options;
    }

    public String[] getOptions() { return Options; }

    public String getQuestion() { return Question; }

    @Override
    public String toString() {
        return "...";
    }

    public MultipleQuestion(Parcel parcel) {
        this.Question = parcel.readString();
        this.Options = parcel.createStringArray();
    }

    public static final Parcelable.Creator<MultipleQuestion> CREATOR = new Parcelable.Creator<MultipleQuestion>() {
        @Override
        public MultipleQuestion createFromParcel(Parcel in) {
            return new MultipleQuestion(in);
        }

        @Override
        public MultipleQuestion[] newArray(int size) {
            return new MultipleQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Question);
        parcel.writeArray(this.Options);
    }
}
