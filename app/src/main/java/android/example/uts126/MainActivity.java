package android.example.uts126;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String buah, cost;

    public void beli_Mangga(View view) {
        buah = "Mangga";
        cost = "20000";

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("extra_order", buah);
        intent.putExtra("extra_cost", cost);
        startActivity(intent);
    }

    public void beli_Apel(View view) {
        buah = "Apel Fuji";
        cost = "35000";

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("extra_order", buah);
        intent.putExtra("extra_cost", cost);
        startActivity(intent);
    }

    public void beli_AngMer(View view) {
        buah = "Anggur Merah";
        cost = "40000";

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("extra_order", buah);
        intent.putExtra("extra_cost", cost);
        startActivity(intent);
    }

    public void beli_AngHit(View view) {
        buah = "Anggur Hitam";
        cost = "30000";

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("extra_order", buah);
        intent.putExtra("extra_cost", cost);
        startActivity(intent);
    }

    public void info_anghit(View view) {
        String url = "https://lifestyle.sindonews.com/read/1278773/155/10-manfaat-anggur-hitam-mulai-fungsi-otak-hingga-kulit-1517539621";

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void info_angmer(View view) {
        String url = "https://doktersehat.com/manfaat-anggur-merah/";

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void info_apel(View view) {
        String url = "https://doktersehat.com/lima-manfaat-buah-apel/";

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

    public void info_mangga(View view) {
        String url = "https://doktersehat.com/manfaat-mangga/";

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
