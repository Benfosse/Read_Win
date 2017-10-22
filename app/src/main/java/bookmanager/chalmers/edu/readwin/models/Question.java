package bookmanager.chalmers.edu.readwin.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Question implements Parcelable {

    private int QuestionNumber;
    private String Type;

    private MultipleQuestion Multiple;
    private PairQuestion Pair;
    private OrderingQuestion Ordering;


    public Question(int questionNumber, String type, MultipleQuestion multiple, PairQuestion pair, OrderingQuestion ordering) {
        QuestionNumber = questionNumber;
        Type = type;
        Multiple = multiple;
        Pair = pair;
        Ordering = ordering;
    }

    public int getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getType() { return Type; }

    public void setType(String type) { this.Type = type; }

    public MultipleQuestion getMultiple() { return Multiple; }

    public PairQuestion getPair() { return Pair; }

    public OrderingQuestion getOrdering() { return Ordering; }

    @Override
    public String toString() {
        return String.valueOf(getQuestionNumber());
    }

    public Question(Parcel parcel) {
        String[] data = new String[5];

        parcel.readStringArray(data);

        this.QuestionNumber = Integer.parseInt(data[0]);
        this.Type = data[1];

        this.Multiple = parcel.readTypedObject(MultipleQuestion.CREATOR);
        this.Pair = parcel.readTypedObject(PairQuestion.CREATOR);
        this.Ordering = parcel.readTypedObject(OrderingQuestion.CREATOR);
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(String.valueOf(this.QuestionNumber));
        parcel.writeString(this.Type);
        parcel.writeParcelable(this.Multiple, 0);
        parcel.writeParcelable(this.Pair, 0);
        parcel.writeParcelable(this.Ordering, 0);
    }
}
