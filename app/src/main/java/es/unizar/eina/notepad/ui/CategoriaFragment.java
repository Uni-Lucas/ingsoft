package es.unizar.eina.notepad.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.unizar.eina.notepad.R;

public class CategoriaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categoria, container, false);
    }

    // Carga los platos del tipo que sean y devuelve un fragmento con argumentos los datos recogidos
    public static CategoriaFragment create(String tipo) {
        // consulta al PlatosViewModel

        // args.put(resultado de la consulta)
        //Bundle args = new Bundle();
        return new CategoriaFragment();
    }

    public void onClick(View view) {

        Intent i = new Intent();
        Activity parentActivity = getActivity();
        if (view.getId() == R.id.add_button) {
            i = new Intent(parentActivity, NewPlato.class);
        }
        ((IntentInterface)parentActivity).startMyIntent(i);
    }
}