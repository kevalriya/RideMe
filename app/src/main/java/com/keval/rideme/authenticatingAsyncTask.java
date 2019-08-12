package com.keval.rideme;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class authenticatingAsyncTask extends AsyncTask<String, String, String> {
    private StringBuilder sb = new StringBuilder();
    private ProgressDialog progressDialog;
    @SuppressLint("StaticFieldLeak")
    private Context context;

    authenticatingAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        /*//=============================================================
         * to show progress bar while we check credentials
         */
        progressDialog = new ProgressDialog(context,
                R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...!!!");
        progressDialog.show();
        //=============================================================
    }

    @Override
    protected String doInBackground(String... params) {
        //=================================================================================
        String ip = "192.168.0.174";
        String url = "http://" + ip + ":8080/www/"+params[0]+".php";
        try {
            //Append parameters to URL
            int p = params.length;
            Uri.Builder builder = new Uri.Builder();
            for(int i = 1; i<p;i++){
                builder.appendQueryParameter("params"+i, params[i]);
            }

            url += "?" + builder.build().getEncodedQuery();
            // Setup HttpURLConnection class to send and receive data from php and mysql
            URL urlObj = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            //Open connection to send data
            urlConnection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            //sb = reader.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //===============================================================================
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (sb.toString().equals("success")) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            prefs.edit().putBoolean("Islogin", true).apply();
            Intent i = new Intent(context, MainActivity.class);
            context.startActivity(i);
            ((Activity) context).finish();

        } else {
            Toast toast = Toast.makeText(context, "error", Toast.LENGTH_LONG);
            toast.show();
            progressDialog.dismiss();

        }
    }

}
