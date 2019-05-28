package com.example.a121firstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.bumptech.glide.request.*;
import com.facebook.login.widget.ProfilePictureView;
import com.google.firebase.database.Transaction;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class UserAccountRegisterFacebookActivity extends AppCompatActivity   {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private TextView show;
    private TextView emailfb;
    private TextView gender;
    private TextView facebookName;
    private Context mContext;
    private ProfilePictureView profilePictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_user_account_register_facebook);



        show = (TextView)findViewById(R.id.txtshow);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        emailfb = (TextView)findViewById(R.id.emailfb);
        facebookName = (TextView)findViewById(R.id.namefb);
        gender = (TextView)findViewById(R.id.genderfb);
        profilePictureView = (ProfilePictureView) findViewById(R.id.imagefb);

       LoginManager.getInstance().logInWithReadPermissions(this,Arrays.asList("public_profile"," email "));

        callbackManager = CallbackManager.Factory.create();

        Login();


        } // create



        private void Login() {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {


                                try {

                                    String id = object.getString("id");
                                    String firstName = object.getString("first_name");
                                    String lastName = object.getString("last_name");


                                    emailfb.setText(object.getString("email"));
                                    facebookName.setText(firstName +" "+ lastName);
                                    profilePictureView.setPresetSize(ProfilePictureView.NORMAL);
                                    profilePictureView.setProfileId(id);

                                    Bundle arg = new Bundle();
                                    arg.putString("Name",firstName + " " + lastName);
                                    arg.putInt("Pic", object.getInt("picture") );

                                    Fragment fragment = new fram_account();
                                    fragment.setArguments(arg);
                                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                    transaction.replace(R.id.com_facebook_fragment_container,fragment);
                                    transaction.commit();
                                    



                                } catch(JSONException e) {
                                    Log.d("FB","Error parsing JSON");
                                }


                            }

                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,first_name,last_name,email,picture");
                request.setParameters(parameters);
                request.executeAsync();

                Toast.makeText(UserAccountRegisterFacebookActivity.this,"login successful",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancel() {
                show.setText("Cancel");

            }

            @Override
            public void onError(FacebookException error) {
                show.setText("Error: " + error.getMessage());
            }
        });
    }

    @Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

                super.onActivityResult(requestCode, resultCode, data);
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }



}
