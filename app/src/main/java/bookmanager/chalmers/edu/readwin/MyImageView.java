package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class MyImageView extends android.support.v7.widget.AppCompatImageView {
    private Paint linePaint;
    private Paint dotPaint;

    private Integer[] answers = {-1, -1, -1, -1};


    private Float[][] Coords_number = new Float[4][2];
    private Float[][] Coords_letter = new Float[4][2];


    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        linePaint = new Paint();
        linePaint.setDither(true);
        linePaint.setColor(0xFF000000);  // alpha.r.g.b
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeJoin(Paint.Join.ROUND);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setStrokeWidth(10);

        dotPaint = new Paint();
        dotPaint.setDither(true);
        dotPaint.setColor(0xFF000000);  // alpha.r.g.b
        dotPaint.setStyle(Paint.Style.STROKE);
        dotPaint.setStrokeJoin(Paint.Join.ROUND);
        dotPaint.setStrokeCap(Paint.Cap.ROUND);
        dotPaint.setStrokeWidth(20);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawLines(canvas);
        //canvas.drawLine(300, 300, 600, 600,linePaint);
    }

    public void drawLines(Canvas canvas) {

            for(int i = 0; i < 4; i++) {
                if (answers[i] != -1)
                    canvas.drawLine(Coords_number[i][0], Coords_number[i][1], Coords_letter[answers[i]][0], Coords_letter[answers[i]][1], linePaint);
            }
    }

    public void setAnswers(Integer[] answers) {
        this.answers = answers;
    }

    public void setCoords_number(Float[][] coords_number) {
        Coords_number = coords_number;
    }

    public void setCoords_letter(Float[][] coords_letter) {
        Coords_letter = coords_letter;
    }

}