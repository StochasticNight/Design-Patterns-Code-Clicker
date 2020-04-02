package com.example.bottomup.ui.dashboard;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomup.CPU;
import com.example.bottomup.RAM;
import com.example.bottomup.GPU;
import com.example.bottomup.Motherboard;
import com.example.bottomup.ComputerComposite;
import com.example.bottomup.MainActivity;
import com.example.bottomup.R;

public class DashboardFragment extends Fragment {


    private DashboardViewModel dashboardViewModel;
    private static final String TAG = DashboardFragment.class.getSimpleName();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        final TextView textView = root.findViewById(R.id.CPU);
        textView.setText("CPU:");
        final TextView textView1 = root.findViewById(R.id.RAM);
        textView1.setText("RAM:");
        final TextView textView2 = root.findViewById(R.id.MOBO);
        textView2.setText("MOBO:");
        final TextView textView3 = root.findViewById(R.id.GPU);
        textView3.setText("GPU:");
        final TextView textView4 = root.findViewById(R.id.CPU2);
        textView4.setText(""+MainActivity.numCPUS);
        final TextView textView5 = root.findViewById(R.id.RAM2);
        textView5.setText(""+MainActivity.numRAM);
        final TextView textView6 = root.findViewById(R.id.MOBO2);
        textView6.setText(""+MainActivity.numMOBO);
        final TextView textView7 = root.findViewById(R.id.GPU2);
        textView7.setText(""+MainActivity.numGPU);
        Button B1 = root.findViewById(R.id.button);
        B1.setText("LoC: 1.5");
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double before = MainActivity.mine.getCostTotal();
                MainActivity.mine.add(new CPU());
                if (((MainActivity) getActivity()).getLoC()>=(MainActivity.mine.getCostTotal()-before)) {
                    ((MainActivity) getActivity()).deductLoC((MainActivity.mine.getCostTotal()-before));
                    MainActivity.clickAmount = MainActivity.mine.getLinesTotal();
                    textView4.setText(""+ ++MainActivity.numCPUS);//+ ++MainActivity.numCPUS
                }
            }
        });

        Button B2 = root.findViewById(R.id.button2);
        B2.setText("LoC: 5.0");
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double before = MainActivity.mine.getCostTotal();
                MainActivity.mine.add(new RAM());
                if (((MainActivity) getActivity()).getLoC()>=(MainActivity.mine.getCostTotal()-before)) {
                    ((MainActivity) getActivity()).deductLoC((MainActivity.mine.getCostTotal()-before));
                    MainActivity.clickAmount = MainActivity.mine.getLinesTotal();
                    textView5.setText("" + ++MainActivity.numRAM);
                }
            }
        });

        Button B3 = root.findViewById(R.id.button3);
        B3.setText("LoC: 5.0");
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double before = MainActivity.mine.getCostTotal();
                MainActivity.mine.add(new Motherboard());
                if (((MainActivity) getActivity()).getLoC()>=(MainActivity.mine.getCostTotal()-before)) {
                    ((MainActivity) getActivity()).deductLoC((MainActivity.mine.getCostTotal()-before));
                    MainActivity.clickAmount = MainActivity.mine.getLinesTotal();
                    textView6.setText("" + ++MainActivity.numMOBO);
                }
            }
        });

        Button B4 = root.findViewById(R.id.button4);
        B4.setText("LoC: 2.0");
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double before = MainActivity.mine.getCostTotal();
                MainActivity.mine.add(new GPU());
                if (((MainActivity) getActivity()).getLoC()>=(MainActivity.mine.getCostTotal()-before)) {
                    ((MainActivity) getActivity()).deductLoC((MainActivity.mine.getCostTotal()-before));
                    MainActivity.clickAmount = MainActivity.mine.getLinesTotal();
                    textView7.setText("" + ++MainActivity.numGPU);
                }
            }
        });

        return root;

    }





    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDes()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onRes()");
    }
}