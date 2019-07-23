package com.xbw.arukas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.xbw.arukas.Adapter.MainAdapter;
import com.xbw.arukas.Bean.AllappBean;
import com.xbw.arukas.Bean.ErrorBean;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.utils.HttpClient;
import com.xbw.arukas.utils.T;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.listview_main)
    ListView listView;
    @BindView(R.id.fabcreate)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.frame_nodata)
    FrameLayout frameLayout;

    private MainAdapter mainAdapter;
    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getApps();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getApps();
            }
        });
        floatingActionButton.setColorFilter(getResources().getColor(R.color.white));
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                getApps();
            }
        }
    }

    private void getApps() {
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_ALLAPP)
                .add("token", Config.Token)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(getBaseContext(), "Network connection failure");
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                AllappBean util = gson.fromJson(result, AllappBean.class);
                if (util.getStatuscode() == 200) {
                    if (util.getData().getData().size() == 0) {
                        frameLayout.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                    } else {
                        frameLayout.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        mainAdapter = new MainAdapter(MainActivity.this, util.getData().getData());
                        listView.setAdapter(mainAdapter);
                    }

                } else {
                    ErrorBean error = gson.fromJson(result, ErrorBean.class);
                    T.showShort(getBaseContext(), error.getData().getErrors().get(0).getTitle().toString());
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("About");
            builder.setMessage("Based on Arukas API\n" +
                    "The author never saves user data\n" +
                    "------------\n" +
                    "Sina Weibo : @偏不写作业\n" +
                    "Twitter : @Bad_Apple____\n" +
                    "Github : xbw12138"
            );
            builder.setPositiveButton("Close", null);
            builder.show();
            return true;
        } else if (id == R.id.feedback) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(Config.ABOUT_URL));
            intent.setAction(Intent.ACTION_VIEW);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
