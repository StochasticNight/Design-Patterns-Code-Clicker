package com.example.bottomup;

/**
 * @authors
 * Christian Baker
 * Richard Dejesus
 * Aleksander Pawlowicz
 * Erika Vogel
 */

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinesOfCode LoC = LinesOfCode.getInstance();
    public static double clickAmount = 1;
    public double linesPerSecond = 0;
    Thread lps= new Thread();

    /**
     * defining instances for the composite store
     */
    public static int numCPUS = 1;
    public static int numRAM = 1;
    public static int numMOBO = 1;
    public static int numGPU = 1;
    public static ComputerComposite mine;
    ComputerComposite graphics = new GPU();
    ComputerComposite motherboard = new Motherboard();

    /**
     * defining instances for the generator store
     */
    public static Programmer programmer = new Programmer(15, .1);;
    public static AgileTeam agileTeam = new AgileTeam(100, 1);
    public static Department department = new Department(1100, 8);
    public static Business business = new Business(12000, 47);
    public static Conglomerate conglomerate = new Conglomerate(130000, 260);

    public static List<PurchaseCommand> commandQueue = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * new thread for incremented the idle lines of code per second
         */
            lps = new Thread() {
                public void run(){
                try
                {
                    while (!lps.isInterrupted()) {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LoC.addAmount(linesPerSecond);
                                TextView score = findViewById(R.id.LoCNum);
                                score.setText("" + new DecimalFormat("##.#").format(LoC.getLines()));
                            }
                        });
                    }
                } catch(
                InterruptedException e)
                {
                }
            }
        };
            lps.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * creating the bottom navigation menu
         */
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_items)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        /**
         *
         */
        graphics.add(new CPU());
        graphics.add(new CPU());
        motherboard.add(new CPU());
        motherboard.add(new RAM());
        mine = graphics;
        mine.add(motherboard);
        mine.add(new CPU());
        mine.add(new RAM());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    return false;
                }
            };

    /**
     * adds to the total Lines of Code in the singleton
     * @param i
     */
    public void addLoC(double i)
    {
        LoC.addAmount(i);
    }

    /**
     * adds to the passive lines per second
     * @param i
     */
    public void addLps(double i){ linesPerSecond += i;}

    /**
     * deduct from the passive lines per second
     * @param i
     */
    public void deductLps(double i){linesPerSecond -= i / 10;}

    /**
     *
     * @return the lines of code from the singleton
     */
    public double getLoC(){
        return LoC.getLines();
    }

    /**
     * deduct i from the total lines of code
     * @param i
     */
    public void deductLoC(double i) { LoC.deductAmount(i);}

}
















