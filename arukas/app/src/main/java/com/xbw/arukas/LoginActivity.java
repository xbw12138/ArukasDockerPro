package com.xbw.arukas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.xbw.arukas.Bean.ErrorBean;
import com.xbw.arukas.Bean.TokenBean;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.utils.HttpClient;
import com.xbw.arukas.utils.T;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.Request;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (!getSettingUser(Config.SHPF_USER).equals("") && !getSettingPass(Config.SHPF_PASS).equals("")) {
            String name = getSettingUser(Config.SHPF_USER);
            String pass = getSettingPass(Config.SHPF_PASS);
            _emailText.setText(name);
            _emailText.setSelection(name.length());
            _passwordText.setText(pass);
            _passwordText.setSelection(pass.length());
        }
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Uri uri = Uri.parse("https://app.arukas.io");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        Log.d("xbw12138", getDeviceId());
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed("Input error");
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_LOGIN)
                .add("email", email)
                .add("pwd", password)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                onLoginFailed("Network connection failure");
                progressDialog.dismiss();
            }

            @Override
            public void onSuccess(Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                TokenBean util = gson.fromJson(result, TokenBean.class);
                if (util.getStatuscode() == 200) {
                    Config.Token = util.getData().getToken().toString();//存储Token
                    onLoginSuccess();
                } else {
                    ErrorBean error = gson.fromJson(result, ErrorBean.class);
                    onLoginFailed(error.getData().getErrors().get(0).getTitle().toString());
                }
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        saveSettingUser(Config.SHPF_USER, _emailText.getText().toString());
        saveSettingPass(Config.SHPF_PASS, _passwordText.getText().toString());
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    public void onLoginFailed(String s) {
        T.showShort(getBaseContext(), s);
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError("enter a password");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    private void saveSettingUser(String s, String saveData) {//保存设置
        SharedPreferences.Editor note = getSharedPreferences(Config.SHPF_ARUKAS, MODE_PRIVATE).edit();
        note.putString(s, saveData);
        note.commit();
    }

    private String getSettingUser(String s) {//获取保存设置
        SharedPreferences read = getSharedPreferences(Config.SHPF_ARUKAS, MODE_PRIVATE);
        return read.getString(s, "");
    }

    private void saveSettingPass(String s, String saveData) {//保存设置
        SharedPreferences.Editor note = getSharedPreferences(Config.SHPF_ARUKAS, MODE_PRIVATE).edit();
        note.putString(s, saveData);
        note.commit();
    }

    private String getSettingPass(String s) {//获取保存设置
        SharedPreferences read = getSharedPreferences(Config.SHPF_ARUKAS, MODE_PRIVATE);
        return read.getString(s, "");
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

    private String getDeviceId() {
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Activity.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            String time = Long.toString((System.currentTimeMillis() / (1000 * 60 * 60)));
            deviceId = time + time;
        }
        return deviceId;
    }
}
