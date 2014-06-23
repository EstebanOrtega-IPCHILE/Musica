package example.Reproductor_Musica;

import android.os.AsyncTask;
import android.widget.TextView;

public class Hilo extends AsyncTask<Void, String, Void> {
	
	MainActivity m = new MainActivity();

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {

			while (true) {
				
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	protected void onProgressUpdate(String... values) {
		
		m.ActualizarT();

	}
	
	
}
