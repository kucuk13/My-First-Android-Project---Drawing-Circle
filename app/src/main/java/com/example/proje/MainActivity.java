package com.example.proje;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static int a;
    public static int b;
    public static int c;
    public static int d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

    }

    public void draw(View v){
        final EditText xe = (EditText) findViewById(R.id.x);
        final EditText ye = (EditText) findViewById(R.id.y);
        final EditText re = (EditText) findViewById(R.id.r);
        final EditText ne = (EditText) findViewById(R.id.n);
        a = Integer.parseInt(xe.getText().toString());
        b = Integer.parseInt(ye.getText().toString());
        c = Integer.parseInt(re.getText().toString());
        d = Integer.parseInt(ne.getText().toString());
        setContentView(new MyView(this));
    }

    public class MyView extends View
    {

        Paint paint = null;
        public MyView(Context context)
        {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            int x = a;
            int y = b;
            int radius;
            radius = c;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(x / 2, y / 2, radius, paint);
            int i ;
            d = d - 1;
            for (i = 0; i < d; i++){
                x = x + (c * 4);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(x / 2, y / 2, radius, paint);
            }
        }
    }


}
