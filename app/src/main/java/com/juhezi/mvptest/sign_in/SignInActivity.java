package com.juhezi.mvptest.sign_in;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.juhezi.mvptest.R;
import com.juhezi.mvptest.model.ResponseImpl;
import com.juhezi.mvptest.model.local.LocalResponse;
import com.juhezi.mvptest.model.remote.RemoteResponse;

public class SignInActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ActionBar mActionBar;

    private SignInFragment mFragment;
    private SignInPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_act);

        initActionBar();

        initFragment();
    }

    private void initFragment() {
        mFragment = (SignInFragment) getSupportFragmentManager().findFragmentById(R.id.rl_sign_in_frag);
        if (mFragment == null) {
            mFragment = new SignInFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.rl_sign_in_frag, mFragment)
                    .commit();
        }
        mPresenter = new SignInPresenter(mFragment,
                new ResponseImpl(new LocalResponse(), new RemoteResponse()));
    }

    private void initActionBar() {
        mToolbar = (Toolbar) findViewById(R.id.tb_sign_in);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
    }

}
