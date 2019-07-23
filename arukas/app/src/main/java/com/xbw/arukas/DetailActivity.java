package com.xbw.arukas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xbw.arukas.Bean.AllappBean;
import com.xbw.arukas.Bean.DetailBean;
import com.xbw.arukas.Bean.ErrorBean;
import com.xbw.arukas.Bean.StartBean;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.utils.HttpClient;
import com.xbw.arukas.utils.T;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;

public class DetailActivity extends BaseLeftActivity {
    private String containerID = "";
    private String appID = "";
    private int instances = 1;
    private boolean openswitch = false;
    private static final int REQUEST_SIGNUP = 1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.tv_update)
    TextView tv_update;
    @BindView(R.id.tv_id)
    TextView tv_id;
    @BindView(R.id.tv_appname)
    TextView tv_appname;
    @BindView(R.id.tv_image)
    TextView tv_image;
    @BindView(R.id.tv_serviceplan)
    TextView tv_serviceplan;
    @BindView(R.id.tv_endpoint)
    TextView tv_endpoint;
    @BindView(R.id.tv_port)
    TextView tv_port;
    @BindView(R.id.tv_env)
    TextView tv_env;
    @BindView(R.id.tv_cmd)
    TextView tv_cmd;
    @BindView(R.id.tv_status)
    TextView tv_status;
    @BindView(R.id.switch1)
    Switch sw_status;
    @BindView(R.id.Btn_extensions)
    Button btn_extensions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setTitle(getIntent().getStringExtra("name"));
        containerID = getIntent().getStringExtra("containerID");
        setSupportActionBar(toolbar);
        getContainer(containerID);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //T.showShort(getBaseContext(),"Will not open the editing function");
                Intent intent = new Intent();
                intent.setClass(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("image", tv_image.getText().toString());
                intent.putExtra("serviceplan", tv_serviceplan.getText().toString());
                intent.putExtra("cmd", tv_cmd.getText().toString());
                intent.putExtra("ports", tv_port.getText().toString());
                intent.putExtra("envs", tv_env.getText().toString());
                intent.putExtra("instances", instances + "");
                intent.putExtra("containerID", containerID);
                intent.putExtra("appID", appID);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        sw_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (openswitch) {
                    getStop(containerID);
                } else {
                    getStart(containerID);
                }
            }
        });
        btn_extensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_status.isChecked()){
                    Intent intent = new Intent();
                    intent.setClass(DetailActivity.this, ExtensionActivity.class);
                    startActivity(intent);
                }else{
                    T.showShort(getBaseContext(),"Docker is not running,can't start extensions");
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                getContainer(containerID);
            }
        }
    }

    private void getStart(String id) {
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_START)
                .add("token", Config.Token)
                .add("serviceid", id)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(okhttp3.Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(getBaseContext(), "Network connection failure");
            }

            @Override
            public void onSuccess(okhttp3.Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                StartBean util = gson.fromJson(result, StartBean.class);
                if (util.getStatuscode() == 202) {
                    //刷新状态
                    T.showShort(getBaseContext(), "Refresh state after two seconds");
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            getContainer(containerID);
                        }
                    }, 2000);
                } else if (util.getStatuscode() == 403) {
                    T.showShort(getBaseContext(), "You have been not allowed to boot app due to penalty.");
                } else if (util.getStatuscode() == 404) {
                    T.showShort(getBaseContext(), "No such service");
                } else if (util.getStatuscode() == 409) {
                    T.showShort(getBaseContext(), "The app is not bootable.");
                } else {
                    T.showShort(getBaseContext(), "An unknown error!");
                }
            }
        });
    }

    private void getStop(String id) {
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_CLOSE)
                .add("token", Config.Token)
                .add("serviceid", id)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(okhttp3.Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(getBaseContext(), "Network connection failure");
            }

            @Override
            public void onSuccess(okhttp3.Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                AllappBean util = gson.fromJson(result, AllappBean.class);
                if (util.getStatuscode() == 202) {
                    getContainer(containerID);
                } else if (util.getStatuscode() == 404) {
                    T.showShort(getBaseContext(), "No such service");
                } else {
                    T.showShort(getBaseContext(), "An unknown error!");
                }
            }
        });
    }

    private void getContainer(String id) {
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_ONESERVICE)
                .add("token", Config.Token)
                .add("serviceid", id)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(okhttp3.Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(getBaseContext(), "Network connection failure");
            }

            @Override
            public void onSuccess(okhttp3.Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                DetailBean util = gson.fromJson(result, DetailBean.class);
                if (util.getStatuscode() == 200) {
                    Config.JSONDATA = result;
                    appID = util.getData().getData().getId();
                    String appid = util.getData().getData().getId();
                    String image = util.getData().getData().getAttributes().getImage();
                    String cmd = util.getData().getData().getAttributes().getCommand();
                    String serviceplan = util.getData().getData().getRelationships().getServiceplan().getData().getId();
                    List<DetailBean.DataBeanXXX.DataBeanXX.AttributesBean.EnvironmentBean> environment = util.getData().getData().getAttributes().getEnvironment();
                    List<String> ports = util.getData().getData().getAttributes().getPorts();
                    List<List<DetailBean.DataBeanXXX.DataBeanXX.AttributesBean.PortmappingsBean>> portMappings = util.getData().getData().getAttributes().getPortmappings();
                    String created_at = util.getData().getData().getAttributes().getCreatedat();
                    String updated_at = util.getData().getData().getAttributes().getUpdatedat();
                    String status_text = util.getData().getData().getAttributes().getStatus();
                    String arukas_domain = util.getData().getData().getAttributes().getSubdomain();
                    String end_point = util.getData().getData().getAttributes().getEndpoint();
                    String custom_domains = util.getData().getData().getAttributes().getCustomdomain();
                    instances = util.getData().getData().getAttributes().getInstances();
                    if (status_text != null) {
                        if (status_text.equals("running")) {
                            sw_status.setChecked(true);
                            openswitch = true;
                            tv_status.setText("Status: " + status_text);
                        } else if (status_text.equals("stopped")) {
                            sw_status.setChecked(false);
                            openswitch = false;
                            tv_status.setText("Status: " + status_text);
                        } else if (status_text.equals("booting")) {
                            sw_status.setChecked(true);
                            openswitch = true;
                            tv_status.setText("Status: deploying... (" + status_text + ")");
                        } else if (status_text.equals("terminated")) {
                            sw_status.setChecked(false);
                            openswitch = false;
                            tv_status.setText("Status: Failed to start (" + status_text + ")");
                        }
                    }
                    tv_update.setText(updated_at != null ? getTime(updated_at) : "");
                    tv_appname.setText(getIntent().getStringExtra("name"));
                    tv_id.setText(appid != null ? appid : "");
                    tv_image.setText(image != null ? image : "");
                    tv_serviceplan.setText(serviceplan);
                    tv_endpoint.setText(end_point != null ? end_point : "");

                    String pportss = "";
                    if (portMappings != null) {
                        for (int i = 0; i < portMappings.size(); i++) {
                            for (int j = 0; j < portMappings.get(i).size(); j++) {
                                pportss += "http://" + portMappings.get(i).get(j).getHost() + ":" + portMappings.get(i).get(j).getServiceport() + "(" + portMappings.get(i).get(j).getContainerport() + "/" + portMappings.get(i).get(j).getProtocol() + ")\n";
                                //pportss+="container_port: "+portMappings.get(i).get(j).getContainerPort()+"\nservice_port: "+portMappings.get(i).get(j).getHost()+"\nhost: "+portMappings.get(i).get(j).getServicePort()+"\n";
                            }
                        }
                    }
                    tv_port.setText(pportss);
                    if (environment == null) {
                        tv_env.setText("0 environment variable(s) has/have been set");
                    } else {
                        String eenvss = "";
                        for (int i = 0; i < environment.size(); i++) {
                            eenvss += environment.get(i).getKey() + " = " + environment.get(i).getValue() + "\n";
                        }
                        tv_env.setText(eenvss);
                    }
                    if (cmd != null) {
                        if (cmd.equals("")) {
                            tv_cmd.setText("Unspecified");
                        } else {
                            tv_cmd.setText(cmd);
                        }
                    } else {
                        tv_cmd.setText("Unspecified");
                    }
                } else {
                    ErrorBean error = gson.fromJson(result, ErrorBean.class);
                    T.showShort(getBaseContext(), error.getData().getErrors().get(0).getTitle().toString());
                }
            }
        });
    }

    public String getTime(String s) {
        //2018-06-02T15:38:55.087Z
        s = s.replace("Z", "");
        s = s.replace("T", " ");
        String newtime = s;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = sd.parse(s);
            long rightTime = (long) (d.getTime() + 8 * 60 * 60 * 1000); //加上8小时对应的毫秒数
            newtime = sd.format(rightTime);
        } catch (Exception e) {

        }
        return newtime;
    }


}
