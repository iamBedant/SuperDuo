package it.jaschke.alexandria;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by bebi2 on 1/3/2016.
 */
public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();

    public static Bus getInstance() {
        return bus;
    }

    private EventBus() {

    }

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    EventBus.super.post(event);
                }
            });
        }
    }
}
