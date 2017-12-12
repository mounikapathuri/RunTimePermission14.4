package com.android.mounika.runtimepermission144;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission_group.CAMERA;

public class MainActivity extends AppCompatActivity {
    Button btnCheck,btnGrant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = (Button) findViewById(R.id.btnCheckPermission);
        btnGrant = (Button) findViewById(R.id.btnGrantPermission);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPermissionGranted()){
                    Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Request Permission First",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGrant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPermissionGranted())
                    requestPermission();
                else
                    Toast.makeText(MainActivity.this,"Permission already granted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA},101);
    }
    //checking permission is granted or not
    private boolean isPermissionGranted(){
        boolean isGranted = false;
        int res = ActivityCompat.checkSelfPermission(getApplicationContext(),CAMERA);
        if (res== PackageManager.PERMISSION_GRANTED){
            isGranted=true;
        }
        return isGranted;
    }
}
