package com.thor.laporyuk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FormActivity extends AppCompatActivity {
    String topik,name,lapor,nomor, Massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

    }

    public void kembali(View view) {
        Intent kembali = new Intent(FormActivity.this,MainActivity.class);
        startActivity(kembali);
    }

    public void kirim(View view) {

        RadioButton pendidikan =(RadioButton) findViewById(R.id.RbPendidikan);
        boolean hasPendidikan = pendidikan.isChecked();
        RadioButton fasilitas = (RadioButton) findViewById(R.id.RbFasilitas);
        boolean hasFasilitas = fasilitas.isChecked();
        RadioButton kriminal = (RadioButton) findViewById(R.id.RbKriminal);
        boolean hasKriminal = kriminal.isChecked();
        RadioButton kesehatan = (RadioButton) findViewById(R.id.RbKesehatan);
        boolean hasKesehatan = kesehatan.isChecked();
        RadioButton pelayanan = (RadioButton) findViewById(R.id.RbPelayanan);
        boolean hasPelayanan = pelayanan.isChecked();
        RadioButton lain = (RadioButton) findViewById(R.id.RbLain);
        boolean hasLain = lain.isChecked();

        if (hasPendidikan == true)
        {
            topik = "Pendidikan" ;
        } else if (hasFasilitas == true)
        {
            topik = "Fasilitas dan Infrastruktur" ;
        }else if (hasKriminal == true)
        {
            topik = "Kriminalitas" ;
        }else if (hasKesehatan == true)
        {
            topik = "Kesehatan dan Pelayanan" ;
        }else if (hasPelayanan == true)
        {
            topik = "Pelayanan Masyarakat" ;
        }else if (hasLain == true)
        {
            topik = "Lain - Lain" ;
        }


        EditText etname = findViewById(R.id.etName);
        String name = etname.getText().toString();

        EditText etnomor = findViewById(R.id.etNomor);
        String nomor = etnomor.getText().toString();

        EditText etLapor = findViewById(R.id.etLapor);
        String lapor = etLapor.getText().toString();


        Intent ImplicitIntent = new Intent(Intent.ACTION_SENDTO);
        ImplicitIntent.setData(Uri.parse("mailto: pemerintahkota@gmail.com"));
        ImplicitIntent.putExtra(Intent.EXTRA_SUBJECT, " " +topik);
        ImplicitIntent.putExtra(Intent.EXTRA_TEXT, OrderSummary(name,nomor,lapor,topik));

        if (ImplicitIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(ImplicitIntent);
        }



    }




    public String OrderSummary (String name, String nomor, String lapor ,String topik)
    {
        String Massage =
                "Nama = " +name
                +"\nNomor = " +nomor
                +"\nTopik = " +topik
                +"\nLapor = \n" +lapor;
                return Massage;

    }
}
