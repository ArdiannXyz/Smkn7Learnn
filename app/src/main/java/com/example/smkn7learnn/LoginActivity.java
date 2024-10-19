package com.example.smkn7learnn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Mengambil TextView untuk Register dan setOnClickListener
        TextView registerTextView = findViewById(R.id.IdRegister); // Perbaikan ID
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke RegisterActivity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class); // Perbaikan konteks
                startActivity(intent);
            }
        });

        // Mengatur shadow pada layout
        RelativeLayout linearLayout = findViewById(R.id.loginFormLayout);
        linearLayout.setLayerType(View.LAYER_TYPE_SOFTWARE, null); // Pastikan layout sudah didefinisikan di XML

        ShapeDrawable shadowDrawable = new ShapeDrawable();
        shadowDrawable.getPaint().setColor(Color.GRAY);
        shadowDrawable.getPaint().setShadowLayer(8f, 0f, 0f, Color.BLACK);

        linearLayout.setBackground(shadowDrawable);

        // Mengatur padding untuk insets (misalnya status bar atau navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(linearLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}