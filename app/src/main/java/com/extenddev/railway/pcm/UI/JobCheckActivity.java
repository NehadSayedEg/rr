package com.extenddev.railway.pcm.UI;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.extenddev.railway.pcm.Data.AgentData.AgRoleElm;
import com.extenddev.railway.pcm.Data.AgentData.AgentList;
import com.extenddev.railway.pcm.Data.AgentData.Data;
import com.extenddev.railway.pcm.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobCheckActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.userIDTextView)
    TextView userIDTextView;
    @BindView(R.id.userIDEditText)
    ExtractEditText userIDEditText;
    @BindView(R.id.checkBtn)
    Button checkBtn;
    @BindView(R.id.passwordTextview)
    TextView passwordTextview;
    @BindView(R.id.jobSpinner)
    AppCompatSpinner jobSpinner;
    @BindView(R.id.confirmBtn)
    Button confirmBtn;


     Context context ;
    private ProgressDialog progressDialog;

    String agentUserName;
    private String result;
    private AgRoleElm AgRoleElm;
    private AgentList agentList ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_check);
        ButterKnife.bind(this);

        agentUserName = userIDEditText.getText().toString();


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check Agent...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

           checkBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   userNameValidation();
               }
           });


       //jobSpinner.setOnItemSelectedListener(this);
       // ArrayList<String> list = new ArrayList<String>();
       // list.add("RANJITH");
       // list.add("ARUN");

        ArrayList<String> rolename = new ArrayList<String>();
        rolename.add("role");
        rolename.add("role2");
        rolename.add("role3");



        ArrayAdapter< AgRoleElm > adapter =  new ArrayAdapter<AgRoleElm>
               (this ,android.R.layout.simple_spinner_item );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
       jobSpinner.setAdapter(adapter);
       jobSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AgRoleElm agRoleElm = (AgRoleElm) parent.getSelectedItem();
        displayRole(agRoleElm);
        String selectedRole = parent.getItemAtPosition(position).toString();
        if(selectedRole.equals("26")){
            Intent intent = new Intent(JobCheckActivity.this ,CheckStationActivity.class );
            startActivity(intent);
        }
        if(selectedRole.equals("28")) {

        }
        if(selectedRole.equals("29")){

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

        public void getSelectd(View view){
            AgRoleElm agRoleElm = (AgRoleElm) jobSpinner.getSelectedItem();
            displayRole(agRoleElm);
    }
    public void displayRole(AgRoleElm agRoleElm){
        int  roleId =  agRoleElm.getAgRoleElmID();
    }

         private void userNameValidation() {
            if (!emptyValidation()) {
                progressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                     //   agentList = agentDao.CheckAgentName();

                        if(agentList!=null){


                            finish();
                        }else{
                            Toast.makeText(JobCheckActivity.this, "Please Write a valid UserName ",
                                    Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                }, 1000);

            }else{
                Toast.makeText(JobCheckActivity.this, "Please Enter your UserName", Toast.LENGTH_SHORT).show();
            }
        }


        private boolean emptyValidation() {
            if (TextUtils.isEmpty(agentUserName)) {
                return true;
            } else {
                return false;
            }
        }
            public  String readFromFile(Context context) {

                String ret = "";

                try {
                    InputStream inputStream = context.openFileInput("DataFile.utf");
                    //.openFileInput("config.txt");

                    if ( inputStream != null ) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String receiveString = "";
                        StringBuilder stringBuilder = new StringBuilder();

                        while ( (receiveString = bufferedReader.readLine()) != null ) {
                            stringBuilder.append(receiveString);
                        }

                        inputStream.close();
                        ret = stringBuilder.toString();
                    }
                }
                catch (FileNotFoundException e) {
                    Log.e("login activity", "File not found: " + e.toString());
                } catch (IOException e) {
                    Log.e("login activity", "Can not read file: " + e.toString());
                }

                return ret;
            }

            public void parseJson() {

        Gson gson = new Gson();
        String json = result;
        Data data = gson.fromJson(json, Data.class);
    }

            public void StringTOjson() {
        Gson gson = new Gson();
        AgentList agentList = new AgentList();
        String json = gson.toJson(agentList);

    }


    public void RoleName() {
        StringTOjson();
        Resources res = getResources();
        String[] job = res.getStringArray(AgRoleElm.getAgRoleElmID());

        List< AgRoleElm > roleList = agentList.getAgRoleElm();
        for (s: roleList) {
            if (roleList.contains(29)) {
            }
        }
    }







}
