package com.example.myapps;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class fragmento1 extends Fragment {

    private EditText editTextNumber1, editTextNumber2;
    private Spinner spinnerOperation;
    private Button btnCalculate;
    private TextView textViewResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        editTextNumber1 = view.findViewById(R.id.editTextNumber1);
        editTextNumber2 = view.findViewById(R.id.editTextNumber2);
        spinnerOperation = view.findViewById(R.id.spinnerOperation);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        textViewResult = view.findViewById(R.id.textViewResult);

        String[] operationsArray = {"Suma", "Resta", "Multiplicación", "División"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                operationsArray
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperation.setAdapter(adapter);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

        return view;
    }

    private void calculateResult() {

        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());


        String operation = spinnerOperation.getSelectedItem().toString();


        double result = 0;
        switch (operation) {
            case "Suma":
                result = number1 + number2;
                break;
            case "Resta":
                result = number1 - number2;
                break;
            case "Multiplicación":
                result = number1 * number2;
                break;
            case "División":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    textViewResult.setText("No se puede dividir por cero");
                    return;
                }
                break;
        }

        textViewResult.setText("Resultado: " + result);
    }
}