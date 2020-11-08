package com.theviciousgames.hdrchecker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView hdrModesTextView;
    private Button refreshButton;
    private int[] hdrCapabsInt;
    private String preTextViewText="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareVars();
        getHDRCapabilities();
        buttonFunctions();

    }

    protected void declareVars() {
       hdrModesTextView=findViewById(R.id.hdrCapabilitiesTextView);
       refreshButton=findViewById(R.id.refreshButton);
    }
    protected void buttonFunctions()
    {
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHDRCapabilities();
                Tools.Utils.vibrate(MainActivity.this);

            }
        });

    }

    protected void getHDRCapabilities() {

        hdrCapabsInt = Tools.Utils.getHDRcapabilities(MainActivity.this);
        for(byte index=0;index<hdrCapabsInt.length;++index)
        {

                if(hdrCapabsInt[index]==1)
                {
                    preTextViewText=preTextViewText+"\n\n"+"HDR Dolby Vision";
                }
                if(hdrCapabsInt[index]==2)
                {
                    preTextViewText=preTextViewText+"\n\n"+"HDR 10";
                }
                if(hdrCapabsInt[index]==3)
                {
                    preTextViewText=preTextViewText+"\n\n"+"HDR HLG";
                }
                if(hdrCapabsInt[index]==4)
                {
                    preTextViewText=preTextViewText+"\n\n"+"HDR 10 PLUS";
                }

        }
        hdrModesTextView.setText(preTextViewText);
        preTextViewText="";
    }
}