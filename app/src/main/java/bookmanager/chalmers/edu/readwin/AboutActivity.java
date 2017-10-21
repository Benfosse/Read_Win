package bookmanager.chalmers.edu.readwin;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		TextView aboutTextView = (TextView) findViewById(R.id.aboutTextView);
		aboutTextView.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
