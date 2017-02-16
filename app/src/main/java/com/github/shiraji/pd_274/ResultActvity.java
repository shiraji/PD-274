package com.github.shiraji.pd_274;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class ResultActvity extends AppCompatActivity {

    TextView mStartPoint, mFinishPoint, mDistance, mFuelCost, mFuelConsumpt, mPrice, mDateTime, mWarning, mResult;
    ImageButton mShareButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_actvity);

        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Uygulama çok güzel";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Uygulama hakkında");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Paylaş"));
*/
                View v1 = getWindow().getDecorView().getRootView();
                // View v1 = iv.getRootView(); //even this works
                // View v1 = findViewById(android.R.id.content); //this works too
                // but gives only content
                v1.setDrawingCacheEnabled(true);
                Bitmap myBitmap = v1.getDrawingCache();
                saveBitmap(myBitmap);

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @NeedsPermission({Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS})
    void saveBitmap(Bitmap bitmap) {
        String filePath = Environment.getExternalStorageDirectory()
                + File.separator + "Pictures/screenshot.png";
        File imagePath = new File(filePath);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            sendMail(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendMail(String path) {
        // NO strings
//        Intent emailIntent = new Intent(Intent.ACTION_SEND);
//        emailIntent.putExtra(Intent.EXTRA_EMAIL,
//                new String[]{getString(R.string.mail_name)});
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
//                getString(R.string.mail_subject));
//        emailIntent.putExtra(Intent.EXTRA_TEXT,
//                getString(R.string.mail_content));
//        emailIntent.setType("image/png");
//        Uri myUri = Uri.parse("file://" + path);
//        emailIntent.putExtra(Intent.EXTRA_STREAM, myUri);
//        startActivity(Intent.createChooser(emailIntent, getString(R.string.mail_send)));
    }

}
