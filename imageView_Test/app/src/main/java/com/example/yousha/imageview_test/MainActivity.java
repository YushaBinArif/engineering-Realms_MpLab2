package com.example.yousha.imageview_test;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int i = 0;
    ImageView imageView ;
    int [] IMAGE = {R.drawable.bumblebee,R.drawable.hungrydino ,R.drawable.optimus_after_mid,R.drawable.optimusprime};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageview);
        registerForContextMenu(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.op_menu,  menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getTitle().toString().toLowerCase()) {

            case "plus":
                if(imageView.getScaleX()<1.5)
                  imageView.setScaleX((float) (imageView.getScaleX()+0.25));
                if(imageView.getScaleY()<1.5)
                   imageView.setScaleY((float) (imageView.getScaleY()+0.25));

                //imageView.getLayoutParams().height = ConstraintLayout.LayoutParams.MATCH_PARENT;
                break;
            case "minus":
                if(imageView.getScaleX()>-1.5)
                    imageView.setScaleX((float) (imageView.getScaleX()-0.25));
                if(imageView.getScaleY()>-1.5)
                    imageView.setScaleY((float) (imageView.getScaleY()-0.25));

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        try {


            switch (item.getTitle().toString().toLowerCase()) {

                case "next":
                    if (i < IMAGE.length - 1) {
                        imageView.setImageResource(IMAGE[i++]);

                    } else {
                        i = 0;

                    }
                    break;
                case "previous":
                    if (i > 0) {
                        imageView.setImageResource(IMAGE[i--]);

                    } else {
                        i = IMAGE.length;

                    }
                    break;

            }
        }
        catch (Exception e)
        {}
            return super.onContextItemSelected(item);
        }


}
