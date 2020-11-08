package com.theviciousgames.hdrchecker;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;

public class Tools {
    public static class Utils
    {
        public static int[] getHDRcapabilities(Activity activity)
        {
            int[] hdrCapabsArray=Screen.HDR.getHDRCapabilities(activity);
            for(byte index=0;index<hdrCapabsArray.length;++index)
            {
                if(hdrCapabsArray[index]==1)
                {
                    System.out.println("HDR_TYPE_DOLBY_VISION");
                }
                else if(hdrCapabsArray[index]==2)
                {
                    System.out.println("HDR_TYPE_HDR10");
                }
                else if(hdrCapabsArray[index]==3)
                {
                    System.out.println("HDR_TYPE_HLG");
                }
                else if(hdrCapabsArray[index]==4)
                {
                    System.out.println("HDR_TYPE_HDR10_PLUS");
                }
            }
            return hdrCapabsArray;
        }

        public static void vibrate(Context context)
        {
                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(50);
        }
    }
}
