package io.mechatron.thesis.base;

import android.support.v4.app.Fragment;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by migz on 1/2/17.
 */

public class BaseFragment extends Fragment {

    private CompositeSubscription mSubscriptions;

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mSubscriptions != null && mSubscriptions.hasSubscriptions()) {
            mSubscriptions.clear();
        }
    }

    protected void trackSubscription(Subscription subscription) {
        if (mSubscriptions == null) {
            mSubscriptions = new CompositeSubscription();
        }

        mSubscriptions.add(subscription);
    }
}
