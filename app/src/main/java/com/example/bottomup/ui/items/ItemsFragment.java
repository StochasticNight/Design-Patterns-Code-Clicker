package com.example.bottomup.ui.items;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomup.AgileTeam;
import com.example.bottomup.Business;
import com.example.bottomup.BuyProgrammer;
import com.example.bottomup.CommandFactory;
import com.example.bottomup.Conglomerate;
import com.example.bottomup.Department;
import com.example.bottomup.Generator;
import com.example.bottomup.MainActivity;
import com.example.bottomup.Programmer;
import com.example.bottomup.PurchaseCommand;
import com.example.bottomup.R;
import com.example.bottomup.UndoableCommand;

public class ItemsFragment extends Fragment {


    private ItemsViewModel itemsViewModel;

    /**
     * all the information that is created and updated
     * whenever this fragment is loaded
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /**
         * creates the factory object that will create the commands to be added
         * and rmeoved from the commandQueue
         */
        final CommandFactory commandFactory = new CommandFactory();

        itemsViewModel =
                ViewModelProviders.of(this).get(ItemsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_items, container, false);

        /**
         * defining the location of the price and counts for each generator
         */
        final TextView programmerCount = root.findViewById(R.id.programmerCount);
        final TextView programmerPrice = root.findViewById(R.id.programmerPrice);
        final TextView agileCount = root.findViewById(R.id.agileCount);
        final TextView agilePrice = root.findViewById(R.id.agilePrice);
        final TextView departmentCount = root.findViewById(R.id.departmentCount);
        final TextView departmentPrice = root.findViewById(R.id.departmentPrice);
        final TextView businessCount = root.findViewById(R.id.businessCount);
        final TextView businessPrice = root.findViewById(R.id.businessPrice);
        final TextView conglomerateCount = root.findViewById(R.id.conglomerateCount);
        final TextView conglomeratePrice = root.findViewById(R.id.conglomeratePrice);


        /**
         * setting the price and count of each generator upon loading the fragment
         */
        programmerCount.setText(MainActivity.programmer.getCount() + " programmer(s)");
        programmerPrice.setText("Price: " + MainActivity.programmer.getPrice() + "\n lps: " + MainActivity.programmer.getLps());
        agileCount.setText(MainActivity.agileTeam.getCount() + " team(s)");
        agilePrice.setText("Price: " + MainActivity.agileTeam.getPrice()+ "\n lps: " + MainActivity.agileTeam.getLps());
        departmentCount.setText(MainActivity.department.getCount() + " department(s)");
        departmentPrice.setText("Price: " + MainActivity.department.getPrice()+ "\n lps: " + MainActivity.department.getLps());
        businessCount.setText(MainActivity.business.getCount() + " business(es)");
        businessPrice.setText("Price: " + MainActivity.business.getPrice()+ "\n lps: " + MainActivity.business.getLps());
        conglomerateCount.setText(MainActivity.conglomerate.getCount() + " conglomerate(s)");
        conglomeratePrice.setText("Price: " + MainActivity.conglomerate.getPrice()+ "\n lps: " + MainActivity.conglomerate.getLps());

        /**
         * defining all the images for each generator
         */
        ImageView programmerImage = root.findViewById(R.id.programmer);
        ImageView agileImage = root.findViewById(R.id.agile);
        ImageView departmentImage = root.findViewById(R.id.department);
        ImageView businessImage = root.findViewById(R.id.business);
        ImageView conglomerateImage = root.findViewById(R.id.conglomerate);

        /**
         * defining the undo button
         */
        Button undo = root.findViewById(R.id.undo);

