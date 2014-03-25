package com.example.texttospeech;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnInitListener,
		OnClickListener {

	EditText text;
	TextToSpeech toSpeech;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toSpeech = new TextToSpeech(getApplicationContext(), this);
		text = (EditText) findViewById(R.id.text);
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(this);
		// button.setEnabled(false);

	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

		if (status == TextToSpeech.SUCCESS) {
			int result = toSpeech.setLanguage(Locale.UK);

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("1", "ERROR");
			}
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		textToSpeech();
	}

	private void textToSpeech() {
		// TODO Auto-generated method stub

		String txt = "Welcome to Eivor technologies "
				+ text.getText().toString();

		toSpeech.setPitch(0.1f);
		toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub

		if (toSpeech != null) {
			toSpeech.stop();
			toSpeech.shutdown();
		}

		super.onDestroy();
	}

}
