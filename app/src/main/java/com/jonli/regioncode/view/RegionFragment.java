package com.jonli.regioncode.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jonli.regioncode.R;
import com.jonli.regioncode.model.CodeModel;
import com.jonli.regioncode.model.Model;
import com.jonli.regioncode.presenter.CodePresenter;
import com.jonli.regioncode.presenter.Presenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegionFragment extends Fragment {

    public RegionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_region, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Model model = new CodeModel(getContext());
        final Presenter presenter = new CodePresenter(model);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, presenter.getRegions());
        final AutoCompleteTextView autoTextRegion = view.findViewById(R.id.auto_text_region);
        autoTextRegion.setAdapter(adapter);

        final TextView textViewAuto = view.findViewById(R.id.text_view_auto);

        autoTextRegion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
                autoTextRegion.setVisibility(View.INVISIBLE);
                autoTextRegion.setEnabled(false);
                textViewAuto.setText(autoTextRegion.getText().toString());
                textViewAuto.setVisibility(View.VISIBLE);
            }
        });


        Button btnOk = view.findViewById(R.id.btn_ok_region);
        Button btnClear = view.findViewById(R.id.btn_clear_region);
        final TextView textView = view.findViewById(R.id.text_view_code);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String region = autoTextRegion.getText().toString();
                textView.setText(presenter.showCode(region));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewAuto.setVisibility(View.INVISIBLE);
                textViewAuto.setText("");
                autoTextRegion.setText("");
                autoTextRegion.setVisibility(View.VISIBLE);
                autoTextRegion.setEnabled(true);
                autoTextRegion.setCursorVisible(true);
                textView.setText("");
            }
        });

        textViewAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewAuto.setVisibility(View.INVISIBLE);
                textViewAuto.setText("");
                autoTextRegion.setText("");
                autoTextRegion.setVisibility(View.VISIBLE);
                autoTextRegion.setEnabled(true);
                autoTextRegion.setCursorVisible(true);
                textView.setText("");
            }
        });
    }

}
