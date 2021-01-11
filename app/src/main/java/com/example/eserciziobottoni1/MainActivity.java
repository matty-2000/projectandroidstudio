package com.example.eserciziobottoni1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.pippo);
        b.setText("bottone 1");
        Context ctx = this;
        ll = findViewById(R.id.Layout1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int nrighe = ll.getChildCount();
                Button b = new Button(ctx);

                if (nrighe == 0)
                {
                    LinearLayout hl = new LinearLayout(ctx);
                    hl.setOrientation(LinearLayout.HORIZONTAL);
                    hl.addView(b);
                    ll.addView(hl);
                    return;
                }

                LinearLayout hl = (LinearLayout) ll.getChildAt(nrighe - 1);
                if (hl.getChildCount() < 3)
                {
                    hl.addView(b);
                }
                else
                {
                    if(nrighe == 5)
                    {
                        Toast.makeText(ctx, "ci sono già 5 righe", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    LinearLayout hl2 = new LinearLayout(ctx);
                    hl2.setOrientation(LinearLayout.HORIZONTAL);
                    hl2.addView(b);
                    ll.addView(hl2);
                }
            }
        });
    }
}