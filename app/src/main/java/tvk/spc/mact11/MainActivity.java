package tvk.spc.mact11;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ImageView imageHolder;
    private final int requestCode = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageHolder = findViewById(R.id.captured_photo);
        Button capturedImageButton = findViewById(R.id.photo_button);
        capturedImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == requestCode && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo;
            photo = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
            imageHolder.setImageBitmap(photo);
        }
    }
}
