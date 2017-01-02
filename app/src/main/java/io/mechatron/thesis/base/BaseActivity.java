package io.mechatron.thesis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.mechatron.thesis.R;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by migz on 1/2/17.
 */

public class BaseActivity extends AppCompatActivity {

    /**
     * Contains all of the subscriptions added on this activity
     */
    private CompositeSubscription mSubscriptions;

    /**
     * The toolbar used by this activity
     */
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            mToolbar.setNavigationContentDescription(getString(R.string.app_name));
            setSupportActionBar(mToolbar);
        }
    }

    @Override
    protected void onDestroy() {
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
