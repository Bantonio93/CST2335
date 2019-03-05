package com.example.androidlabs;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 867593;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton mImageButton;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";
    private Button goChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_profile);
        Intent fromPrevious = getIntent();
        String previousType = fromPrevious.getStringExtra("typed");
        EditText enterText = findViewById(R.id.editText4);
        enterText.setText(previousType);
       mImageButton = findViewById(R.id.imageButton2);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,REQUEST_IMAGE_CAPTURE);
            }
        });
        goChat = findViewById(R.id.goToChat);
        goChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPage = new Intent(ProfileActivity.this, ChatRoomAcivity.class);
                startActivity(nextPage);
            }
        });
        Log.e(ACTIVITY_NAME, "In function:" +  "onCreate" );

        // button to go to chat


    }
      //  click.setOnClickListener( b -> {
       public void takePicture(View view) {
        if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
        {
            dispatchTakePictureIntent();
        }
        else
        {
            // if we do not have permission to invoke camera
            String [] permissionRequest = {Manifest.permission.CAMERA};
            requestPermissions(permissionRequest,CAMERA_PERMISSION_REQUEST_CODE);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                dispatchTakePictureIntent ();
            }
             else
                 {
                     Toast.makeText(this, "can not take photo", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void dispatchTakePictureIntent ()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
            Log.e(ACTIVITY_NAME, "In function:   onActivityResult" );
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(ACTIVITY_NAME, "In function:  onStart" );
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.e(ACTIVITY_NAME, "In function: onResume" );
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.e(ACTIVITY_NAME, "In function: onPause" );
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.e(ACTIVITY_NAME, "In function:   onStop" );
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In function:   onDestroy" );


    }

}












