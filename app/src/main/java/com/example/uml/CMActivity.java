package com.example.uml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CMActivity extends AppCompatActivity
{
    private int numberNorth = -1 , numberSouth = -1 , numberEast = -1 , numberLib = -1 , numberSup = -1 ;

    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState ) ;
        setContentView ( R.layout.activity_cm ) ;

        TimerTask task = new TimerTask ( )
        {
            @Override
            public void run ( )
            {
                numberNorth = setNumber ( R.id.northcafeteria , numberNorth ) ;
                numberSouth = setNumber ( R.id.southcafeteria , numberSouth ) ;
                numberEast = setNumber ( R.id.eastcafeteria , numberEast ) ;
                numberLib = setNumber ( R.id.library , numberLib ) ;
                numberSup = setNumber ( R.id.supermarket , numberSup ) ;
            }
        } ;
        Timer time = new Timer ( ) ;
        time.schedule ( task , 0 , 2000 ) ;

/*        findViewById ( R.id.northCafeteriaImage ).setOnClickListener
                (
                        new View.OnClickListener ( )
                        {
                            @Override
                            public void onClick ( View v )
                            {
                                numberNorth = setNumber ( R.id.northcafeteria , numberNorth ) ;
                            }
                        }
                ) ;

        findViewById ( R.id.southCafeteriaImage ).setOnClickListener
                (
                        new View.OnClickListener ( )
                        {
                            @Override
                            public void onClick ( View v )
                            {
                                numberSouth = setNumber ( R.id.southcafeteria , numberSouth ) ;
                            }
                        }
                ) ;

        findViewById ( R.id.eastCafeteriaImage ).setOnClickListener
                (
                        new View.OnClickListener ( )
                        {
                            @Override
                            public void onClick ( View v )
                            {
                                numberEast = setNumber ( R.id.eastcafeteria , numberEast ) ;
                            }
                        }
                ) ;

        findViewById ( R.id.libraryImage ).setOnClickListener
                (
                        new View.OnClickListener ( )
                        {
                            @Override
                            public void onClick ( View v )
                            {
                                numberLib = setNumber ( R.id.library , numberLib ) ;
                            }
                        }
                ) ;

        findViewById ( R.id.supermarketImage ).setOnClickListener
                (
                        new View.OnClickListener ( )
                        {
                            @Override
                            public void onClick ( View v )
                            {
                                numberSup = setNumber ( R.id.supermarket , numberSup ) ;
                            }
                        }
                ) ;
*/

    }



    private int setNumber ( int id , int number )
    {
        Random random = new Random ( ) ;
        if ( number == -1 )
        {
            number = 120 + random.nextInt ( 50 ) ;
        }
        else
        {
            number += -2 + random.nextInt ( 10 ) ;
        }
        ( (TextView) findViewById ( id ) )
                .setText ( Integer.toString ( number ) ) ;
        return number ;
    }

}