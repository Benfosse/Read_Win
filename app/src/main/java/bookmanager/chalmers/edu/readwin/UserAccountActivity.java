package bookmanager.chalmers.edu.readwin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import bookmanager.chalmers.edu.readwin.models.User;
import bookmanager.chalmers.edu.readwin.services.UserService;

public class UserAccountActivity extends AppCompatActivity {

    User currentUser;
    private static final int PERMISSION_REQUEST_CODE = 1;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        UserService userService = new UserService(getApplicationContext());
        currentUser = userService.getCurrentUser();
        if ((Build.VERSION.SDK_INT >= 23) && (!checkPermission())){
                requestPermission(); // Code for permission
            }

        TextView userName = (TextView) findViewById(R.id.account_username);
        TextView firstName = (TextView) findViewById(R.id.account_first_name);
        TextView lastName = (TextView) findViewById(R.id.account_last_name);
        TextView yearOfBirth = (TextView) findViewById(R.id.account_date_of_birth);
        TextView email = (TextView) findViewById(R.id.account_email);
        TextView userScore = (TextView) findViewById(R.id.account_score);
        ImageView avatar = (ImageView) findViewById(R.id.account_avatar_preview);
        String path = Environment.getExternalStorageDirectory()
                + File.separator + "avatar" +currentUser.getId() + ".png";
        File imgFile = new File(path);

        if(imgFile.exists())
        {


            //Bitmap myBitmap = BitmapFactory.decodeFile(path);
            Bitmap myBitmap = decodeFile(imgFile);
           // avatar.setImageBitmap(getScaledBitmap(path, 100, 100));
            //avatar.setImageBitmap(myBitmap);
            //avatar.setImageURI(Uri.parse(new File(path).toString()));
            //avatar.setImageBitmap(getScaledBitmap(path,400,400));
            Glide.with(avatar.getContext()).load(path).signature(new StringSignature(UUID.randomUUID().toString())).into(avatar);

            //  Picasso.with(context).load(new File(path)).into(avatar);


        }

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent splash = new Intent(context, Splash.class);
                startActivity(splash);
            }
        });


        userName.setText(currentUser.getUserName());
        firstName.setText(currentUser.getFirstName());
        lastName.setText(currentUser.getLastName());
        yearOfBirth.setText(String.valueOf(currentUser.getYearOfBirth()));
        email.setText(currentUser.getEmail());
        userScore.setText(String.valueOf(currentUser.getCurrentScore()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_user, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        UserService userService = new UserService(getApplicationContext());
        currentUser = userService.getCurrentUser();

        TextView userName = (TextView) findViewById(R.id.account_username);
        TextView firstName = (TextView) findViewById(R.id.account_first_name);
        TextView lastName = (TextView) findViewById(R.id.account_last_name);
        TextView yearOfBirth = (TextView) findViewById(R.id.account_date_of_birth);
        TextView email = (TextView) findViewById(R.id.account_email);
        TextView userScore = (TextView) findViewById(R.id.account_score);ImageView avatar = (ImageView) findViewById(R.id.account_avatar_preview);
        String path = Environment.getExternalStorageDirectory()
                + File.separator + "avatar" +currentUser.getId() + ".png";
        File imgFile = new File(path);

        if(imgFile.exists())
        {
            //Bitmap myBitmap = BitmapFactory.decodeFile(path);
            Bitmap myBitmap = decodeFile(imgFile);
            //avatar.setImageBitmap(getScaledBitmap(path, 100, 100));
           // avatar.setImageURI(Uri.parse(new File(path).toString()));
            //avatar.setImageBitmap(myBitmap);
           // avatar.setImageBitmap(getScaledBitmap(path,400,400));
            //Glide.with(avatar.getContext()).skipMemoryCache(true);
            Glide.with(avatar.getContext()).load(path).signature(new StringSignature(UUID.randomUUID().toString())).into(avatar);


            //Picasso.with(context).load(new File(path)).into(avatar);


        }

        userName.setText(currentUser.getUserName());
        firstName.setText(currentUser.getFirstName());
        lastName.setText(currentUser.getLastName());
        yearOfBirth.setText(String.valueOf(currentUser.getYearOfBirth()));
        email.setText(currentUser.getEmail());
        userScore.setText(String.valueOf(currentUser.getCurrentScore()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.edit_user)
        {
            Intent editUserAccountIntent = new Intent(UserAccountActivity.this,
                    EditUserAccountActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("user", currentUser);
            editUserAccountIntent.putExtras(bundle);

            startActivity(editUserAccountIntent);
        }

        return super.onOptionsItemSelected(item);
    }



    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(UserAccountActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE);
        int result2 = ContextCompat.checkSelfPermission(UserAccountActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED && result2==PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(UserAccountActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast.makeText(UserAccountActivity.this, "Read External Storage permission allows us to display avatar. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(UserAccountActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(UserAccountActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(UserAccountActivity.this, "Read External Storage permission allows us to display avatar. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(UserAccountActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }

    // Decodes image and scales it to reduce memory consumption
    private Bitmap decodeFile(File f) {
        try {
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            // The new size we want to scale to
            final int REQUIRED_SIZE=70;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while(o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {}
        return null;
    }

    private Bitmap getScaledBitmap(String picturePath, int width, int height) {
        BitmapFactory.Options sizeOptions = new BitmapFactory.Options();
        sizeOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(picturePath, sizeOptions);

        int inSampleSize = calculateInSampleSize(sizeOptions, width, height);

        sizeOptions.inJustDecodeBounds = false;
        sizeOptions.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(picturePath, sizeOptions);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}
