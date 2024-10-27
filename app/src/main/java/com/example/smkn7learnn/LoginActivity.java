package com.example.smkn7learnn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);setContentView(R.layout.activity_login);

        // Get references to TextViews and set click listeners
        TextView registerTextView = findViewById(R.id.txt_registertext);
        registerTextView.setOnClickListener(v -> {
            // Intent to navigate to RegisterActivity
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        TextView lupaPasswordTextView = findViewById(R.id.txt_lupapass);
        lupaPasswordTextView.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                // Tangani error, misalnya tampilkan pesan error ke pengguna
                Log.e("LoginActivity", "Error navigating to LupaPasswordActivity", e);
                Toast.makeText(LoginActivity.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });

        // Set shadow on the layout
        RelativeLayout linearLayout = findViewById(R.id.lupa_pw_FormLayout);
        linearLayout.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        ShapeDrawable shadowDrawable = new ShapeDrawable();
        shadowDrawable.getPaint().setColor(Color.GRAY);
        shadowDrawable.getPaint().setShadowLayer(8f, 0f, 0f, Color.BLACK);

        linearLayout.setBackground(shadowDrawable);

        // Set padding for insets (e.g., status bar or navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(linearLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}