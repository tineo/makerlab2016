package debra.makerlab;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UsuarioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsuarioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private DataBase mDataBase;
    private ListView mUsuariosList;
    private UsuariosCursorAdapter mUsuariosAdapter;

    private OnFragmentInteractionListener mListener;

    public UsuarioFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UsuarioFragment newInstance() {
        UsuarioFragment fragment = new UsuarioFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_usuario, container, false);
        View root =  inflater.inflate(R.layout.fragment_usuario, container, false);
        mUsuariosList = (ListView) root.findViewById(R.id.usuarios_list);
        mUsuariosAdapter = new UsuariosCursorAdapter(getActivity(), null);
        //mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mUsuariosList.setAdapter(mUsuariosAdapter);

        // Instancia de helper
        mDataBase = new DataBase(getActivity());


        Cursor cur = mDataBase.getAllUsuarios();
        int count =cur.getCount();

        Toast.makeText(getContext(), "Hay registrado: "+count, Toast.LENGTH_LONG).show();

        // Carga de datos
        loadUsuarios();

        return root;
    }
    private void loadUsuarios() {
        new UsuariosLoadTask(getContext()).execute();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
