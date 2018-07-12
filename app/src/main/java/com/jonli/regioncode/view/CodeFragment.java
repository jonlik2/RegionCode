package com.jonli.regioncode.view;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jonli.regioncode.R;
import com.jonli.regioncode.model.CodeModel;
import com.jonli.regioncode.model.Model;
import com.jonli.regioncode.presenter.CodePresenter;
import com.jonli.regioncode.presenter.Presenter;

import java.lang.ref.WeakReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class CodeFragment extends Fragment {

    private Model model;
    private Presenter presenter;

    private EditText editTextCode;
    private Button btnOk;
    private Button btnClear;
    private TextView textView;

    public CodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = new CodeModel(getContext());
        presenter = new CodePresenter(model);

        editTextCode = view.findViewById(R.id.edit_text_code);
        btnOk = view.findViewById(R.id.btn_ok_code);
        btnClear = view.findViewById(R.id.btn_clear_code);
        textView = view.findViewById(R.id.text_view_region);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = editTextCode.getText().toString();
                String editCode = presenter.formatCode(code);
                editTextCode.setText(editCode);
                editTextCode.setSelection(editTextCode.getText().length());
                textView.setText(presenter.showRegion(editCode));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextCode.setText("");
                textView.setText("");
            }
        });

        editTextCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextCode.setText("");
                textView.setText("");
            }
        });

    }
}
