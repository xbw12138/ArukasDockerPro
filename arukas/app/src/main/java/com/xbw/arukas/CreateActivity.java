package com.xbw.arukas;


import android.content.DialogInterface;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xbw.arukas.Adapter.EnvAdapter;
import com.xbw.arukas.Adapter.PortsAdapter;
import com.xbw.arukas.Bean.CreateBean;
import com.xbw.arukas.Bean.Envs;
import com.xbw.arukas.Bean.ErrorBean;
import com.xbw.arukas.Bean.Ports;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.View.CustomTextView;
import com.xbw.arukas.View.MyListView;
import com.xbw.arukas.utils.HttpClient;
import com.xbw.arukas.utils.T;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.Request;

public class CreateActivity extends BaseLeftActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.tv_status)
    CustomTextView tvStatus;
    @BindView(R.id.ET_appname)
    EditText ETAppname;
    @BindView(R.id.ET_image)
    EditText ETImage;
    @BindView(R.id.RadioA_mem)
    RadioButton RadioAMem;
    @BindView(R.id.RadioB_mem)
    RadioButton RadioBMem;
    @BindView(R.id.RadioC_mem)
    RadioButton RadioCMem;
    @BindView(R.id.RadioD_mem)
    RadioButton RadioDMem;
    @BindView(R.id.mRadioGroup_mem)
    RadioGroup mRadioGroupMem;
    @BindView(R.id.SB_instances)
    SeekBar SBInstances;
    @BindView(R.id.textViewsb)
    TextView textViewsb;
    @BindView(R.id.plan_money)
    TextView planMoney;
    @BindView(R.id.Li_instances)
    LinearLayout LiInstances;
    @BindView(R.id.ET_endpoint)
    EditText ETEndpoint;
    @BindView(R.id.Img_Padd)
    ImageView ImgPadd;
    @BindView(R.id.listview_port)
    MyListView listviewPort;
    @BindView(R.id.linearport)
    LinearLayout linearport;
    @BindView(R.id.Img_Eadd)
    ImageView ImgEadd;
    @BindView(R.id.listview_env)
    MyListView listviewEnv;
    @BindView(R.id.linearenv)
    LinearLayout linearenv;
    @BindView(R.id.ET_cmd)
    EditText ETCmd;
    @BindView(R.id.Btn_create)
    Button BtnCreate;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private PortsAdapter PortAdapter;
    private EnvAdapter EnvsAdapter;


    private List<Ports> listport;
    private List<Envs> listenv;

    String planid = "jp-tokyo/free";
    int instances = 1;
    int money = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTitle("Create Application");
        initView();
        PortAdapter = new PortsAdapter(CreateActivity.this, listport);
        EnvsAdapter = new EnvAdapter(CreateActivity.this, listenv);
        listviewPort.setAdapter(PortAdapter);
        listviewEnv.setAdapter(EnvsAdapter);
        initEvent();
    }

    private void initView() {
        listport = new ArrayList<Ports>();
        Ports p = new Ports();
        p.setProtocol("tcp");
        p.setNumber(22);
        listport.add(p);
        listenv = new ArrayList<Envs>();
    }

    private void initEvent() {
        ImgPadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog builder = new AlertDialog.Builder(CreateActivity.this)
                        .create();
                builder.show();
                builder.getWindow().setContentView(R.layout.dialogports_item);//设置弹出框加载的布局
                builder.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                builder.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                final EditText et = (EditText) builder.findViewById(R.id.ET_port);
                final RadioButton RB_a = (RadioButton) builder.findViewById(R.id.RadioC_Con);
                final RadioButton RB_b = (RadioButton) builder.findViewById(R.id.RadioD_Con);
                builder.getWindow()
                        .findViewById(R.id.Img_Padd)
                        .setOnClickListener(new View.OnClickListener() {  //按钮点击事件
                            @Override
                            public void onClick(View v) {
                                Ports p = new Ports();
                                if (isNumeric(et.getText().toString())) {
                                    p.setNumber(Integer.valueOf(!et.getText().toString().equals("") ? et.getText().toString() : "22").intValue());
                                    if (RB_a.isChecked()) {
                                        p.setProtocol("tcp");
                                    } else {
                                        p.setProtocol("udp");
                                    }
                                    PortAdapter.addItem(p);
                                    builder.dismiss();
                                } else {
                                    Toast.makeText(CreateActivity.this, "Port can only be a number", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
        ImgEadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog builder = new AlertDialog.Builder(CreateActivity.this)
                        .create();
                builder.show();
                builder.getWindow().setContentView(R.layout.dialogenv_item);//设置弹出框加载的布局
                builder.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                builder.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                final EditText et = (EditText) builder.findViewById(R.id.ET_key);
                final EditText et2 = (EditText) builder.findViewById(R.id.ET_value);
                builder.getWindow()
                        .findViewById(R.id.Img_Eadd)
                        .setOnClickListener(new View.OnClickListener() {  //按钮点击事件
                            @Override
                            public void onClick(View v) {
                                Envs p = new Envs();
                                p.setKey(et.getText().toString());
                                p.setValue(et2.getText().toString());
                                EnvsAdapter.addItem(p);
                                builder.dismiss();
                            }
                        });
            }
        });
        //seekbar设置最大值为9，旁边显示+1。根据textview记录数值
        SBInstances.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == 0) {
                    textViewsb.setText(1 + "");
                } else {
                    textViewsb.setText((i + 1) + "");
                }
                instances = i + 1;
                setMoney();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createApp();
            }
        });
        BtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createApp();
            }
        });
        mRadioGroupMem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                instances = 1;
                if (RadioAMem.isChecked()) {
                    planid = "jp-tokyo/free";
                    money = 0;
                    LiInstances.setVisibility(View.GONE);
                } else {
                    if (RadioBMem.isChecked()) {
                        planid = "jp-tokyo/hobby";
                        money = 540;
                        setMoney();
                    } else if (RadioCMem.isChecked()) {
                        planid = "jp-tokyo/standard-1";
                        money = 1080;
                        setMoney();
                    } else if (RadioDMem.isChecked()) {
                        planid = "jp-tokyo/standard-2";
                        money = 2160;
                        setMoney();
                    }
                    setInstances();
                }
            }
        });
    }

    String datajsonfinal = "";

    public void createApp() {
        if (ETAppname.getText().toString().equals("")) {
            T.showShort(getBaseContext(), "App name cannot be empty");
            return;
        } else if (ETImage.getText().toString().equals("")) {
            T.showShort(getBaseContext(), "Image cannot be empty");
            return;
        } else {
            String appname = ETAppname.getText().toString();
            String command = ETCmd.getText().toString();
            String customdomain = ETEndpoint.getText().toString();
            String image = ETImage.getText().toString();
            List<Envs> envs = EnvsAdapter.getEnvsAdapter();
            List<Ports> ports = PortAdapter.getPortsAdapter();
            datajsonfinal = genJson(appname, command, customdomain, image, envs, ports);
        }
        if (!planid.equals("jp-tokyo/free")) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("In order to ensure property security, non-free Docker please go to the official website to create");
            builder.setPositiveButton("Apply", null);
            builder.show();
        } else {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("Confirm to create Docker");
            builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    RequestCreate(datajsonfinal);
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.show();

        }
    }

    private void setMoney() {
        String sAgeFormat = getResources().getString(R.string.plan_money);
        String result = String.format(sAgeFormat, money * instances);
        planMoney.setText(result);
    }

    private void setInstances() {
        LiInstances.setVisibility(View.VISIBLE);
        SBInstances.setProgress(0);
        textViewsb.setText("1");
    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    private String genJson(String appname, String command, String customdomain, String image, List<Envs> envs, List<Ports> ports) {
        String json1 = "{\n" +
                "  \"data\":{\n" +
                "    \"type\": \"apps\",\n" +
                "    \"attributes\": {\n" +
                "      \"name\": \"%s\"\n" +
                "    },\n" +
                "    \"relationships\": {\n" +
                "      \"services\": {\n" +
                "        \"data\": [\n" +
                "          {\n" +
                "            \"lid\": \"1\",\n" +
                "            \"type\": \"services\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"included\": [\n" +
                "    {\n" +
                "      \"lid\": \"1\",\n" +
                "      \"type\": \"services\",\n" +
                "      \"attributes\": {\n" +
                "        \"command\": \"%s\",\n" +
                "        \"custom-domain\": \"%s\",\n" +
                "        \"image\": \"%s\",\n" +
                "        \"instances\": %d,\n" +
                "        \"ports\": [\n";

        String json2 = "],\n" +
                "        \"environment\": [\n";

        String json3 = "],\n" +
                "        \"subdomain\": \"%s\"\n" +
                "      },\n" +
                "      \"relationships\": {\n" +
                "        \"service-plan\": {\n" +
                "          \"data\": {\n" +
                "            \"type\": \"service-plans\",\n" +
                "            \"id\": \"%s\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String sports = "{\n" +
                "            \"number\": \"%s\",\n" +
                "            \"protocol\": \"%s\"\n" +
                "          }";
        String senvironment = "{\n" +
                "            \"key\": \"%s\",\n" +
                "            \"value\": \"%s\"\n" +
                "          }";

        //String appname = "ss";
        //String command = "/foo/bash.sh";
        //String customdomain = "ecfun.cc";
        //String image = "xbw12138/auto-shadowsocks:latest";

        //String plid = "jp-tokyo/free";// jp-tokyo/hobby jp-tokyo/standard-1 jp-tokyo/standard-2
        json1 = String.format(json1, appname, command, customdomain, image, instances);
        json3 = String.format(json3, "", planid);//subdomain还不清除作用

        for (int i = 0; i < ports.size(); i++) {
            if (i != 0) {
                json1 += ",";
                json1 += String.format(sports, ports.get(i).getNumber(), ports.get(i).getProtocol());
            } else {
                json1 += String.format(sports, ports.get(i).getNumber(), ports.get(i).getProtocol());
            }
        }
        json1 += json2;
        for (int i = 0; i < envs.size(); i++) {
            if (i != 0) {
                json1 += ",";
                json1 += String.format(senvironment, envs.get(i).getKey(), envs.get(i).getValue());
            } else {
                json1 += String.format(senvironment, envs.get(i).getKey(), envs.get(i).getValue());
            }
        }
        json1 += json3;
        Log.d("xbw12138", json1);
        return json1;
    }

    private void RequestCreate(String datajson) {
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_CREATE)
                .add("token", Config.Token)
                .add("datajson", datajson)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(getBaseContext(), "Network connection failure");
            }

            @Override
            public void onSuccess(Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                CreateBean util = gson.fromJson(result, CreateBean.class);
                if (util.getStatuscode() == 201) {
                    T.showShort(getBaseContext(), "Create Successful");
                    setResult(RESULT_OK, null);
                    finish();
                } else {
                    ErrorBean error = gson.fromJson(result, ErrorBean.class);
                    T.showShort(getBaseContext(), error.getData().getErrors().get(0).getTitle().toString());
                }
            }
        });
    }
}

