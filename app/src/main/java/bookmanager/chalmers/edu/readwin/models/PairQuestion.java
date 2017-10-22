package bookmanager.chalmers.edu.readwin.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by andreranito on 18/10/2017.
 */

public class PairQuestion implements Parcelable {

    private String Heading;
    private String[] NumberColumn;
    private String[] LetterColumn;

    public PairQuestion(String heading, String[] numberColumn, String[] letterColumn) {
        Heading = heading;
        NumberColumn = numberColumn;
        LetterColumn = letterColumn;
    }

    public String getHeading() { return Heading; }

    public String[] getNumberColumn() { return NumberColumn; }

    public String[] getLetterColumn() { return LetterColumn; }

    @Override
    public String toString() {
        return "...";
    }

    public PairQuestion(Parcel parcel) {
        this.Heading = parcel.readString();
        this.NumberColumn = parcel.createStringArray();
        this.LetterColumn = parcel.createStringArray();
    }

    public static final Parcelable.Creator<PairQuestion> CREATOR = new Parcelable.Creator<PairQuestion>() {
        @Override
        public PairQuestion createFromParcel(Parcel in) {
            return new PairQuestion(in);
        }

        @Override
        public PairQuestion[] newArray(int size) {
            return new PairQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Heading);
        parcel.writeArray(this.NumberColumn);
        parcel.writeArray(this.LetterColumn);
    }
}
