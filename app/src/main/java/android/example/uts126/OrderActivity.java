package android.example.uts126;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    TextView bayar, pemesan, buah_, buah, total_harga, detail, metode_bayar;
    Spinner jumlah;
    EditText nama;
    String metode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra("extra_order");
        String harga = intent.getStringExtra("extra_cost");

        TextView order = findViewById(R.id.order_textview);
        order.setText(message);

        TextView cost = findViewById(R.id.harga);
        cost.setText(harga);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        nama = (EditText) findViewById(R.id.nama_fill);
        pemesan = (TextView) findViewById(R.id.pemesan);
        jumlah = (Spinner) findViewById(R.id.label_spinner);
        buah_ = (TextView) findViewById(R.id.order_textview);
        buah = (TextView) findViewById(R.id.buah);
        bayar = (TextView) findViewById(R.id.harga);
        total_harga = (TextView) findViewById(R.id.total_harga);
        detail = (TextView) findViewById(R.id.detail);
        metode_bayar = (TextView) findViewById(R.id.metode_bayar);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.transfer:
                if (checked)
                    metode = getString(R.string.transfer);
                break;
            case R.id.cod:
                if (checked)
                    metode = getString(R.string.cod);
                break;
            default:
                // Do nothing.
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void proses_pesan(View view) {
        String nama_ = nama.getText().toString();
        String buuah = buah_.getText().toString();
        String harga_ = bayar.getText().toString();
        String jum_ = jumlah.getSelectedItem().toString();
        String metode_ = metode;

        int juml = Integer.parseInt(harga_) * Integer.parseInt(jum_);
        String jum = Integer.toString(juml);

        pemesan.setText("Pemesanan untuk "+ nama_+" sedang diproses");
        buah.setText("pilihan buah: "+buuah);
        detail.setVisibility(View.VISIBLE);
        total_harga.setText("Total harga: "+jum);
        metode_bayar.setText("metode pembayaran: "+metode_);
    }
}
