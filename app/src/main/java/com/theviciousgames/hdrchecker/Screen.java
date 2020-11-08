package com.theviciousgames.hdrchecker;

import android.app.Activity;
import android.view.Display;

public class Screen {
    public static class HDR
    {
        public static int[] getHDRCapabilities(Activity activity)
        {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Display.HdrCapabilities hdrCapabilities = display.getHdrCapabilities();
            int[] hdrTypes=hdrCapabilities.getSupportedHdrTypes();

            return hdrTypes;
        }
    }
}
