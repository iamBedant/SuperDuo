package it.jaschke.alexandria;

import com.google.android.gms.vision.barcode.Barcode;

/**
 * Created by bebi2 on 1/3/2016.
 */
public class OverviewLoadedEvent {
    public Barcode overview;

    public OverviewLoadedEvent(Barcode overview) {
        this.overview = overview;
    }
}