        /**
         * when the undo button is pressed, if their is a command in the queue
         * it removes the most recent command and performs the unexecute() function
         * on that command then updates all the text feilds to reflect the change
         */
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.commandQueue.isEmpty()) {
                }
                else {
                    PurchaseCommand lastCommand = MainActivity.commandQueue.remove(MainActivity.commandQueue.size() - 1);
                    lastCommand.unexecute();
                    ((MainActivity)getActivity()).addLoC(lastCommand.type);
                    ((MainActivity)getActivity()).deductLps(lastCommand.rate);
                    programmerCount.setText(MainActivity.programmer.getCount() + " programmer(s)");
                    programmerPrice.setText("Price: " + MainActivity.programmer.getPrice() + "\n lps: " + MainActivity.programmer.getLps());
                    agileCount.setText(MainActivity.agileTeam.getCount() + " team(s)");
                    agilePrice.setText("Price: " + MainActivity.agileTeam.getPrice()+ "\n lps: " + MainActivity.agileTeam.getLps());
                    departmentCount.setText(MainActivity.department.getCount() + " department(s)");
                    departmentPrice.setText("Price: " + MainActivity.department.getPrice()+ "\n lps: " + MainActivity.department.getLps());
                    businessCount.setText(MainActivity.business.getCount() + " business(es)");
                    businessPrice.setText("Price: " + MainActivity.business.getPrice()+ "\n lps: " + MainActivity.business.getLps());
                    conglomerateCount.setText(MainActivity.conglomerate.getCount() + " conglomerate(s)");
                    conglomeratePrice.setText("Price: " + MainActivity.conglomerate.getPrice()+ "\n lps: " + MainActivity.conglomerate.getLps());
                }
            }
        });


        /**
         * When the programmer generator image is clicked, it creates a
         * buyBusiness Purchase command through the commandFactory and adds
         * that command to the commandQueue while also preforming the execute()
         * method on that command, then updates the price and count text fields
         * associated with the Programmer class
         */
        programmerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MainActivity)getActivity()).getLoC() >= MainActivity.programmer.getPrice())
                {
                    clickGenerator(MainActivity.programmer);
                    MainActivity.commandQueue.add(commandFactory.makeUndoableCommand('p'));
                    MainActivity.commandQueue.get(MainActivity.commandQueue.size() - 1).execute();
                    programmerCount.setText(MainActivity.programmer.getCount() + " programmer(s)");
                    programmerPrice.setText("Price: " + MainActivity.programmer.getPrice() + "\n lps: " + MainActivity.programmer.getLps());
                }
            }
        });

        /**
         * When the agileTeam generator image is clicked, it creates a
         * buyBusiness Purchase command through the commandFactory and adds
         * that command to the commandQueue while also preforming the execute()
         * method on that command, then updates the price and count text fields
         * associated with the AgileTeam class
         */
        agileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MainActivity)getActivity()).getLoC() >= MainActivity.agileTeam.getPrice())
                {
                    clickGenerator(MainActivity.agileTeam);
                    MainActivity.commandQueue.add(commandFactory.makeUndoableCommand('a'));
                    MainActivity.commandQueue.get(MainActivity.commandQueue.size() - 1).execute();
                    agileCount.setText(MainActivity.agileTeam.getCount() + " team(s)");
                    agilePrice.setText("Price: " + MainActivity.agileTeam.getPrice()+ "\n lps: " + MainActivity.agileTeam.getLps());
                }
            }
        });

        /**
         * When the department generator image is clicked, it creates a
         * buyBusiness Purchase command through the commandFactory and adds
         * that command to the commandQueue while also preforming the execute()
         * method on that command, then updates the price and count text fields
         * associated with the department class
         */
        departmentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MainActivity)getActivity()).getLoC() >= MainActivity.department.getPrice())
                {
                    clickGenerator(MainActivity.department);
                    MainActivity.commandQueue.add(commandFactory.makeUndoableCommand('d'));
                    MainActivity.commandQueue.get(MainActivity.commandQueue.size() - 1).execute();
                    departmentCount.setText(MainActivity.department.getCount() + " department(s)");
                    departmentPrice.setText("Price: " + MainActivity.department.getPrice()+ "\n lps: " + MainActivity.department.getLps());
                }
            }
        });

        /**
         * When the business generator image is clicked, it creates a
         * buyBusiness Purchase command through the commandFactory and adds
         * that command to the commandQueue while also preforming the execute()
         * method on that command, then updates the price and count text fields
         * associated with the business class
         */
        businessImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MainActivity)getActivity()).getLoC() >= MainActivity.business.getPrice())
                {
                    clickGenerator(MainActivity.business);
                    MainActivity.commandQueue.add(commandFactory.makeUndoableCommand('b'));
                    MainActivity.commandQueue.get(MainActivity.commandQueue.size() - 1).execute();
                    businessCount.setText(MainActivity.business.getCount() + " business(es)");
                    businessPrice.setText("Price: " + MainActivity.business.getPrice()+ "\n lps: " + MainActivity.business.getLps());
                }
            }
        });

        /**
         * When the conglomerate generator image is clicked, it creates a
         * buyBusiness Purchase command through the commandFactory and adds
         * that command to the commandQueue while also preforming the execute()
         * method on that command, then updates the price and count text fields
         * associated with the Conglomerate class
         */
        conglomerateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MainActivity)getActivity()).getLoC() >= MainActivity.conglomerate.getPrice())
                {
                    clickGenerator(MainActivity.conglomerate);
                    MainActivity.commandQueue.add(commandFactory.makeUndoableCommand('c'));
                    MainActivity.commandQueue.get(MainActivity.commandQueue.size() - 1).execute();
                    conglomerateCount.setText(MainActivity.conglomerate.getCount() + " conglomerate(s)");
                    conglomeratePrice.setText("Price: " + MainActivity.conglomerate.getPrice()+ "\n lps: " + MainActivity.conglomerate.getLps());
                }

            }
        });

        return root;
    }

    /**
     * clickGenerator occurs whenever one of the generators is clicked on,
     * LinoesOfCode total and being generated per second
     * @param g the generator which is impacting the LinOfCode singleton
     *          and the total lines of code being generated per second
     */
    public void clickGenerator(Generator g){

            ((MainActivity)getActivity()).deductLoC(g.getPrice());
            ((MainActivity) getActivity()).addLps(g.getLps() / 10);
    }
}