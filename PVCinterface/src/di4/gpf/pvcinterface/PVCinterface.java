package di4.gpf.pvcinterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.text.AndroidCharacter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PVCinterface extends ActionBarActivity {
	
	Carte carte;
	Solution sol;
	List<ImageButton> bVilleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carte_activity);
        String villeListe[] = getResources().getStringArray(R.array.VilleListe);
        try {
			InputStream inXML = getAssets().open(villeListe[0]);
	        carte= new Carte(1,inXML);
		} catch (IOException e) {
			e.printStackTrace();
		}

        
        
        
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.carte);

        ImageView butt;
        TextView txtNom;
        Ville ville;
        
        Iterator<Ville> itVille=carte.getVilles().iterator();
        while(itVille.hasNext()){
        	ville = itVille.next();
        	final Ville ville1 = ville;
        	butt = new ImageView(this);
        	butt.setImageResource(android.R.drawable.ic_menu_compass);
        	
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50,50);
            params.leftMargin = (int) ville1.getCoordX();
            params.topMargin = (int ) ville1.getCoordY();

            sol= new Solution();
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!sol.getChemin().contains(ville1)){
                    	sol.addNext(ville1);
                    	Toast.makeText(getApplicationContext(), ville1.getNom() + " ajouté", Toast.LENGTH_SHORT).show();
                    }else
                    	Toast.makeText(getApplicationContext(), ville1.getNom() + " déjà présent", Toast.LENGTH_SHORT).show();
                    	
                }
            });
            
            layout.addView(butt,params);
        }
        

        /*sol= new Solution();
        sol.addNext(carte.getVilles().get(2));
        sol.addNext(carte.getVilles().get(1));
        sol.addNext(carte.getVilles().get(3));
        sol.addNext(carte.getVilles().get(0));
        sol.opt2();*/
        
        /*
        carte = new Carte(1);
        ImageButton butt;
        Ville ville;
        Iterator<Ville> itVille=carte.getVilles().iterator();
        while(itVille.hasNext()){
        	butt = new ImageButton(this);
        	ville = itVille.next();
        	butt.layout(ville.getCoordX(), ville.getCoordY(), butt.getMeasuredWidth(), butt.getMeasuredHeight());
        	
        }
        */
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pvcinterface, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
