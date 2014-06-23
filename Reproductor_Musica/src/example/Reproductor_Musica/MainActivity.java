package example.Reproductor_Musica;

import java.util.concurrent.TimeUnit;

import example.musica.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView tvpos;
	public String tiempo = "0";

	private double startTime = 0;

	private Handler handler1 = new Handler();
	private Runnable H = new Runnable() { //Hilo que se ejecutara en conjunto con la canción para determinar el tiempo
		public void run() { // metodo que corre el Hilo y los metodos para actualizar el tiempo y validar las preguntas
			ActualizarT();
			Preguntas();
		}
	};

	MediaPlayer mep;
	int pos = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvpos = (TextView) findViewById(R.id.tvpos);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void iniciarH() { // confeccion del Thread
		final Thread thread1 = new Thread() {
			public void run() {
				try {

					while (true) {
						Thread.sleep(1000);
						handler1.post(H);

					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		};
		thread1.start();
	}

	public void destruir() {
		if (mep != null)
			mep.release();
	}

	public void iniciar(View v) {
		destruir();
		mep = MediaPlayer.create(this, R.raw.tv);
		mep.start();

		tvpos.setText("0");

		iniciarH();
	}

	public void pausar(View v) {
		if (mep != null && mep.isPlaying()) {
			pos = mep.getCurrentPosition();
			mep.pause();
		}
	}

	public void continuar(View v) {
		if (mep != null && mep.isPlaying() == false) {
			mep.seekTo(pos);
			mep.start();
		}
	}

	public void detener(View v) {
		if (mep != null) {
			mep.stop();
			pos = 0;

			tvpos.setText("0");

		}
	}

	public void ActualizarT() { // metodo que convierte los milisegundos en minutos y segundos

		
		startTime = mep.getCurrentPosition();

		tvpos.setText(String.format(
				"%d min, %d sec",
				TimeUnit.MILLISECONDS.toMinutes((long) startTime),
				TimeUnit.MILLISECONDS.toSeconds((long) startTime)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes((long) startTime))));

		tiempo = tvpos.getText().toString();

		
	}

	public void Preguntas() {
		// Validacion de todos los tiempos a preguntar
		
		
		if (tiempo.equals("0 min, 21 sec")) {
			
			try {
				
				// este thread suma un segundo para no llamar nuevamente en la misma posición
				Thread.sleep(1000);
				final View v = null;
				pausar(v);
				
				//Confección del mensaje
				final CharSequence[] items = { "hang on the street", "Nothing",
						"Play the guitar" };
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("What we did last week?");
				builder.setSingleChoiceItems(items, -1,
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int item) {
								
								//Validación de la pregunta, si es correcta o no
								if (items[item].equals("hang on the street")) {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta Correcta!!: ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();
									continuar(v); // metodo para continuar con la canción si es correcta
								} else {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta incorrecta, NEXT! ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									iniciar(v);// metodo para reiniciar la canción si es incorrecta

								}

							}
						});
				AlertDialog alert = builder.create();
				alert.show();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			if (tiempo.equals("0 min, 32 sec")) {

				try {

					Thread.sleep(1000);
					final View v = null;
					pausar(v);

					final CharSequence[] items = { "talk", "Run", "Drink" };

					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setTitle("What makes one with her?");
					builder.setSingleChoiceItems(items, -1,
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int item) {

									if (items[item].equals("talk")) {

										Toast toast = Toast.makeText(
												getApplicationContext(),
												"Respuesta correcta!!: ",														
												Toast.LENGTH_SHORT);
										toast.show();
										dialog.cancel();

										continuar(v);
									} else {

										Toast toast = Toast.makeText(
												getApplicationContext(),
												"Respuesta incorrecta, NEEEEXT!:",														
												Toast.LENGTH_SHORT);
										toast.show();
										dialog.cancel();

										iniciar(v);
									}

								}
							});
					AlertDialog alert = builder.create();
					alert.show();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} }

		if (tiempo.equals("0 min, 38 sec")) {

			try {

				Thread.sleep(1000);
				final View v = null;
				pausar(v);

				final CharSequence[] items = { "other city", "Live upstairs",
						"with grandfather" };

				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Where the parents live?");
				builder.setSingleChoiceItems(items, -1,
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int item) {

								if (items[item].equals("Live upstairs")) {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta correcta!!: ",
													Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									continuar(v);
								} else {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta incorrecta, NEEEEXT!: ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									iniciar(v);

								}

							}
						});
				AlertDialog alert = builder.create();
				alert.show();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{

			if (tiempo.equals("0 min, 51 sec")) {

				try {

					Thread.sleep(1000);
					final View v = null;
					pausar(v);

					final CharSequence[] items = { "Clapton", "Roses", "Nixon" };

					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setTitle("Who died?");
					builder.setSingleChoiceItems(items, -1,
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int item) {

									if (items[item].equals("Nixon")) {

										Toast toast = Toast.makeText(
												getApplicationContext(),
												"Respuesta correcta!!: ",														
												Toast.LENGTH_SHORT);
										toast.show();
										dialog.cancel();

										continuar(v);
									} else {

										Toast toast = Toast.makeText(
												getApplicationContext(),
												"Respuesta incorrecta, NEEEEXT!: ",														
												Toast.LENGTH_SHORT);
										toast.show();
										dialog.cancel();

										iniciar(v);

									}

								}
							});
					AlertDialog alert = builder.create();
					alert.show();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} }
			
			
		if (tiempo.equals("1 min, 20 sec")) {

			try {

				Thread.sleep(1000);
				final View v = null;
				pausar(v);

				final CharSequence[] items = { "Texas", "Wisconsin",
						"Los Angeles" };

				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Where are rocking?");
				builder.setSingleChoiceItems(items, -1,
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int item) {

								if (items[item].equals("Wisconsin")) {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta correcta!!: ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									continuar(v);
								} else {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta incorrecta, NEEEEXT!: ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									iniciar(v);

								}

							}
						});
				AlertDialog alert = builder.create();
				alert.show();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else{

			if (tiempo.equals("1 min, 30 sec")) {

				try {

					Thread.sleep(1000);
					final View v = null;
					pausar(v);

					final CharSequence[] items = { "A car", "A plane",
							"motorcycle" };

					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setTitle("What a steal to go about nothing?");
					builder.setSingleChoiceItems(items, -1,
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int item) {

									if (items[item].equals("A car")) {

										Toast toast = Toast.makeText(
												getApplicationContext(),
												"Respuesta correcta!!: ",														
												Toast.LENGTH_SHORT);
										toast.show();
										dialog.cancel();

										continuar(v);
									} else {

										Toast toast = Toast.makeText(
												getApplicationContext(),
												"Respuesta incorrecta, NEEEEXT!: ",														
												Toast.LENGTH_SHORT);
										toast.show();
										dialog.cancel();

										iniciar(v);

									}

								}
							});
					AlertDialog alert = builder.create();
					alert.show();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} }

		if (tiempo.equals("1 min, 39 sec")) {

			try {

				Thread.sleep(1000);
				final View v = null;
				pausar(v);

				final CharSequence[] items = { "About Rock and Roll",
						"About love", "About family" };

				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("You talking about the song?");
				builder.setSingleChoiceItems(items, -1,
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int item) {

								if (items[item].equals("About Rock and Roll")) {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta correcta!!: ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									continuar(v);
								} else {

									Toast toast = Toast.makeText(
											getApplicationContext(),
											"Respuesta incorrecta, NEEEEXT!: ",													
											Toast.LENGTH_SHORT);
									toast.show();
									dialog.cancel();

									iniciar(v);

								}

							}
						});
				AlertDialog alert = builder.create();
				alert.show();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
