package duc.example.com.kidsgames;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Duc on 25.9.2017..
 */

public class PaintView extends View implements View.OnTouchListener{
    private int mPenCol;
    private final int DEFAULT_COLOR= Color.GREEN;
    private Paint mPaint;
    private Path mPath;
    private float mX;
    private float mY;
    private float mXOld;
    private float mYOld;
    private ArrayList<Path>mPaths;
    private ArrayList<Paint>mPaints;

    public PaintView(Context context) {
        super(context);
        this.init();
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }
    private  void init(){
        this.mPenCol=DEFAULT_COLOR;
        this.mPath=new Path();
        this.mPaths=new ArrayList<Path>();
        this.mPaints=new ArrayList<Paint>();
        this.addPath();
        this.mX=this.mY=this.mXOld=this.mYOld=(float)0.0;
        this.setOnTouchListener(this);
    }
    private void addPath(){
        mPath=new Path();
        mPaths.add(mPath);
        mPaint=new Paint();
        mPaints.add(mPaint);
        mPaint.setColor(mPenCol);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);


    }

    public int getPenCol() {
        return mPenCol;
    }

    public void setPenCol(int penCol) {
        this.mPenCol = penCol;
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }
    public void reset(){
        this.init();
        this.invalidate();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<mPaths.size();i++)
            canvas.drawPath(mPaths.get(i),mPaints.get(i));


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mX=event.getX();
        mY=event.getY();


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.addPath();
                this.mPath.moveTo(mX,mY);
                break;
            case MotionEvent.ACTION_MOVE:
                this.mPath.lineTo(mX,mY);
                break;
            case MotionEvent.ACTION_UP:
                if(mYOld==mY && mXOld==mX)
                    this.mPath.addCircle(mX,mY,5,Path.Direction.CW);
                break;


        }
        this.invalidate();
        mXOld=mX;
        mYOld=mY;
        return  true;





    }
}