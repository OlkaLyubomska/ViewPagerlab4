package com.example.viewpager_lab4.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpager_lab4.R;

public class List extends Fragment implements AdapterView.OnItemClickListener {

    private OnFragmentInteractionListener mListener;

    public List() {}

    private String[] data = { "Google", "pinterest", "yakaboo", "Helvetica" };
    // lifecycle method call #1
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    // lifecycle method call #2
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mListener.onFragmentInteraction(data[position]);
    }
// creating an interface that implements Activity

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String result);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // find the list
        ListView list = view.findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, data);
        // assign an adapter to the list
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

}
